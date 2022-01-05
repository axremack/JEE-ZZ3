public class Livre {
    private String titre;
    private Double prix;

    public Integer isbn;
    public static int cpt = 0;

    public Livre() {
        this.titre = "";
        this.prix = 0.0;
        cpt++;
        isbn = cpt;
    }

    public Livre(String titre, Double prix) {
        this.titre = titre;
        this.prix = prix;
        cpt++;
        isbn = cpt;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public Double getPrix() {
        return prix;
    }

    public void setPrix(Double prix) {
        this.prix = prix;
    }

    public String toString() {
        String res = titre + " - " + prix + " euros - " + isbn;
        return res;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }

        if (!(o instanceof Livre)) {
            return false;
        }

        Livre l = (Livre) o;

        return titre.equals(l.getTitre()) == true
                && Double.compare(this.getPrix(), l.getPrix()) == 0;
    }

}
