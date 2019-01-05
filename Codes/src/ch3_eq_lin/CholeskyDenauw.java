package ch3_eq_lin;


/**
 * Implementation of a Cholesky Factorization in Java.
 *
 * @author Antoine Denauw.
 * @date january 2018.
 */
public class CholeskyDenauw {

    /**
     * Apply the Cholesky method to the matrix.
     *
     * @param c the initial matrix.
     * @param l the matrix c after the Cholesky method.
     * @return the matrix l with Cholesky applied.
     */
    private static int[][] cholesky(int[][] c, int[][] l) {
        for (int i = 0; i < c.length; i++) {
            for (int j = 0; j < c[0].length; j++) {
                if (i < j) l[i][j] = 0;
                else if (i > j) {
                    int sum = 0;
                    for (int k = 0; k <= j-1; k++) {
                        sum += l[i][k] * l[j][k];
                    }
                    int temp = c[i][j] - sum;
                    double div = (1.0/l[j][j]);
                    l[i][j] = (int)(div * temp);
                }
                else if (i == j) {
                    int sum = 0;
                    for (int k = 0; k <= i-1; k++) {
                        sum += Math.pow(l[i][k], 2);
                    }
                    l[i][j] = (int)Math.sqrt(c[i][j] - sum);
                }
            }
        }
        return l;
    }

    /**
     * Print a matrix.
     * @param mat the matrix to print.
     */
    private static void printMatrix(int[][] mat) {
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat.length; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        /*int[][] c = {{25, 15, -5}, Should print : 5 0 0
                     {15, 18, 0},                   3 3 0
                     {-5, 0, 11}};                 -1 1 3
        */
        int[][] c = {{4, 12, -16},      //Should print : 2 0 0
                     {12, 37, -43},     //               6 1 0
                     {-16, -43, 98}};   //              -8 5 3

        int[][] l = new int[c.length][c[0].length];
        System.out.println("The initial matrix : ");
        printMatrix(c);
        l = cholesky(c, l);
        System.out.println();
        System.out.println("The Cholesky matrix : ");
        printMatrix(l);
    }
}
