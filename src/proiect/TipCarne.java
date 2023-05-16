package proiect;
/**
 * @author      Dan Proca <address @ example.com>
 * @version     1.6                 (current version number of program)
 * @since       1.2          (the version of the package this class was first added to)
 */
public enum TipCarne {
	VITA("VITA"),
	PORC("PORC"),
	PUI("PUI");
	
	private String tipCarne;
	 
    TipCarne(String tipCarne) {
        this.tipCarne = tipCarne;
    }
 
    public String getTipCarne() {
        return tipCarne;
    }
}

