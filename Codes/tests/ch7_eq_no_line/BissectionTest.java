package ch7_eq_no_line;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BissectionTest {
    @Test
    void usual(){
        Bissection b = new Bissection();
        double res = Math.abs(b.getRoot()-5);
        System.out.println(b.getRoot());
        assertTrue(res < 0.05);

    }

}