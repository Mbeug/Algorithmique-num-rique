package ch9_ivp;

class RungeKutta {

	private  double maxValue;
	private  double h;
	
	RungeKutta(double h, double maxValue){
		this.h=h;
		this.maxValue= maxValue;
	}
	double rungeKuttaMethod(double x, double f){
		double f_i = f;
		double x_i = x;
		for(double i =0 ; i<maxValue;i++){
			double k_1=dFunction(x_i,f_i);
			double k_2=dFunction(x_i+(h/2),f_i+(h/2)*k_1);
			double k_3=dFunction(x_i+(h/2),f_i+(h/2)*k_2);
			double k_4=dFunction(x_i+h,f_i+h*k_3);
			f_i += (h/6)*(k_1+2*k_2+2*k_3+k_4);
			x_i+=h;
		}
		return f_i;
	}
	private double dFunction(double x, double f) {
		return x+Math.sqrt(f);
	}

}
