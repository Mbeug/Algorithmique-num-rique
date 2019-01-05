package ch6_integra;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RiemannTest {

    @Test
    void usual(){
        Riemann integral = new Riemann(function(0,10),0,10);
        assertEquals(1150/3,integral.getAera());
    }

    private double[] function(double lo, double hi) {
        double[] res = new double[100000001];
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