package com.example.login_e_logado_com_menu;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.preference.PreferenceManager;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    public EditText login;
    public EditText password;
    public TextView usuarioinvalido;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //inicializo a tela
        setContentView(R.layout.activity_main);

        Log.i("Debug", "minha msg");

        //inicializo os campos de login e senha
        login = findViewById(R.id.editLogin);
        password = findViewById(R.id.editTextTextPassword);
        usuarioinvalido = findViewById(R.id.usuarioinvalido);

        EdgeToEdge.enable(this);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void fazLogin(View view){
        String msg = "O login é " +
                login.getText().toString() +
                " e a senha é " +
                password.getText().toString();

        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        String senhaPadrao = sharedPreferences.getString("senha_padrao", "admin");

//        SharedPreferences.Editor editor = sharedPreferences.edit();
//        editor.putString("senha_padrao", "senha2");
//        editor.apply();

        Log.i("Debug", "A senha padrão é: " + senhaPadrao);

        if(
                login.getText().toString().equals("admin")
                        && password.getText().toString().equals(senhaPadrao)
        ){
            Toast notif = Toast.makeText(this,
                    msg,
                    Toast.LENGTH_LONG);
            notif.show();
            //acesso uma activity nova através da Intent
            Intent intent = new Intent(MainActivity.this, tela_logada.class);
            intent.putExtra("usuario", login.getText().toString());

            startActivity(intent);

            // Se quiserem matar essa activity
            // finish();
        }else{
            //ta errado user e senha
            usuarioinvalido.setVisibility(View.VISIBLE);
        }
    }

}