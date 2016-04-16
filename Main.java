// public class Executable{
    // public static void main(String[] args){
    // 	Fenetre f = new Fenetre();
    // 	Projectile p = new Projectile(5,5);
    // 	Cible c = new Cible(58,20);
    // 	Obstacle o = new Obstacle(30, 1);
    // 	o.make();

    // 	while(p.estDans(f) && !p.touche(c) && !p.touche(o)) {
    // 		f.pause(50);
    // 		p.bouge();
    //         // System.out.println(o.getEnsembleCaractere().toString());
    // 		// System.out.println("cible : " + c.x + " " + c.y);
    //   //       System.out.println("obstacle : " + o.x + " " + o.y);
    //         EnsembleCaracteres a = new EnsembleCaracteres();
    // 		a = p.getEnsembleCaractere().union(c.getEnsembleCaractere());
    // 		a = a.union(o.getEnsembleCaractere());
    // 		f.AfficherCaracteres(a);
    //         o.getEnsembleCaractere().vider();
    //         o.make();
    // 		System.out.println("projectile x : " + p.x + " y : " + p.y);
    // 	}
    // }

class Main{
    public static void main( String [] args) {
        Fenetre fenetre = new Fenetre ();
        GorillaBomb jeu = new GorillaBomb ();
        while (!jeu.fin()){
            jeu.affiche(fenetre);
            System.out.println("Début tour");
            jeu.debutTour();
            while (!jeu.finTour(fenetre)){
                System.out.println("Evolue");
                jeu.evolue(fenetre);
                fenetre.pause(110);
                System.out.println("Affiche Fenetre");
                jeu.affiche(fenetre);
            }
        }
    }
}
// }