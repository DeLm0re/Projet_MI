package isen.projet.code;


public class Fourier
{
    private int taille;
    private Data donnee;

    private float Lreel[];
    private NombreComplexe Lcomplexe[];

    Fourier(int taille)
    {
        setTaille(taille);
    }

    public NombreComplexe[] FFTr(int signal)
    {
        return null;
    }

    private void recursiveFFTr(float Lreel[])
    {

    }

    public int getTaille() {
        return taille;
    }

    public void setTaille(int taille) {
        this.taille = taille;
    }

}
