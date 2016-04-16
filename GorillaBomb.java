import java.util.Scanner;

public class GorillaBomb {

    Projectile p;
    Cible c;
    Obstacle o;
    EnsembleCaracteres a;
    int angle;
    double force;

    GorillaBomb() {
    	this.c = new Cible(58,20);
    	this.o = new Obstacle(30, 1);
        this.o.make();
        this.p = new Projectile(5,5);
        this.a = new EnsembleCaracteres();
        this.a = p.getEnsembleCaractere().union(c.getEnsembleCaractere());
        this.a = a.union(o.getEnsembleCaractere());
    }

    public void evolue(Fenetre f) {
        this.p.bouge();
        // System.out.println(o.getEnsembleCaractere().toString());
        // System.out.println("cible : " + c.x + " " + c.y);
        // System.out.println("obstacle : " + o.x + " " + o.y);
        this.a = new EnsembleCaracteres();
        this.a = p.getEnsembleCaractere().union(c.getEnsembleCaractere());
        this.a = a.union(o.getEnsembleCaractere());
    }

    public void affiche(Fenetre f) {
        f.AfficherCaracteres(this.a);
        o.getEnsembleCaractere().vider();
        o.make();
        System.out.println("projectile x : " + p.x + " y : " + p.y);
    }

    public boolean finTour(Fenetre f) {
        System.out.println("estDans : " + this.p.estDans(f));
        System.out.println("touche obstacle : " + this.p.touche(this.o));
        return !this.p.estDans(f) || this.p.touche(this.o);
    }

    public boolean fin() {
        System.out.println("touche cible : " + this.p.touche(c));
        return this.p.touche(c);
    }

    public void debutTour() {
        Scanner in = new Scanner(System.in);
        System.out.println("Entrez l'angle");
        this.angle = in.nextInt();
        System.out.println("Entrez la force");
        this.force = in.nextDouble();
        this.p.setTir(this.angle, this.force);
    }
}