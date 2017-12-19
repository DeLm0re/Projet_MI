package isen.projet.code;

import java.text.DecimalFormat;
import java.text.NumberFormat;

import static java.lang.Math.*;

public class NombreComplexe
{
    private double partieReelle;
    private double partieImaginaire;

    public NombreComplexe(double partieReelle, double partieImaginaire)
    {
        this.partieReelle=partieReelle;
        this.partieImaginaire=partieImaginaire;
    }

    public NombreComplexe()
    {
        this.partieReelle=0;
        this.partieImaginaire=0;
    }

    public double getPartieReelle() {
        return partieReelle;
    }

    public void setPartieReelle(double partieReelle) {
        this.partieReelle = partieReelle;
    }

    public double getPartieImaginaire() {
        return partieImaginaire;
    }

    public void setPartieImaginaire(double partieImaginaire) {
        this.partieImaginaire = partieImaginaire;
    }

    public void setNombreComplexe(NombreComplexe z)
    {
        this.partieReelle = z.getPartieReelle();
        this.partieImaginaire = z.getPartieImaginaire();
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
            throw new ArithmeticException(); //0 n'a pas d'argument!
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
        }
        if(partieImaginaire != 0)
        {
            if(partieImaginaire > 0)
                valeur += " + ";
            if(partieImaginaire < 0)
                valeur += " - ";
            if(abs(partieImaginaire) != 1)
                valeur += formatter.format(abs(partieImaginaire));
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
        valeur += formatter.format(module());
        if(partieImaginaire != 0)
            valeur += ("*e^(i*"+formatter.format(argument())+")");
        return valeur;
    }
}