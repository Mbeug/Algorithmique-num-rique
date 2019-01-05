package ch7_eq_no_line;

import aux.Function;

public class Bissection {
    private double root;
    private double epsilonX;
    private double epsilonF;
    private double precision = 0.01;

    public Bissection(){
        epsilonF = 0.01;
        epsilonX = 0.01;
        root = compute(-11,20);
    }

    private double compute(double leftValue, double rightValue)throws ArithmeticException{

        while(Math.abs(leftValue - rightValue) >= precision){
            double c = (leftValue+rightValue)/2;
            System.out.println("c:"+c+" l:"+leftValue +" r:"+rightValue);
            if ((Math.abs(f(c))<epsilonF) || (Math.abs(rightValue-leftValue)<epsilonX))
                return c;
            else if (f(leftValue)*f(c)< 0)
                rightValue = c;
            else
                leftValue = c;
        }
        throw new ArithmeticException("No root found");

    }

    public double getRoot(){
        return root;
    }
    public double f(double x){
        return new Function().f2(x);
    }
}
