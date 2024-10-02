[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-22041afd0340ce965d47ae6ef1cefeee28c7c493a6346c4f15d667ab976d596c.svg)](https://classroom.github.com/a/FVZ-bAxQ)
# Obligatorisk Oppgave 2 i DATS2300 - Algoritmer og Datastrukturer

Denne oppgaven er en innlevering i DATS2300 - Algoritmer og datastrukturer. Den er innlevert av følgende studenter:
* pegro6469@oslomet.no


## Arbeidsfordeling
Ønsker i utganspunktet å gjøre alle oppgavene, derfor er jeg ikke på gruppe.

## Oppgavebeskrivelser

# Oppgave 1
I begge de første oppgavene starter jeg med å lage en tom liste. En for løkke lager nye noder, som gies en verdi av tabellen og settes inn i den lenkede listen. det er en if løkke som tar seg av den første noden. Løkken itterer igjennom tabellen og oppdaterer antall. Effektivisering. her kunne en while løkke funnet det første elementet og sendt startpunktet til forløkken som i+1 inn i for løkken. Dette ville unngått en if operasjon for hver løkke.

# Oppgave 2
Søkte opp hva stringbuilder var og fant noe på Geeks for geeks. Bruker ut.append(verdi.verdi) for å lagre alle verdiene. ut.toString(), bygger srtengen til slutt. omvendt, er en kopi av første kode, men motsatt vei. If løkkene gjør ingenting hvis den er null. 

For å legge inn en ny node bakerst, Sjekker om den er tom, og setter da evt hode og hale til den ny noden. else setter inn i en liste ved å sette inn nyNode. Oppdaterer pekeren forrige til den gamle halen. setter neste til å være null. setter hale neste til å peke på den nye noden. Setter halepekeren til den nå ny noden som er bakerst.  

# Oppgave 3
i private node<T> finnNode(int indeks) Laget en sjekk som fant om indeksen er mindre enn halvparten. Og kjørte en forløkke i hver av resultatene.
public T hent(int indeks) - Akkurat det som står.
public T oppdater() - henter noden, lagrer gammel verdi, legger inn ny verdi og returnerer gammel verdi.
public Liste<T> subliste() - henter første noden, bruker en løkke til å følge noden og legge inn verdiene i den nye noden, med leggInn funksjonen. Hvis tid kunne jeg sett i fratilKontroll og leggInn for å se etter optimaliseringer.

# Oppgave 4
ideksTil - Indeks til setter -1 som default og lar en forløkke motbevise det hvis verdien finnes. løkken itterer over antall, hele listen. Den bruker hent(i).equals verdi. Men finnNode og så følge noden ville vært mer effektivt.
inneholder - Bruker indeksTil for å sjekke. Det ville vært marginalt mer effektivt å skrive koden.

# Oppgave 5
Metoden lager en node som den skal legge inn. For å finne ut hvor og hvordan brukes en if stamenet som deler inn i om noden skal inn i start, slutt eller noensted midt i. Starten deles videre inn i to scenarioer med en if statment, hvis listen er tom er hode=null da skal hode og hale peke på den nye noden. Hvis den ikke er tom, vet vi at hode peker på en node og vi kan legge inn noden og forandre pekeren. Hvis det er på slutten så vet vi at den har en venstrepeker, fordi tom er allerede ivaretatt. Midt i her, henter jeg nodene og gir de navn. Det gjør det enkelt å sette inn. endrer pekerne fra de gamle nodene slik at de peker på den nye og så endrer jeg den nye nodens pekere slik at den peker på de gamle. 

# Oppgave 6
fjern indeks - Finner noden som skal slettes med finnNode(). Hvis noden er først i listen, oppdateres hode til neste node, og forrige-pekeren til null hvis listen ikke blir tom. Hvis noden er sist i listen, oppdateres hale til forrige node, og neste-pekeren settes til null. For noder i midten kobles nodens forrige og neste noder sammen. Noden fjernes ved å sette neste og forrige til null, og antall reduseres. Returnerer verdien av noden som ble slettet.
fjern verdi - Søker gjennom listen fra hode. Hvis verdien finnes, fjerner noden. Hvis noden er først, oppdateres hode til neste node. Hvis listen blir tom, settes både hode og hale til null. Hvis noden er sist, oppdateres hale til forrige node og setter neste til null. Hvis noden er i midten, kobles forrige og neste noder sammen. Noden fjernes ved å sette pekere til null, oppdaterer antall og endringer, og returnerer true. Hvis verdien ikke finnes, returneres false.

Har ikke kodet dem ved hjelp av hverandre. fjern(indeks) bruker indekstilgang som er O(n/2), dette kan ikke verdi gjøre. Derfor feiler testen iblandt. Ja, jeg vet O(n/2) er O(n).

# Oppgave 7  (Ikke obligatorisk)


# Oppgave 8
iterator() returnerer en iterator som starter på hode. iterator(int indeks) starter iteratoren på gitt indeks etter å ha sjekket at indeksen er gyldig.
DobbeltLenketListeIterator implementerer Iterator<T>. Den ene konstruktøren starter på hode, den andre på en gitt indeks med finnNode().
hasNext() sjekker om det er flere noder igjen. next() kaster ConcurrentModificationException hvis listen har endret seg, eller NoSuchElementException hvis ingen elementer gjenstår. Den returnerer verdien til den nåværende noden og flytter til neste node.

# Oppgave 9  (Ikke obligatorisk)

# Oppgave 10 (Ikke obligatorisk)