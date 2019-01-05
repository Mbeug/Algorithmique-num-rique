package ch4_interpol;

import aux.Coordinates;
import ch3_eq_lin.EliminationGaussLegendre;

public class Newton {
	private double vectorC[];
	private double X[];
    public void doPreparations(Coordinates[] controlPoints) {
		int n = controlPoints.length;
		X = new double [n];
        double Y[] = new double[n];
		
		for(int i = 0; i<n ; i++){
        	X[i] = controlPoints[i].getX();
        	Y[i] = controlPoints[i].getY();
        }
		double A[][] = new double[n][n];
		for (int i = 0; i<n ;i++){
			for (int j = i;j<n;j++){
					A[j][i]=computePsy(j,X,X[j]);
			}
		}
		vectorC = EliminationGaussLegendre.solve(A, Y);
	}

	private double computePsy(int i, double[] vectorX, double x) {
		double psy =1;
		if(i==0){
			return psy;
		}
		for(int j =0;j<i;j++){
			psy *= x-vectorX[j];
		}
		return psy;
	}
	//y=c1+psy1 *c2 + psy2*c3
	public double calculateY(double x) {
		double y =0;
		for (int i =0 ; i< vectorC.length;i++){
			y+= vectorC[i]*computePsy(i,X,x);
		}
		return y;
	}
}
