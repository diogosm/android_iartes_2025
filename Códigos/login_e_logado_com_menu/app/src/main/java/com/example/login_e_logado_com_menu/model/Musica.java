package com.example.login_e_logado_com_menu.model;

public class Musica {
    private int id;
    private String nome;
    private String artista;
    private String album;
    private String imagemPath;

    public Musica(int id, String nome, String artista, String album, String imagemPath) {
        this.id = id;
        this.nome = nome;
        this.artista = artista;
        this.album = album;
        this.imagemPath = imagemPath;
    }

    public Musica(String nome, String artista, String album, String imagemPath) {
        this.nome = nome;
        this.artista = artista;
        this.album = album;
        this.imagemPath = imagemPath;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getImagemPath() {
        return imagemPath;
    }

    public void setImagemPath(String imagemPath) {
        this.imagemPath = imagemPath;
    }
}