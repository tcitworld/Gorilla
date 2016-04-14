import java.util.ArrayList;
import java.lang.Math;

class EnsembleCaracteres {

	ArrayList<CaracterePositionne> caracteres;

	EnsembleCaracteres()
	{
		this.caracteres = new ArrayList<CaracterePositionne>();
	}

	public void ajouteCar(double x, double y, char c) {
		caracteres.add(new CaracterePositionne(x,y,c));
	}

	public void vider(){
		caracteres.clear();
	}

	public void union(EnsembleCaracteres a) {
		for (CaracterePositionne cp : a.caracteres) {
			this.ajouteCar(cp.x, cp.y, cp.c);
		}
	}

	public String toString() {
		String str = "";
		for (CaracterePositionne cp : this.caracteres) {
			str += cp.toString() + "\n";
		}
		return str;
	}
	/* 
	 * S'il y a un caratère en position x,y
	 */
	public boolean hasChar(Double x, Double y) {
		int i = 0;
		boolean hasChar = false;
		System.out.println("x : " + x + " y : " + y);
		while (i < this.caracteres.size() && !hasChar) {
			hasChar = Math.round(this.caracteres.get(i).x) == Math.round(x) && Math.round(this.caracteres.get(i).y) == Math.round(y) && this.caracteres.get(i).c != ' ';
			i++;
		}
		return hasChar;
	}
}
