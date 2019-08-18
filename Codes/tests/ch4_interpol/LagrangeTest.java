package ch4_interpol;

import aux.Function;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LagrangeTest {
    @Test
    void usualCase(){
        Function y = new Function() {
            @Override
            public double eval(double x) {
                return (-5/48)*x*x+(29/6)*x-39;
            }
        };

        double [] U = {12,20,24};
        double [] T = {4,16,17};

    }

}