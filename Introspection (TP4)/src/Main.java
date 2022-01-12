import Partie_1.Enfant;
import Partie_2.Afficher;
import Partie_2.Algorithme;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {

    public static void main(String[] args) throws Exception {
        // PARTIE 1

        Partie_1.Personne p1 = new Partie_1.Personne(); // Affiche Partie_1.Personne
        Partie_1.Enfant e1 = new Partie_1.Enfant();     // Affiche Partie_1.Enfant

        Class classe = Class.forName("Partie_1.Personne");
        Object o = classe.getDeclaredConstructor().newInstance(); // Affiche Partie_1.Personne
        System.out.println((o instanceof Enfant)?"vrai":"faux"); // FAUX

        Class classe2 = Class.forName("Partie_1.Enfant");
        Object o2 = classe2.getDeclaredConstructor().newInstance(); // Affiche Partie_1.Enfant
        System.out.println((o2 instanceof Enfant)?"vrai":"faux"); // VRAI
        System.out.println(classe2.getSuperclass()); // Affiche Partie_1.Personne

        System.out.println();
        Constructor[] constructors;
        constructors = classe.getDeclaredConstructors();
        for (Constructor constructor : constructors) {
            System.out.println(constructor.toGenericString());
        }

        Object[] argsConstructor = { "Nom" };
        Object o3 = classe.getDeclaredConstructor(String.class).newInstance(argsConstructor); // Construction de Partie_1.Personne avec un nom précisé

        System.out.println();
        System.out.println();

        Class c = Class.forName("java.util.ArrayList");
        Class[] interfaces = c.getInterfaces();
        for (int i = 0; i < interfaces.length; i++) {
            System.out.print(interfaces[i] + "  ");
        }
        System.out.println();

        Method[] methods = c.getDeclaredMethods();
        for (int i = 0; i < methods.length; i++) {
            System.out.print(methods[i].toGenericString() + "  ");
        }
        System.out.println();

        Field[] fields = c.getFields();
        for (int i = 0; i < fields.length; i++) {
            System.out.print(fields[i].toGenericString() + "  ");
        }
        System.out.println();


        System.out.println();

        // PARTIE 2
        /*
        double[] tabD = new double[10];
        double min = 0;
        double max = 50;

        for(int i = 0; i < 10; i++) {
            Random r = new Random();
            tabD[i] =  min + (max - min) * r.nextDouble();
        }


        boolean executeAlgo = false;
        Class c = Class.forName(args[0]);
        Class[] interfaces = c.getInterfaces();
        for (int i = 0; i < interfaces.length; i++) {
            if(interfaces[i].getName() == "Partie_2.Algorithme") {
                executeAlgo = true;
            }
        }

        if(executeAlgo) {
            Algorithme a = (Algorithme) c.getDeclaredConstructor().newInstance();
            a.appliquer(tabD);
        }

        for (double elt : tabD) {
            System.out.println(elt);
        }

        */
    }
}
