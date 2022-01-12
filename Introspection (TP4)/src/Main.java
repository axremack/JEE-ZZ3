import java.lang.reflect.Constructor;

public class Main {

    public static void main(String[] args) throws Exception {
        //Personne p1 = new Personne(); // Affiche Personne
        //Enfant e1 = new Enfant();     // Affiche Enfant

        Class classe = Class.forName("Personne");
        Object o = classe.getDeclaredConstructor().newInstance(); // Affiche Personne
        System.out.println((o instanceof Enfant)?"vrai":"faux"); // FAUX

        Class classe2 = Class.forName("Enfant");
        Object o2 = classe2.getDeclaredConstructor().newInstance(); // Affiche Enfant
        System.out.println((o2 instanceof Enfant)?"vrai":"faux"); // VRAI
        System.out.println(classe2.getSuperclass()); // Affiche Personne

        System.out.println();
        Constructor[] constructors;
        constructors = classe.getDeclaredConstructors();
        for (Constructor constructor : constructors) {
            System.out.println(constructor.toGenericString());
        }

        Object[] argsConstructor = { "Nom" };
        Object o3 = classe.getDeclaredConstructor(String.class).newInstance(argsConstructor); // Construction de Personne avec un nom précisé

        System.out.println();
        System.out.println();


    }
}
