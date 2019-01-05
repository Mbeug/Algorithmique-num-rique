package ch3_eq_lin;

public class GaussJordan {
    /*
     * @post : return the index of the line where the biggest number of the first row in the offset
     */
    private int findPivot(double[][] mtx, int offset){
        int idx=0;
        Double max= 0d;
        for(int i= offset ; i <mtx.length ;i++ ){
            if(max.compareTo(Math.abs(mtx[i][offset]))<0){
                max = mtx[i][offset];
                idx = i;
            }
        }
        return idx;
    }

    /*
     *
     */
    private void swapLines(double[][] mtx, double[] vector, int l1, int l2){
        double tmp;
        for(int i = 0; i<mtx[l1].length; i++){
            tmp = mtx[l2][i];
            mtx[l2][i] = mtx[l1][i];
            mtx[l1][i] = tmp;
        }
        tmp = vector[l1];
        vector[l1]=vector[l2];
        vector[l2]=tmp;

    }

    /*
     *
     */
    private void divideLineByPivot(double[][] mtx, double[] vector, int offset){
        double pivot = mtx [offset][offset];
        if(pivot !=0){
            for (int i = 0; i< mtx.length;i++){
                mtx[offset][i] = mtx[offset][i]/pivot;
            }
            vector[offset]= vector[offset]/pivot;
        }
    }

    /*
     *
     */
    private void multiplyLine(double[] vector, double value){
        for (int i = 0; i< vector.length;i++){
            vector[i] = vector[i] * value;
        }

    }

    /*
     *
     */
    private void negateVector(double[] vector){
        for (int i =0; i<vector.length;i++){
            vector[i]= - vector[i];
        }

    }

    /*
     *
     */
    private void addLine(double[][] mtx, double[] vector, int line1, double[] line){
        for(int i= 0; i<mtx.length;i++){
            mtx[line1][i]= mtx[line1][i]+ line[i];
        }
        vector[line1]=vector[line1]+line[line.length-1];
    }
    private double [] initTmpVector(double[][] mtx, double[] vector, int offset){
        double tmp []= new double [(mtx[offset].length)+1];
        for (int i =0; i<mtx.length;i++){
            tmp[i]=mtx[offset][i];
        }
        tmp[tmp.length-1]=vector[offset];
        return tmp;
    }
    /*
     *
     */
    private void simplification(double[][] mtx, double[] vector, int offset){
        int pivotLine = findPivot(mtx,offset);
        if(pivotLine != offset){
            swapLines(mtx,vector,offset,pivotLine);
        }
        divideLineByPivot(mtx,vector,offset);

        for(int i= offset+1; i<(mtx.length);i++){
            double [] tmp = initTmpVector(mtx,vector,offset);
            negateVector(tmp);
            multiplyLine(tmp,mtx[i][offset]);
            addLine(mtx,vector,i,tmp);
        }

    }

    /*
     *
     */
    public double [][] fowardSubstitution(double [][] mtx, double[] vector){
        for(int offset=0; offset<mtx.length ; offset++){
            simplification(mtx,vector,offset);
        }
        return mtx;
    }

    public double [] backwardSubstitution(double [][]mtx,double [] vector){
        double[] x = new double[vector.length];
        for (int i = vector.length - 1; i >= 0; i--) {
            double sum = 0.0;
            for (int j = i + 1; j < vector.length; j++) {
                sum += mtx[i][j] * x[j];
            }
            x[i] = (vector[i] - sum) / mtx[i][i];
        }
        return x;
    }
}
