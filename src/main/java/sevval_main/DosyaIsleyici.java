package sevval_main;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class DosyaIsleyici {


    /**
     * oyuncularıOku metodu data klasöründeki dosyaları okur.
     * @return Oyuncu array
     */
    public static Oyuncu[] oyuncularıOku() {
        File klasör = new File("data");

        File[] files = klasör.listFiles();

        Oyuncu[] oyuncular = new Oyuncu[files.length];

        for (int i = 0; i < files.length; i++) {
            try {

                oyuncular[i] = oyuncuOku(files[i]);
            } catch (FileNotFoundException exception) {

                exception.printStackTrace();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
//        oyuncular[files.length] = new sevval_main.Oyuncu("Çağatay Ulusoy", new ArrayList<>());
//        oyuncular[files.length + 1] = new sevval_main.Oyuncu("Emre Kınay", new ArrayList<>());
        return oyuncular;
    }

    public static Oyuncu oyuncuOku(File file) throws IOException {
        File okunandosya = file;

        FileInputStream dosyaokuyucu = new FileInputStream(okunandosya); // sadece okunabilecek hale getirir.Oluşturmak zorunda
        // çünkü oluşturmak da yazmak dır.
        Scanner input = new Scanner(dosyaokuyucu);
        String isim = input.nextLine();
        String dogumTarihi = null;
        List<String> strings = new ArrayList<>();

        if (input.hasNextLine()) {

            dogumTarihi = input.nextLine();

            if (dogumTarihi.equals("")) {

                dogumTarihi = null;

            }

            if (input.hasNextLine()) {
                String dizilersatırı = input.nextLine();
                String[] split = dizilersatırı.split(",");// virgüle bakıp satırı böler.
                strings = Arrays.asList(split);// arrayı liste cevirdik.

            } else {

                strings = new ArrayList<>();
            }
        }

        dosyaokuyucu.close();

        return new Oyuncu(isim, new ArrayList<>(strings), okunandosya, dogumTarihi);
    }
}
