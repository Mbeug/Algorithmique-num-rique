package ch1_numb;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

public class ValFunction {
    private  String filename = "gnuplot_input.txt";

    public ValFunction(){}
    public ValFunction(String filename){
        this.filename = filename;
    }

    private double function(double x){
        return (Math.exp(x)-1.0)/x-1.0;
    }

    private void computeFunction(){
        double min = -(Math.pow(10,-8));
        double max = Math.pow(10,-8);
        double range = Math.pow(10,-11);

        try{
            PrintStream ps = new PrintStream(new File(filename));
            for (double i = min; i < max; i=i+range) {
                ps.print(i);
                ps.print(" ");
                ps.print(function(i));
                ps.println();
            }
            ps.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String [] args){
        ValFunction vf = new ValFunction();
        vf.computeFunction();
    }

}

