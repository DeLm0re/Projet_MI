/**
 * \file      OperationComplexe.java
 * \author    Romain Jacquiez, Théo HIPAULT et Antoine BERENGUER
 * \version   1.0
 * \date      19 décembre 2017
 * \brief     La classe \e final OperationComplexe
 * \details   Cette classe permet de définir les opérations sur les nombres complexes.
 *            Effectivement, les nombres complexes n'étant pas gérés en Java, cette classe
 *            permet de définir une implémentation des fonctions de bases de calculs que l'on
 *            peut effectuer sur les nombres complexes, définies dans la classe NombreComplexe.
 *            Ces opérations sont :
 *            - addition()
 *            - soustraction()
 *            - etc
 */
package isen.projet.code;

import static java.lang.Math.PI;
import static java.lang.Math.cos;
import static java.lang.Math.sin;

public final class OperationComplexe
{
    private OperationComplexe(){}

    /**
     * \brief    Fonction inverse
     * \details  Cette fonction permet de calculer l'inverse d'un nombre complexe
     *           passé en paramètre.
     * \param    z         Notre nombre complexe, dont on veut savoir son inverse
     * \return   \e NombreComplexe zs, il s'agit de l'inverse de notre nombre complexe z, passé en paramètre
     */
    public static NombreComplexe inverse(NombreComplexe z)
    {
        if(z.getPartieReelle() == 0 && z.getPartieImaginaire() == 0)
            throw new IllegalArgumentException("0 ne peut pas avoir d'inverse."); //Impossible de calculer l'inverse de 0
        NombreComplexe zs = new NombreComplexe();
        zs.setPartieReelle(z.getPartieReelle()/(z.getPartieReelle()*z.getPartieReelle() + z.getPartieImaginaire()*z.getPartieImaginaire()));
        zs.setPartieImaginaire(-z.getPartieImaginaire()/(z.getPartieReelle()*z.getPartieReelle() + z.getPartieImaginaire()*z.getPartieImaginaire()));
        return zs;
    }

    /**
     * \brief    Fonction additioner
     * \details  Cette fonction permet de calculer l'addition entre deux nombre complexes
     *           passés en paramètre.
     * \param    z1        Notre premier nombre complexe
     * \param    z2        Notre deuxième nombre complexe
     * \return   \e NombreComplexe zs, il s'agit de l'addition de nos deux nombre complexes passés en paramètre
     */
    public static NombreComplexe additionner(NombreComplexe z1, NombreComplexe z2)
    {
        NombreComplexe zs = new NombreComplexe();
        zs.setPartieReelle(z1.getPartieReelle()+z2.getPartieReelle());
        zs.setPartieImaginaire(z1.getPartieImaginaire()+z2.getPartieImaginaire());
        return zs;
    }

    public static NombreComplexe additionner(NombreComplexe z1, double x)
    {
        NombreComplexe zs = new NombreComplexe();
        zs.setPartieReelle(x+z1.getPartieReelle());
        zs.setPartieImaginaire(z1.getPartieImaginaire());
        return zs;
    }

    /**
     * \brief    Fonction soustraire
     * \details  Cette fonction permet de calculer la soustraction entre deux nombre complexes
     *           passés en paramètre.
     * \param    z1        Notre premier nombre complexe
     * \param    z2        Notre deuxième nombre complexe
     * \return   \e NombreComplexe zs, il s'agit de la soustraction de nos deux nombre complexes passés en paramètre
     */
    public static NombreComplexe soustraire(NombreComplexe z1, NombreComplexe z2)
    {
        NombreComplexe zs = new NombreComplexe();
        zs.setPartieReelle(z1.getPartieReelle()-z2.getPartieReelle());
        zs.setPartieImaginaire(z1.getPartieImaginaire()-z2.getPartieImaginaire());
        return zs;
    }

    public static NombreComplexe soustraire(NombreComplexe z1, double x)
    {
        NombreComplexe zs = new NombreComplexe();
        zs.setPartieReelle(z1.getPartieReelle()-x);
        zs.setPartieImaginaire(z1.getPartieImaginaire());
        return zs;
    }

    public static NombreComplexe soustraire(double x, NombreComplexe z1)
    {
        NombreComplexe zs = new NombreComplexe();
        zs.setPartieReelle(x-z1.getPartieReelle());
        zs.setPartieImaginaire(z1.getPartieImaginaire());
        return zs;
    }

    /**
     * \brief    Fonction multiplier
     * \details  Cette fonction permet de calculer la multiplication entre deux nombre complexes
     *           passés en paramètre.
     * \param    z1        Notre premier nombre complexe
     * \param    z2        Notre deuxième nombre complexe
     * \return   \e NombreComplexe zs, il s'agit de la multiplication de nos deux nombre complexes passés en paramètre
     */
    /*pour tester cette fonction:
     * z_1 = a_1 + ib_1
     * z_2 = a_2 + ib_2
     * il faut que:
     * z_1*z_2 = (a_1 + ib_1)(a_2 + ib_2) = (a_1*a_2 - b_1*b_2) + i(a_1*b_2 + b_1*a_2)
     */
    public static NombreComplexe multiplier(NombreComplexe z1, NombreComplexe z2)
    {
        NombreComplexe zs = new NombreComplexe();
        zs.setPartieReelle(z1.getPartieReelle()*z2.getPartieReelle()-z1.getPartieImaginaire()*z2.getPartieImaginaire());
        zs.setPartieImaginaire(z1.getPartieReelle()*z2.getPartieImaginaire()+z1.getPartieImaginaire()*z2.getPartieReelle());
        return zs;
    }

    public static NombreComplexe multiplier(NombreComplexe z1, double x)
    {
        NombreComplexe zs = new NombreComplexe();
        zs.setPartieReelle(x*z1.getPartieReelle());
        zs.setPartieImaginaire(x*z1.getPartieImaginaire());
        return zs;
    }

    /**
     * \brief    Fonction diviser
     * \details  Cette fonction permet de calculer la division entre deux nombre complexes
     *           passés en paramètre.
     * \param    z1        Notre premier nombre complexe
     * \param    z2        Notre deuxième nombre complexe
     * \return   \e NombreComplexe zs, il s'agit de la division de nos deux nombre complexes passés en paramètre
     */
    public static NombreComplexe diviser(NombreComplexe z1, NombreComplexe z2)
    {
        return multiplier(z1,inverse(z2));
    }

    /**
     * \brief    Fonction diviser
     * \details  Cette fonction permet de transformer un nombre complexe en forme exponentiel, en forme algebrique.
     *           La forme exponentiel est passée en paramètre grâce au module et à l'argument du nombre complexe.
     * \param    module     Le module du nombre complexe
     * \param    argument   L'argument du nombre complexe
     * \return   \e NombreComplexe zs, Un nombre complexe (sous forme algébrique, grâce à l'objet)
     */
    public static NombreComplexe expoVersAlgebrique(double module, double argument)
    {
        NombreComplexe zs = new NombreComplexe();
        if(module < 0)
            throw new IllegalArgumentException("Un module ne peut pas être négatif."); //un module ne peut pas être négatif
        argument = (argument+PI)%(2*PI)-PI; //on s'assure que l'argument reste entre -pi et pi
        zs.setPartieReelle(module*cos(argument));
        zs.setPartieImaginaire(module*sin(argument));
        return zs;
    }
}
