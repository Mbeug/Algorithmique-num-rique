package ch9_ivp;

import aux.DFunction;

public class IVP {
	private static final int MAXSTEPS =100;
	private double h;
	private DFunction df;
	
	IVP(double h, DFunction df){
		this.h=h;
		this.df = df;
	}
	
	double fowardEuler(double x, double initValue){
		double f_i = initValue;
		double x_i = x;
		for(int i =0 ; i < MAXSTEPS ;i++){
			f_i += h*df.eval(x_i,f_i);
			x_i+=h;
		}
		return f_i;
	}
	
	public void backwardEuler(double x,double f){
		//TODO
	}

	
}
