package isen.projet.code;

import java.text.DecimalFormat;
import java.text.NumberFormat;

import static java.lang.Math.*;

public class NombreComplexe
{
    private double partieReelle;
    private double partieImaginaire;

    NombreComplexe(double partieReelle, double partieImaginaire)
    {
        this.partieReelle=partieReelle;
        this.partieImaginaire=partieImaginaire;
    }

    NombreComplexe()
    {
        this.partieReelle=0;
        this.partieImaginaire=0;
    }

    public double getPartieReelle() {
        return partieReelle;
    }

    public void setpartieReelle(double partieReelle) {
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
        if(partieReelle<0 && partieImaginaire==0)
            return PI;
        else
            return 2*atan(partieImaginaire/(partieReelle + module()));
    }

    public String toString()
    {
        return null;
    }

    public String formeExponentielle()
    {
        return null;
    }
}