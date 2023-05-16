package proiect;
/**
 * @author      Dan Proca <address @ example.com>
 * @version     1.6                 (current version number of program)
 * @since       1.2          (the version of the package this class was first added to)
 */
public enum TipBlat {
	SUBTIRE("SUBTIRE"),
	GROS("GROS");
	
	private String tipBlat;
	 
	TipBlat(String tipBlat) {
        this.tipBlat = tipBlat;
    }
 
    public String getTipBlat() {
        return tipBlat;
    }
}

