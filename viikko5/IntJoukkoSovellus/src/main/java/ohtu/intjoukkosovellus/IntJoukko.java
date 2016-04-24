package ohtu.intjoukkosovellus;

public class IntJoukko {

    public final static int KAPASITEETTI = 5, // aloitustalukon koko
            OLETUSKASVATUS = 5;  // luotava uusi taulukko on 
    // näin paljon isompi kuin vanha
    private int kasvatuskoko;     // Uusi taulukko on tämän verran vanhaa suurempi.
    private int[] taulukko;      // Joukon luvut säilytetään taulukon alkupäässä. 
    private int alkioidenLkm;    // Tyhjässä joukossa alkioiden_määrä on nolla. 

    public IntJoukko() {
        this(KAPASITEETTI, OLETUSKASVATUS);
    }

    public IntJoukko(int kapasiteetti) {
        this(kapasiteetti, OLETUSKASVATUS);
    }

    public IntJoukko(int kapasiteetti, int kasvatuskoko) {
        if (kapasiteetti < 0 || kasvatuskoko < 0) {
            throw new IndexOutOfBoundsException("Kapasitteetti tai kasvatuskoko on negatiivinen!");
        }
        taulukko = new int[kapasiteetti];
        for (int i = 0; i < taulukko.length; i++) {
            taulukko[i] = 0;
        }
        alkioidenLkm = 0;
        this.kasvatuskoko = kasvatuskoko;
    }

    public boolean lisaa(int luku) {
        if (!onTaulukossa(luku)) {
            taulukko[alkioidenLkm] = luku;
            alkioidenLkm++;
            if (alkioidenLkm == taulukko.length) {
                int[] vanha = taulukko;
                taulukko = new int[alkioidenLkm + kasvatuskoko];
                System.arraycopy(vanha, 0, taulukko, 0, vanha.length);
            }
            return true;
        }
        return false;
    }

    public boolean onTaulukossa(int luku) {
        for (int i = 0; i < alkioidenLkm; i++) {
            if (luku == taulukko[i]) {
                return true;
            }
        }
        return false;
    }

    public boolean poista(int luku) {
        int poistettavanIndex = -1;
        for (int i = 0; i < alkioidenLkm; i++) {
            if (luku == taulukko[i]) {
                poistettavanIndex = i;
                break;
            }
        }
        if (poistettavanIndex != -1) {
            for (int j = poistettavanIndex; j < alkioidenLkm - 1; j++) {
                taulukko[j] = taulukko[j + 1];
            }
            alkioidenLkm--;
            return true;
        }
        return false;
    }

    public int alkioidenLukumaara() {
        return alkioidenLkm;
    }

    @Override
    public String toString() {
        String palautus = "{";
        for (int i = 0; i < alkioidenLkm - 1; i++) {
            palautus += taulukko[i] + ", ";
        }
        if(alkioidenLkm > 0) {
            palautus += taulukko[alkioidenLkm - 1];
        }
        palautus += "}";
        return palautus;
    }

    public int[] toIntArray() {
        int[] palautus = new int[alkioidenLkm];
        System.arraycopy(taulukko, 0, palautus, 0, palautus.length);
        return palautus;
    }

    public static IntJoukko yhdiste(IntJoukko ensimmainen, IntJoukko toinen) {
        IntJoukko yhdistettyTaulukko = new IntJoukko();
        int[] ensimmainenTaulukko = ensimmainen.toIntArray();
        int[] toinenTaulukko = toinen.toIntArray();
        for (int i = 0; i < ensimmainenTaulukko.length; i++) {
            yhdistettyTaulukko.lisaa(ensimmainenTaulukko[i]);
            yhdistettyTaulukko.lisaa(toinenTaulukko[i]);
        }
        return yhdistettyTaulukko;
    }

    public static IntJoukko leikkaus(IntJoukko ensimmainen, IntJoukko toinen) {
        IntJoukko palautus = new IntJoukko();
        int[] ensimmainenTaulukko = ensimmainen.toIntArray();
        int[] toinenTaulukko = toinen.toIntArray();
        for (int i = 0; i < ensimmainenTaulukko.length; i++) {
            for (int j = 0; j < toinenTaulukko.length; j++) {
                if (ensimmainenTaulukko[i] == toinenTaulukko[j]) {
                    palautus.lisaa(toinenTaulukko[j]);
                }
            }
        }
        return palautus;

    }

    public static IntJoukko erotus(IntJoukko ensimmainen, IntJoukko toinen) {
        IntJoukko palautus = new IntJoukko();
        int[] ensimmainenTaulukko = ensimmainen.toIntArray();
        int[] toinenTaulukko = toinen.toIntArray();
        for (int i = 0; i < ensimmainenTaulukko.length; i++) {
            palautus.lisaa(ensimmainenTaulukko[i]);
        }
        for (int i = 0; i < toinenTaulukko.length; i++) {
            palautus.poista(i);
        }
        return palautus;
    }

}
