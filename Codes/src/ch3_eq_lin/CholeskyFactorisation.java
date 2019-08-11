package ch3_eq_lin;


import ch2_matrix.*;

public class CholeskyFactorisation {
	private static double sum(int i, int j, Matrix L) {
        double ret = 0;
        for (int k = 0; k < j; k++) {
            ret += L.get(i, k) * L.get(j, k);
        }
        return ret;
    }
    
    public Matrix getL(Matrix C) {
        SimpleMatrix L = new SimpleMatrix(C.getHeight(), C.getWidth());
        
        for (int j = 0; j < C.getWidth(); j++) {
            double diag = Math.sqrt(C.get(j, j) -sum(j, j, L));
            L.set(diag, j, j);
            
            for (int i = j+1; i < C.getHeight(); i++) {
                double val = (C.get(i, j) -sum(i, j, L))/diag;
                L.set(val, i, j);
            }
        }
        return L;
    }

    
}
