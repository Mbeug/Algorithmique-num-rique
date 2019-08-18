package ch6_integra;


import aux.Function;

/**
 * @author Francois Duchene
 */
public class GaussLegendre {

    private  Function f;
    GaussLegendre(Function f){
        this.f = f;
    }

    private double polLeg(int k, double x){
        double p=1;
        double p1=0;
        double p2;
        for (int i = 1; i <= k; i++) {
            p2 = p1;
            p1 = p;
            p = ((2*i-1)*x*p1-(i-1)*p2)/i;
        }
        return p;
    }
    public double gaussLegendre( double a, double b, int k){
        double h,r,alpha,pol,s,t;
        double [] racine = new double[5];
        switch (k){
            case 0:
                racine[0]= 0.0;
                break;
            case 1:
                racine[0] = 1/Math.sqrt(3);
                racine[1] -= racine[0];
                break;
            case 2:
                racine[0] = Math.sqrt(3/5);
                racine[1] =0;
                racine[2] -= racine[0];
                break;
            case 3:
                racine[0] = Math.sqrt((15+2*Math.sqrt(30))/35);
                racine[1] = Math.sqrt((15-2*Math.sqrt(30))/35);
                racine[2] -= racine[1];
                racine[3] -= racine[0];
                break;
            case 4:
                racine[0] = Math.sqrt((35+2*Math.sqrt(70))/63);
                racine[1] = Math.sqrt((35-2*Math.sqrt(70))/63);
                racine[2] = 0.0;
                racine[3] -= racine[1];
                racine[4] -= racine[0];
                break;
        }
        h = b-a;
        t = 0;
        s = 0.0;
        for (int j = 1; j <=k; j++) {
            r = racine[j];
            pol = polLeg(k,r);
            alpha = 2*(1-r*r)/((k+1)*(k+1)*pol*pol);
            s+= alpha*f.eval(h/2*(1+r)+a);
        }
        t += h/2*s;
        return t;
    }
}
