package ch1_numb;

public class Kahan {

    public double sum(double [] input){
        double sum = 0.0;
        double c = 0.0;                 // A running compensation for lost low-order bits.
        for (double anInput : input) {
            double y = anInput - c;    // So far, so good: c is zero.
            double t = sum + y;         // Alas, sum is big, y small, so low-order digits of y are lost.
            c = (t - sum) - y;          // (t - sum) cancels the high-order part of y; subtracting y recovers negative (low part of y)
            sum = t;                     // Algebraically, c should always be zero. Beware overly-aggressive optimizing compilers!
        }                               // Next time around, the lost low part will be added to y in a fresh attempt.
        return sum;
    }
}
