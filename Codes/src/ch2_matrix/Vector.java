package ch2_matrix;

import java.util.EmptyStackException;

import static java.lang.Math.sqrt;

public class Vector {
    int m;
    double[] data;

    public Vector(int m) {
        this.m = m;
        this.data = new double[m];
    }

    public Vector(int m, double[] vals) {
        this(m);
        data = vals;
    }

    public Vector(double[] vals) {
        this(vals.length, vals);
    }


    public Double get(int i) {
        if (i<0 ) return 0.;
        return data[i];
    }

    public void set(Double value, int i) {
        data[i] = value;
    }

    public int getLength() { return this.m;}

    public double getMax() throws EmptyStackException{
        if(m>0){
            double max=0.0001;
            for (double d :
                    data) {
                if (max< d) max =d;
            }
            return max;
        }
        throw new EmptyStackException();
    }
    public double getNorm1(){
        double sum = 0;
        for (int i = 0; i < m ; i++) {
            sum += Math.abs(data[i]);
        }
        return sum;
    }

    public double getNorme2(){
        double maxElem =  getMax();
        double squaredSum = 0;
        for (int i = 0; i < m; i++) {
            double scaledElem = data[i]/maxElem;
            squaredSum += scaledElem * scaledElem;
        }
        return sqrt(squaredSum) * maxElem;
    }

    public double getNormInfinite(){
        if(m>0){
            double max= Double.MIN_VALUE;
            for (double d :
                    data) {
                if (max< d) max = Math.abs(d);
            }
            return max;
        }
        throw new EmptyStackException();
    }
}
