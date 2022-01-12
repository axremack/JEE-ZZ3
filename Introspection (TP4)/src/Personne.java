public class Personne {
    public String nom;

    public Personne() {
        this.nom = "Inconnu";
        System.out.println(this.getClass());
    }

    public Personne(String n) {
        this.nom = n;
        System.out.println(this.getClass());
        System.out.println(this.nom);
    }



}
