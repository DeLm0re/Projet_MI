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

public class Data
{
    public static final int INC = 0;
    public static final int UN = 1;
    public static final int SIN = 2;
    public static final int COS = 3;
    public static final int DIRAC = 4;

    private double Sreel[];
    private NombreComplexe Scomplexe[];

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
}
