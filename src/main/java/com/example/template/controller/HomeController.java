package com.example.template.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import sevval_main.DosyaIsleyici;
import sevval_main.Oyuncu;
import sevval_main.RandomStringOlustur;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static java.lang.System.out;


@Controller
public class HomeController {


    @Autowired
    OyuncuRepository oyuncuRepository ;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("message", "Welcome!");
        model.addAttribute("oyuncusayisi", "10");
        return "index";
    }

    @GetMapping("/oyuncular")
    public String sayHello(Model model) {

//        Oyuncu[] oyuncular = DosyaIsleyici.oyuncularıOku();
//        model.addAttribute("oyuncular", oyuncular);
//
//        String isimler = "";
//
//        for (int i = 0; i < oyuncular.length; i++) {
//            String name = oyuncular[i].okunandosya.getName();
//            isimler += "<a href=\"oyuncudetay?filename=%s\"> %s</a><br/>\n".formatted(name, oyuncular[i].isim);
//        }


        Iterable<com.example.template.controller.Oyuncu> oyuncular = oyuncuRepository.findAll();
        model.addAttribute("oyuncular", oyuncular);


        return "oyuncular"; //jsp dosyasına gider.(Response body yazmadığı için)
    }


    @GetMapping("/oyuncudetay")
    public String oyuncuDetayi(@RequestParam("id") long id, Model model) {

//        try {
//            Oyuncu okunanoyuncu = DosyaIsleyici.oyuncuOku(new File("data/" + filename));
//            model.addAttribute("oyuncu", okunanoyuncu);
//
//
//            return "oyuncudetay";
//
//        } catch (IOException e) {
//            throw new RuntimeException(e); //404
//        }

        Optional<com.example.template.controller.Oyuncu> byId = oyuncuRepository.findById(id);
        com.example.template.controller.Oyuncu oyuncu = byId.get();
        model.addAttribute("oyuncu",oyuncu);


        return "oyuncudetay";

    }

    @PostMapping("/yenioyuncu")
    @ResponseBody()
    public String yenioyunucuPost(@RequestParam(name = "gelenisim") String isim) {

        return isim + "<button>Kaydet</button>";

    }


    @GetMapping("/yenioyuncu")
    public String yeniOyuncu(@RequestParam("isim") String gelenisim,Model model) {

//        File dosya = new File("data/" + RandomStringOlustur.randomString(5));
//        Oyuncu yenioyuncu = null;
//
//        try {
//
//            dosyayaYaz(gelenisim, dosya);
//            yenioyuncu = DosyaIsleyici.oyuncuOku(dosya);
//            model.addAttribute("oyuncu",yenioyuncu);
//
//
//        } catch (IOException e) {
//
//            throw new RuntimeException(e);
//        }

        com.example.template.controller.Oyuncu oyuncu = new com.example.template.controller.Oyuncu();
        oyuncu.setIsim(gelenisim);
        oyuncuRepository.save(oyuncu);
        model.addAttribute("oyuncu",oyuncu);


          return "yenioyuncu";


    }

    /**
     * dosya parametresiyle verilen dosyanın içine oyuncunun bilgilerini yazar.
     *
     * @param gelenisim oyuncunun ismi
     * @param dosya     yazılacak dosya
     */
    private void dosyayaYaz(String gelenisim, File dosya) {

        try {

            FileOutputStream stream = new FileOutputStream(dosya);

            PrintStream out = new PrintStream(stream);

            Oyuncu yenioyuncu = new Oyuncu(gelenisim, new ArrayList<>(), dosya, "2001");

            out.println(yenioyuncu.isim);
            out.println(yenioyuncu.dogumtarihi);
            out.println(yenioyuncu.diziler);

        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
    }


    private void dosyayaYaz2(Oyuncu oyuncu, File dosya) {

        try {

            FileOutputStream stream = new FileOutputStream(dosya);

            PrintStream out = new PrintStream(stream);

            Oyuncu yenioyuncu = new Oyuncu(oyuncu.isim, new ArrayList<>(), dosya, "2001");


        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }

    }


    @PostMapping("/oyuncudetay")
    @ResponseBody()
    public String dizileriKaydet(@RequestParam(name = "dname") String dname,
                                 @RequestParam(name = "filename") String dosyaadı ) {

        File dosya = new File("data/" + dosyaadı);
        Oyuncu oyuncu ;

        try {
             oyuncu = DosyaIsleyici.oyuncuOku(dosya);
             dosya.delete();

            File dosya2 = new File("data/" + dosyaadı);
            FileOutputStream stream = new FileOutputStream(dosya);

            PrintStream out = new PrintStream(stream);

            oyuncu = new Oyuncu(oyuncu.isim, oyuncu.diziler, dosya2, "2001");
            oyuncu.diziler.add(dname);

            out.println(oyuncu.isim);
            out.println(oyuncu.dogumtarihi);
            out.println(oyuncu.diziler);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

//        com.example.template.controller.Oyuncu oyuncu = new com.example.template.controller.Oyuncu();
//        Optional<com.example.template.controller.Oyuncu> byId = oyuncuRepository.findById(id);

        return oyuncu.isim + "<br>" + oyuncu.dogumtarihi + "<br>" + oyuncu.diziler;

    }
}





