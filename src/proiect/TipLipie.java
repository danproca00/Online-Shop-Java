package proiect;
/**
 * @author      Dan Proca <address @ example.com>
 * @version     1.6                 (current version number of program)
 * @since       1.2          (the version of the package this class was first added to)
 */
public enum TipLipie {
	LIBANEZA("LIBANEZA"),
	INTEGRALA("INTEGRALA");
	
	
	private String tipLipie;
	 
	TipLipie(String tipLipie) {
        this.tipLipie = tipLipie;
    }
 
    public String getTipLipie() {
        return tipLipie;
    }
}
