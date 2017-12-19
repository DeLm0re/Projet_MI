package isen.projet.code;

public final class OperationComplexe
{
    private OperationComplexe(){}

    public static NombreComplexe inverse(NombreComplexe z)
    {
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

    public static NombreComplexe soustraire(NombreComplexe z1, NombreComplexe z2)
    {
        NombreComplexe zs = new NombreComplexe();
        zs.setPartieReelle(z1.getPartieReelle()-z2.getPartieReelle());
        zs.setPartieImaginaire(z1.getPartieImaginaire()-z2.getPartieImaginaire());
        return zs;
    }

    public static NombreComplexe multiplier(NombreComplexe z1, NombreComplexe z2)
    {
        NombreComplexe zs = new NombreComplexe();
        zs.setPartieReelle(z1.getPartieReelle()*z2.getPartieReelle()-z1.getPartieImaginaire()*z2.getPartieImaginaire());
        zs.setPartieImaginaire(z1.getPartieReelle()*z2.getPartieImaginaire()+z1.getPartieImaginaire()*z2.getPartieReelle());
        return zs;
    }

    public static NombreComplexe diviser(NombreComplexe z1, NombreComplexe z2)
    {
        return multiplier(z1,inverse(z2));
    }
}
