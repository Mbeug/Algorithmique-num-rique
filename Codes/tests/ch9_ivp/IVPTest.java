package ch9_ivp;

import aux.DFunction;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class IVPTest {

    @Test
    void casSynthese(){
        DFunction df = (x, f_i) -> x*Math.sqrt(1+f_i*f_i);
        IVP ivp = new IVP(0.01, df);
        assertTrue(Math.abs(euler(0.0,0.01) - ivp.fowardEuler(0,0))<0.001);
    }
    double euler(double y0, double h){
        double x,y=y0;
        for (int i = 0; i < 100; i++) {
            x = i*h;
            y+= h*df(x,y);
        }
        return y;
    }

    private double df(double x, double y) {
        return x*Math.sqrt(1+y*y);
    }

    @Test
    void exo2(){
        DFunction df = (x,f_i) -> x+Math.sqrt(f_i);
        IVP ivp = new IVP(0.0000005, df);
        assertEquals(10.6446,ivp.fowardEuler(1,2));
        //assertTrue(Math.abs(10.6446-ivp.fowardEuler(3,2))<0.001);
    }
}