package br.edu.ufam.menuinferior;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        navigationView = (BottomNavigationView) findViewById(R.id.navegacaoDash);
        navigationView.setOnNavigationItemSelectedListener
                (
                        item ->
                        {
                            if(item.getItemId() == R.id.Home){
                                startActivity(new Intent(this, MainActivity.class));
                                finish();
                                return true; //auto loop :-p
                            }else if(item.getItemId() == R.id.dadosItemMenu){
                                Toast aux =
                                        Toast.makeText(this, "Item 2 clicado", Toast.LENGTH_SHORT);
                                aux.show();
                            }else if(item.getItemId() == R.id.pontosItemMenu){
                                Toast aux =
                                        Toast.makeText(this, "Item 3 clicado", Toast.LENGTH_SHORT);
                                aux.show();
                            }else if(item.getItemId() == R.id.outraCoisaItemMenu){
                                Toast aux =
                                        Toast.makeText(this, "Item 4 clicado", Toast.LENGTH_SHORT);
                                aux.show();
                            }
                            return false;
                        }
                );
    }
}