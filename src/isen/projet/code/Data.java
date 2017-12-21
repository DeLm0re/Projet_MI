/**
 * \file      Data.java
 * \author    Romain Jacquiez, Théo HIPAULT et Antoine BERENGUER
 * \version   1.0
 * \date      19 décembre 2017
 * \brief     La classe Data
 * \details   Cette classe contient nos données que nous allons traiter avec la classe Fourier.
 *            Elles sont stockées dans un tableau réel ou complexe.
 *            Cette classe a un constructeur qui initialise ces tableaux suivant notre signal.
 */
package isen.projet.code;

import static java.lang.Math.PI;
import static java.lang.Math.*;

import java.awt.*;
import java.io.*;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Data
{
    public static final int INC = 0;
    public static final int UN = 1;
    public static final int SIN = 2;
    public static final int COS = 3;
    public static final int DIRAC = 4;
    public static final int CSV = 5;

    private double Sreel[];
    private NombreComplexe Scomplexe[];
    private String csvFile;

    /**
     * \brief    Constructeur de la classe Data
     * \details  Ce constructeur modifie les attributs de la classe (les tableaux)
     *           en fonction du signal passé en paramétre ainsi que de la taille.
     *           /!\ Cette taille doit être une puissance de 2.
     * \param    signal         Constante qui représente notre signal (ex: 1 = SIN et 2 = COS)
     * \param    taille         La taille de nos tableaux \e (^2)
     * \return   \e void (le constructeur change les attributs et ne doit rien retourner)
     */
    public Data(int signal, int taille)
    {
        this.Sreel = new double[taille];
        this.Scomplexe = new NombreComplexe[taille];
        this.csvFile = "";

        switch(signal){

            case INC:
                initInc(taille);
                break;

            case UN:
                initUn(taille);
                break;

            case SIN:
                initSin(taille);
                break;

            case COS:
                initCos(taille);
                break;

            case DIRAC:
                initDirac(taille);
            break;

            case CSV:
                initCSV(taille);
            break;
                break;
        }
    }

    /**
     * \brief    Fonction initInc
     * \details  Appelée par le constructeur de la classe, cette fonction initialise les tableaux de la classe
     *           par un increment de 1
     * \param    taille         La taille de nos tableaux \e (^2)
     * \return   \e void (cette fonction change les attributs et ne doit rien retourner)
     */
    private void initInc(int taille)
    {
        for(int i = 0; i < taille; ++i) {
            getSreel()[i] = i;
            getScomplexe()[i] = new NombreComplexe(0,i);
        }
    }

    /**
     * \brief    Fonction initUn
     * \details  Appelée par le constructeur de la classe, cette fonction initialise les tableaux de la classe
     *           par des 1
     * \param    taille         La taille de nos tableaux \e (^2)
     * \return   \e void (cette fonction change les attributs et ne doit rien retourner)
     */
    private void initUn(int taille)
    {
        for(int i = 0; i < taille; ++i) {
            getSreel()[i] = 1;
            getScomplexe()[i] = new NombreComplexe(1,1);
        }
    }

    /**
     * \brief    Fonction initSin
     * \details  Appelée par le constructeur de la classe, cette fonction initialise les tableaux de la classe
     *           par un échantillonage des valeurs de sin().
     *           Pour le tableau complexe, on utilise les formules d'Euleur.
     * \param    taille         La taille de nos tableaux \e (^2)
     * \return   \e void (cette fonction change les attributs et ne doit rien retourner)
     */
    private void initSin(int taille)
    {
        for(int i = 0; i < taille; ++i)
        {
            double x = (2*i*PI)/taille;
            getSreel()[i] = sin(x);
            getScomplexe()[i] = new NombreComplexe(0,sin(x));
        }
    }

    /**
     * \brief    Fonction initCos
     * \details  Appelée par le constructeur de la classe, cette fonction initialise les tableaux de la classe
     *           par un échantillonage des valeurs de cos().
     *           Pour le tableau complexe, on utilise les formules d'Euleur.
     * \param    taille         La taille de nos tableaux \e (^2)
     * \return   \e void (cette fonction change les attributs et ne doit rien retourner)
     */
    private void initCos(int taille)
    {
        for(int i = 0; i < taille; ++i)
        {
            double x = (2*i*PI)/taille;
            getSreel()[i] = cos(x);
            getScomplexe()[i] = new NombreComplexe(0,cos(x));
        }
    }

    /**
     * \brief    Fonction initDirac
     * \details  Appelée par le constructeur de la classe, cette fonction initialise les tableaux de la classe
     *           par une impulsion de Dirac
     * \param    taille         La taille de nos tableaux \e (^2)
     * \return   \e void (cette fonction change les attributs et ne doit rien retourner)
     */
    private void initDirac(int taille)
    {
        getSreel()[0] = 1;
        for(int i = 1; i < taille; ++i) {
            getSreel()[i] = 0;
        }

        getScomplexe()[0] = new NombreComplexe(1,1);
        for(int i = 1; i < taille; ++i) {
            getScomplexe()[i] = new NombreComplexe(0,0);
        }
    }

    /**
     * \brief    Fonction initCSV
     * \details  Appelée par le constructeur de la classe, cette fonction initialise les tableaux de la classe
     *           par la première colonne du tableur .CSV sélectionné
     * \param    taille         La taille de nos tableaux \e (^2)
     * \return   true si le tableau a bien été initialisé
     *           false sinon
     */
    private boolean initCSV(int taille)
    {
        String path = menuOuverture("csv");
        if(path == null)
            return false;
        try {
            String info[][] = CSVparser(path, taille);
            for(int i = 0; i < info.length; i++)
            {
                double Re = Double.parseDouble(info[i][0]);
                double Im = Double.parseDouble(info[i][1]);
                getScomplexe()[i] = new NombreComplexe(Re,Im);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }


    /**
     * \brief    Fonction magique getSreel
     * \details  Une fois appelée, cette fonction renvoie l'attribut Sreel de la classe Data.
     *           La fonction est \e public et permet de retourner Sreel qui est \e private
     * \return   \e double[] Sreel, qui est notre tableau de \e double (Sreel est un attribut de la classe Data)
     */
    public double[] getSreel()
    {
        return Sreel;
    }

    /**
     * \brief    Fonction magique getScomplexe
     * \details  Une fois appelée, cette fonction renvoie l'attribut Scomplexe de la classe Data.
     *           La fonction est \e public et permet de retourner Scomplexe qui est \e private
     * \return   \e NombreComplexe[] Scomplexe, qui est notre tableau de \e NombreComplexe
     *              (Scomplexe est un attribut de la classe Data)
     *              (NombreComplexe est une classe qui gére les nombres complexes)
     */
    public NombreComplexe[] getScomplexe()
    {
        return Scomplexe;
    }


    /**
     * \brief    Fonction CSVparser
     * \details  Appelée par la fonction initCSV, elle lit le fichier afin de transformer le contenu du fichier en un tableau 2D de String
     * \param    path         Le chemin du fichier CSV à lire
     *           taille       taille du tableau à renvoyer
     * \return   \e String[][] info, notre tableau de nombre complexes
     *              (info est une variable de initCSV)
     */
    private String[][] CSVparser(String path, int taille) throws Exception{
        String line;
        String separator = ";";
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            csvFile = path;
            String info[][] = new String[taille][2];
            int i = 0;
            while ((line = br.readLine()) != null && i < taille) {
                info[i] = (line.split(separator));
                i++;
            }
            if(i < taille)
                throw new Exception("La liste fournie n'est pas de taille 2^N");
            return info;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * \brief    Fonction CSVWrite
     * \details  Appelée dans le main, cette fonction écrit le tableau de nombre complexes fourni en paramètre dans le fichier CSV d'adresse stockée comme attribut.
     * \param    donnees      Le tableau de nombres complexes
     * \return   true si l'écriture a réussi
     *           false sinon
     */
    public boolean CSVWrite(NombreComplexe donnees[])
    {
        if (csvFile.equals("")) {
            String line;
            String separator = ";";
            String info[] = new String[donnees.length];
            try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
                int i = 0;
                while ((line = br.readLine()) != null && i < donnees.length) {
                    info[i] = line + separator + separator + donnees[i].getPartieReelle() + separator + donnees[i].getPartieImaginaire();
                    i++;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try (FileWriter fw = new FileWriter(csvFile)) {
                for (int i = 0; i < donnees.length; i++) {
                    fw.write(info[i] + "\n");
                }
                System.out.println("données écrites dans " + csvFile);
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();

            }
            return true;
        }
        else return false;
    }

    /**
     * \brief    Fonction CSVWrite
     * \details  Appelée dans initCSV, cette fonction affiche un menu qui permet à l'utilisateur de sélectionner le fichier CSV à importer
     * \param    type       Le type de fichier à importer, ici CSV
     * \return   \e String CSVfile, le chemin vers le fichier CSV sélectionné
     *              (CSVfile est un attribut de la classe Data)
     */
    private String menuOuverture(String type)
    {
        JFileChooser fenetreMenu = new JFileChooser();
        fenetreMenu.setAcceptAllFileFilterUsed(false);
        fenetreMenu.setFileFilter(new FileNameExtensionFilter("CSV files", type));
        JFrame jf = new JFrame();
        int resultat = fenetreMenu.showOpenDialog(jf);

        if (resultat == JFileChooser.APPROVE_OPTION)
        {
            String path = fenetreMenu.getSelectedFile().getAbsolutePath();
            jf.dispose();
            return (path);
        }
        else
            jf.dispose();
            return (null);
    }
}
