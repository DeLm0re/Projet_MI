/**
 * \file      Fourier.java
 * \author    Romain Jacquiez, Théo HIPAULT et Antoine BERENGUER
 * \version   1.0
 * \date      19 décembre 2017
 * \brief     La classe Fourier
 * \details   Cette classe contient nos données qui résultent des données de la classe Data.
 *            Elles sont stockées dans un tableau réel ou complexe.
 *            Cette classe a un constructeur qui initialise son attribut \e int taille.
 */
package isen.projet.code;

public class Fourier
{
    private int taille;
    private Data donnee;

    private double Lreel[];
    private NombreComplexe Lcomplexe[];

    /**
     * \brief    Constructeur de la classe Fourier
     * \details  Ce constructeur modifie l'attribut taille de la classe (\e int)
     * \param    taille         La taille de nos futurs tableaux \e (^2)
     * \return   \e void (le constructeur change l'attribut et ne doit rien retourner)
     */
    public Fourier(int taille)
    {
        if( (taille < 0) || ((taille & (taille-1)) != 0) )
        {
            //erreur
        }
        else {
            setTaille(taille);
        }
    }

    /**
     * \brief    Fonction FFTr
     * \details  Cette fonction a pour but de calculer la FFT (Fast Fourier Transformation) de notre
     *           échantillon de valeurs \e réelles de notre signal (\e int), passé en paramétre.
     * \param    signal         Notre entier représentant le signal
     * \return   \e double[], On renvoie un tableau similaire à celui qui contient nos données à traiter.
     */
    public double[] FFTr(int signal)
    {
        this.donnee = new Data(signal,this.getTaille());

        

        return(this.Lreel);
    }

    /**
     * \brief    Fonction recursiveFFTr
     * \details  Cette fonction a pour but de calculer la FFT (Fast Fourier Transformation) de notre
     *           échantillon de valeurs \e réelles de notre signal (\e int), passé en paramétre.
     *           Elle est appelée par la fonction FFTr et permet de "descendre et remonter" dans la récursion,
     *           nécessaire pour traiter notre tableau de réels.
     * \param    reel[]         Notre tableau de réels en \e double; (contient nos résultats)
     * \return   \e void, il s'agit d'une fonction de calcul, donc pas de retour.
     */
    private void recursiveFFTr(double reel[])
    {
        if(getTaille() == 1) {
            this.Lreel = this.donnee.getSreel();
        }
    }

    /**
     * \brief    Fonction magique getTaille
     * \details  Une fois appelée, cette fonction renvoie l'attribut taille de la classe Fourier.
     *           La fonction est \e public et permet de retourner taille qui est \e private
     * \return   \e int taille, qui est notre taille de tableau \e (^2) de nos retours, comme de nos traitements.
     */
    public int getTaille() {
        return taille;
    }

    /**
     * \brief    Fonction magique setTaille
     * \details  Une fois appelée, cette fonction modifie l'attribut taille de la classe Fourier.
     *           La fonction est \e public et permet de modifier l'attribut taille qui est \e private
     * \param    taille        La valeur de notre taille que l'on veut sauvegarder
     * \return   \e void, il s'agit d'un setteur, donc il n'y a pas de retour.
     */
    public void setTaille(int taille) {
        this.taille = taille;
    }

}
