package ch3_eq_lin;


import ch2_matrix.*;

public class GaussSeidel {
    private final static double epsilon = 0.001;
    private final static double omega = 1.75;
    public Vector process(Matrix matrice, double[] bs) {
        Vector prec = new Vector(matrice.getWidth());

        return iterate(matrice, bs, prec,0);
    }

    private Vector iterate(Matrix a, double[] bs, Vector prec, int max_it) {
        Vector xK = new Vector(a.getWidth(),0);
        for (int i = 0; i < xK.getLength(); i++) {
            double sum1 = 0;
            for (int j = 0; j <i-1; j++) {
                if (i!=j)
                    sum1 += a.get(i, j) * xK.get(j);
            }
            double sum2 = 0;
            for (int j = i+1; j < xK.getLength() ; j++) {
                if (i!=j)
                    sum2 += a.get(i,j)* prec.get(j);
            }
            double ici = (1/ a.get(i, i))*(bs[i]-sum1-sum2);
            System.out.println(ici);
            xK.set(ici, i);
        }
        System.out.println(max_it);
        if ((difference(xK,prec)) || (max_it == 20) )
            return xK;
        max_it ++;
        return iterate(a, bs, xK, max_it);
    }

    private boolean diff(Vector res, Vector prec) {
        double sumRes = 0;
        double sumPrec= 0;
        for (int i = 0; i < res.getLength(); i++) {
            sumRes += res.get(i);
            sumPrec+= prec.get(i);
        }
        return Math.abs(sumRes-sumPrec)<=epsilon;
    }
    private boolean difference(final Vector v1, final Vector v2) {
        double s=0.0;
        for(int i=0;i<v1.getLength();i++) {
            double d=v1.get(i)-v2.get(i);
            s=s+d*d;
        }
        return Math.sqrt(s)< epsilon;
    }

}
