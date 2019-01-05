package ch6_integra;

public class Riemann {

    private double [] functionValue;
    private double aera;
    public Riemann(double[] functionValue , double loBound, double upBound){
        this.functionValue = functionValue;
        aera=0;
        aera = intregral(loBound,upBound);
    }

    private double intregral(double loBound, double upBound) {
        double stepRange = (upBound-loBound)/functionValue.length;
        double sumArea=0;
        int j = 0;
        for (double i = loBound; i < upBound; i+=stepRange) {
            sumArea += stepRange*functionValue[j];
            j++;
        }
        return sumArea;
    }


    public double getAera() {
        return aera;
    }
}
