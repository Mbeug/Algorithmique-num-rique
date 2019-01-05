package ch3_eq_lin;


import ch2_matrix.*;

public class GaussSeidel {
    private final static double epsilon = 0.1;
    private final static double omega = 1.5;
    public Vector process(Matrix matrice, double[] bs) {
        Vector prec = new Vector(matrice.getWidth());

        return iterate(matrice, bs, prec);
    }

    private Vector iterate(Matrix matrice, double[] bs, Vector prec) {
        Vector res = new Vector(matrice.getWidth());
        for (int i = 0; i < res.getLength(); i++) {
            double sum1 = 0;
            for (int j = 0; j <i-1; j++) {
                //if (i!=j)
                    sum1 += matrice.get(i, j) * res.get(j);
            }
            double sum2 = 0;
            for (int j = i+1; j < res.getLength() ; j++) {
                //if (i!=j)
                    sum2 += matrice.get(i,j)* prec.get(j);
            }
            double ici = (1/ matrice.get(i, i))*(bs[i]-sum1-sum2);
            System.out.println(ici);
            res.set(ici, i);
        }

        if (diff(res,prec))
            return res;

        return iterate(matrice, bs, res);
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
}
