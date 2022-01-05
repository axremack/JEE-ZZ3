import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;


public class TableauTest {
    Tableau t;

    @Before
    public void initialisation() {
        t = new Tableau();
        assertNotNull("@Before en échec", t);
    }

    @After
    public void finalisation(){
        t = null;
    }

    @Test
    public void testTableauVide() {
        assertEquals(t.getCapacite(), 1);
        assertEquals(t.getTaille(), 0);
    }

    @Test
    public void testAjout1Element() throws OutOfMemoryError {
        t.addElement(new Integer(3));
        assertEquals(t.getTaille(), 1);
    }

    @Test
    public void testAjout2Elements() throws OutOfMemoryError {
        testAjout1Element();
        t.addElement(new Integer(4));
        assertEquals(t.getTaille(), 2);
        assertEquals(t.getCapacite(), 2);
    }

    @Test
    public void testAjout3Elements() throws OutOfMemoryError {
        testAjout2Elements();
        t.addElement(new Integer(1));
        assertEquals(t.getTaille(), 3);
        assertEquals(t.getCapacite(), 4);
    }

    @Test
    public void testAccesElements1() throws Exception {
        testAjout3Elements();
        assertEquals(t.getElementAt(0), 3);
        assertEquals(t.getElementAt(1), 4);
        assertEquals(t.getElementAt(2), 1);
        // auto boxing ...
        t.addElement(7);
        assertEquals(t.getElementAt(3), 7);
    }

    @Test(expected=MyArrayOutOfBoundsException.class)
    public void testAccesElements2()  throws Exception {
        testAccesElements1();
        t.getElementAt(-1);
    }

    @Test(expected=MyArrayOutOfBoundsException.class)
    public void testAccesElements3() throws Exception {
        testAccesElements1();
        t.getElementAt(4);
    }
/*
    @Test(expected=MyArrayOutOfBoundsException.class)
    public void testExceptionPourIncredule() throws Exception {
        // evidemment ce test est toujours FAUX
        throw new OutOfMemoryError();
    }
*/
    @Test(expected=OutOfMemoryError.class)
    //@Ignore
    public void testAgrandirException() throws Exception  {
        t = new Tableau(Integer.MAX_VALUE);
        try {
            while (true) {
                t.addElement(new Double(Math.random()));
                //System.out.println(t.getTaille());
            }
        }  catch(Exception e) {
            System.out.println("Exception a la taille"+t.getTaille());
            throw e;
        }
    }
}

