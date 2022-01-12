package Partie_2;

public class Afficher implements Algorithme{
    @Override
    public void appliquer(double[] d) {
        for (double elt : d) {
            System.out.println(elt);
        }
    }
}
