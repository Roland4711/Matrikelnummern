public class Main {
    public static void main(String[] args) {
        // Prüfziffer ist richtig
        int y = berechnePruefziffer(777775);
        System.out.println(y);
    }

    static int berechnePruefziffer(int m) {
        int gewSumme = 0;

        for (int Gewichtung = 0; m>0; Gewichtung++) {
            int aktuelleZiffer = m % 10;
            gewSumme += Gewichtung * aktuelleZiffer;
            m /= 10;
        }

        int pZiffer = 11 - (gewSumme % 11);
        if (pZiffer >= 10) { pZiffer = 0; }
        return pZiffer;
    }
}