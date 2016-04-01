public class Executable{
    public static void main(String[] args){
    	Fenetre f = new Fenetre();
    	Projectile p = new Projectile(7,3);

    	while(p.estDans()) {
    		f.AfficherCaracteres(p.getEnsembleCaractere());
    	}
    }
}