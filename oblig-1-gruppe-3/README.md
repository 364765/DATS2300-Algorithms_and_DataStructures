# Obligatorisk oppgave 1 i Algoritmer og Datastrukturer

Denne oppgaven er en innlevering i Algoritmer og Datastrukturer. 
Oppgaven er levert av følgende studenter:

Ylva Evenrud, S364748, s364748@oslomet.no
Andreas Dårstad, S364765, s364765@oslomet.no
Miriam Sarpong, S364766, s364766@oslomet.no
Siri Esteri Berg-Johnsen, s364735@oslomet.no


* ...

# Arbeidsfordeling

I oppgaven har vi hatt følgende arbeidsfordeling:
- Andreas og Ylva har hovedansvar for oppgave 2, 4, 6, 8, 9
- Miriam og Siri har hovedansvar for oppgave 1, 3, 5, 6, 7, 10


# Oppgavebeskrivelse

I oppgave 1 så gikk vi frem ved å finne det største verdien ved hjelp av en for-løkke og en if-setning.
I tillegg til å sende en feilmelding til terminalen. Videre var det å finne ut antall sammenligninger som går
gjennom tabellen. 

Spørsmål i oppgave1:

    Når blir det flest ombyttinger?: Det blir flest ombyttinger 
    når den største verdien ligger på indeks 0.

    Når blir det færrest?: Det blir færrest ombyttinger når 
    listen er sortert stigende. 

    Hvor mange blir det i gjennomsnitt?:
    4n + 7x - 2 = 4n + 7(log(n) - 0.423) - 2 = 4n + 7log(n) - 4,961 (Gjennomsnittsformelen)

    Kan du på grunnlag av dette si om metoden maks er bedre (eller dårligere) 
    enn de maks-metodene vi har sett på tidligere? 
    Siden vi har 4n istedenfor 5n (som de fleste vi har sett på har), er den "bedre", 
    siden den første n-en påvirker mer enn det x-en vil (Hn-1)


I oppgave 2 så gikk frem ved å bruke en if, else if, else løkke for å finne ut av arrayes lenge (0, 1 eller større), og skriver ut forskjellige verdier i arrayet etter dette. Er det større går det videre og det sjekkes om det er et usortert array. Er det ikke sortert kastes en illegalStatementException. Er arrayet sortert går det videre til en for og if/else løkke som sjekker indexen mot en verdi, om de er like. Antallet forkjellige verdier sjekkes igjennom hele metoden, og skrives ut til slutt. 


I oppgave 3 så gikk vi frem ved å sjekke om elementet er unik i forhold til elementene som kommer foran i listen, 
hvis det var ikke unik skal den hoppe videre i for-løkken. Hvis den var unik, skulle tellern for den unike tallet øke med 1. 

I oppgave 4 så gikk vi frem ved å sette v til å starte på første verdi og h til å starte på nest siste verdi i arrayet, ettersom at siste index brukes til skilleverdien. Bruker if og if else setninger for å sjekke om v og h er partall eller oddetall. Dersom det stemmer flytter siden med tallet som kommer gjennom sjekken en index nærmere midten. Når for løkka er ferdig med å gå gjennom arrayet brukes quicksort til å sortere arrayet. 
- Vi hentet metodene bytt, parter0, sParter0, kvikksortering 0 og kvikksortering fra kompendiet.

I oppgave 5 så gikk vi frem ved å lage en for-løkke som skal loope gjennom tabellen og 
brukte nesten samme funksjon som bytt metoden, men motsatt vei for å rotere tabellen en enhet.

I oppgave 6 så gikk vi frem først ved å bruke bytt metoden i oppgaven, men fikk med oss at den ikke var effektiv nok. 
- Dermed gikk vi ut fra programkoden 1.3.13 i) i kompendiet. 

I oppgave 7a så gikk vi frem ved å først finne hvilken streng som var lengst, også brukte
øvre grensen til ordene som var minst. Deretter ble det laget en ny for-løkke som hadde start
verdi til den korteste strengen og slutt verdi på den lengste for å få de siste karakterene  i retur strengen. 

I oppgave 7b så gikk vi frem ved å indeksere på riktig måtte. Vi fant den lengste strengen i listen,
som da skulle være den øvre grensen i strengen. Og hvis ordet var kortere enn indeksen i karakteren skulle det
legges til en tom streng. 

I oppgave 8 starter med å lage to hjelpetabeller med samme lengde som arrayet vi får inn(a), "aSortert" og "indeks". aSortert sorteres med boblesortering, for å sammenligne hvor tallet er i a[i]. Om indeksen er lik setter vi den i indeks arrayet. 
- Vi hentet metoden boblesortering fra kompendiet.

I oppgave 9 så gikk vi frem ved å sjekke om arreyet har en lengde på over 3. Er det under kastes en feilmelding. 
Gjør likt som i oppgave 8 med å lage to hjelpetabeller, idx1 og sort1. Vi prøvde å bruke kun 1 metode for alle array lengdene men dette ble for treigt. Derfor gikk vi over til å sjekke lengden på arrayet og sorterer deretter. Etter det sjekker vi verdien i sort1 opp mot samme verdi i a, og deretter setter vi indeksen til verdien i a til å være minste verdi i arrayet idx.

I oppgave 10 så gikk vi frem ved å først gjøre strengene om til array av char, for så å bruke den innebygde sort metoden til array. Så gjorde vi om de sorterte arrayene til strenger, også sjekket om den sorterte a strengen var en del av den sorterte b strengen ved hjelp av streng sin contains() funskjon
