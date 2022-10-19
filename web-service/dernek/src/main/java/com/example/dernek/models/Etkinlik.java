package com.example.dernek.models;

import javax.persistence.*;
import java.io.Serializable;

@MappedSuperclass
public abstract class Etkinlik implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;
    private String konu;
    private String icerik;
    private String gecerlilikTarihi;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getKonu() {
        return konu;
    }

    public void setKonu(String konu) {
        this.konu = konu;
    }

    public String getIcerik() {
        return icerik;
    }

    public void setIcerik(String icerik) {
        this.icerik = icerik;
    }

    public String getGecerlilikTarihi() {
        return gecerlilikTarihi;
    }

    public void setGecerlilikTarihi(String gecerlilikTarihi) {
        this.gecerlilikTarihi = gecerlilikTarihi;
    }
}
