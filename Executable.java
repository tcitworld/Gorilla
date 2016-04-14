public class Executable{
    public static void main(String[] args){
    	Fenetre f = new Fenetre();
    	Projectile p = new Projectile(5,5);
    	Cible c = new Cible(58,35);
    	Obstacle o = new Obstacle(30, 1);
    	o.make();

    	while(p.estDans(f) && !p.touche(c) && !p.touche(o)) {
    		f.pause(50);
    		p.bouge(60.0,35.0,-0.6);
    		// System.out.println("cible : " + c.x + " " + c.y);
    		p.getEnsembleCaractere().union(c.getEnsembleCaractere());
    		p.getEnsembleCaractere().union(o.getEnsembleCaractere());
    		f.AfficherCaracteres(p.getEnsembleCaractere());
    		// System.out.println("x : " + p.x + "y : " + p.y);
    	}
    }
}