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

    }

    NombreComplexe()
    {

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
        return null;
    }

    public double module()
    {
        return 0;
    }

    public double argument()
    {
        return 0;
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