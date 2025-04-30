package com.example.login_e_logado_com_menu;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.login_e_logado_com_menu.model.Database;

public class SplashScreen extends AppCompatActivity {

    public int TEMPO_SPLASH_SCREEN = 2000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_splash_screen);

        // vamos iniciar o banco de dados
        inicializarBancoDados();

        new Handler().postDelayed(new Runnable() {
                                      @Override
                                      public void run() {
                                          irParaAProximaActivity();
                                      }

                                      private void irParaAProximaActivity() {
                                          Intent intent = new Intent(
                                                  SplashScreen.this,
                                                  MainActivity.class
                                          );
                                          startActivity(intent);
                                          finish();
                                      }
                                  }
        , TEMPO_SPLASH_SCREEN);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void inicializarBancoDados() {
        try {
            Database dbHelper = new Database(this);
            dbHelper.getWritableDatabase();
            Log.i("Debug", "Banco de dados inicializado");
        } catch (Exception e) {
            Log.e("Debug", "Erro ao inicializar banco: " + e.getMessage());
        }
    }
}