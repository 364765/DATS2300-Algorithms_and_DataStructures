package no.oslomet.cs.algdat.Oblig3;


import java.util.*;

public class SBinTre<T> {
    private static final class Node<T>   // en indre nodeklasse
    {
        private T verdi;                   // nodens verdi
        private Node<T> venstre, høyre;    // venstre og høyre barn
        private Node<T> forelder;          // forelder

        // konstruktør
        private Node(T verdi, Node<T> v, Node<T> h, Node<T> forelder) {
            this.verdi = verdi;
            venstre = v;
            høyre = h;
            this.forelder = forelder;
        }

        private Node(T verdi, Node<T> forelder)  // konstruktør
        {
            this(verdi, null, null, forelder);
        }


        @Override
        public String toString() {
            return "" + verdi;
        }

    } // class Node

    private Node<T> rot;                            // peker til rotnoden
    private int antall;                             // antall noder
    private int endringer;                          // antall endringer

    private final Comparator<? super T> comp;       // komparator

    public SBinTre(Comparator<? super T> c)    // konstruktør
    {
        rot = null;
        antall = 0;
        comp = c;
    }

    public boolean inneholder(T verdi) {
        if (verdi == null) return false;

        Node<T> p = rot;

        while (p != null) {
            int cmp = comp.compare(verdi, p.verdi);
            if (cmp < 0) p = p.venstre;
            else if (cmp > 0) p = p.høyre;
            else return true;
        }

        return false;
    }

    public int antall() {
        return antall;
    }

    public String toStringPostOrder() {
        if (tom()) return "[]";

        StringJoiner s = new StringJoiner(", ", "[", "]");

        Node<T> p = førstePostorden(rot); // går til den første i postorden
        while (p != null) {
            s.add(p.verdi.toString());
            p = nestePostorden(p);
        }

        return s.toString();
    }

    public boolean tom() {
        return antall == 0;
    }

    public boolean leggInn(T verdi) {
        Objects.requireNonNull(verdi, "Ulovlig med nullverdier!");

        Node<T> p = rot, q = null;               // p starter i roten
        int cmp = 0;                             // hjelpevariabel


        while (p != null)       // fortsetter til p er ute av treet
        {
            q = p;                                 // q er forelder til p
            cmp = comp.compare(verdi, p.verdi);     // bruker komparatoren
            p = cmp < 0 ? p.venstre : p.høyre;     // flytter p
        }

        // p er nå null, dvs. ute av treet, q er den siste vi passerte

        p = new Node<>(verdi, null);                   // oppretter en ny node, setter forelder til null

        if (q == null) {
            rot = p;                  // p blir rotnode
        } else if (cmp < 0) {
            q.venstre = p;         // venstre barn til q
        } else {
            q.høyre = p;                        // høyre barn til q
        }

        p.forelder = q;                         //Setter p sin forelder til g

        antall++;                                // én verdi mer i treet
        return true;                             // vellykket innlegging
    }


    public boolean fjern(T verdi)  // hører til klassen SBinTre
    {
        throw new UnsupportedOperationException("Ikke kodet ennå!");
    }

    public int fjernAlle(T verdi) {
        throw new UnsupportedOperationException("Ikke kodet ennå!");
    }

    public int antall(T verdi) {
        if (verdi == null) {                       //Sjekker om verdi er null
            return 0;
        }

        int antallVerdier = 0;                      //Lager hjelpevariabel
        Node<T> p = rot;                            //Setter p til rot

        while (p != null) {                           //Går så lenge p ikke er null
            int cmp = comp.compare(verdi, p.verdi);   //Sammenligner
            if (cmp < 0) {
                p = p.venstre;                        //Går til venstre
            } else {
                if (cmp == 0) {                       //Verdi er lik, plusser på
                    antallVerdier++;
                }
                p = p.høyre;                          //Hvis ikke cmp == null går den til høyre
            }
        }
        return antallVerdier;
    }

    public void nullstill() {
        throw new UnsupportedOperationException("Ikke kodet ennå!");
    }

    private static <T> Node<T> førstePostorden(Node<T> p) {
        while (p.verdi != null) {                            //Sjekker om p ikke er null
            if (p.venstre != null) {                         //Sjekker om p har venstrebarn
                p = p.venstre;                               //Flytter p til p sitt venstre barn
            } else if (p.høyre != null) {                    //Hvis p ikke har venstrebarn sjekker om den har høyre barn
                p = p.høyre;                                 //Flytter p til p sitt høre barn
            } else {
                return p;                                    //Har ingen barn, returnerer rot
            }
        }
        return null;
    }

    private static <T> Node<T> nestePostorden(Node<T> p) {
        Node<T> forelder = p.forelder;                      //Setter forelder til p.forelder
        if (forelder == null) {                             //Sjekker om p er rot
            return null;
        }
        if (forelder.høyre == p) {                         //Sjekker om høyre barn er p
            return forelder;
        } else if (forelder.høyre == null) {               //Sjekker om forelder har høyre barn
            return forelder;
        } else {
            return førstePostorden(forelder.høyre);        //Kaller på førstePostorden som sjekker om neste postorden
        }                                                  //ligger i forelder.høyre sitt venstre barn
    }

    public void postorden(Oppgave<? super T> oppgave) {
        Node<T> p = rot;
        if (p == null) {                                      //Sjekker om treet er tomt
            return;
        }
        while (true) {
            if (p.venstre != null) {                         //Sjekker om rot har venstre barn
                p = p.venstre;                               //Setter p til venstre barn
            } else if (p.høyre != null) {                    //Sjekker om rot har høyre barn
                p = p.høyre;                                 //Setter p til høyre barn
            } else {
                oppgave.utførOppgave(p.verdi);               //Skriver ut første postorder verdi i treet
                break;                                       //Breaker while løkka
            }
        }
        while (p != null) {
            p = nestePostorden(p);                           //Går inn i nestePostorden(p) og finner neste verdi i postorder etter 2
            oppgave.utførOppgave(p.verdi);                   //Skriver ut neste verdi i postorder
            if (p.verdi == rot.verdi) {                      //Sjekker om p sin verdi er rot, stopper løkka om dette stemmer siden det er siste node i treet
                break;
            }
        }
    }

    public void postordenRecursive(Oppgave<? super T> oppgave) {
        if (rot != null) {                                          //Sjekker om rot ikke er null
            postordenRecursive(rot, oppgave);                       //Lar oss bruke rot i private metoden under
        }
    }

    private void postordenRecursive(Node<T> p, Oppgave<? super T> oppgave) {
        if (p.venstre != null) {                                                //Sjekker om p sitt venstre barn er null
            postordenRecursive(p.venstre, oppgave);                             //Kaller på seg selv og sjekker alle venstre barn
        }
        if (p.høyre != null) {                                                  //Sjekker om p sitt høyre barn er null
            postordenRecursive(p.høyre, oppgave);                               //Kaller på seg selv og sjekker alle høyre barn
        }
        oppgave.utførOppgave(p.verdi);                                          //Legger bladnode til i printen
    }

    public ArrayList<T> serialize() {
        throw new UnsupportedOperationException("Ikke kodet ennå!");
    }

    static <K> SBinTre<K> deserialize(ArrayList<K> data, Comparator<? super K> c) {
        throw new UnsupportedOperationException("Ikke kodet ennå!");
    }
} // ObligSBinTre
