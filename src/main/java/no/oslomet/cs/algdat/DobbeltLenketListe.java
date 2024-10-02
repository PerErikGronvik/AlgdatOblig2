package no.oslomet.cs.algdat;

import java.awt.geom.IllegalPathStateException;
import java.util.*;

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
    public DobbeltLenketListe() {//genererer en tom dobbelt lenket liste
        antall = 0; endringer = 0;
    } //O(1)

    public DobbeltLenketListe(T[] a) {
        Objects.requireNonNull(a,"a er null");
        antall = 0;  endringer = 0; //tom liste

        for (int i = 0; i < a.length; i++) { // legger arrayet inn en dobbel lenket liste, hopper over nullverdier.
            if (a[i] != null) {                                // hopper over null verdier
                Node<T> nyNode= new Node<T>(a[i]);                //definerer noden vi skal bruke

                if (hode == null) { //dette er den første noden
                    hode = nyNode; hale = nyNode;              //Er bare denne noden derfor er den hale og hode
                    nyNode.forrige = null;nyNode.neste = null; //har ingen adjacent noder
                } else { // en ny ikke null node
                    nyNode.forrige = hale; nyNode.neste = null; // Oppdaterer nodens pekere
                    hale.neste=nyNode;                          // Oppdaterer gammel peker, som er lagret i hale
                    hale = nyNode;                              // Nå som vi er ferdige setter vi Noden til å være halen
                }
                antall++;
            }
        }
    } // O(n) fordi løkken kjører n ganger for hvert element og resten av operasjonene er O(1)

    @Override
    public int antall() { return antall; }//returnere antall verdier i lista.

    @Override
    public boolean tom() { return antall == 0; } //  En logisk sammenligning returnerer true eller false om listen er tom

    // Oppgave 2
    @Override
    public String toString() { // returnere en tegnstreng med listens verdier, omringet av klammeparenteser

        // OBS
        // Bruk stringbuilder
        // StringBuilder str = new StringBuilder();
        // str.append("GFG"); fra Geeks for geeks
        // sout(str.toString())

        Node<T> temp = hode;

        StringBuilder ut = new StringBuilder();
        ut.append("[");

        for (int i = 0; i < antall; i++) {                  //
            if (i==0){ ut.append(temp.verdi); }             //
            else { ut.append(", ").append(temp.verdi); }    //

            if (temp.neste != null){// sjekker om det er en neste node
                temp = temp.neste;//flytter til neste node
            }
        }
        ut.append("]");
        return ut.toString();
    } // O(n)

    public String omvendtString() {

        StringBuilder ut = new StringBuilder();
        ut.append("[");

        Node<T> temp = hale;

        for (int i = 0; i < antall; i++) {
            if (i==0){
                ut.append(temp.verdi);
            } else {
                ut.append(", ").append(temp.verdi);
            }
            if (temp.forrige != null){// sjekker om det er en neste node
                temp = temp.forrige;//flytter til neste node
            }
        }
        ut.append("]");
        return ut.toString();
    } //O(n)

    @Override
    public boolean leggInn(T verdi) {

        Objects.requireNonNull(verdi,"Ikke lov å legge inn null verdi");

        Node<T> nyNode= new Node<>(verdi); //Temp variabel

        //legg til node bakerst i listen
        if (antall==0) { //Settes inn i tom liste
            hode=nyNode; hale=nyNode;
        }else { //Settes inn i vanlig liste
            nyNode.forrige = hale;
            nyNode.neste = null;
            // Oppdaterer forrige peker, som er lagret i hale
            hale.neste = nyNode;
            // Nå som vi er ferdige setter vi Noden til å være halen
            hale = nyNode;
        }
        endringer++;
        antall++;
        return true;
    } //O(1)

    // Oppgave 3
    private Node<T> finnNode(int indeks) {
        Node<T> ut=null;
        if (indeks < (antall / 2)) {//indeksen er mindre enn halvparten av antallet
            ut = hode;
            for (int i = 0; i < indeks; i++) { //index 0=hode index 1= nr1 -> stop pga i=indexs
                ut=ut.neste; // gå framover fra hode
            }
        } else { // Indeksen er lik eller større enn halvparten
            ut = hale;
            for (int i = antall-1; i > indeks; i--) { // index siste = hale
                ut=ut.forrige; // gå bakover fra hale
            }
        }
        return ut; //returnerer noden med den gitte posisjonen.
    } //O(n/2) // som er O(n)

    @Override
    public T hent(int indeks) {
        indeksKontroll(indeks,false); // er indeksen gyldig
        return finnNode(indeks).verdi; //returner verdien
    }

    @Override
    public T oppdater(int indeks, T nyverdi) {
        Objects.requireNonNull(nyverdi,"Ikke lov å legge inn null verdi");
        indeksKontroll(indeks,false); //er indeksen gyldig

        Node<T> erstattes= finnNode(indeks); // henter noden
        T ut=erstattes.verdi; // lagrer gammel verdi
        erstattes.verdi = nyverdi; //legger inn ny verdi

        endringer++;
        return ut; //returnerer gammel verdi
    }


    public Liste<T> subliste(int fra, int til) {
        fraTilKontroll(fra, til); //sjekker indeksene er lovlige
        DobbeltLenketListe<T> nyListe= new DobbeltLenketListe<>();//generer liste
        Node<T> temp = finnNode(fra); //henter første noden.

        for (int i = fra; i < til; i++) {
            nyListe.leggInn(temp.verdi); // legger inn verdien fra noden
            temp= temp.neste; // flytter til neste node.
        }
        return nyListe; //returnerer listen
    }

    // Oppgave 4
    @Override
    public int indeksTil(T verdi) {
        int ut = -1; //verdien finnes ikke settes som default
        for (int i = 0; i < antall; i++) {
            if (hent(i).equals(verdi)) {
                ut = i;
                break;
            }
        }
        return ut;//returnerer indeksen eller -1
    }

    @Override
    public boolean inneholder(T verdi) {
        return indeksTil(verdi) != -1; //bruker indeks til for å sjekke
    }

    // Oppgave 5
    @Override
    public void leggInn(int indeks, T verdi) {
        indeksKontroll(indeks,true);
        Objects.requireNonNull(verdi,"Nullverdi er ikke godtatt");
        Node<T> nyNode = new Node<>(verdi);         // Lager noden
        if (indeks == 0 ) {                         // starten
            if (hode==null){            // Egen kode for å legge inn i tom liste
            hode = nyNode;
            hale = nyNode;
            } else {                   // ikke tom
            nyNode.neste=hode;
            hode.forrige=nyNode;
            hode=nyNode;
        }}  else if (indeks == antall) {            //slutten Her skal det vær antall -1 men tror det er feil i fasiten.
            nyNode.forrige = hale;
            hale.neste = nyNode;
            hale = nyNode;
        } else {                       // midt i
            // Henter noder og gir de navn.
            Node<T> høyre = finnNode(indeks);
            Node<T> venstre = høyre.forrige;

            // Sett inn ny node
            venstre.neste = nyNode;
            høyre.forrige = nyNode;
            nyNode.forrige=venstre;
            nyNode.neste=høyre;
        }
        antall++;
        endringer++;
    }

    // Oppgave 6
    @Override
    public T fjern(int indeks) {

        indeksKontroll(indeks,false);

        // velg noder og gi de navn.
        Node<T> slettNode = finnNode(indeks);
        T ut = slettNode.verdi;

        if (indeks == 0 ) { //starten
                hode = slettNode.neste;
                if(hode != null){ //listen er ikke blitt tom
                    hode.forrige=null;
                }
        }  else if (indeks == antall-1) { //slutten
                hale = slettNode.forrige;
                //tom liste er håndtert
                hale.neste=null;
        } else { //midten
            Node<T> venste = slettNode.forrige;
            Node<T> høyre =  slettNode.neste;

            venste.neste= høyre;
            høyre.forrige = venste;
        }
        slettNode.neste=null;
        slettNode.forrige=null;

        antall--;
        endringer++;
        return ut;

    }

    @Override
    public boolean fjern(T verdi) {
        if (hode == null) { //listen er tom
            return false;
        }

        Node<T> temp = hode;
        while (temp!=null){ //kjører til slutten
            if (temp.verdi.equals(verdi)) { //jeg finner verdi
                if (temp == hode) { //på starten
                    if (temp == hale) { //blir tom
                        hode = null;
                        hale = null;
                    } else { //blir ikke tom
                        hode = temp.neste;
                        hode.forrige = null;
                        //hode neste finns
                        //neste skal peke på hode
                    }
                } else if (temp == hale) {//slutten
                        hale = temp.forrige;
                        hale.neste = null;
                } else {// midt i en plass
                    Node<T> venstre = temp.forrige;
                    Node<T> høyre = temp.neste;

                    venstre.neste = høyre;
                    høyre.forrige = venstre;
                }
                temp.neste = null;
                temp.forrige = null;

                endringer++;
                antall--;
                return true;
                }
            temp = temp.neste;
            }
        return false;
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

    // Oppgave 8 og 9

    @Override
    public Iterator<T> iterator() {
        return new DobbeltLenketListeIterator();
    }

    public Iterator<T> iterator(int indeks) {
        indeksKontroll(indeks,false);
        return new DobbeltLenketListeIterator(indeks);
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

        @Override
        public T next() {
            if (iteratorendringer != endringer) {
                throw new ConcurrentModificationException("Iteratorendringer er ikke lik endringer");
            }
            if (!hasNext()) {
                throw new NoSuchElementException("Det er ikke flere elementer igjen i listen");
            }

            kanFjerne=true;
            T ut= denne.verdi; // lagerer gammel verdi
            denne= denne.neste; // overskriver
            return ut;
        }

        private DobbeltLenketListeIterator(int indeks) {
            denne=finnNode(indeks);         // Starter på indeks
            kanFjerne = false;              // Settes true når next() kalles
            iteratorendringer = endringer;  // Teller endringer
        }

        @Override
        public boolean hasNext() { //ferdig ikke rør
            return denne != null;
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
