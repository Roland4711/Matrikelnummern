public class Main {
    public static void main(String[] args) {
        int matrNummer = 777777; // Eine sechsstellige Matrikelnummer

        // Prüfen, ob die Matrikelnummer richtig ist
        boolean istRichtig = checkMatrikelnummer(matrNummer);
        System.out.println("Prüfung, ob die Matrikelnnumer " + matrNummer + " eine richtige Prüfziffer hat. Ergebnis: " + istRichtig);

        // Korrekte Prüfziffer berechnen
        int y = berechnePruefziffer(matrNummer);
        System.out.println("Die richtige Prüfziffer der Matrikelnummer " + matrNummer + " lautet: " + y);
    }

    /**
     * Prüft, ob von einer Matrikelnummer die letzte Ziffer der berechneten Prüfziffer entspricht
     * @param mNummer Matrikelnnumer der HSD
     * @return true, wenn die Prüfziffer korrekt ist.
     */
    static boolean checkMatrikelnummer (int mNummer) {

        // Die letzte Ziffer ist die Prüfziffer
        // Die letzte Ziffer einer Zahl wird bestimmt mit Modulo 10
        int pZiffer = mNummer % 10;

        // Der Rückgabewert wird bestimmt mit dem Vergleich, ob die
        // letzte Ziffer der Matrikelnummer mit der Berechnung der
        // Prüfziffer identisch ist.

        return pZiffer == berechnePruefziffer(mNummer);
    }

    /**
     * Berechnet von einer (sechsstelligen) Matrikelnummer die Prüfziffer.
     * Die Prüfziffer ist richtig, wenn die letzte Ziffer der Matrikelnummer
     * der berechneten Prüfziffer entspricht
     * @param m eine Matrikelnummer
     * @return Prüfziffer der Matrikelnummer
     */
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