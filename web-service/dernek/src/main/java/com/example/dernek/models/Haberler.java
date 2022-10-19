package com.example.dernek.models;

import javax.persistence.Entity;

@Entity
public class Haberler extends Etkinlik{
    private String haberUrl;

    public String getHaberUrl() {
        return haberUrl;
    }

    public void setHaberUrl(String haberUrl) {
        this.haberUrl = haberUrl;
    }
}
