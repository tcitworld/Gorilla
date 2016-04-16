import java.lang.Math;

public class Projectile {
	public double x, y;
	private EnsembleCaracteres car;
	private double vitesseX, vitesseY, aY;

	Projectile(double x, double y) {
		this.x = x;
		this.y = y;
		this.vitesseX = 60.0;
		this.vitesseY = 35.0;
		this.aY = -0.6;
		this.car = new EnsembleCaracteres();
		this.afficheCar();
	}

	public EnsembleCaracteres getEnsembleCaractere() {
		return this.car;
	}

	public void bouge() {
		double deltaT;
		this.car.vider();
		deltaT = 1/(Math.sqrt(vitesseX*vitesseX+vitesseY*vitesseY));
		this.x+=vitesseX*deltaT;
		this.y+=vitesseY*deltaT;
		this.vitesseY+=aY;
		this.afficheCar();
	}

	public void afficheCar() {
		this.car.ajouteCar(this.x,this.y,'\\');
    	this.car.ajouteCar(this.x+1,y,'#');
    	this.car.ajouteCar(this.x+2,this.y,'/');
    	this.car.ajouteCar(this.x,this.y+1,'/');
    	this.car.ajouteCar(this.x+2,this.y+1,'\\');
	}

	public boolean estDans(Fenetre f) {
		return this.y < f.getNbLignes() && this.x < f.getNbColonnes() && this.y > 0 && this.x > 0;
	}

	public boolean touche(Cible c) {
		int i = 0;
		boolean touche = false;
		while(i < this.car.caracteres.size() && !touche) {
			touche = c.getEnsembleCaractere().hasChar(this.car.caracteres.get(i).x, this.car.caracteres.get(i).y);
			i++;
		}
		return touche;
	}

	public boolean touche(Obstacle o) {
		int i = 0;
		boolean touche = false;
		while(i < this.car.caracteres.size() && !touche) {
			touche = o.getEnsembleCaractere().hasChar(this.car.caracteres.get(i).x, this.car.caracteres.get(i).y);
			i++;
		}
		return touche;
	}

	public void setChars(EnsembleCaracteres t) {
		this.car.vider();
		this.car = t;
	}

	public void setTir(int angle, double force) {
		this.vitesseX = force*Math.cos(angle/180*Math.PI);
		this.vitesseY = force*Math.sin(angle/180*Math.PI);
	}
}