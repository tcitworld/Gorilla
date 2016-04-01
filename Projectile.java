public class Projectile {
	private double x, y;
	private EnsembleCaracteres car;
	private double vitesseX, vitesseY, aY;

	Projectile(double x, double y) {
		this.x = x;
		this.y = y;
		this.car = new EnsembleCaracteres();
		this.car.ajouteCar(x,y,'\\');
    	this.car.ajouteCar(x+1,y,'#');
    	this.car.ajouteCar(x+2,y,'/');
    	this.car.ajouteCar(x,y+1,'/');
    	this.car.ajouteCar(x+2,y+1,'\\');
	}

	public EnsembleCaracteres getEnsembleCaractere() {
		return this.car;
	}

	public void bouge() {
		this.car.vide();
		deltaT = 1/(Math.sqrt(vitesseX*vitesseX+vitesseY*vitesseY));
		this.x+=vitesseX*deltaT;
		this.y+=vitesseY*deltaT;
		this.vitesseY+=aY;
	}

	public boolean estDans(Fenetre f) {
		return this.y < f.getNbLignes() && this.x < f.getNbColonnes();
	}
}