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

import org.jfree.chart.*;
import org.jfree.chart.plot.*;
import org.jfree.data.category.*;
import org.jfree.data.general.*;
import java.util.Scanner;

import java.io.File;
import java.util.List;

import static java.lang.Math.*;

public class Main {

    /**
     * \brief    main du programme
     * \details  Cette fonction lance et fait tourner le programme
     * \param    args[]         La taille de nos futurs tableaux \e (^2)
     * \return   \e void (la fonction main ne doit rien retourner)
     */
    public static void main(String args[]) throws Exception {

        int signal;
        int taille;
        Scanner in = new Scanner(System.in);

        do {
            System.out.println("Choisissez votre signal :");
            System.out.println("0. Signal incrémenté :");
            System.out.println("1. Signal unitaire constant");
            System.out.println("2. Sinus");
            System.out.println("3. Cosinus");
            System.out.println("4. Impulsion de Dirac");
            System.out.println("5. Importer un signal depuis un fichier CSV");
            signal = in.nextInt();
            if(signal<0 || signal>5)
            {
                System.out.println("Choix incorrect. Vous devez entrer un nombre entre 0 et 5.");
            }
            else
            {
                System.out.print("Choix confirmé. Vous avez choisi un");
                switch(signal)
                {
                    case 0:
                        System.out.println(" signal incrémenté.");
                        break;
                    case 1:
                        System.out.println(" signal unitaire constant.");
                        break;
                    case 2:
                        System.out.println(" sinus.");
                        break;
                    case 3:
                        System.out.println(" cosinus.");
                        break;
                    case 4:
                        System.out.println("e impulsion de Diract.");
                        break;
                    case 5:
                        System.out.println(" signal importé depuis un fichier CSV.");
                        break;
                }
            }
        } while (signal<0 || signal>5);

        do {
            System.out.println("Choisissez votre taille d'échantillon :");
            taille = in.nextInt();
            if((taille <= 0) || ((taille & (taille - 1)) != 0))
            {
                System.out.println("Choix incorrect. Vous devez entrer une puissance de 2.");
            }
        } while ((taille <= 0) || ((taille & (taille - 1)) != 0));

        Fourier monFourier = new Fourier(taille);

        NombreComplexe monRetour[] = new NombreComplexe[monFourier.getTaille()];

        monRetour = monFourier.FFTc(signal);

        System.out.println("FFT");
        for(int i = 0; i < monFourier.getTaille(); ++i)
        {
            //System.out.println(i + ", " + monFourier.donnee.getSreel().length + ", " + monRetour.length);
            System.out.println(monFourier.donnee.getSreel()[i] + " => " + monRetour[i]);
        }

        System.out.println("");

        NombreComplexe monRetourInverse[] = new NombreComplexe[monFourier.getTaille()];

        System.arraycopy(monRetour,0,monRetourInverse,0,monFourier.getTaille());

        monRetourInverse = monFourier.iFFT(monRetour,monFourier.getTaille());

        System.out.println("iFFT");
        for(int i = 0; i < monFourier.getTaille(); ++i)
        {
            //System.out.println(i + ", " + monFourier.donnee.getSreel().length + ", " + monRetour.length);
            System.out.println(monRetour[i] + " => " + monRetourInverse[i]);
        }
        if(signal == 5) {
            monFourier.donnee.CSVWrite(monRetour);
            monFourier.donnee.CSVWrite(monRetourInverse);
        }

        try {
            genereChartSignal(monFourier);
            genereChartFourier(monRetour,false);
            genereChartFourier(monRetourInverse,true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * \brief    Fonction genereChartFourier
     * \details  Cette fonction permet de crée une frame qui contient le graph d'un signal,
     *           dont les données sont passées dans un tableau, lui même passé en paramètre.
     *           Les titres des axes varient si on choisit d'afficher notre signal FFT ou iFFT
     * \param    retour[]       Nos valeurs représentant notre signal
     * \param    inverse        Un boolean pour savoir si on nomme les axes avec FFT ou iFFT
     * \return   \e void (la fonction affiche et ne doit rien retourner)
     */
    public static void genereChartFourier(NombreComplexe retour[], boolean inverse) throws Exception{

        DefaultCategoryDataset line_chart_dataset = new DefaultCategoryDataset();

        for(int i = 0; i < retour.length; ++i) {
            if(inverse == false)
                line_chart_dataset.addValue(retour[i].module(),"FFT", String.valueOf(i));
            if(inverse == true)
                line_chart_dataset.addValue(retour[i].module(),"iFFT", String.valueOf(i));
        }

        if(inverse == false) {
            JFreeChart lineChartObject = ChartFactory.createLineChart(
                    "Signal après FFT", "Valeurs échantillonées",
                    "Représentation avec le module",
                    line_chart_dataset, PlotOrientation.VERTICAL,
                    true, true, false);
            ChartFrame frame = new ChartFrame("Graph", lineChartObject);
            frame.pack();
            frame.setSize(750,500);
            frame.setVisible(true);
        }

        if(inverse == true) {
            JFreeChart lineChartObject = ChartFactory.createLineChart(
                    "Signal après iFFT (signal de départ)", "Valeurs échantillonées",
                    "Représentation avec le module",
                    line_chart_dataset, PlotOrientation.VERTICAL,
                    true, true, false);
            ChartFrame frame = new ChartFrame("Graph", lineChartObject);
            frame.pack();
            frame.setSize(750,500);
            frame.setVisible(true);
        }
    }

    /**
     * \brief    Fonction genereChartSignal
     * \details  Cette fonction permet de crée une frame qui contient le graph de notre signal d'entré.
     * \param    monFourier      Une fois monFourier initialisé, on accède à notre signal d'entrée,
     *                           en allant dans son attribut donnee de type \e Data, qu'il par la suite
     *                           transformé avec FFT.
     * \return   \e void (la fonction affiche et ne doit rien retourner)
     */
    public static void genereChartSignal(Fourier monFourier) throws Exception{

        DefaultCategoryDataset line_chart_dataset = new DefaultCategoryDataset();

        for(int i = 0; i < monFourier.getTaille(); ++i) {
            double module = monFourier.donnee.getScomplexe()[i].module();
            line_chart_dataset.addValue(module,"Signal", String.valueOf(i));
        }

        JFreeChart lineChartObject = ChartFactory.createLineChart(
                "Notre signal de départ","Valeurs échantillonées",
                "Module des valeurs du sinus",
                line_chart_dataset, PlotOrientation.VERTICAL,
                true,true,false);

        ChartFrame frame = new ChartFrame("Graph", lineChartObject);
        frame.pack();
        frame.setSize(750,500);
        frame.setVisible(true);
    }
}
