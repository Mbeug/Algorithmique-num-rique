package ch1_numb;

public class OptimisationCompute {
	
	public double softmax(double[]x){
		double a = max(x,0.0001);
		double sum=0;
		for(int i =0; i<x.length;i++){
			sum+= Math.exp(x[i]-a);
		}
		return a+Math.log(sum);
	}

	private double max(double[] x, double max) {
		for(int i =0; i<x.length;i++){
			if(max<x[i]) max=x[i];
		}
		return max;
	}
	
	public double vectorNorm(double []x){
		double max = max(x,0.0001);
		double squaredSum=0;
		
		for(int i=0;i<x.length;i++){
			double scaledX = x[i]/max;
			squaredSum+=scaledX*scaledX;
		}
		return max*Math.sqrt(squaredSum);
	}
	
	public double kahanSum(double []input){
		double sum=0;
		double c=0;
		for(int i=0;i<input.length;i++){
			double y = input[i]-c;
			double t = sum+y;
			c=(t-sum)-y;
			sum=t;
		}
		return sum;
	}
}
