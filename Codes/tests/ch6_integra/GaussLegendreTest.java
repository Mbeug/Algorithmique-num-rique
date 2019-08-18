package ch6_integra;

import aux.Function;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GaussLegendreTest {

    @Test
    void usualCase(){
        Function f = new Function() {
            @Override
            public double eval(double x) {
                return Math.exp(-x*x/2);
            }
        };
        GaussLegendre gl = new GaussLegendre(f);
        int a = 1;
        int b = 2;
        double t ;
        System.out.println("Méthode gauss-legendre");
        System.out.println("\nRang k \t\tValeur calculée");
        for (int k = 0; k < 5 ; k++) {
            t = gl.gaussLegendre(a,b,k);
            System.out.println(""+k+"\t\t"+t);
        }
    }
}