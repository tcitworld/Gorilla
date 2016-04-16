public class CaracterePositionne{
    Double x,y;
    char c;
    public CaracterePositionne(double a, double b, char d){
    	x=a;
    	y=b;
    	c=d;
    }

    public String toString() {
    	return this.c + " en  x : " + this.x + " y : " + this.y;
    }
}
