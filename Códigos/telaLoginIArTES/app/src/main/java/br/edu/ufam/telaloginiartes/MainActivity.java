package br.edu.ufam.telaloginiartes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText loginEditText, passwordEditText;
    private Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loginEditText = (EditText) findViewById(R.id.login);
        passwordEditText = (EditText) findViewById(R.id.senha);
        loginButton = (Button) findViewById(R.id.loginButton);

        /*
            2a forma de fazer funcionalidades em botoes
         */
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //faz um toast de ola
                String ans = "Olá, " + loginEditText.getText().toString();
                Toast bemVindoMsg = Toast.makeText(view.getContext(),
                        ans,
                        Toast.LENGTH_LONG);
            }
        });
    }
}