public class LivreNumerique extends Livre {
    public Format format;

    public LivreNumerique() {
        super();
        format = Format.none;
    }

    public LivreNumerique(String titre, Double prix, Format format) {
        super(titre, prix);
        this.format = format;
    }

    public String toString() {
        String res = super.toString() + " - " + format;
        return res;
    }

}
