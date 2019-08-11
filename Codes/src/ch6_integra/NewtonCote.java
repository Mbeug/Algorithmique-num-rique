package ch6_integra;

import aux.Function;

public class NewtonCote {


    private double res3;
    private double res2;

    public NewtonCote(Function f, double lo , double hi, int N){
        res2 = integral2(f,lo,hi,N,2);
        res3 = integral3(f,lo,hi);
    }

    private double integral2(Function f,double lo, double hi, int N, int n) {
        double h = (hi-lo)/(N-1)*(n-1);
        double res = f.eval(lo);
        for (double i = lo; i < hi; i+=h) {
            res+= n*f.eval(i);
        }
        res += f.eval(n);
        return res * h/n;

    }

    private double integral3(Function f ,double lo, double hi) {
        return ((hi-lo)/6) * (f.eval(lo)+4*f.eval((lo+hi)/2)+f.eval(hi));

    }

    public double getRes3() {
        return res3;
    }

    public double getRes2() {
        return res2;
    }
}
