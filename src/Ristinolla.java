
import java.util.Random;
import java.util.Scanner;

public class Ristinolla {
    public static void main(String[] args) throws Exception {
        int tyhjätRuudut = 9;
        char[][] peliLauta = { { ' ', '|', ' ', '|', ' ' },
                { '-', '+', '-', '+', '-' },
                { ' ', '|', ' ', '|', ' ' },
                { '-', '+', '-', '+', '-' },
                { ' ', '|', ' ', '|', ' ' } };

        piirräLauta(peliLauta);

        Scanner s = new Scanner(System.in);
        Random random = new Random();
        String pelinVoitti = "";

        while (true) {

            System.out.print("Valitse ruutu (1-9): ");
            int pelaajanRuutu = s.nextInt();
            if (syoteOikein(pelaajanRuutu) && onkoTyhja(peliLauta, pelaajanRuutu)) {
                asetaNappula(peliLauta, pelaajanRuutu, "pelaaja");
                tyhjätRuudut--;
                if (tyhjätRuudut == 0) {
                    break;
                }
            } else {
                System.out.println("Syöte ei kelpaa");
                continue;
            }
            while (true) {
                int cpuRuutu = random.nextInt(9) + 1;
                if (onkoTyhja(peliLauta, cpuRuutu)) {
                    asetaNappula(peliLauta, cpuRuutu, "cpu");
                    tyhjätRuudut--;
                    if (tyhjätRuudut == 0) {
                        break;
                    }
                    break;
                } else {
                    continue;
                }

            }
            piirräLauta(peliLauta);
            char voittaja = voittajaSelvillä(peliLauta);

            if (voittaja == 'X') {
                pelinVoitti = "pelaaja";
                break;

            } else if (voittaja == 'O') {
                pelinVoitti = "tietokone";
                break;
            }
            if (tyhjätRuudut == 0) {
                break;
            }
        }

        if (tyhjätRuudut == 0) {
            System.out.println("Tasapeli");
        } else {
            System.out.println("Pelin voitti " + pelinVoitti);
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
        return syote > 0 && syote <= 9;
    }

    public static char voittajaSelvillä(char[][] peliLauta) {
        char[] symbolit = { 'X', 'O' };
        for (char symboli : symbolit) {
            if (// vaakarivit
            (peliLauta[0][0] == symboli && peliLauta[0][2] == symboli && peliLauta[0][4] == symboli)
                    || (peliLauta[2][0] == symboli && peliLauta[2][2] == symboli && peliLauta[2][4] == symboli)
                    || (peliLauta[4][0] == symboli && peliLauta[4][2] == symboli && peliLauta[4][4] == symboli)

                    // pystyrivit
                    || (peliLauta[0][0] == symboli && peliLauta[2][0] == symboli && peliLauta[4][0] == symboli)
                    || (peliLauta[0][2] == symboli && peliLauta[2][2] == symboli && peliLauta[4][2] == symboli)
                    || (peliLauta[0][4] == symboli && peliLauta[2][4] == symboli && peliLauta[4][4] == symboli)

                    // ristikkäin
                    || (peliLauta[0][0] == symboli && peliLauta[2][2] == symboli && peliLauta[4][4] == symboli)
                    || (peliLauta[0][4] == symboli && peliLauta[2][2] == symboli && peliLauta[4][0] == symboli)) {
                return symboli;
            }

        }
        return ' ';
    }
}