package com.example.myapplication;

public class Manga {
    private String judul;
    private String json;

    public Manga(String judul, String json) {
        this.judul = judul;
        this.json = json;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getJson() {
        return json;
    }

    public void setJson(String json) {
        this.json = json;
    }
}
