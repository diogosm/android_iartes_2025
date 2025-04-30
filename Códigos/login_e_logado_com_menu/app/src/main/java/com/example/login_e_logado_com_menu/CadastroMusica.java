package com.example.login_e_logado_com_menu;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.annotation.Nullable;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.login_e_logado_com_menu.model.Musica;
import com.example.login_e_logado_com_menu.model.MusicaDAO;

import java.util.ArrayList;

public class CadastroMusica extends AppCompatActivity {

    private static final int IMG_REQUEST = 1;

    private EditText editNome;
    private EditText editArtista;
    private EditText editAlbum;
    private ImageView imageView;
    private String img = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_cadastro_musica);

        editNome = findViewById(R.id.editNome);
        editArtista = findViewById(R.id.editArtista);
        editAlbum = findViewById(R.id.editAlbum);
        imageView = findViewById(R.id.imageView);

        // para fins de debug, verifica o que já existe
        // mais pra frente iremos implementar a tela de visualização de itens
        MusicaDAO musicaDAO = new MusicaDAO(this);
        ArrayList<Musica> listaMusicas = musicaDAO.getMusicas();

        Log.i("Debug", "Há " + listaMusicas.size() + " músicas no banco");
        for (Musica musica : listaMusicas) {
            Log.i("Debug", "Música: " + musica.getNome() + ", Artista: " + musica.getArtista());
        }
    }

    public void escolherImagem(View view) {
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(intent, IMG_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == IMG_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null) {
            Uri uri = data.getData();
            imageView.setImageURI(uri);
            img = uri.toString();
        }
    }

    public void salvarMusica(View view) {
        String nome = editNome.getText().toString().trim();
        String artista = editArtista.getText().toString().trim();
        String album = editAlbum.getText().toString().trim();

        if (nome.isEmpty() || artista.isEmpty() || album.isEmpty()) {
            Toast.makeText(this, "Preencha todos os campos!", Toast.LENGTH_SHORT).show();
            return;
        }

        Musica musica = new Musica(nome, artista, album, img);
        MusicaDAO dao = new MusicaDAO(this);

        if (dao.addMusica(musica)) {
            finish();
        }
    }
}