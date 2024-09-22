package no.oslomet.cs.algdat;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Objects;

public class DobbeltLenketListe<T> implements Liste<T> {
    // Innebygd (Trenger ikke endres)

    /**
     * Node class
     *
     * @param <T>
     */
    private static final class Node<T> {
        private T verdi;
        private Node<T> forrige, neste;

        private Node(T verdi, Node<T> forrige, Node<T> neste) {
            this.verdi = verdi; this.forrige = forrige; this.neste = neste;
        }
        private Node(T verdi) {this(verdi, null, null);}
    }

    private Node<T> hode;
    private Node<T> hale;
    private int antall;
    private int endringer;

    public void fraTilKontroll(int fra, int til) {
        if (fra < 0) throw new IndexOutOfBoundsException("fra("+fra+") er negativ.");
        if (til > antall) throw new IndexOutOfBoundsException("til("+til+") er større enn antall("+antall+")");
        if (fra > til) throw new IllegalArgumentException("fra("+fra+") er større enn til("+til+") - Ulovlig intervall.");
    }

    // Oppgave 0
    public static int gruppeMedlemmer() {
        return 1; // Returner hvor mange som er i gruppa deres
    }

    // Oppgave 1
    public DobbeltLenketListe() {
        hode = null;
        hale = null;
        antall = 0;
        endringer = 0;
        //Lag konstruktøren public DobbeltLenketListe() så den genererer en tom
        //dobbelt lenket liste
    }

    public DobbeltLenketListe(T[] a) { // T for type, fordi type ville vært for selvforklarende.
        Objects.requireNonNull(a,"a er null");
        //tom liste
        hode = null;
        hale = null;
        antall = 0;
        endringer = 0;

        // legger arrayet inn en dobbel lenket liste, hopper over nullverdier.
        for (int i = 0; i < a.length; i++) {
            if (a[i] != null) { // hopper over null verdier
                Node<T> nyNode= new Node(a[i]); //definerer noden vi skal bruke

                if (hode == null) { //dette er den første noden
                    //Er bare denne noden derfor er den hale og hode
                    hode = nyNode;
                    hale = nyNode;
                    // Har ingen adjecent noder.
                    nyNode.forrige = null;
                    nyNode.neste = null;
                } else { // dette er en ny ikke null node
                    // Oppdaterer nodens pekere
                    nyNode.forrige = hale;
                    nyNode.neste = null;
                    // Opdaterer forrige peker, som er lagret i hale
                    hale.neste=nyNode;
                    // Nå som vi er ferdie setter vi Noden til å være halen
                    hale = nyNode;
                }
                antall++;
            }
        }
    }

    @Override
    public int antall() {

        //Lag metoden public int antall(), som skal returnere antall verdier i lista.
        return antall;
    }

    @Override
    public boolean tom() {
        //Lag metoden public boolean tom(), som skal returnere true dersom lista
        //er tom, og false dersom den ikke er tom.
        return antall == 0; //  En logisk sammenligning returnerer tue eller false
    }

    // Oppgave 2
    @Override
    public String toString() {
        // Den skal returnere en tegnstreng
        // med listens verdier, omringet av klammeparenteser. Om lista er tom, får man
        // da "[]", og om lista inneholder verdiene 1, 2, og 3, får man da "[1, 2, 3]".
        // Merk mellomrom etter komma. Metoden skal lage strengen ved å følge neste-
        // pekerne i lista.
        // 2
        // (toString)

        throw new UnsupportedOperationException();
    }

    public String omvendtString() {
        //Lag metoden public String omvendtString(). Den skal returnere
        //en tegnstreng med listens verdier i motsatt rekkefølge, omringet av
        //klammeparenteser. Metoden skal lage strengen ved å følge forrige-pekerne
        //i lista.
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean leggInn(T verdi) {
        //Lag metoden public boolean leggInn(T verdi). Den skal kaste en
        //NullPointerException dersom du prøver legge inn en null-verdi, og ellers
        //legge til en ny node med oppgitt verdi bakerst i listen, og returnere true. Øk
        //variabelen endringer hver gang en ny verdi legges inn
        throw new UnsupportedOperationException();
    }

    // Oppgave 3
    private Node<T> finnNode(int indeks) {
        //Lag den private metoden private Node<T> finnNode(int indeks), som
        //returnerer noden med den gitte posisjonen.
        //– Dersom indeksen er mindre enn halvparten av antallet, skal metoden
        //starte fra hodet og følge neste-pekere.
        //– Dersom indeksen er større enn eller lik halvparten av antallet, skal
        //metoden starte fra halen, og følge forrige-pekere.
        throw new UnsupportedOperationException();
    }

    @Override
    public T hent(int indeks) {
        //Lag metoden public T hent(int indeks), som henter ut verdi-
        //en på den gitte posisjonen, ved hjelp av finnNode. Bruk meto-
        //den indeksKontroll(int indeks, boolean leggInn) som er arvet fra
        //Liste til å sjekke at den innsendte indeksen er en lovlig indeks. Siden vi ikke
        //skal legge noe inn i lista, settes leggInn til false.
        throw new UnsupportedOperationException();
    }

    @Override
    public T oppdater(int indeks, T nyverdi) {
        //Lag metoden public T oppdater(int indeks, T nyverdi), som erstat-
        //ter verdien på plass indeks med nyverdi, og returnerer det som lå der før.
        //Husk å sjekke etter lovlige indekser. Variabelen endringer skal økes når lista
        //oppdateres.
        throw new UnsupportedOperationException();
    }


    public Liste<T> subliste(int fra, int til) {
        //Lag metoden public Liste<T> subliste(int fra, int til), som re-
        //turnerer en ny liste (en instans av DobbeltLenketListe) som inneholder
        //verdiene i det halvåpne intervallet [fra, til⟩ fra lista denne kalles fra. Bruk
        //metoden fraTilKontroll(int fra, int til) for å sjekke om indeksene
        //er lovlige. Et tomt intervall er lovlig, og skal gi ut en tom liste. Pass på at
        //den nye lista har riktig antall.
        throw new UnsupportedOperationException();
    }

    // Oppgave 4
    @Override
    public int indeksTil(T verdi) {
        //Lag metoden public int indeksTil(T verdi), som returnerer indeksen
        //til første element med den gitte verdien i lista, eller −1 dersom verdien ikke
        //finnes i lista. Det skal ikke kastes et unntak dersom verdi er null.
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean inneholder(T verdi) {
        //Lag metoden public boolean inneholder(T verdi), som returnerer
        //true dersom den gitte verdien finnes i lista, og false dersom den ikke
        //finnes i lista. Du kan gjerne bruke indeksTil som hjelpemetode.
        throw new UnsupportedOperationException();
    }

    // Oppgave 5
    @Override
    public void leggInn(int indeks, T verdi) {
        //som legger inn verdi i lista på posisjon indeks. Alle andre verdier vil da
        //flyttes videre til neste indeks. Pass på at metoden kan legge inn i tom liste,
        //i starten av liste, i slutten av liste, og i midten av liste. Bruk metoden
        //indeksKontroll(int indeks, boolean leggInn) til å sjekke at den insendte
        //indeksen er en lovlig indeks. Siden vi her skal legge noe inn i lista, settes leggInn
        //til true.
        //Pass på at alle noder får riktige pekere i alle tilfeller, også om en ny verdi
        //plasseres først eller sist. Pass også på at både antall og endringer økes når en
        //verdi legges til. Det skal fremdeles ikke være lov å legge inn nullpekere i lista, og
        //dette skal kaste en NullPointerException
        throw new UnsupportedOperationException();
    }

    // Oppgave 6
    @Override
    public T fjern(int indeks) {
        //jerner og returnerer
        //verdien på posisjon indeks. Du skal kaste IndexOutOfBoundsException
        //om du prøver fjerne en indeks som ikke eksisterer.
        //må derfor kodes direkte.
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean fjern(T verdi) {
        //om prøver å fjerne første
        //instans av verdien verdi. Den returnerer true dersom den finner og fjerner
        //verdien, og false dersom den ikke finner verdien.
        //må derfor kodes direkte.

        //Pass på at metodene fungerer på en tom liste, på en liste med ett element, om
        //første element fjernes, om siste element fjernes, og om et element i slutten fjernes.
        //Noden som fjernes bør sette sine forrige og neste-pekere til null. Verdiene
        //antall og endringer må oppdateres ved at antall reduseres og endringer
        //økes, dersom noe fjernes.
        //4
        throw new UnsupportedOperationException();
    }

    // Oppgave 7  Ikke obligatorisk
    @Override
    public void nullstill() {
        //I denne oppgaven skal man lage metoden public void nulstill(). Den skal
        //«tømme» lista. Vi ønsker gjøre dette ved å gå gjennom lista og passe på at ingen
        //av nodene peker på hverandre lenger. Dette gjør at selv om en av nodene blir pekt
        //på via andre metoder (for eksempel en uferdig iterator), så vil de fleste nodene i
        //lista være umulig å komme til, og da vil Java slette dem. Kod dette på begge disse
        //måtene, og velg så den som er mest effektiv (mål tiden!). Kommenter forskjellen i
        //tid.
        //(a) Start i hode og gå mot hale ved å følge neste-pekere. For hver node,
        //gjør slik at både forrige og neste-pekeren settes til null. Husk å følg
        //neste-pekeren før du nuller den! Til slutt settes både hode og hale til null,
        //antall settes til 0, og endringer økes.
        //(b) Lag en løkke som kjører fjern(0) til listen er tom.
        throw new UnsupportedOperationException();
    }

    // Oppgave 8

    @Override
    public Iterator<T> iterator() {
        //Lag metoden public Iterator<T> iterator() i DobbeltLenketListe,
        //som returnerer en instans av iteratoren.
        throw new UnsupportedOperationException();
    }

    public Iterator<T> iterator(int indeks) {
        //Lag metoden public Iterator<T> iterator(int indeks), som først
        //sjekker om indeks er en lovlig indeks, og så returnerer en instans av
        //iteratorklassen som starter på den gitte indeksen

        throw new UnsupportedOperationException();
    }

    private class DobbeltLenketListeIterator implements Iterator<T> {
        private Node<T> denne;
        private boolean kanFjerne;
        private int iteratorendringer;

        private DobbeltLenketListeIterator() {// ferdig ikke rør
            denne = hode;                   // Starter på første i lista
            kanFjerne = false;              // Settes true når next() kalles
            iteratorendringer = endringer;  // Teller endringer
        }

        private DobbeltLenketListeIterator(int indeks) {
            //ag konstruktøren private DobbeltLenketListeIterator(int indeks).
            //Den skal sette nodepekeren denne til å peke på noden på plass indeks, og
            //ellers gjøre det samme som private DobbeltLenketListeIterator()
            throw new UnsupportedOperationException();
        }

        @Override
        public boolean hasNext() { //ferdig ikke rør
            return denne != null;
        }

        @Override
        public T next() {
            //Lag metoden public T next() i DobbeltLenketListeIterator. Den
            //skal først sjekke om iteratorendringer er lik endringer, og om de er
            //forskjellige skal man kaste en ConcurrentModificationException. Den
            //skal kaste en NoSuchElementException om det ikke er flere elementer igjen
            //i listen. Deretter må den sette kanFjerne til true. Verdien til noden denne
            //må returneres, og denne må settes til neste node i lista.
            throw new UnsupportedOperationException();
        }

        // Oppgave 9: Ikke obligatorisk
        @Override
        public void remove() {
            //Vi skal i denne oppgaven implementere at verdier kan fjernes fra lista ved hjelp av
            //iteratoren. Dette skal gjøres ved å implementere metoden public void remove()
            //i iteratorklassen. Her må du ikke bruke noen av de andre fjern-metodene, da du
            //ikke vet verken hvilken indeks du er på, eller om verdien du er på er den første med
            //en gitt verdi. Metoden remove må derfor kodes direkte.
            //Dersom det ikke er tillatt å endre, skal det kastes en IllegalStateException.
            //Dersom endringer og iteratorendringer er forskjellige, skal det kastes en
            //ConcurrentModificationException. Dersom begge disse hindrene passeres, skal
            //kanFjerne settes til false, og så skal noden rett til venstre for denne fjernes. Til
            //slutt reduseres antall, og både endringer og iteratorendringer økes.
            //Her må du huske å ta hensyn til spesialtilfeller som at listen består av ett
            //element, du fjerner siste element, eller du fjerner første element.
            //Metoden public boolean fjernHvis(Predicate<? super T> sjekk) er
            //innebygd i Beholder-grensesnittet, og vil virke så lenge remove() er kodet i
            //iteratorklassen. Du kan sjekke at følgende kode virker:
            //String[] frukt = {"Eple", "Pære", "Banan", "Mango", "Drue"};
            //Liste<String> liste = new DobbeltLenketListe<>(frukt);
            //// fjerner frukt med 'a' som andre bokstav
            //liste.fjernHvis(f -> f.charAt(1) = 'a');
            //System.out.println(liste)
            //// Skal printe [Eple, Pære, Drue]
            //Prøv gjerne selv finne predikater som gjør at kun frukt med navn på 4 bokstaver
            //blir igjen, eller kun frukt som inneholder bokstaven «e».
            throw new UnsupportedOperationException();
        }
    }

    // Oppgave 10 Ikke obligatorisk
    public static <T> void sorter(Liste<T> liste, Comparator<? super T> c) {
        //ag følgende metode:
        //public static <T> void sorter(Liste<T> liste,
        //Comparator<? super T> c)
        //Den skal sortere liste ved hjelp av sammenlikneren c. Siden parametertypen er
        //Liste, er det kun metodene i grensesnittet Liste som kan brukes.
        //Det kan friste å bare kopiere alle verdiene over i en tabell, og så sortere tabellen,
        //men metoden skal løses uten hjelpestrukturer. Den skal sorteres ved å kun flytte
        //elementer innad i lista.
        //Merk også at siden man kun kan bruke Liste-metoder, får man ikke tilgang
        //til den indre strukturen til lista. Dette gjør at vi antagelig ikke klarer å lage en
        //sorteringsalgoritme som har O(n log n)-kompleksitet. Prøv likevel å gjøre metoden
        //relativt effektiv. Finn kompleksiteten til metoden din ved å først teste den på en
        //lang liste (så metoden tar for eksempel omkring ett sekund å fullføre), og så på en
        //liste som er dobbelt så lang som dette. Forklar hvordan dette hjelper med å finne
        //kompleksitetstypen til koden
        throw new UnsupportedOperationException();
    }
}
