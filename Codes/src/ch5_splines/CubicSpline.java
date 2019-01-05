package ch5_splines;

import java.awt.Color;
import java.awt.Graphics;
import java.util.List;

import aux.Coordinates;
import ch3_eq_lin.EliminationGaussLegendre;

public class CubicSpline {
	private Coordinates[] controlPoints;
    private int n;
    private double[] B; // the b_i coefficients of the spline
    private double[] C; // the c_i coefficients of the spline
    private double[] D; // the d_i coefficients of the spline

    public void controlPointsChanged(List<Coordinates> lcp) {
        // sort the control points by x position.
        // this makes things easier later when we paint the function.
        lcp.sort(
                (point1,point2) -> Integer.compare(point1.getX(),point2.getX())
        );

        // collect the points in an array before doing the calculations.
        // again, this makes things easier for us.
        controlPoints=lcp.toArray(new Coordinates[0]);
        n=controlPoints.length;
        if(n<2) {
            // nothing to do here
            return;
        }
        double []X = new double[n];
        double []Y = new double[n];
        for(int i =0;i<n;i++){
        	X[i]=controlPoints[i].getX();
        	Y[i]=controlPoints[i].getY();
        }
        // Construct the linear system S*C=T with n-2 equations.
        // The matrix S contains the left hand side of the equations on slide 13.
        // The matrix Z contains the right hand side of the equations on slide 13.
        double[][] S=new double[n-2][n-2];
        double[] Z=new double[n-2];
        
        // Fill the matrix S and the vector Z and solve S*C=T to get c_2 to c_{n-1}.
        for(int i = 0; i< n-3;i++){
        	S[i][i]=2*delta(X,i+1,0);
        	S[i+1][i]=delta(X,i+2,-1);
        	S[i][i+1]=delta(X,i+1,1);
        	Z[i]=z(Y,X,i);
        }
        S[n-2][n-2]=2*delta(X,n-1,0);
        
        C= EliminationGaussLegendre.solve(S, Z);
        
        // Calculate the n-1 coefficients b_i and d_i.
        // Note that you need all c_i here (but you know that c_1 and c_n are zero).
        //a_i = y_i;
        for(int i=1 ; i<n ; i++){
        	D[i-1]=d(Y,X,i-1);
        	B[i-1]=b(Y,C,X,i-1);
        }
        
    }
    private double delta(double []X,int i, int a){
    	if(a==-1){
    		return X[i]-X[i-1];
    	}
    	else if(a == 0){
    		return X[i+1]-X[i-1];
    	}
    	else if(a == 1){
    		return X[i+1]-X[i];
    	}
    	else{
    		return 0;
    	}
    }
    private double z(double []Y, double []X, int i){
    	return 3*(((Y[i+1]-Y[i])/(X[i+1]-X[i]))-((Y[i]-Y[i-1])/(X[i]-X[i-1])));
    }
    private double d(double []C, double []X,int i){
    	return C[i]-C[i-1]/3*(C[i]-X[i-1]);
    }
    private double b(double []Y, double []C, double[]X,int i){
    	double delta = X[i-1]-X[i];
    	return ((Y[i]-Y[i-1])/delta) - C[i-1]*delta - (delta/3)*(C[i]-C[i-1]);
    }
    
    public void paint(Graphics g) {
        g.setColor(Color.black) ;
        
        // Paint the n-1 polynomials
        for(int i=0;i<n-1;i++) {
            int x_i=controlPoints[i].getX();
            int x_iplus1=controlPoints[i+1].getX();
            double a_i=controlPoints[i].getY();
            
            int previousX=0,previousY=0;
            for(int x=x_i;x<x_iplus1;x++) {	
            	// Calculate y
            	double x1=(x-x_i);
                double x2=x1*(x-x_i);
                double x3=x2*(x-x_i);
                
                double y=a_i+B[i]*x1+C[i]*x2+D[i]*x3;
                
                // draw a line between this (x,y) and the previous (x,y)
                if(x!=x_i) {
                    g.drawLine(previousX,previousY,x,(int)y);
                }
                previousX=x;
                previousY=(int)y;
            }
        }
    }
}
