public class Obstacle {
	
	private EnsembleCaracteres car;
	double x, y;

	String [] sprite = {
	"             ()",
	"            /\\",
	"            |==|",
	"            ====",
	"            XX",
	"           xXXx",
	"           XXXX",
	"           XXXX",
	"           XXXX",
	"          xXXXXx ",
	"          XXXXXX ",
	"          XXXXXX ",
	"         xXXXXXXx ",
	"         XXXXXXXX ",
	"        xXXXXXXXXx ",
	"        XXXXXXXXXX ",
	"       XXXXX  XXXXXX ",
	"      xXXXX’  ’XXXXx ",
	"     XXXXXxxxxxxXXXXX ",
	"   xXXXXX’’’’’’’’XXXXXx ",
	"  xXXXXXX’       ’XXXXXXx ",
	"xxXXXXXXX         XXXXXXXxx"	
	};

	Obstacle(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public void make() {
		this.car = new EnsembleCaracteres();
		for (int i = this.sprite.length-1; i>=0; i--) {
			for (int j=0; j<this.sprite[i].length() ; j++) {
				this.car.ajouteCar(this.x + j, this.y-i + this.sprite.length, this.sprite[i].charAt(j));
			}
		}
	}

	public EnsembleCaracteres getEnsembleCaractere() {
		return this.car;
	}

}