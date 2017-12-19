package isen.projet.test;

import isen.projet.code.NombreComplexe;
import org.junit.jupiter.api.Test;

import static isen.projet.code.OperationComplexe.*;
import static org.junit.jupiter.api.Assertions.*;

class OperationComplexeTest {
    @Test
    void inverseTest()
    {
        NombreComplexe z = new NombreComplexe(1, 1);
        NombreComplexe inv = inverse(z);
        assertTrue(inv.getPartieReelle() == 0.5 && inv.getPartieImaginaire() == -0.5, "Erreur inverse : z positif");

        z = new NombreComplexe(-2, 4);
        inv = inverse(z);
        assertTrue(inv.getPartieReelle() == -0.1 && inv.getPartieImaginaire() == -0.2, "Erreur inverse : x négatif");

        z = new NombreComplexe(8, -4);
        inv = inverse(z);
        assertTrue(inv.getPartieReelle() == 0.1 && inv.getPartieImaginaire() == 0.05, "Erreur inverse : y négatif");

        z = new NombreComplexe(-4, -4);
        inv = inverse(z);
        assertTrue(inv.getPartieReelle() == -0.125 && inv.getPartieImaginaire() == 0.125, "Erreur inverse : z négatif");

        assertThrows(IllegalArgumentException.class,
                ()-> {
                    NombreComplexe z0 = new NombreComplexe(0, 0);
                    inverse(z0);
                }, "Erreur inverse : exception de division par 0");
    }

    @Test
    void additionnerTest()
    {
        NombreComplexe z1 = new NombreComplexe(2, 5);
        NombreComplexe z2 = new NombreComplexe(8, 3);
        NombreComplexe za = additionner(z1, z2);
        assertTrue(za.getPartieReelle() == 10 && za.getPartieImaginaire() == 8, "Erreur addition : z1 et z2 positifs");

        z1 = new NombreComplexe(-4, -32);
        z2 = new NombreComplexe(-22, -6);
        za = additionner(z1, z2);
        assertTrue(za.getPartieReelle() == -26 && za.getPartieImaginaire() == -38, "Erreur addition : z1 et z2 negatifs");

        z1 = new NombreComplexe(-2, 5);
        z2 = new NombreComplexe(8, -3);
        za = additionner(z1, z2);
        assertTrue(za.getPartieReelle() == 6 && za.getPartieImaginaire() == 2, "Erreur addition : z1 et z2 random");

        z1 = new NombreComplexe(-20, 785);
        z2 = new NombreComplexe(0, 0);
        za = additionner(z1, z2);
        assertTrue(za.getPartieReelle() == -20 && za.getPartieImaginaire() == 785, "Erreur addition : z2 nul ");

        z1 = new NombreComplexe(0, 0);
        z2 = new NombreComplexe(0, 0);
        za = additionner(z1, z2);
        assertTrue(za.getPartieReelle() == 0 && za.getPartieImaginaire() == 0, "Erreur addition : z1 et z2 nuls");
    }

    @Test
    void soustraireTest()
    {
        NombreComplexe z1 = new NombreComplexe(2, 5);
        NombreComplexe z2 = new NombreComplexe(8, 3);
        NombreComplexe za = soustraire(z1, z2);
        assertTrue(za.getPartieReelle() == -6 && za.getPartieImaginaire() == 2, "Erreur soustraction : z1 et z2 positifs");

        z1 = new NombreComplexe(-4, -32);
        z2 = new NombreComplexe(-22, -6);
        za = soustraire(z1, z2);
        assertTrue(za.getPartieReelle() == 18 && za.getPartieImaginaire() == -26, "Erreur soustraction : z1 et z2 negatifs");
        z1 = new NombreComplexe(-2, 5);
        z2 = new NombreComplexe(8, -3);
        za = soustraire(z1, z2);
        assertTrue(za.getPartieReelle() == -10 && za.getPartieImaginaire() == 8, "Erreur soustraction : z1 et z2 random");

        z1 = new NombreComplexe(-20, 785);
        z2 = new NombreComplexe(0, 0);
        za = soustraire(z1, z2);
        assertTrue(za.getPartieReelle() == -20 && za.getPartieImaginaire() == 785, "Erreur soustraction : z2 nul ");

        z1 = new NombreComplexe(0, 0);
        z2 = new NombreComplexe(0, 0);
        za = soustraire(z1, z2);
        assertTrue(za.getPartieReelle() == 0 && za.getPartieImaginaire() == 0, "Erreur soustraction : z1 et z2 nuls");
    }

    @Test
    void multiplierTest()
    {
        NombreComplexe z1 = new NombreComplexe(1, 2);
        NombreComplexe z2 = new NombreComplexe(3, 4);
        NombreComplexe za = multiplier(z1, z2);
        assertTrue(za.getPartieReelle() == -5 && za.getPartieImaginaire() == 10, "Erreur multiplication : z1 et z2 positifs");

        z1 = new NombreComplexe(2, 3);
        z2 = new NombreComplexe(6, -1);
        za = multiplier(z1, z2);
        assertTrue(za.getPartieReelle() == 15 && za.getPartieImaginaire() == 16, "Erreur multiplication : y z2 négatif");

        z1 = new NombreComplexe(2, 3);
        z2 = new NombreComplexe(0, 0);
        za = multiplier(z1, z2);
        assertTrue(za.getPartieReelle() == 0 && za.getPartieImaginaire() == 0, "Erreur multiplication : z2 nul");

        z1 = new NombreComplexe(0, 3);
        z2 = new NombreComplexe(6, 0);
        za = multiplier(z1, z2);
        assertTrue(za.getPartieReelle() == 0 && za.getPartieImaginaire() == 18, "Erreur multiplication : x z1 et y z2 nuls");

        z1 = new NombreComplexe(0, 0);
        z2 = new NombreComplexe(0, 0);
        za = multiplier(z1, z2);
        assertTrue(za.getPartieReelle() == 0 && za.getPartieImaginaire() == 0, "Erreur multiplication : z1 et z2 nuls");
    }

    @Test
    void diviserTest()
    {
        NombreComplexe z = new NombreComplexe(547,-9845);
        NombreComplexe za = diviser(z, z);
        assertTrue(za.getPartieReelle() == 1 && za.getPartieImaginaire() == 0, "Erreur division");
    }

}