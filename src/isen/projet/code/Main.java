/**
 * \file      Main.java
 * \author    Romain Jacquiez, Théo HIPAULT et Antoine BERENGUER
 * \version   1.0
 * \date      20 décembre 2017
 * \brief     La classe Main
 * \details   Cette classe permet de lancer le programme, et elle appele nos autres classes
 *            pour réaliser le programme souhaité. Elle retour la FFT d'un signal.
 */
package isen.projet.code;

public class Main {

    /**
     * \brief    main du programme
     * \details  Cette fonction lance et fait tourner le programme
     * \param    args[]         La taille de nos futurs tableaux \e (^2)
     * \return   \e void (la fonction main ne doit rien retourner)
     */
    public static void main(String args[])
    {
        Fourier monFourier = new Fourier(16);

        NombreComplexe monRetour[] = new NombreComplexe[monFourier.getTaille()];

        monRetour = monFourier.FFTc(5);

        NombreComplexe monRetourInverse[] = new NombreComplexe[monFourier.getTaille()];

        for(int i = 0; i < monFourier.getTaille(); ++i)
        {
            //System.out.println(i + ", " + monFourier.donnee.getSreel().length + ", " + monRetour.length);
            System.out.println(monFourier.donnee.getScomplexe()[i] + " => " + monRetour[i]);
        }
        System.out.println("test inverse");
        System.arraycopy(monRetour,0,monRetourInverse,0,monFourier.getTaille());
        monRetourInverse = monFourier.iFFT(monRetour,monFourier.getTaille());
        for(int i = 0; i < monFourier.getTaille(); ++i)
        {
            //System.out.println(i + ", " + monFourier.donnee.getSreel().length + ", " + monRetour.length);
            System.out.println(monRetour[i] + " => " + monRetourInverse[i]);
        }
        monFourier.donnee.CSVWrite(monRetour);
        monFourier.donnee.CSVWrite(monRetourInverse);
    }
}
