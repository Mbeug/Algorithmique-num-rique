package ch6_integra;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NewtonCoteTest {
    private int N = 10000000;
    NewtonCote nc = new NewtonCote(0,10,N);
    @Test
    void usual2(){

        double flag = Math.abs((nc.getRes2())-(1150/3));
        System.out.println(nc.getRes2());
        assertTrue(flag < 0.5);
    }
    @Test
    void usual3(){
        double flag = Math.abs((nc.getRes3())-(1150/3));
        System.out.println(nc.getRes3());
        assertTrue(flag<0.5);
    }

    private double[] function(double lo, double hi,int N) {
        double[] res = new double[N];
        double step = (hi-lo)/res.length;
        for (int i = 0; i < res.length; i++) {
            res[i]= function(lo+(i*step));
        }
        return res;
    }

    // x^2 + 5
    private double function(double x){

        return x*x +5;
    }
}