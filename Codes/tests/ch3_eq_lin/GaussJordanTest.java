package ch3_eq_lin;

import ch3_eq_lin.GaussJordan;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GaussJordanTest {
    @Test
    void usualTest(){
        GaussJordan gj = new GaussJordan();
        double [][] mtx = {{1,1,-2},{0,1,-1},{3,-1,1}};
        double [] vector={-3,-1,4};
        System.out.println("matrice de départ:");
        affiche(mtx);
        System.out.println("vecteur:");
        affiche(vector);
        double [][] result=gj.fowardSubstitution(mtx,vector);
        System.out.println("matrice résultat:");
        affiche(result);
        System.out.println("vecteur:");
        affiche(vector);
        System.out.println("result:");
        double [] res = gj.backwardSubstitution(mtx,vector);
        affiche(res);
        double [] expected = {1,2,3};
        assertEquals(expected.length, res.length);
    }

    private static void affiche(double[] vector){
        for (double aVector : vector) {
            System.out.println(aVector);
        }
    }
    private static void affiche(double[][] mtx){
        for (double[] aMtx : mtx) {
            for (int j = 0; j < mtx[0].length; j++) {
                System.out.print(aMtx[j] + " ");
            }
            System.out.println("");
        }
    }
}
