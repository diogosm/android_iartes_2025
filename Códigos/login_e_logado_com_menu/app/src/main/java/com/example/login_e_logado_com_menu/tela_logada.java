package com.example.login_e_logado_com_menu;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

public class tela_logada extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawer;
    private TextView usuarioLogadoTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_logada);

        // Configurando o Toolbar e o Navigation Drawer
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar,
                R.string.menu_open,
                R.string.menu_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        usuarioLogadoTextView = findViewById(R.id.usuarioLogadoTextView);

        String nomeUsuario = getIntent().getStringExtra("usuario");
        if (nomeUsuario != null && !nomeUsuario.isEmpty()) {
            usuarioLogadoTextView.setText("Usuário logado: " + nomeUsuario);
        }
    }

    public void abrirCadastroMusica(View view) {
        Intent intent = new Intent(this, CadastroMusica.class);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        // Fecha o drawer se estiver aberto quando o botão voltar clicado
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            Toast.makeText(this, "Clicou em Home", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.nav_perfil) {
            Toast.makeText(this, "Clicou em Perfil", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.nav_configuracoes) {
            Toast.makeText(this, "Clicou em Configurações", Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(this, PreferencesActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_compartilhar) {
            Toast.makeText(this, "Clicou em Compartilhar", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.nav_sobre) {
            Toast.makeText(this, "Clicou em Sobre", Toast.LENGTH_SHORT).show();
        }

        //fecha depois do taoast
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}