public class Tableau<T> {
    public T [] tab;
    private int capacite = 1;
    private int taille;

    public Tableau() {
        this.tab = (T[]) new Object[capacite];
        taille = 0;
    }

    public Tableau(int i) {
        capacite = i;
        this.tab = (T[]) new Object[capacite];
        taille = 0;
    }

    public int getCapacite() {
        return capacite;
    }

    public int getTaille() {
        return taille;
    }

    private void agrandir() throws OutOfMemoryError {
        capacite = capacite * 2;
        T[] t = (T[]) new Object[capacite];
        if(t != null) {
            System.arraycopy(tab, 0, t, 0, taille);
            tab = t;
        } else {
            throw new OutOfMemoryError("Agrandissement de tableau impossible");
        }
    }

    public void addElement(T o) throws OutOfMemoryError {
        if (taille == capacite) {
            agrandir();
        }

        tab[taille] = o;
        taille++;
    }

    public Object getElementAt(int i) throws MyArrayOutOfBoundsException {
        if (i < taille && i >= 0) {
            return tab[i];
        } else {
            throw new MyArrayOutOfBoundsException("Indice invalide");
        }
    }

    public String toString() {
        String res = "classe : " + this.getClass().getName() + " - hashcode : " + this.hashCode() + " - taille : " + taille + " - capacite : " + capacite;
        return res;
    }

}
