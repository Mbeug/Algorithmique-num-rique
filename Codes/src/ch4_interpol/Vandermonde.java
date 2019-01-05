package ch4_interpol;


import aux.Coordinates;
import ch3_eq_lin.EliminationGaussLegendre;

public class Vandermonde {
	 // The coefficients of the polynomial y = a_0 + a_1*x + a_3*x^2 + ...
    // Note that we start with a_0 (not a_1 like in the course) because
    // Java arrays start with index 0.
    private double[] vectorA;

    // This method is called whenever a control point is changed or deleted or added.
    // Here is a good place to do calculations that you need to do only once.
    public void doPreparations(Coordinates[] controlPoints) {
        // Construct and solve the linear system X*A=Y (where X is the Vandermonde matrix).
        // The degree of the polynomial is the number of control points minus 1.
        
        // n = the number of points
        int n = controlPoints.length;
        int vectorX[] = new int [n];
        double Y[] = new double[n];
        //initialization of vectors
        for(int i = 0; i<n ; i++){
        	vectorX[i] = controlPoints[i].getX();
        	Y[i] = controlPoints[i].getY();
        }
        double [][]X = new double [n][n];
        
        //initialization of Matrix X
        for(int i=0 ; i<n ; i++){
        	for(int j =0 ; j<n ; j++){
        		X[i][j]= Math.pow(vectorX[i], j);
        	}
        }
        
        //compute
        vectorA= EliminationGaussLegendre.solve(X,Y);
    }

    // This method calculates y=a0+a1*x+a2*x^2+...
    public double calculateY(double x) {
    	double y=0;
        for(int i = 0; i<vectorA.length;i++){
        	y += vectorA[i]*Math.pow(x, i);
        }
        
        return y;
    }  
}
