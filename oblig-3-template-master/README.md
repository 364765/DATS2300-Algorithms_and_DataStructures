# Obligatorisk oppgave 3 i Algoritmer og Datastrukturer

Denne oppgaven er en innlevering i Algoritmer og Datastrukturer. 
Oppgaven er levert av følgende student:
* Andreas Dårstad, S364765, s364765@oslomet.no


# Oppgavebeskrivelse

I oppgave 1 så gikk jeg frem ved å hente programkoden 5.2.3 a) og la den i legg inn metoden. 
For å fikse foreldrepekere la jeg inn null som forelder til noden som blir laget etter while løkka. Før antall++ og return statement setter jeg p sin forelder til 
q ettersom at vi setter q sine venstre/høyre barn til p. 

I oppgave 2 så hentet jeg litt av koden fra delkapittel 5.2.6 løsningsforslag oppgave 2). Først sjekker jeg om verdien er null, deretter lager jeg et par hjelpevariabler. 
Så lagde jeg en while loop som kjører så lenge p ikke er null. Inne i while loopen sammenligner den p sin verdi med verdien vi skal sjekke antallet til, og sjekker om den ligger i 
rot, høyre eller venstrebarn ved hjelp av compare, og deretter plusser på antallVerdier variabelen dersom de er like. Da p er null stopper while loopen og antallVerdier returneres.

I oppgave 3 kodet jeg hovedsakelig ut fra beskrivelsen av postorden i delkapittel 5.1.7. 
I første postorden er det en while loop som kjører helt til p sin verdi er null. Den går nedover i 
nodenes venstre barn helt til neste venstrebarn er null. Deretter sjekker den om noden den er på har et høyre barn, hvis ikke returneres nodens verdi, hvis den har et høyre barn returneres
høyre barnets verdi om det er den ikke har noen barn. 
I neste postorden starter jeg med å sette forelder til p sin forelder, og sjekker om p er rotnoden. Så sjekker jeg om forelder sitt høyre barn er p, 
deretter sjekker jeg om p har et høyrebarn. Hvis ingen av if setningene over går kaller jeg jeg på førstePostorden og sjekker om neste postorden ligger i forelder sitt høyre barn sitt venstre barn.

I oppgave 4 så jeg tilbake på oppgave 3 sin første postorden for å lage metoden postorden uten rekursjon. Jeg starter med å sjekke om treet er tomt. Deretter er det en while løkke som kjører 
helt til vi har funnet den første bladnoden, så legges denne verdien i printen. Etter den første verdien i postorden er lagt til går vi inn i en while løkke som stopper når vi har lagt til 
den siste verdien i postorder som er i rotnoden. Disse finner vi ved hjelp av å kalle på metoden nestePostordre. Det er en if sjekk nederst i while løkka som breaker dersom p sin verdi er lik rotnoden sin verdi.

I den rekursive postorden metoden hentet jeg kode fra kompendiet løsningsforslag avsnitt 5.1.7 oppgave 7. Den første postordenRecursive metoden sjekker at rot ikke er null og lar oss bruke rot i den private metoden under.
I den andre postordenRecursive metoden sjekker vi venstre og høyre barn til vi er i den første bladnoden ved å bruke rekursjon slik at metoden kaller på seg selv. Deretter legges den første bladnoden til i printen.
Disse rekursive kallene fortsetter å kjøre til alle node verdiene er lagt til i postorder og stopper da vi har lagt til rotnoden sin verdi.


Jeg prøvde ikke å løse oppgave 5 men prøvde litt på oppgave 6 men stoppet da testen min for oppgave 6 ikke funket. Jeg fjernet koden fra oppgave 6 og skrev inn "Ikke kodet enna!" exception istedenfor.