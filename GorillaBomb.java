import java.util.Scanner;

public class GorillaBomb{
	private Projectile p;
	private Cible c;
	private Obstacle o;
	private boolean fin;

	public GorillaBomb(){
		c = new Cible(58,22);
		o = new Obstacle(30,1);
		fin = false;
		p = new Projectile(7,5);
	}

	public void affiche(Fenetre f) {
		f.AfficherCaracteres(this.c.getEnsembleCaracteres().union(this.p.getEnsembleCaracteres()).union(o.getEnsembleCaracteres()));
	}

	public void debutTour(Fenetre f){
		p = new Projectile(7,5);
		this.affiche(f);
		p.initialisation();
	}

	public boolean finTour(Fenetre f){
		return !p.estDans(f) || p.touche(o) || p.touche(c);	
	}

	public void evolue(){
		p.bouge();
	}

	public boolean fin(){
		return p.touche(c);
	}

	public void setFinTour(){
		if (!p.touche(c)) {
			boolean pasValable = true;
			while(pasValable){
				Scanner sc = new Scanner(System.in);
				System.out.print("Voulez vous continuer ? o/n : ");
				String str = sc.nextLine();
				if(str.charAt(0) == 'o'){
					this.fin = false;
					pasValable = false;
				} else {
					if(str.charAt(0) == 'n'){
						this.fin = true;
						pasValable = false;
					}
				}
			}
		}
	}
}