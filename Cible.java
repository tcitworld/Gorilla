public class Cible {
	public double x, y;
	private EnsembleCaracteres car;

	Cible(double x, double y) {
		this.x = x;
		this.y = y;
		this.car = new EnsembleCaracteres();
		this.car.ajouteCar(this.x,this.y,'(');
		this.car.ajouteCar(this.x+2,this.y,'^');
		this.car.ajouteCar(this.x+3,this.y,')');
		this.car.ajouteCar(this.x-1,this.y+1,'C');
		this.car.ajouteCar(this.x+1,this.y+1,'o');
		this.car.ajouteCar(this.x+2,this.y+1,'o');
	}

	public EnsembleCaracteres getEnsembleCaractere() {
		return this.car;
	}
}