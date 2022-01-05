import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class TableauTest {
    Tableau<Integer> tInt;
    Tableau<String> tString;

    @Before
    public void initialisation() {
        tInt = new Tableau<Integer>();
        tString = new Tableau<String>();
        assertNotNull("@Before en échec", tInt);
        assertNotNull("@Before en échec", tString);
    }

    @After
    public void finalisation(){
        tInt = null;
        tString = null;
    }

    @Test
    public void testTableauVide() {
        assertEquals(tInt.getCapacite(), 1);
        assertEquals(tInt.getTaille(), 0);
        assertEquals(tString.getCapacite(), 1);
        assertEquals(tString.getTaille(), 0);
    }

    @Test
    public void testAjout1Element() throws OutOfMemoryError {
        tInt.addElement(new Integer(3));
        assertEquals(tInt.getTaille(), 1);
        tString.addElement("Pouet");
        assertEquals(tString.getTaille(), 1);
    }

    @Test
    public void testAjout2Elements() throws OutOfMemoryError {
        testAjout1Element();
        tInt.addElement(new Integer(4));
        assertEquals(tInt.getTaille(), 2);
        assertEquals(tInt.getCapacite(), 2);
        tString.addElement("Pouet 2");
        assertEquals(tString.getTaille(), 2);
        assertEquals(tString.getCapacite(), 2);
    }

    @Test
    public void testAjout3Elements() throws OutOfMemoryError {
        testAjout2Elements();
        tInt.addElement(new Integer(1));
        assertEquals(tInt.getTaille(), 3);
        assertEquals(tInt.getCapacite(), 4);
        tString.addElement("Pouet 3");
        assertEquals(tString.getTaille(), 3);
        assertEquals(tString.getCapacite(), 4);
    }

    @Test
    public void testAccesElements1() throws Exception {
        testAjout3Elements();
        assertEquals(tInt.getElementAt(0), 3);
        assertEquals(tInt.getElementAt(1), 4);
        assertEquals(tInt.getElementAt(2), 1);
        // auto boxing ...
        tInt.addElement(7);
        assertEquals(tInt.getElementAt(3), 7);

        assertEquals(tString.getElementAt(0), "Pouet");
        assertEquals(tString.getElementAt(1), "Pouet 2");
        assertEquals(tString.getElementAt(2), "Pouet 3");
        // auto boxing ...
        tString.addElement("Pouet 4");
        assertEquals(tString.getElementAt(3), "Pouet 4");
    }

    @Test(expected=MyArrayOutOfBoundsException.class)
    public void testAccesElementsInteger2()  throws Exception {
        testAccesElements1();
        tInt.getElementAt(-1);
    }

    @Test(expected=MyArrayOutOfBoundsException.class)
    public void testAccesElementsString2()  throws Exception {
        testAccesElements1();
        tString.getElementAt(-1);
    }

    @Test(expected=MyArrayOutOfBoundsException.class)
    public void testAccesElementsInteger3() throws Exception {
        testAccesElements1();
        tInt.getElementAt(4);
    }

    @Test(expected=MyArrayOutOfBoundsException.class)
    public void testAccesElementsString3() throws Exception {
        testAccesElements1();
        tString.getElementAt(4);
    }

    @Test(expected=OutOfMemoryError.class)
    public void testAgrandirException() throws Exception  {
        tInt = new Tableau<Integer>(Integer.MAX_VALUE);
        try {
            while (true) {
                tInt.addElement(new Integer((int)Math.random()));
            }
        }  catch(Exception e) {
            System.out.println("Exception a la taille"+tInt.getTaille());
            throw e;
        }
    }

    @Test(expected=OutOfMemoryError.class)
    public void testAgrandirStringException() throws Exception  {
        tString = new Tableau<String>(Integer.MAX_VALUE);
        try {
            while (true) {
                tString.addElement(((Double)Math.random()).toString());
                //System.out.println(t.getTaille());
            }
        }  catch(Exception e) {
            System.out.println("Exception a la taille"+tString.getTaille());
            throw e;
        }
    }
}

