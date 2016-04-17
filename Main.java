class Main{
	public static void main(String[] args){
		Fenetre f = new Fenetre();
		GorillaBomb jeu = new GorillaBomb();
		while (!jeu.fin()){
			System.out.println("Début Partie");		
			jeu.affiche(f);
			f.pause(50);
			jeu.debutTour(f);
			System.out.println("Début Tour");	
			while(!jeu.finTour(f)){
				jeu.evolue();
				f.pause(110);
				jeu.affiche(f);
			}
			System.out.println("Fin Tour");
			jeu.setFinTour();
		}
		System.out.println("Fin du game");
		System.exit(0);
	}
}