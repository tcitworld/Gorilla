import java.util.ArrayList;
class EnsembleCaracteres {
	ArrayList<CaracterePositionne> caracteres;
	EnsembleCaracteres(){caracteres = new ArrayList<CaracterePositionne>(); }
	public void ajouteCar(double x, double y, char c){
		caracteres.add(new CaracterePositionne(x,y,c));}
	public void vider(){ caracteres.clear();}
}
