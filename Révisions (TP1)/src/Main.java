public class Main {
    public static void main (String[] args) {
        Livre l1 = new Livre("Livre 1", 30.0);
        Livre l2 = new Livre("Livre 2", 50.0);
        Livre l3 = new Livre("Livre 3", 70.0);
        Livre l4 = new Livre("Livre 4", 20.0);
        Livre l5 = new Livre("Livre 5", 10.0);
        LivreNumerique ln = new LivreNumerique("Livre 6", 40.0, Format.pub);

        /*
        System.out.println(l1);
        System.out.println(l2);
        System.out.println(l3);
        System.out.println(l4);
        System.out.println(l5);
        System.out.println(ln);
         */

        Bibliothecaire b = new Bibliothecaire();
        try {
            b.getBibli().add(l1);
            b.getBibli().add(ln);
        } catch (Exception e) {
            e.printStackTrace();
        }

        for (Livre l : b.getBibli()) {
            System.out.println(l);
        }



    }
}
