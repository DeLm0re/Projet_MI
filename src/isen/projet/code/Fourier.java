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

import static java.lang.Math.*;

public class Fourier
{
    private int taille;
    private Data donnee;

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
     * \return   \e NombreComplexe[], On renvoie un tableau similaire à celui qui contient nos données à traiter.
     */
    public NombreComplexe[] FFTr(int signal)
    {
        this.donnee = new Data(signal,this.getTaille());

        recursiveFFTr(this.donnee.getSreel());

        return(this.Lcomplexe);
    }

    /**
     * \brief    Fonction recursiveFFTr
     * \details  Cette fonction a pour but de calculer la FFT (Fast Fourier Transformation) de notre
     *           échantillon de valeurs \e réelles de notre signal (\e int), passé en paramétre.
     *           Elle est appelée par la fonction FFTr et permet de "descendre et remonter" dans la récursion,
     *           nécessaire pour traiter notre tableau de réels.
     * \param    reel[]         Notre tableau de réels en \e double; (contient nos données)
     * \return   \e void, il s'agit d'une fonction de calcul, donc pas de retour.
     */
    private void recursiveFFTr(double reel[])
    {
        if(reel.length == 1) {
            this.Lcomplexe[0] = new NombreComplexe(this.donnee.getSreel()[0],0);
        }
        else {
            double reelPair[] = new double[taille/2];
            double reelImpair[] = new double[taille/2];

            for(int i = 0; i < taille/2; i++){
                reelPair[i] = this.donnee.getSreel()[2*i];
                reelImpair[i] = this.donnee.getSreel()[(2*i)+1];
            }

            recursiveFFTr(reelPair);
            recursiveFFTr(reelImpair);

            for(int k = 0; k <= (taille/2) - 1; k++){
                double argumentM = -((2*PI*k)/taille);
                NombreComplexe M = OperationComplexe.expoVersAlgebrique(1,argumentM);

                this.Lcomplexe[k] = OperationComplexe.additionner(OperationComplexe.multiplier(M,reelImpair[k]),reelPair[k]);
                this.Lcomplexe[(k+taille)/2] = OperationComplexe.soustraire(OperationComplexe.multiplier(M,reelImpair[k]),reelPair[k]);
            }
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
