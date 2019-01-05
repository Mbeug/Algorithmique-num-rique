package ch5_splines;

import aux.Coordinates;

import java.awt.Color;
import java.awt.Graphics;
import java.util.List;


public class BSpline {
	private Coordinates[] controlPoints;
    private int n;
    private final static int m=3;  // the degree of the B-spline
    
    public void controlPointsChanged(List<Coordinates> cp) {
        controlPoints=cp.toArray(new Coordinates[0]);
        n=controlPoints.length;
    }
    
    public void paint(Graphics g) {
        // draw lines between the control points (so the user can see the order of the points)
        g.setColor(Color.lightGray) ;
        for(int i=0;i<n;i++) {
            if(i!=0) {
                Coordinates c1=controlPoints[i-1];
                Coordinates c2=controlPoints[i];
                g.drawLine(c1.getX(),c1.getY(),c2.getX(),c2.getY());
            }
        }
        
        // now, draw the curve
        
        g.setColor(Color.black) ;
        
        int previousX=0,previousY=0;
        for(double t=0.0;t<=n-m;t+=0.01) {
        	// Calculate x and y
        	double x, y;
        	x=0;
        	y=0;
        	for(int i=0;i<n;i++) {
                double b=b(i,m,t);
                x+=controlPoints[i].getX()*b;
                y+=controlPoints[i].getY()*b;
            }
            // draw a line between this (x,y) and the previous (x,y)
            if(t>0.0) {
                g.drawLine(previousX,previousY,(int)x,(int)y);
            }
            previousX=(int)x;
            previousY=(int)y;
        }
    }
    
    private int t(int i) {
    	if(i<=m) {
            return 0;
        }
        else if(i>=n) {
            return n-m;
        }
        else {
            return i-m;
        }
    }
    
    private double b(int i,int k,double t) {       
    	if(k==0) return t>=t(i) && t<t(i+1) ? 1.0 : 0.0 ;
        else {
            double t1,t2;
            
            if(t(i+k)==t(i)) 	t1=0.0;
            else 				t1=(t-t(i))/(t(i+k)-t(i)); 
            
            if(t(i+k+1)==t(i+1))t2=0.0;
            else 				t2=(t(i+k+1)-t)/(t(i+k+1)-t(i+1));

            return t1*b(i,k-1,t) + t2*b(i+1,k-1,t);
        }
    }
}
