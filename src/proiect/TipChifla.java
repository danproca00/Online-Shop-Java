package proiect;
/**
 * @author      Dan Proca <address @ example.com>
 * @version     1.6                 (current version number of program)
 * @since       1.2          (the version of the package this class was first added to)
 */
public enum TipChifla {
	SIMPLA("SIMPLA"),
	SUSAN("SUSAN");
	
	private String tipChifla;
	 
    TipChifla(String tipChifla) {
        this.tipChifla = tipChifla;
    }
 
    public String getTipChifla() {
        return tipChifla;
    }
}
