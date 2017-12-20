package isen.projet.test;

import isen.projet.code.Data;
import isen.projet.code.NombreComplexe;
import isen.projet.code.Fourier;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class FourierTest
{
    @Test
    void FFTrTest()
    {
        Fourier f = new Fourier(16);
        NombreComplexe resu[] = f.FFTr(Data.UN);
        assertTrue(resu[0].getPartieReelle() == 16, "Erreur FFTr : signal uniforme à 1");
        for(int i = 1; i < 16; i++)
        {
            assertTrue(resu[i].getPartieReelle() == 0, "Erreur FFTr : signal uniforme à 1");
        }

        f = new Fourier(64);
        resu = f.FFTr(Data.DIRAC);
        for(int i = 0; i < 64; i++)
        {
            assertTrue(resu[i].getPartieReelle() == 1, "Erreur FFTr : impulsion de Dirac");
        }

        f = new Fourier(4);
        resu = f.FFTr(Data.SIN);
        assertTrue(resu[0].getPartieReelle() == 0, "Erreur FFTr : sinus");
        assertTrue(resu[1].getPartieImaginaire() == -2, "Erreur FFTr : sinus");
        assertTrue(resu[2].getPartieReelle() == 0, "Erreur FFTr : sinus");
        assertTrue(resu[3].getPartieImaginaire() == 2, "Erreur FFTr : sinus");

    }

}