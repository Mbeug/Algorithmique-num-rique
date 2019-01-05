package ch9_ivp;

public class IVP {
	private static double maxValue;
	private double h;
	
	public IVP(double h){
		this.h=h;
	}
	
	public void fowardEuler(double x , double f,int cas){
		double f_i = f;
		double x_i = x;
		for(double i =0 ; i<maxValue;i++){
			System.out.println(f_i);
			f_i += h*dFuntion(x_i,f_i,cas);
			x_i+=h;
		}
		
	}
	
	public void backwardEuler(double x,double f,int cas){
		//TODO
	}
	private double dFuntion(double x, double f,int cas) {
		switch(cas){
		case 1: //pour exo 1
			return 1+(x-f)*(x-f);
		case 2://pour exo 2
			return x+Math.sqrt(f);
		default:
			return 0;
		}
		
	}
	
}
