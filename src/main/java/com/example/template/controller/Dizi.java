package com.example.template.controller;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Dizi {
    @Id
    @GeneratedValue

    private Long id;
    private String isim;

    private int ilkBolumTarihi;
    private int sonBolumTarihi;

    public int getIlkBolumTarihi() {
        return ilkBolumTarihi;
    }

    public void setIlkBolumTarihi(int ilkBolumTarihi) {
        this.ilkBolumTarihi = ilkBolumTarihi;
    }

    public int getSonBolumTarihi() {
        return sonBolumTarihi;
    }

    public void setSonBolumTarihi(int sonBolumTarihi) {
        this.sonBolumTarihi = sonBolumTarihi;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getIsim() {
        return isim;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }
}
