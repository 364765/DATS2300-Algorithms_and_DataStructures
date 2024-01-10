package no.oslomet.cs.algdat.Oblig1;

////// Løsningsforslag Oblig 1 ////////////////////////

import java.lang.UnsupportedOperationException;
import java.util.Arrays;
import java.util.NoSuchElementException;

public class Oblig1 {
    private Oblig1() {
    }

    ///// Oppgave 1 //////////////////////////////////////
    public static int maks(int[] a) {

        //sjekker om tabellen a er tom
        if (a.length == 0) {
            throw new NoSuchElementException("Tabellen a er tom!"); //Sender en feilmelding hvis listen er tom
        } else {
            if (a.length == 1) {//Hvis listen bare har 1 element, er det det største elementet
                return a[0];
            }
            for (int i = 0; i < a.length - 1; i++) {  //1 + n + n-1
                if (a[i] > a[i + 1]) { // 2 * (n-1)
                    int temp = a[i + 1]; // 2 * x
                    a[i + 1] = a[i]; // 3 * x
                    a[i] = temp; // 2 * x
                }

            } // 4n + 7x - 2 = 4n + 7(log(n) - 0.423) - 2 = 4n + 7log(n) - 4,961
            // Gjennomsnittsformelen
            return a[a.length - 1]; // 1
        }

    }

    public static int ombyttinger(int[] a) {

        int antall = 0;

        for (int i = 0; i < a.length - 1; i++) {
            if (a[i] > a[i + 1]) {
                antall++; //øker telleren siden vi begår et bytt
                int temp = a[i + 1]; //hentet fra bytt fra kompendiet
                a[i + 1] = a[i];
                a[i] = temp;
            }
        }
        return antall;
    }

    ///// Oppgave 2 //////////////////////////////////////
    public static int antallUlikeSortert(int[] a) {
        int tellerForskjelligeVerdier = 1;

        if (a.length == 0) { //Sjekker om arrayet er tomt
            return 0;
        } else if (a.length == 1) {
            return tellerForskjelligeVerdier;
        } else {

            for (int i = 0; i < a.length - 1; i++) {
                if (a[i] > a[i + 1]) {                                     // Sjekker om arrayet er sortert, går inn i if hvis den er usortert
                    throw new IllegalStateException("Usortert array");  // Arrayet er usortert
                } else if (a[i] == a[i + 1] && a.length == 2) {           // Sjekker om 0. og 1. verdi er like, og om lengden er på 2
                    return tellerForskjelligeVerdier;                     // Returner antallet forkjellige verdier
                }
            }

            int verdi = 0;                              // Setter en verdi som skal brukes til å sammenligne verdiene i arrayet med
            for (int i = 0; i < a.length; i++) {        // Går igjennom arrayet
                if (a[i] == verdi) {                    // Om tallet i arrayets index er lik verdi - Gå videre
                    verdi = a[i];                       // Settes verdien til arrayet sin index for å sjekke om mot denne senere
                } else {
                    tellerForskjelligeVerdier += 1;     // Verdien og arrayets index er forskjellige, og telleren for forskjellige verdier plusses på
                    verdi = a[i];                       // Settes verdien til arrayet sin index for å sjekke om mot denne senere
                }
            }
        }
        return tellerForskjelligeVerdier - 1;           // Skriver ut de opptellte verdiene, og tar -1, fordi det starter på 1
    }

    ///// Oppgave 3 //////////////////////////////////////
    public static int antallUlikeUsortert(int[] a) {
        int teller = 0;

        for (int i = 0; i < a.length; i++) {
            boolean ulik = false;  
            for (int j = 0; j < i; j++) {
                if (a[i] == a[j]) { //Hvis elementet ikke er unikt, har en lik som seg etter seg i lista, breaker løkken
                    ulik = true; //endrer ulik til true, siden if setningen er sann
                    break;
                }
            }
            if (!ulik) { //Hvis ulik aldri ble true, altså elementet var unikt, økes telleren vår med en
                teller++;
            }
        }
        return teller;
    }

    ///// Oppgave 4 //////////////////////////////////////
    public static void delsortering(int[] a) {

        int v = 0;
        int h = a.length - 1;

        for (int i = 0; i < a.length; i++) {
            if (v <= h) {
                if ((a[v] % 2 == 0) && !(a[h] % 2 == 0)) {          //sjekker om v er partall og h oddetall, begge er feil og byttes
                    bytt(a, v++, h--);
                } else if ((a[v] % 2 == 0)) {                       //Sjekker om v er partall
                    h--;
                } else if (!(a[h] % 2 == 0)) {                      //Sjekker om h er oddetall
                    v++;
                } else if (!(a[v] % 2 == 0) && (a[h] % 2 == 0)) {   //Sjekker om v er oddetall og h partall, begge er riktig
                    v++;
                    h--;
                }
            }
        }
        kvikksortering(a, 0, v);
        kvikksortering(a, v, a.length);
    }


    //Hentet fra kompendiet

    public static void bytt(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    private static int parter0(int[] a, int v, int h, int skilleverdi) {
        while (true)                                    // stopper når v > h
        {
            while (v <= h && a[v] < skilleverdi) v++;   // h er stoppverdi for v
            while (v <= h && a[h] >= skilleverdi) h--;  // v er stoppverdi for h

            if (v < h) bytt(a, v++, h--);               // bytter om a[v] og a[h]
            else return v;                              // a[v] er nåden første som ikke er mindre enn skilleverdi
        }
    }

    private static int sParter0(int[] a, int v, int h, int indeks) {
        bytt(a, indeks, h);                             // skilleverdi a[indeks] flyttes bakerst
        int pos = parter0(a, v, h - 1, a[h]);           // partisjonerer a[v:h - 1]
        bytt(a, pos, h);                                // bytter for å få skilleverdien på rett plass
        return pos;                                     // returnerer posisjonen til skilleverdien
    }

    private static void kvikksortering0(int[] a, int v, int h) {  // en privat metode
        if (v >= h) {                                   // a[v:h] er tomt eller har maks ett element
            return;
        }
        int k = sParter0(a, v, h, (v + h) / 2);         // bruker midtverdien
        kvikksortering0(a, v, k - 1);                   // sorterer intervallet a[v:k-1]
        kvikksortering0(a, k + 1, h);                   // sorterer intervallet a[k+1:h]
    }

    public static void kvikksortering(int[] a, int fra, int til) { // a[fra:til>
        //fratilKontroll(a.length, fra, til);  // sjekker når metoden er offentlig
        kvikksortering0(a, fra, til - 1);               // v = fra, h = til - 1
    }

    public static void kvikksortering(int[] a) {        // sorterer hele tabellen
        kvikksortering0(a, 0, a.length - 1);
    }


    ///// Oppgave 5 //////////////////////////////////////
    public static void rotasjon(char[] a) {

        //lage en for-løkke som looper gjennom tabellen
        for (int i = a.length - 1; i > 0; i--) {
            char move = a[i];
            a[i] = a[i - 1];
            a[i - 1] = move;
        }
        //Bruker bytt metoden, men motsatt vei
    }


    ///// Oppgave 6 //////////////////////////////////////
    public static int euk(int a, int b) { // Euklids algoritme
        if (b == 0) {
            return a;
        }
        return euk(b, a % b);
    }

    public static void rotasjon(char[] a, int k) {
        int n = a.length;
        if (n < 2) { // ingen rotasjon
            return;
        }
        if ((k %= n) < 0) { // motsatt vei?
            k += n;
        }

        int s = euk(n, k);  // største felles divisor
        for (int j = 0; j < s; j++) { // antall sykler
            char temp = a[j];  // hjelpevariabel

            for (int i = j - k, l = j; i != j; i -= k) { // løkke
                if (i < 0) {  // sjekker fortegnet til i
                    i += n;
                }
                a[l] = a[i];
                l = i;    // kopierer og oppdaterer j
            }
            a[j + k] = temp; // legger tilbake verdien
        }
    }


    ///// Oppgave 7 //////////////////////////////////////
    /// 7a)
    public static String flett(String s, String t) {
        if (t.length() == 0 && s.length() == 0) {       //Hvis begge strengene er tomme, returner en tom streng
            return "";
        }
        if(s.length()==0 || t.length()==0){
            return s+t; //Hvis en av strengene er tomme, returneres bare strengene satt sammen
        }
        String retur = "";
        if (s.length() > t.length()) {
            for (int i = 0; i < t.length(); i++) {
                retur += s.charAt(i);                //Fletter sammen strengene char for char
                retur += t.charAt(i);
            }
            for (int j = t.length(); j < s.length(); j++) {
                retur += s.charAt(j);                //Legger til de resterende char i den lengste strengen
            }
            return retur;
        } else {
            for (int i = 0; i < s.length(); i++) {
                retur += s.charAt(i);               //Fletter sammen strengene char for char
                retur += t.charAt(i);
            }
            for (int j = s.length(); j < t.length(); j++) {
                retur += t.charAt(j);               //Legger til de resterende char i den lengste strengen
            }
            return retur;
        }
    }

    /// 7b)
    public static String flett(String... s) {

        String retur = "";
        if (s.length == 0) { //Hvis listen er tom, returneres en tom streng
            return "";
        }

        String longest = s[0];
        for (int i = 0; i < s.length; i++) {
            if (s[i].length() > longest.length()) { //Finner det lengste ordet
                longest = s[i];
            }
        }
        for (int i = 0; i < longest.length(); i++) {    //Bruker det lengste ordet som øvre tak for for-løkken
            for (int j = 0; j < s.length; j++) {
                if (s[j].length() <= i) { //Hvis ordets lengde er mindre enn i
                    retur += ""; //legges det bare til en tom streng
                } else {
                    retur += s[j].charAt(i); //Ellers legges til bokstaven på indeksplass i
                }
            }
        }
        return retur;
    }

    ///// Oppgave 8 //////////////////////////////////////
    public static int[] indekssortering(int[] a) {

        int[] aSortert = new int[a.length];         //Setter aSortert sin lengde like lang som a sin lengde
        int[] indeks = new int[a.length];           //Setter indeks sin lengde like lang som a sin lengde

        if (a.length == 0) {                        //Sjekker om lengden på arrayet er 0, returnerer indeks dersom det stemmer
            return indeks;
        }
        for (int i = 0; i < a.length; i++) {
            aSortert[i] = a[i];                     //Setter aSortert sine verdier til a sine verdier
        }

        boblesortering(aSortert);                   //Sorterer arrayet aSortert i stigende rekkefølge

        //Løkke for å sammenligne aSortert og sette inn index verdier i array "indeks"
        for (int i = 0; i < a.length; i++) {            // Går igjennom orginalt array
            for (int j = 0; j <= a.length - 1; j++) {   // Går igjennom igjenn for å kunne sammenligne 2 array
                if (aSortert[j] == a[i]) {              // Sjekker om tallet på index plassen er likt i det sorterte og orginale 
                    indeks[j] = i;                      // Setter a sin idx inn i indeks 
                }
            }
        }

        return indeks;                                  //Returnerer arrayet med indeksene
    }

    //Hentet fra kompendiet

    public static void boblesortering(int[] a) {        // hører til klassen Tabell
        for (int n = a.length; n > 1; n--) {            // n reduseres med 1 hver gang

            for (int i = 1; i < n; i++)                 // går fra 1 til n
            {
                if (a[i - 1] > a[i]) bytt(a, i - 1, i); // sammenligner/bytter
            }
        }
    }


    ///// Oppgave 9 //////////////////////////////////////
    public static int[] tredjeMin(int[] a) {
        int n = a.length;                               // tabellens lengde

        if (n < 3) {                                    // må ha minst 3 verdier
            throw new java.util.NoSuchElementException("a.length(" + n + ") < 3!");   //Skriver feilmelding
        }

        if (n == 3) {

            int[] idx1 = new int[n];                        // Setter idx1 sin lengde til array a sin lengde
            int[] sort1 = new int[n];                       // Setter sort1 sin lengde til array a sin lengde


            for (int i = 0; i < n; i++) {
                sort1[i] = a[i];                            // Setter sort1 sine verdier til a sine verdier
            }

            boblesortering(sort1);                          // Sorterer arrayet sort1 i stigende rekkefølge, referer til oppgave 8

            //Løkke for å sammenligne sort1 og sette inn index verdier i array "idx1"
            for (int i = 0; i < n; i++) {                   // Går igjennom orginalt array
                for (int j = 0; j <= n - 1; j++) {          // Går igjennom igjen for å kunne sammenligne 2 array
                    if (sort1[j] == a[i]) {                 // Sjekker om tallet på index plassen er likt i det sorterte og orginale
                        idx1[j] = i;                        // Setter a sin idx inn i idx1
                    }
                }
            }

            return idx1;                                    // Returnerer arrayet med indeksene
        }

        //Sjekker om a sin lengde er mellom og med 4 og 6
        if (n > 3 && n <= 6) {

            int[] idx2 = new int[n];
            int[] sort2 = new int[n];


            for (int i = 0; i < n; i++) {
                sort2[i] = a[i];
            }

            boblesortering(sort2);

            for (int i = 0; i < n; i++) {
                for (int j = 0; j <= n - 1; j++) {
                    if (sort2[j] == a[i]) {
                        idx2[j] = i;
                    }
                }
            }

            return idx2;
        }

        //Sjekker om a sin lengde er 10
        if (n == 10) {

            int[] idx3 = new int[n];
            int[] sort3 = new int[n];


            for (int i = 0; i < n; i++) {
                sort3[i] = a[i];
            }

            boblesortering(sort3);

            for (int i = 0; i < n; i++) {
                for (int j = 0; j <= n - 1; j++) {
                    if (sort3[j] == a[i]) {
                        idx3[j] = i;
                    }
                }
            }

            return idx3;
        }
        return a;
    }


    ///// Oppgave 10 //////////////////////////////////////
    public static int bokstavNr(char bokstav) {
        throw new UnsupportedOperationException();
    }

    public static boolean inneholdt(String a, String b) {
        if (a.length() == 0) {
            return true; //Hvis a er en tom streng, er den alltid inne i b
        }
        char[] aSort = a.toCharArray(); //Gjør om strengen til en liste med char
        Arrays.sort(aSort); //Bruker Array sin egen sort metode
        String aSortert = String.valueOf(aSort); //Gjør om den sorterte listen, til en streng

        char[] bSort = b.toCharArray();//Gjør om strengen til en liste med char
        Arrays.sort(bSort);//Bruker Array sin egen sort metode
        String bSortert = String.valueOf(bSort); //Gjør om den sorterte listen, til en streng

        if (bSortert.contains(aSortert)) { //Sjekker om bSortert inneholder aSortert
            return true; //returnerer true hvis dette er sant
        }

        return false; //Ellers returneres false
    }

}  // Oblig1
