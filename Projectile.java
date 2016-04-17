import java.util.Scanner;


public class Projectile{
	public double x;
	public double y;
	private double vitesseX;
	private double vitesseY;
	private double aY;
	private EnsembleCaracteres car;

	public Projectile(double a, double b){
		car = new EnsembleCaracteres();
		x = a;
		y = b;
		aY = -0.6;
		this.InitProjectile();
	}

	private void InitProjectile(){
		car.ajouteCar(x,y,'\\');
		car.ajouteCar(x+1,y,'#');
		car.ajouteCar(x+2,y,'/');
		car.ajouteCar(x,y+1,'/');
		car.ajouteCar(x+2,y+1,'\\');
	}

	public EnsembleCaracteres getEnsembleCaracteres(){
		return this.car;
	}

	public void initialisation(){
		int angle = this.entrerInt("l'angle de tir",0,90);
		int force = this.entrerInt("la force du tir",0,100);
		this.vitesseX = force*Math.cos(Math.toRadians((double)angle));
		this.vitesseY = force*Math.sin(Math.toRadians((double)angle));
	}

	public void bouge(){
		double deltaT = 1/(Math.sqrt(vitesseX*vitesseX+vitesseY*vitesseY));
		x += vitesseX*deltaT;
		y += vitesseY*deltaT;
		vitesseY += aY;
		this.car.vider();
		this.InitProjectile();
	}

	public boolean estDans(Fenetre f){
		return ( 0 < x && y < f.getNbLignes() && y > 0 && x < f.getNbColonnes());
	}

	public boolean touche(Cible c) {
		int i = 0;
		boolean touche = false;
		while(i < this.car.caracteres.size() && !touche) {
			touche = c.getEnsembleCaracteres().hasChar(this.car.caracteres.get(i).x, this.car.caracteres.get(i).y);
			i++;
		}
		return touche;
	}

	public boolean touche(Obstacle o) {
		int i = 0;
		boolean touche = false;
		while(i < this.car.caracteres.size() && !touche) {
			touche = o.getEnsembleCaracteres().hasChar(this.car.caracteres.get(i).x, this.car.caracteres.get(i).y);
			i++;
		}
		return touche;
	}

	private static int entrerInt(String type, int min, int max){
		int valeur = 0;
		boolean pasValable = true;
		while(pasValable){
			Scanner sc = new Scanner(System.in);
			System.out.print("Entrer " + type + " entre " + min + " et " + max + " : ");
			String str = sc.nextLine();
			if (str.matches("^\\d+$")){
				valeur = Integer.parseInt(str);
				if ( valeur >= min && valeur <= max){
					pasValable = false;
				}
			}
		}
		return valeur;
	}
}