package ch3;


import ch2_matrix.Matrix;
import ch2_matrix.SimpleMatrix;
import ch2_matrix.Vector;
import ch3_eq_lin.GaussSeidel;
import org.junit.jupiter.api.Test;

public class GaussSeidelTest {
    
    @Test
    void usualCase(){
        double[][] input ={{1,1,-2},{0,1,-1},{3,-1,1}};
        Matrix matrice = new SimpleMatrix(input);
        double[] bs = {-3,-1,4};
        GaussSeidel gs = new GaussSeidel();
        Vector res = gs.process(matrice,bs);
        affiche(res);
    }

    private void affiche(Vector res) {
        for (int i = 0; i < res.getLength(); i++) {
            System.out.println(res.get(i));
        }
    }
}
