package aux;

public class Coordinates {
	private int x,y;
	public Coordinates(int x,int y){
		this.x=x;
		this.y=y;
	}
	
	public int getX(){
		return x;
	}
	public int getY(){
		return y;
	}
	
	public void setPosition(int x,int y) {
        this.x=x;
        this.y=y;
    }
}
