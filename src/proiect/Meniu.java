package proiect;
/**
 * @author      Dan Proca <address @ example.com>
 * @version     1.6                 (current version number of program)
 * @since       1.2          (the version of the package this class was first added to)
 */
public class Meniu{
	private String nume;
	private TipSos tipSos;
	private TipSuc tipSuc;
	private Produs produs;
	
	
	public Meniu(String nume, TipSos tipSos, TipSuc tipSuc, Produs produs) {
		super();
		this.nume 	= nume;
		this.tipSos = tipSos;
		this.tipSuc = tipSuc;
		this.produs = produs;
	}
	
	
	public String getNume() {
		return nume;
	}

	public void setNume(String nume) {
		this.nume = nume;
	}

	public TipSos getTipSos() {
		return tipSos;
	}
	public void setTipSos(TipSos tipSos) {
		this.tipSos = tipSos;
	}
	public TipSuc getTipSuc() {
		return tipSuc;
	}
	public void setTipSuc(TipSuc tipSuc) {
		this.tipSuc = tipSuc;
	}
	public Produs getProdus() {
		return produs;
	}
	public void setProdus(Produs produs) {
		this.produs = produs;
	}
	
	
}
