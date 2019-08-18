package ch9_ivp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RungeKuttaTest {

    @Test
    void exo(){
        double h = 0.000005;
        double maxValue = 2/h;
        RungeKutta rk = new RungeKutta(h,maxValue);
        System.out.println(rk.rungeKuttaMethod(1,2));
    }

}