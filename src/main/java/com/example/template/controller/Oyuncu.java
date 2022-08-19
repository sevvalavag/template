package com.example.template.controller;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Oyuncu {

    @Id
    @GeneratedValue
    long id;
    String isim;
    String dogumTarihi;
    String boy;
    @OneToMany
    private List<Dizi> diziler = new ArrayList<>();

    public List<Dizi> getDiziler() {
        return diziler;
    }

    public void setDiziler(List<Dizi> diziler) {
        this.diziler = diziler;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getIsim() {
        return isim;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }

    public String getDogumTarihi() {
        return dogumTarihi;
    }

    public void setDogumTarihi(String dogumTarihi) {
        this.dogumTarihi = dogumTarihi;
    }

    public String getBoy() {
        return boy;
    }

    public void setBoy(String boy) {
        this.boy = boy;
    }


}
