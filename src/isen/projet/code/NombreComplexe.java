package isen.projet.code;

import java.text.DecimalFormat;
import java.text.NumberFormat;

import static java.lang.Math.*;

public class NombreComplexe
{
    private double partieEntiere;
    private double partieImaginaire;

    NombreComplexe(double partieEntiere, double partieImaginaire)
    {
        this.partieEntiere=partieEntiere;
        this.partieImaginaire=partieImaginaire;
    }

    NombreComplexe()
    {
        this.partieEntiere=0;
        this.partieImaginaire=0;
    }

    public double getPartieEntiere() {
        return partieEntiere;
    }

    public void setPartieEntiere(double partieEntiere) {
        this.partieEntiere = partieEntiere;
    }

    public double getPartieImaginaire() {
        return partieImaginaire;
    }

    public void setPartieImaginaire(double partieImaginaire) {
        this.partieImaginaire = partieImaginaire;
    }

    public void setNombreComplexe(NombreComplexe z)
    {
        this.partieEntiere = z.getPartieEntiere();
        this.partieImaginaire = z.getPartieImaginaire();
    }

    public NombreComplexe conjugue()
    {
        NombreComplexe zs = new NombreComplexe(partieEntiere,-partieImaginaire);
        return zs;
    }

    public double module()
    {
        return sqrt(partieEntiere*partieEntiere + partieImaginaire*partieImaginaire);
    }

    public double argument()
    {
        if(partieEntiere<0 && partieImaginaire==0)
            return PI;
        else
            return 2*atan(partieImaginaire/(partieEntiere + module()));
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