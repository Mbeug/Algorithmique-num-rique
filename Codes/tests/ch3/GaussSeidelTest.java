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
        gs.process(matrice,bs);
    }

    @Test
    void case2(){
        double[][] a={ {5,-1,2}, {3,8,-2}, {1,1,4} };
        double[] b={12,-25,6};
        GaussSeidel gs = new GaussSeidel();
        gs.process(new SimpleMatrix(a),b);
    }
    //0.9999784306640624  -2.9999822893066406  2.0000009646606447


}
