package ch6_integra;

import aux.Function;

public class NewtonCote {


    private double res3;
    private double res2;

    public NewtonCote(double lo , double hi, int N){

        res2 = integral2(lo,hi,N,2);
        res3 = integral3(lo,hi);
    }

    private double integral2(double lo, double hi, int N, int n) {
        double h = (hi-lo)/(N-1)*(n-1);
        double res = f(lo);
        for (double i = lo; i < hi; i+=h) {
            res+= n*f(i);
        }
        res += f(n);
        return res * h/n;

    }

    private double integral3(double lo, double hi) {
        return ((hi-lo)/6) * (f(lo)+4*f((lo+hi)/2)+f(hi));

    }
    private double f(double x) {
        Function fun = new Function();
        return fun.f1(x);
    }

    public double getRes3() {
        return res3;
    }

    public double getRes2() {
        return res2;
    }
}
