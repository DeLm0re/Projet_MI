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

    public NombreComplexe(double partieReelle, double partieImaginaire)
    {
        this(partieReelle, partieImaginaire, 1e-10);
    }

    public NombreComplexe()
    {
        this(0,0);
    }

    public double getPartieReelle() {
        return partieReelle;
    }

    public void setPartieReelle(double partieReelle) {
        this.partieReelle=(abs(partieReelle)>margeErreur)?partieReelle:0;
    }

    public double getPartieImaginaire() {
        return partieImaginaire;
    }

    public void setPartieImaginaire(double partieImaginaire) {
        this.partieImaginaire=(abs(partieImaginaire)>margeErreur)?partieImaginaire:0;
    }

    public void setNombreComplexe(NombreComplexe z)
    {
        setPartieReelle(z.getPartieReelle());
        setPartieImaginaire(z.getPartieImaginaire());
    }

    public NombreComplexe conjugue()
    {
        NombreComplexe zs = new NombreComplexe(partieReelle,-partieImaginaire);
        return zs;
    }

    public double module()
    {
        return sqrt(partieReelle*partieReelle + partieImaginaire*partieImaginaire);
    }

    public double argument()
    {
        if(partieReelle == 0 && partieImaginaire == 0)
            throw new IllegalArgumentException("0 ne peut pas avoir d'argument.");
        if(partieReelle<0 && partieImaginaire==0)
            return PI; //l'argument d'un nombre réel négatif est toujours pi. Gérer ce cas séparément permet d'éviter une division par zéro.
        else
            return 2*atan(partieImaginaire/(partieReelle + module()));
    }

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