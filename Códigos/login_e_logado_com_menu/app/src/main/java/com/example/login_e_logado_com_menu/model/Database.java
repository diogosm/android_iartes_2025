package com.example.login_e_logado_com_menu.model;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class Database extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "musicapp.db";

    private static final String SQL_CREATE_MUSIC = "CREATE TABLE musicas (" +
            "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "nome TEXT, " +
            "artista TEXT, " +
            "album TEXT, " +
            "img TEXT)";

    private static final String SQL_POPULATE_MUSIC = "INSERT INTO musicas VALUES " +
            "(NULL, 'Bring me to life', 'Evanescence', 'Fallen', '')";

    private static final String SQL_DELETE_MUSIC = "DROP TABLE IF EXISTS musicas";

    public Database(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        try {
            db.execSQL(SQL_CREATE_MUSIC);
            db.execSQL(SQL_POPULATE_MUSIC);
            Log.i("Debug", "Banco de dados criado com sucesso");
        } catch (SQLException e) {
            Log.e("Debug", "Erro ao criar banco: " + e.getMessage());
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DELETE_MUSIC);
        onCreate(db);
    }
}