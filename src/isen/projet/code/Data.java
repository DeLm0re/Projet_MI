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

public class Data
{
    public static final int SIN = 1;
    public static final int COS = 2;

    private float Sreel[];
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
    public void Data(int signal, int taille)
    {

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

    }

    /**
     * \brief    Fonction magique getSreel
     * \details  Une fois appelée, cette fonction renvoie l'attribut Sreel de la classe Data.
     *           La fonction est \e public et permet de retourner Sreel qui est \e private
     * \return   \e float[] Sreel, qui est notre tableau de \e float (Sreel est un attribut de la classe Data)
     */
    public float[] getSreel()
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