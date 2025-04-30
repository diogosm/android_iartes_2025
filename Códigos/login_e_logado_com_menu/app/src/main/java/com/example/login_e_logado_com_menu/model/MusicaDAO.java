package com.example.login_e_logado_com_menu.model;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;

public class MusicaDAO {
    private Context context;
    private SQLiteDatabase database;

    public MusicaDAO(Context context) {
        this.context = context;
        this.database = (new Database(context)).getWritableDatabase();
    }

    public ArrayList<Musica> getMusicas() {
        ArrayList<Musica> result = new ArrayList<>();
        String sql = "SELECT * FROM musicas ORDER BY nome";
        Cursor cursor = database.rawQuery(sql, null);

        while (cursor.moveToNext()) {
            int id = cursor.getInt(0);
            String nome = cursor.getString(1);
            String artista = cursor.getString(2);
            String album = cursor.getString(3);
            String imagemPath = cursor.getString(4);

            result.add(new Musica(id, nome, artista, album, imagemPath));
            Log.i("Debug", "Música encontrada: " + nome + " - " + artista);
        }
        cursor.close();
        return result;
    }

    public boolean addMusica(Musica musica) {
        String sql = "INSERT INTO musicas VALUES (NULL, "
                + "'" + musica.getNome() + "', "
                + "'" + musica.getArtista() + "', "
                + "'" + musica.getAlbum() + "', "
                + "'" + musica.getImagemPath() + "')";
        try {
            database.execSQL(sql);
            Toast.makeText(context, "Música salva com sucesso!", Toast.LENGTH_SHORT).show();
            Log.i("Debug", "Música adicionada: " + musica.getNome());
            return true;
        } catch (SQLException e) {
            Toast.makeText(context, "Erro ao salvar música! " + e.getMessage(), Toast.LENGTH_SHORT).show();
            Log.e("Debug", "Erro ao adicionar música: " + e.getMessage());
            return false;
        }
    }

    public Musica getMusica(int id) {
        String sql = "SELECT * FROM musicas WHERE id=" + id;
        Cursor cursor = database.rawQuery(sql, null);

        if (cursor.moveToNext()) {
            String nome = cursor.getString(1);
            String artista = cursor.getString(2);
            String album = cursor.getString(3);
            String imagemPath = cursor.getString(4);
            cursor.close();
            return new Musica(id, nome, artista, album, imagemPath);
        }
        cursor.close();
        return null;
    }

    public boolean updateMusica(Musica musica) {
        String sql = "UPDATE musicas SET "
                + "nome='" + musica.getNome() + "', "
                + "artista='" + musica.getArtista() + "', "
                + "album='" + musica.getAlbum() + "', "
                + "img='" + musica.getImagemPath() + "' "
                + "WHERE id=" + musica.getId();
        try {
            database.execSQL(sql);
            Toast.makeText(context, "Música atualizada!", Toast.LENGTH_SHORT).show();
            return true;
        } catch (SQLException e) {
            Toast.makeText(context, "Erro ao atualizar! " + e.getMessage(), Toast.LENGTH_SHORT).show();
            return false;
        }
    }
}