import java.lang.Math;

public class Projectile {
	public double x, y;
	private EnsembleCaracteres car;
	private double vitesseX, vitesseY, aY;

	Projectile(double x, double y) {
		this.x = x;
		this.y = y;
		this.car = new EnsembleCaracteres();
		this.afficheCar();
	}

	public EnsembleCaracteres getEnsembleCaractere() {
		return this.car;
	}

	public void bouge(double vitesseX, double vitesseY, double aY) {
		this.car.vider();
		double deltaT = 1/(Math.sqrt(vitesseX*vitesseX+vitesseY*vitesseY));
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
		return this.y < f.getNbLignes() && this.x < f.getNbColonnes();
	}

	public boolean touche(Cible c) {
		// int i = 0;
		// boolean touche = false;
		// while(i < c.getEnsembleCaractere().caracteres.size() && !touche) {
		// 	touche = this.getEnsembleCaractere().hasChar(c.getEnsembleCaractere().caracteres.get(i).x, c.getEnsembleCaractere().caracteres.get(i).y);
		// 	i++;
		// }
		// return touche;
		return Math.abs(this.y - c.y) < 3 && Math.abs(this.x - c.x) < 3;
	}

	public boolean touche(Obstacle o) {
		return Math.abs(this.y - o.y) < 3 && Math.abs(this.x - o.x) < 3;
	}
}