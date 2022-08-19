package sevval_main;

import java.io.File;
import java.util.List;

public class Oyuncu {

    public String isim ;
    public List<String> diziler ;
    public final File okunandosya ;
    public String dogumtarihi;


    public Oyuncu(String isim, List<String> diziler,File okunandosya,String dogumtarihi){

        this.isim = isim ;
        this.diziler = diziler;
        this.okunandosya = okunandosya ;
        this.dogumtarihi = dogumtarihi ;
    }

    public String getIsim() {
        return isim;
    }

    public List<String> getDiziler() {
        return diziler;
    }

    public File getOkunandosya() {
        return okunandosya;
    }

    public String getDogumtarihi() {
        return dogumtarihi;
    }

}
