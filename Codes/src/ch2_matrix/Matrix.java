package ch2_matrix;

public interface Matrix<T> {
	public double get(int i, int j);
	public void set(T value, int i, int j);
	public int getWidth();
	public int getHeight();

}
