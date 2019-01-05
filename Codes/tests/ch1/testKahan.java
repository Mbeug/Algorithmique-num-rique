package ch1;

import ch1_numb.Kahan;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class testKahan {
    Kahan kahan = new Kahan();
    @Test
    void usualCase(){
        double [] input = new double [10];
        double sum=0;
        for (int i = 0; i < input.length; i++) {
            //input[i] = Math.random()*10;
            input[i] = 0.1;
        }
        for (double d : input) {
            sum+=d;
        }

        double res=kahan.sum(input);
        assertFalse(res==sum);// car erreur d'approximation avec la somme basique represente ici par la variable sum
        assertEquals(1.0,res
        );
    }
}
