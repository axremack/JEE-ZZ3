import java.util.Vector;

public class Bibliothecaire extends Personne {
    private Bibliotheque bibli;

    public Bibliothecaire() {
        super();
        bibli = new Bibliotheque();
    }

    public Bibliothecaire(String nom, String prenom) {
        super(nom, prenom);
        this.bibli = new Bibliotheque();
    }

    public Vector<Livre> getBibli() {
        return bibli.getBibli();
    }
}
