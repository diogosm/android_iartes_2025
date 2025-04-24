package br.edu.ufam.hellotoast;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private int contador = 0;
    private TextView meuNumero;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        meuNumero = (TextView) findViewById(R.id.meuNumero);
        Log.i("debug", "Meu numero eh: " +
                meuNumero.getText().toString());
     }

     public void imprimeMinhaMsg(View view){
        Toast meuToast = null;
        meuToast = Toast.makeText(this, "valor do contador é "
                        + contador,
                Toast.LENGTH_LONG);
        meuToast.show();
     }

     public void somaTexto(View view){
        contador++;

        Log.i("debug", "Novo valor do contador: "
                + contador);

         meuNumero.setText(Integer.toString(contador));
     }
}