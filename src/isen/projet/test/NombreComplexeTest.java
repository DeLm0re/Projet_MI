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

        assertTrue(z_barre.getPartieReelle() == z.getPartieReelle(), "Erreur partie réelle conjuguée x et y positifs");
        assertTrue(z_barre.getPartieImaginaire() == -z.getPartieImaginaire(), "Erreur partie imaginaire conjuguée x et y positifs");

        x = -7;
        y = -23;
        z = new NombreComplexe(x, y);
        z_barre = z.conjugue();

        assertTrue(z_barre.getPartieReelle() == z.getPartieReelle(), "Erreur partie réelle conjuguée x et y negatifs");
        assertTrue(z_barre.getPartieImaginaire() == -z.getPartieImaginaire(), "Erreur partie imaginaire conjuguée x et y negatifs");

        x = 6;
        y = -33;
        z = new NombreComplexe(x, y);
        z_barre = z.conjugue();

        assertTrue(z_barre.getPartieReelle() == z.getPartieReelle(), "Erreur partie réelle conjuguée y negatif");
        assertTrue(z_barre.getPartieImaginaire() == -z.getPartieImaginaire(), "Erreur partie imaginaire conjuguée y negatif");

        x = -9;
        y = 128;
        z = new NombreComplexe(x, y);
        z_barre = z.conjugue();

        assertTrue(z_barre.getPartieReelle() == z.getPartieReelle(), "Erreur partie réelle conjuguée x negatif");
        assertTrue(z_barre.getPartieImaginaire() == -z.getPartieImaginaire(), "Erreur partie imaginaire conjuguée x negatif");
    }

    @Test
    void moduleTest()
    {
        NombreComplexe z = new NombreComplexe(8, 2);
        double module = 8.246211251235321;
        assertTrue(z.module() == module, "Erreur module x et y positifs");

        z = new NombreComplexe(-11, -27);
        module = 29.154759474226502;
        System.out.println(module);
        assertTrue(z.module() == module, "Erreur module x et y negatifs");

        z = new NombreComplexe(0, -98);
        module = 98;
        assertTrue(z.module() == module, "Erreur module y negatif");

        z = new NombreComplexe(-74, 8);
        module = 74.43117626371358;
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
        NombreComplexe z = new NombreComplexe(-11, -27);
        String string = "-11 - 27i";
        assertTrue(z.toString() == string, "Erreur string x et y negatifs");

        z = new NombreComplexe(785, 245);
        string = "785 + 245i";
        assertTrue(z.toString() == string, "Erreur string x et y positifs");

        z = new NombreComplexe(0, 8);
        string = "8i";
        assertTrue(z.toString() == string, "Erreur string x nul");

        z = new NombreComplexe(34, 0);
        string = "34";
        assertTrue(z.toString() == string, "Erreur string y nul");

    }

    @Test
    void formeExponentielleTest()
    {
        NombreComplexe z = new NombreComplexe(-5, -9);
        String string = "10,296*e^(i*-2,078)";
        assertTrue(z.formeExponentielle().equals(string), "Erreur forme exponentielle x et y negatifs");

        z = new NombreComplexe(78, 43);
        string = "89,067*e^(i*0,504)";
        assertTrue(z.formeExponentielle().equals(string), "Erreur forme exponentielle x et y positifs");

        z = new NombreComplexe(2, 0);
        string = "2";
        assertTrue(z.formeExponentielle().equals(string), "Erreur forme exponentielle y nul");

        z = new NombreComplexe(0, 4);
        string = "4*e^(i*1,571)";
        System.out.println(z.formeExponentielle());
        assertTrue(z.formeExponentielle().equals(string), "Erreur forme exponentielle x nul");

        z = new NombreComplexe(0, 0);
        string = "0";
        assertTrue(z.formeExponentielle().equals(string), "Erreur forme exponentielle x et y nul");

    }

}