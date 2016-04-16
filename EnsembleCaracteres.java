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

	public EnsembleCaracteres copy() {
		EnsembleCaracteres a = new EnsembleCaracteres();
		a.caracteres = this.caracteres;
		return a;
	}

	public EnsembleCaracteres union(EnsembleCaracteres ens){
		EnsembleCaracteres uni = new EnsembleCaracteres();
		uni.caracteres.addAll(this.caracteres);
		uni.caracteres.addAll(ens.caracteres);
		return uni;
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
		while (i < this.caracteres.size() && !hasChar) {
			hasChar = Math.abs(Math.round(this.caracteres.get(i).x) - Math.round(x)) < 2 && Math.abs(Math.round(this.caracteres.get(i).y) - Math.round(y)) < 2 && this.caracteres.get(i).c != ' ';
			i++;
		}
		return hasChar;
	}
}
