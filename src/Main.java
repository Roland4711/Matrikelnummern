import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int matrNummer = 777777; // Eine sechsstellige Matrikelnummer

        // Prüfen, ob die Matrikelnummer richtig ist
        boolean istRichtig = checkMatrikelnummer(matrNummer);
        System.out.println("Prüfung, ob die Matrikelnnumer " + matrNummer + " eine richtige Prüfziffer hat. Ergebnis: " + istRichtig);

        // Korrekte Prüfziffer berechnen
        int y = berechnePruefziffer(matrNummer);
        System.out.println("Die richtige Prüfziffer der Matrikelnummer " + matrNummer + " lautet: " + y);

        // eine gültige Matrikelnummer erzeugen
        int rndMatrikelnummer = generiereMatrikelnummer();
        System.out.println("Zufällig Matrikelnummer mit korrekter Prüfziffer: " + rndMatrikelnummer);

        // signifikanten Ziffern die korrekte Prüfziffer anhängen
        int erzeugteMatrikelnummer = generiereMatrikelnummer(12345);
        System.out.println("Aus den signifikatnen Ziffern 12345 wird die Matrikelnnumer " + erzeugteMatrikelnummer);

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

        for (int gewichtung = 0; m>0; gewichtung++) {
            int aktuelleZiffer = m % 10;
            gewSumme += gewichtung * aktuelleZiffer;
            m /= 10;
        }

        int pZiffer = 11 - (gewSumme % 11);
        if (pZiffer >= 10) { pZiffer = 0; }
        return pZiffer;
    }

    /**
     * Generiert eine zufällige sechsstellige Matrikelnummer mit Korrekter Prüfziffer
     * @return eine Matrikelnummer
     */
    public static int generiereMatrikelnummer() {
        Random random = new Random();
        // Zufällige 5 signifikante Ziffern generieren
        int signZiffern = random.nextInt(99999 - 10000) + 10000;
        return generiereMatrikelnummer(signZiffern);
    }

    /**
     * Generiert aus einer gegebenen Nummer mit den signifikanten 5 Ziffern eine
     * korrekte Matrikelnummer mit 6 Ziffern.
     * Funktioniert auf mit mehr oder weniger signikanten Ziffern, aber bei der
     * Hochschule Düsseldorf gibt es immer 5 signifikante Ziffern
     * @param signZiffern Zahl mit den signifikanten n Ziffern
     * @return Matrikelnummer mit (n+1) Ziffern
     */
    public static int generiereMatrikelnummer(int signZiffern) {
        signZiffern *= 10; // Ziffer Null an die signifikanten Ziffern hängen

        // Richtige Prüfziffer berechnen und addieren
        return signZiffern + berechnePruefziffer(signZiffern);
    }
}
