package ch4_interpol;

import aux.Coordinates;

public class Lagrange {
	private double X[];
	private double Y[];
	private int n;
    public void doPreparations(Coordinates[] controlPoints) {
		n = controlPoints.length;
		X = new double [n];
        Y = new double[n];
		
		for(int i = 0; i<n ; i++){
        	X[i] = controlPoints[i].getX();
        	Y[i] = controlPoints[i].getY();
        }
		//not need to use AX=Y
	}
    //phi= voir cours
	private double computePhi(int i, double[] vectorX, double x) {
		double psyNum = 1;
		double psyDen = 1;
		if(i==0) return psyNum;
		for(int j =0;j<n;j++){
			if (i!=j){
				psyNum *= x-vectorX[j];
				psyDen *= vectorX[i]-vectorX[j];
			}
		}
		return psyNum/psyDen;
	}
	//f(x)= phi1*y1+phi2*y2...
	public double f(double x) {
		double f =0;
		for (int i =0 ; i< Y.length;i++){
			f+= Y[i]*computePhi(i,X,x);
		}
		return f;
	}
}
