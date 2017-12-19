package isen.projet.test;

import isen.projet.code.NombreComplexe;
import org.junit.jupiter.api.Test;

import static java.lang.Math.sqrt;
import static org.junit.jupiter.api.Assertions.*;

class NombreComplexeTest {
    @Test
    void conjugueTest()
    {
        int x = 1;
        int y = 2;
        NombreComplexe z = new NombreComplexe(x, y);
        NombreComplexe z_barre = z.conjugue();

        assertTrue(z_barre.getPartieEntiere() == z.getPartieEntiere(), "Erreur partie réelle conjuguée x et y positifs");
        assertTrue(z_barre.getPartieImaginaire() == -z.getPartieImaginaire(), "Erreur partie imaginaire conjuguée x et y positifs");

        x = -7;
        y = -23;
        z = new NombreComplexe(x, y);
        z_barre = z.conjugue();

        assertTrue(z_barre.getPartieEntiere() == z.getPartieEntiere(), "Erreur partie réelle conjuguée x et y negatifs");
        assertTrue(z_barre.getPartieImaginaire() == -z.getPartieImaginaire(), "Erreur partie imaginaire conjuguée x et y negatifs");

        x = 6;
        y = -33;
        z = new NombreComplexe(x, y);
        z_barre = z.conjugue();

        assertTrue(z_barre.getPartieEntiere() == z.getPartieEntiere(), "Erreur partie réelle conjuguée y negatif");
        assertTrue(z_barre.getPartieImaginaire() == -z.getPartieImaginaire(), "Erreur partie imaginaire conjuguée y negatif");

        x = -9;
        y = 128;
        z = new NombreComplexe(x, y);
        z_barre = z.conjugue();

        assertTrue(z_barre.getPartieEntiere() == z.getPartieEntiere(), "Erreur partie réelle conjuguée x negatif");
        assertTrue(z_barre.getPartieImaginaire() == -z.getPartieImaginaire(), "Erreur partie imaginaire conjuguée x negatif");
    }

    @Test
    void moduleTest()
    {
        int x = 8;
        int y = 2;
        NombreComplexe z = new NombreComplexe(x, y);
        double module = sqrt(x*x +y*y);

        assertTrue(z.module() == module, "Erreur module x et y positifs");

        x = -11;
        y = -27;
        z = new NombreComplexe(x, y);
        module = sqrt(x*x +y*y);

        assertTrue(z.module() == module, "Erreur module x et y negatifs");

        x = 0;
        y = -98;
        z = new NombreComplexe(x, y);
        module = sqrt(x*x +y*y);

        assertTrue(z.module() == module, "Erreur module y negatif");

        x = -74;
        y = 8;
        z = new NombreComplexe(x, y);
        module = sqrt(x*x +y*y);

        assertTrue(z.module() == module, "Erreur module x negatif");

    }

    @Test
    void argumentTest()
    {
        fail("Not yet implemented");
    }

    @Test
    void toStringTest()
    {
        int x = -11;
        int y = -27;
        NombreComplexe z = new NombreComplexe(x, y);
        String string = "-11 -27i";

        assertTrue(z.toString() == string, "Erreur string x et y negatifs");

        x = 785;
        y = 245;
        z = new NombreComplexe(x, y);
        string = "785 +245i";

        assertTrue(z.toString() == string, "Erreur string x et y positifs");

    }

    @Test
    void formeExponentielleTest()
    {
        fail("Not yet implemented");
    }

}