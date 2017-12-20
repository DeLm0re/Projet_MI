package isen.projet.code;

import static java.lang.Math.*;

public final class OperationComplexe
{
    private OperationComplexe(){}

    public static NombreComplexe inverse(NombreComplexe z)
    {
        if(z.getPartieReelle() == 0 && z.getPartieImaginaire() == 0)
            throw new IllegalArgumentException("0 ne peut pas avoir d'inverse."); //Impossible de calculer l'inverse de 0
        NombreComplexe zs = new NombreComplexe();
        zs.setPartieReelle(z.getPartieReelle()/(z.getPartieReelle()*z.getPartieReelle() + z.getPartieImaginaire()*z.getPartieImaginaire()));
        zs.setPartieImaginaire(-z.getPartieImaginaire()/(z.getPartieReelle()*z.getPartieReelle() + z.getPartieImaginaire()*z.getPartieImaginaire()));
        return zs;
    }

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

    public static NombreComplexe soustraire(NombreComplexe z1, NombreComplexe z2)
    {
        NombreComplexe zs = new NombreComplexe();
        zs.setPartieReelle(z1.getPartieReelle()-z2.getPartieReelle());
        zs.setPartieImaginaire(z1.getPartieImaginaire()-z2.getPartieImaginaire());
        return zs;
    }

    public static NombreComplexe soustraire(NombreComplexe z, double x)
    {
        NombreComplexe zs = new NombreComplexe();
        zs.setPartieReelle(z.getPartieReelle()-x);
        zs.setPartieImaginaire(z.getPartieImaginaire());
        return zs;
    }

    public static NombreComplexe soustraire(double x, NombreComplexe z)
    {
        NombreComplexe zs = new NombreComplexe();
        zs.setPartieReelle(x-z.getPartieReelle());
        zs.setPartieImaginaire(-z.getPartieImaginaire());
        return zs;
    }

    public static NombreComplexe multiplier(NombreComplexe z1, NombreComplexe z2)
    {
        NombreComplexe zs = new NombreComplexe();
        zs.setPartieReelle(z1.getPartieReelle()*z2.getPartieReelle()-z1.getPartieImaginaire()*z2.getPartieImaginaire());
        zs.setPartieImaginaire(z1.getPartieReelle()*z2.getPartieImaginaire()+z1.getPartieImaginaire()*z2.getPartieReelle());
        return zs;
    }

    public static NombreComplexe multiplier(NombreComplexe z, double x)
    {
        NombreComplexe zs = new NombreComplexe();
        zs.setPartieReelle(x*z.getPartieReelle());
        zs.setPartieImaginaire(x*z.getPartieImaginaire());
        return zs;
    }

    public static NombreComplexe diviser(NombreComplexe z1, NombreComplexe z2)
    {
        return multiplier(z1,inverse(z2));
    }

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

    public static NombreComplexe puissance(NombreComplexe z, double x)
    {
        if(z.getPartieReelle() == 0 && z.getPartieImaginaire() == 0) //on gère le cas z1 = 0 séparément, car 0 n'a pas d'argument
        {
            return new NombreComplexe((x!=0)?0:1,0); //0^x = 0 si x!=0 et 0^0 = 1
        }
        return expoVersAlgebrique(pow(z.module(),x),z.argument()*x);
    }
}
