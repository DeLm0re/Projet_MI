/**
 * \file      NombreComplexe.java
 * \author    Romain Jacquiez, Théo HIPAULT et Antoine BERENGUER
 * \version   1.0
 * \date      19 décembre 2017
 * \brief     La classe NombreComplexe
 * \details   Cette classe permet de gérer les nombres complexes.
 *            Effectivement, les nombres complexes n'étant pas gérés en Java, cette classe
 *            qui contient deux attributs : partieReelle et partieImaginaire, va jouer le rôle
 *            d'un nombre complexe. Elle contient aussi des méthodes utiles comme :
 *            - argument()
 *            - module()
 *            - etc
 */
package isen.projet.code;

import java.text.DecimalFormat;
import java.text.NumberFormat;

import static java.lang.Math.*;

public class NombreComplexe
{
    private double partieReelle;
    private double partieImaginaire;
    private double margeErreur;

    public NombreComplexe(double partieReelle, double partieImaginaire, double margeErreur)
    {
        this.partieReelle=(abs(partieReelle)>margeErreur)?partieReelle:0;
        this.partieImaginaire=(abs(partieImaginaire)>margeErreur)?partieImaginaire:0;
        this.margeErreur=margeErreur;
    }

    /**
     * \brief    Un constructeur de la classe NombreComplexe
     * \details  Ce constructeur modifie les attributs de la classe (la partie réelle et imaginaire)
     *           en fonction des valeurs passées en paramétre.
     * \param    partieReelle         Valeur de notre partieReelle
     * \param    partieImaginaire     Valeur de notre partieImaginaire
     * \return   \e void (le constructeur change les attributs et ne doit rien retourner)
     */
    public NombreComplexe(double partieReelle, double partieImaginaire)
    {
        this(partieReelle, partieImaginaire, 1e-10);
    }

    /**
     * \brief    Un constructeur de la classe NombreComplexe
     * \details  Ce constructeur modifie les attributs de la classe (la partie réelle et imaginaire)
     *           et les mets à 0.
     * \return   \e void (le constructeur change les attributs et ne doit rien retourner)
     */
    public NombreComplexe()
    {
        this(0,0);
    }

    /**
     * \brief    Fonction magique getPartieReelle
     * \details  Une fois appelée, cette fonction renvoie l'attribut partieReelle de la classe NombreComplexe.
     *           La fonction est \e public et permet de retourner partieReelle qui est \e private
     * \return   \e double partieReelle, qui est la valeur de notre partie réelle
     */
    public double getPartieReelle() {
        return partieReelle;
    }

    /**
     * \brief    Fonction magique setPartieReelle
     * \details  Une fois appelée, cette fonction modifie l'attribut partieReelle de la classe NombreComplexe.
     *           La fonction est \e public et permet de modifier l'attribut partieReelle qui est \e private
     * \param    partieReelle        La valeur de notre partie réelle que l'on veut sauvegarder
     * \return   \e void, il s'agit d'un setteur, donc il n'y a pas de retour.
     */
    public void setPartieReelle(double partieReelle) {
        this.partieReelle=(abs(partieReelle)>margeErreur)?partieReelle:0;
    }

    /**
     * \brief    Fonction magique getPartieImaginaire
     * \details  Une fois appelée, cette fonction renvoie l'attribut partieImaginaire de la classe NombreComplexe.
     *           La fonction est \e public et permet de retourner partieImaginaire qui est \e private
     * \return   \e double partieImaginaire, qui est la valeur de notre partie imaginaire
     */
    public double getPartieImaginaire() {
        return partieImaginaire;
    }

    /**
     * \brief    Fonction magique setPartieImaginaire
     * \details  Une fois appelée, cette fonction modifie l'attribut partieImaginaire de la classe NombreComplexe.
     *           La fonction est \e public et permet de modifier l'attribut partieImaginaire qui est \e private
     * \param    partieImaginaire        La valeur de notre partie imaginaire que l'on veut sauvegarder
     * \return   \e void, il s'agit d'un setteur, donc il n'y a pas de retour.
     */
    public void setPartieImaginaire(double partieImaginaire) {
        this.partieImaginaire=(abs(partieImaginaire)>margeErreur)?partieImaginaire:0;
    }

    /**
     * \brief    Fonction magique setNombreComplexe
     * \details  Une fois appelée, cette fonction modifie l'attribut partieImaginaire et partieReelle de la classe NombreComplexe,
     *           en fonction du nombre complexe passé en paramétre.
     * \param    z        Notre nombre complexe dont on récupere sa partie réelle et imaginaire
     * \return   \e void, il s'agit d'un setteur, donc il n'y a pas de retour.
     */
    public void setNombreComplexe(NombreComplexe z)
    {
        setPartieReelle(z.getPartieReelle());
        setPartieImaginaire(z.getPartieImaginaire());
    }

    /**
     * \brief    Fonction conjuge
     * \details  Appelée, cette fonction renvoie un nouveau nombre complexe qui est le conjugé,
     *           du nombre complexe qui appele cette fonction.
     * \return   \e NombreComplexe zs, le conjugé du nombre complexe
     */
    public NombreComplexe conjugue()
    {
        NombreComplexe zs = new NombreComplexe(partieReelle,-partieImaginaire);
        return zs;
    }

    /**
     * \brief    Fonction module
     * \details  Appelée, cette fonction renvoie le module du nombre complexe qui appele cette fonction.
     * \return   \e double, le module du nombre complexe appelant
     */
    public double module()
    {
        return sqrt(partieReelle*partieReelle + partieImaginaire*partieImaginaire);
    }

    /**
     * \brief    Fonction argument
     * \details  Appelée, cette fonction renvoie l'argument du nombre complexe qui appele cette fonction.
     * \return   \e double, l'argument du nombre complexe appelant
     */
    public double argument()
    {
        if(partieReelle == 0 && partieImaginaire == 0)
            throw new IllegalArgumentException("0 ne peut pas avoir d'argument.");
        if(partieReelle<0 && partieImaginaire==0)
            return PI; //l'argument d'un nombre réel négatif est toujours pi. Gérer ce cas séparément permet d'éviter une division par zéro.
        else
            return 2*atan(partieImaginaire/(partieReelle + module()));
    }

    /**
     * \brief    Fonction toString
     * \details  Override de la fonction toString de java.lang.object
     *           Cette fonction permet de définir comment va être affiché notre objet,
     *           si on "l'appele" dans une chaine de caractères.
     * \return   \e String, le string correspondant à notre objet dans une chaine de caractères
     */
    public String toString()
    {
        String valeur = "";
        NumberFormat formatter = new DecimalFormat("##.###"); //permet d'éviter les virgules non nécessaires
        if(partieReelle == 0 && partieImaginaire == 0)
        {
            valeur = "0";
            return valeur;
        }
        if(partieReelle != 0)
        {
            valeur += formatter.format(partieReelle);
            if(partieImaginaire != 0)
            {
                if (partieImaginaire > 0)
                    valeur += " +";
                if (partieImaginaire < 0)
                    valeur += " -";
                if(abs(partieImaginaire) != 1)
                    valeur += formatter.format(abs(partieImaginaire));
                valeur += "i";
            }
        }
        else if(partieImaginaire != 0)
        {
            if(abs(partieImaginaire) != 1)
                valeur += formatter.format(partieImaginaire);
            else if (partieImaginaire < 0)
                valeur += "-";
            valeur += "i";
        }
        return valeur;
    }

    /**
     * \brief    Fonction formeExponentielle
     * \details  Cette fonction permet de définir comment va être affiché notre objet,
     *           si on veut sa forme exponentielle.
     *           Cette forme exponentielle est représentée dans un \e String
     * \return   \e String, le string correspondant à notre objet en forme exponentielle
     */
    public String formeExponentielle()
    {
        String valeur = "";
        NumberFormat formatter = new DecimalFormat("##.###"); //permet d'éviter les virgules non nécessaires
        if(partieReelle == 0 && partieImaginaire == 0)
        {
            valeur = "0";
            return valeur;
        }
        if(module() == 1) //module unitaire
        {
            if(partieImaginaire == 0) //1
            {
                valeur = "1";
            }
            else //nombre complexe du cercle trigonométrique
            {
                valeur += "e^(" + formatter.format(argument()) + "i)";
            }
        }
        else //module non unitaire
        {
            valeur = formatter.format(module());
            if(partieImaginaire != 0) //nombre complexe différent de 1
            {
                valeur += "*e^(" + formatter.format(argument()) + "i)";
            }
        }
        return valeur;
    }
}