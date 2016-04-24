package ohtu.intjoukkosovellus;

import java.util.Scanner;

public class Sovellus {

    private static IntJoukko A, B, C;

    private static String syote() {
        Scanner lukija = new Scanner(System.in);
        String luettu = lukija.nextLine();
        return luettu;
    }

    private static IntJoukko mikaJoukko() {
        String luettu = syote();
        while (true) {
            if (luettu.equalsIgnoreCase("a")) {
                return A;
            } else if (luettu.equalsIgnoreCase("b")) {
                return B;
            } else if (luettu.equalsIgnoreCase("c")) {
                return C;
            } else {
                System.out.println("Virheellinen joukko! " + luettu);
                System.out.print("Yritä uudelleen!");
                luettu = syote();
            }
        }
    }

    private static void lisaa() {
        Scanner lukija = new Scanner(System.in);
        System.out.print("Mihin joukkoon? ");
        IntJoukko joukko = mikaJoukko();
        System.out.println("");
        System.out.print("Mikä luku lisätään? ");
        int lisattava = lukija.nextInt();
        joukko.lisaa(lisattava);
    }

    private static void yhdiste() {
        System.out.print("1. joukko? ");
        IntJoukko ensimmainen = mikaJoukko();
        System.out.print("2. joukko? ");
        IntJoukko toinen = mikaJoukko();
        IntJoukko yhdiste = IntJoukko.yhdiste(ensimmainen, toinen);
        System.out.println("A yhdiste B = " + yhdiste.toString());
    }

    private static void leikkaus() {
        System.out.print("1. joukko? ");
        IntJoukko ensimmainen = mikaJoukko();
        System.out.print("2. joukko? ");
        IntJoukko toinen = mikaJoukko();
        IntJoukko leikkaus = IntJoukko.leikkaus(ensimmainen, toinen);
        System.out.println("A leikkaus B = " + leikkaus.toString());
    }

    private static void erotus() {
        System.out.print("1. joukko? ");
        IntJoukko ensimmainen = mikaJoukko();
        System.out.print("2. joukko? ");
        IntJoukko toinen = mikaJoukko();
        IntJoukko erotus = IntJoukko.erotus(ensimmainen, toinen);
        System.out.println("A erotus B = " + erotus.toString());
    }

    private static void poista() {
        Scanner lukija = new Scanner(System.in);
        System.out.print("Mistä joukosta? ");
        IntJoukko joukko = mikaJoukko();
        System.out.print("Mikä luku poistetaan? ");
        int poistettava = lukija.nextInt();
        joukko.poista(poistettava);
    }

    private static void kuuluu() {
        Scanner lukija = new Scanner(System.in);
        System.out.print("Mihin joukkoon? ");
        IntJoukko joukko = mikaJoukko();
        System.out.print("Mikä luku? ");
        int etsittava = lukija.nextInt();
        boolean kuuluuko = joukko.onTaulukossa(etsittava);
        if (kuuluuko) {
            System.out.println(etsittava + " kuuluu joukkoon ");
        } else {
            System.out.println(etsittava + " ei kuulu joukkoon ");
        }
    }

    public static void main(String[] args) {
        A = new IntJoukko();
        B = new IntJoukko();
        C = new IntJoukko();

        alkuHopinat();

        Scanner lukija = new Scanner(System.in);
        while (true) {
            String luettu = lukija.nextLine();
            if (luettu.equals("lisää") || luettu.equals("li")) {
                lisaa();
            } else if (luettu.equalsIgnoreCase("poista") || luettu.equalsIgnoreCase("p")) {
                poista();
            } else if (luettu.equalsIgnoreCase("kuuluu") || luettu.equalsIgnoreCase("k")) {
                kuuluu();
            } else if (luettu.equalsIgnoreCase("yhdiste") || luettu.equalsIgnoreCase("y")) {
                yhdiste();
            } else if (luettu.equalsIgnoreCase("leikkaus") || luettu.equalsIgnoreCase("le")) {
                leikkaus();
            } else if (luettu.equalsIgnoreCase("erotus") || luettu.equalsIgnoreCase("e")) {
                erotus();
            } else if (luettu.equalsIgnoreCase("A")) {
                System.out.println(A);
            } else if (luettu.equalsIgnoreCase("B")) {
                System.out.println(B);
            } else if (luettu.equalsIgnoreCase("C")) {
                System.out.println(C);
            } else if (luettu.equalsIgnoreCase("lopeta") || luettu.equalsIgnoreCase("quit") || luettu.equalsIgnoreCase("q")) {
                System.out.println("Lopetetaan, moikka!");
                break;
            } else {
                System.out.println("Virheellinen komento! " + luettu);
                System.out.println("Komennot ovat lisää(li), poista(p), kuuluu(k), yhdiste(y), erotus(e) ja leikkaus(le).");
            }
            System.out.println("Komennot ovat lisää(li), poista(p), kuuluu(k), yhdiste(y), erotus(e) ja leikkaus(le).");
        }
    }
    
    public static void alkuHopinat() {
        System.out.println("Tervetuloa joukkolaboratorioon!");
        System.out.println("Käytössäsi ovat joukot A, B ja C.");
        System.out.println("Komennot ovat lisää(li), poista(p), kuuluu(k), yhdiste(y), erotus(e), leikkaus(le) ja lopetus(quit)(q).");
        System.out.println("Joukon nimi komentona tarkoittaa pyyntöä tulostaa joukko.");
    }
}
