package com.example.dernek.models;

import javax.persistence.Entity;

@Entity
public class Duyuru extends Etkinlik{
    private String resim;

    public String getResim() {
        return resim;
    }

    public void setResim(String resim) {
        this.resim = resim;
    }
}
