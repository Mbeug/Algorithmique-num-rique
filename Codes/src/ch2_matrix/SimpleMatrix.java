package ch2_matrix;


public class SimpleMatrix implements Matrix<Double> {
    int m, n;    
    double[][] data;

    public SimpleMatrix(int m, int n) {
        this.m = m;
        this.n = n;
        this.data = new double[m][n];
    }
    
    public SimpleMatrix(int m, int n, double[][] vals) {
        this(m, n);
        data = vals;
    }
    
    public SimpleMatrix(double[][] vals) {
        this(vals.length, vals[0].length, vals);
    }
    
    public SimpleMatrix(String latex) {
        double[][] vals = Utilities.fromLatexToArray(latex);
        this.m = vals.length;
        this.n = vals[0].length;
        this.data = vals;
    }
    
    public double get(int i, int j) {
        if (i<0 || j<0) return 0.;
        return data[i][j];
    }
    
    public void set(Double value, int i, int j) {
        if (i >= m )    throw new IllegalArgumentException("i value is "+i+" must be lower than "+this.m);
        if (i < 0)      throw new IllegalArgumentException("i value is negative");
        if (j >= n)     throw new IllegalArgumentException("j value is "+j+" must be lower than "+this.n);
        if (j < 0)      throw new IllegalArgumentException("j value is negatice");
        data[i][j] = value;
    }
    
    public int getWidth() { return this.n; }
    public int getHeight() { return this.m; }

}