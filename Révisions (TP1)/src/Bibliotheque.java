import java.util.Vector;

public class Bibliotheque implements Gestion {
    private Vector<Livre> bibli;
    private final static int CAPACITE = 10; // Constante fixée à la compilation

    public Bibliotheque() {
        bibli = new Vector<>();
    }
    public Bibliotheque(Vector<Livre> bibli) throws Exception {
        if (bibli.size() >= CAPACITE) {
            throw new Exception("Le vecteur est trop grand.");
        } else {
            this.bibli = bibli;
        }
    }

    public Vector<Livre> getBibli() {
        return bibli;
    }

    public void addLivre(Livre l) throws Exception {
        if (bibli.size() < CAPACITE) {
            this.bibli.add(l);
        } else {
            throw new Exception("Le vecteur a atteint sa capacité max.");
        }
    }




}
