import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        Pelilauta lauta = new Pelilauta();
        lauta.piirraPelilauta();

    }

}

class Pelilauta {
    ArrayList<String> lauta;

    public Pelilauta() {
        this.lauta = new ArrayList<>(Arrays.asList("-", "-", "-", "-", "-", "-", "-", "-", "-"));
    }

    public void piirraPelilauta() {
        for (String merkki : lauta) {
            System.out.println(merkki);
        }
    }

}