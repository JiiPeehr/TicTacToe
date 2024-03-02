
import java.util.Random;
import java.util.Scanner;

public class Ristinolla {
    public static void main(String[] args) throws Exception {

        char[][] peliLauta = { { ' ', '|', ' ', '|', ' ' },
                { '-', '+', '-', '+', '-' },
                { ' ', '|', ' ', '|', ' ' },
                { '-', '+', '-', '+', '-' },
                { ' ', '|', ' ', '|', ' ' } };

        piirräLauta(peliLauta);

        Scanner s = new Scanner(System.in);
        Random random = new Random();

        while (true) {

            System.out.print("Valitse ruutu (0-9): ");
            int pelaajanRuutu = s.nextInt();
            if (syoteOikein(pelaajanRuutu) && onkoTyhja(peliLauta, pelaajanRuutu)) {
                asetaNappula(peliLauta, pelaajanRuutu, "pelaaja");
            } else {
                System.out.println("Syöte ei kelpaa");
                continue;
            }
            while (true) {
                int cpuRuutu = random.nextInt(10);
                if (onkoTyhja(peliLauta, cpuRuutu)) {
                    asetaNappula(peliLauta, cpuRuutu, "cpu");
                    break;
                } else {
                    continue;
                }

            }
            piirräLauta(peliLauta);
        }

    }

    public static void piirräLauta(char[][] peliLauta) {
        for (char[] rivi : peliLauta) {
            for (char c : rivi) {
                System.out.print(c);
            }
            System.out.println();
        }
    }

    public static void asetaNappula(char[][] peliLauta, int ruutu, String pelaaja) {
        char symboli = ' ';
        if (pelaaja.equals("pelaaja")) {
            symboli = 'X';
        } else if (pelaaja.equals("cpu")) {
            symboli = 'O';
        }

        switch (ruutu) {
            case 1:
                peliLauta[0][0] = symboli;
                break;
            case 2:
                peliLauta[0][2] = symboli;
                break;
            case 3:
                peliLauta[0][4] = symboli;
                break;
            case 4:
                peliLauta[2][0] = symboli;
                break;
            case 5:
                peliLauta[2][2] = symboli;
                break;
            case 6:
                peliLauta[2][4] = symboli;
                break;
            case 7:
                peliLauta[4][0] = symboli;
                break;
            case 8:
                peliLauta[4][2] = symboli;
                break;
            case 9:
                peliLauta[4][4] = symboli;
                break;
            default:
                break;
        }

    }

    public static boolean onkoTyhja(char[][] peliLauta, int ruutu) {
        switch (ruutu) {
            case 1:
                return peliLauta[0][0] == ' ';
            case 2:
                return peliLauta[0][2] == ' ';
            case 3:
                return peliLauta[0][4] == ' ';
            case 4:
                return peliLauta[2][0] == ' ';
            case 5:
                return peliLauta[2][2] == ' ';
            case 6:
                return peliLauta[2][4] == ' ';
            case 7:
                return peliLauta[4][0] == ' ';
            case 8:
                return peliLauta[4][2] == ' ';
            case 9:
                return peliLauta[4][4] == ' ';
            default:
                return true;
        }
    }

    public static boolean syoteOikein(int syote) {
        return syote >= 0 && syote <= 9;
    }

}