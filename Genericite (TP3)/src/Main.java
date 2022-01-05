public class Main {
    public static void main(String [] args) {
        /*Tableau t = new Tableau();

        System.out.println(t.getTaille());
        System.out.println(t.getCapacite());

        t.addElement("machin 1");
        t.addElement("machin 2");
        t.addElement("machin 3");

        System.out.println(t.getTaille());
        System.out.println(t.getCapacite());

        for(int i = 0; i < t.getTaille(); i++) {
            try {
                System.out.println(t.getElementAt(i));
            } catch (MyArrayOutOfBoundsException e) {
                e.printStackTrace();
            }
        }

        System.out.println(t);
        System.out.println();
        */
        // Vraie appli
        Tableau<String> tab = new Tableau<String>();
        for (Integer i = 1; i <=3; i++) {
            tab.addElement(i.toString());
        }

        /*Integer sum = 0;
        for (Object o : tab.tab) {
            if (o instanceof String) {
                sum += (String)o;
            }
        }*/

        System.out.println(tab);




    }
}
