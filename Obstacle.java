class Obstacle{
	
	double x,y;
	EnsembleCaracteres car;

	public Obstacle( double a, double b){
		x = a;
		y = b;
		String[] sprite ={
			"              ()",
			"              /\\",
			"             |==|",
			"             ====",
			"              XX",
			"             xXXx",
			"             XXXX",
			"             XXXX",
			"             XXXX",
			"            xXXXXx",
			"            XXXXXX",
			"            XXXXXX",
			"           xXXXXXXx",
			"           XXXXXXXX",
			"          xXXXXXXXXx",
			"          XXXXXXXXXX",
			"         XXXXX  XXXXX",
			"        xXXXX'  'XXXXx",
			"       XXXXXxxxxxxXXXXX",
			"     xXXXXX''''''''XXXXXx",
			"   xXXXXXX'        'XXXXXXx",
			"xxXXXXXXX            XXXXXXXxx",
		};
		car = new EnsembleCaracteres();
		for(int j = sprite.length-1; j>=0;j--) {
			String ligne = sprite[j];
			a = x;
			for(int i = 0; i < ligne.length() ; i++){
				char c = ligne.charAt(i);
				if (c != ' '){
					car.ajouteCar(a,b,c);
				}
				a++;
			}
			b++;
		}
	}

	public EnsembleCaracteres getEnsembleCaracteres(){
		return this.car;
	}
}