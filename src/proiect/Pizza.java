package proiect;
/**
 * @author      Dan Proca <address @ example.com>
 * @version     1.6                 (current version number of program)
 * @since       1.2          (the version of the package this class was first added to)
 */
public class Pizza extends Produs{
	
	private int dimensiune;
	private TipBlat tipBlat;
	private String topping;
	
	
	public Pizza(int dimensiune, TipBlat tipBlat, String topping) {
		super();
		this.dimensiune = dimensiune;
		this.tipBlat = tipBlat;
		this.topping = topping;
	}
	
	public Pizza(String nume, String descriere, Double pret, Double cantitate, TipBlat tipBlat, String topping , int dimensiune) {
		super(nume,pret,descriere,cantitate);
		this.dimensiune = dimensiune;
		this.tipBlat = tipBlat;
		this.topping = topping;
	}
	
	public Pizza() {
		// TODO Auto-generated constructor stub
	}

	public int getDimensiune() {
		return dimensiune;
	}
	public void setDimensiune(int dimensiune) {
		this.dimensiune = dimensiune;
	}
	public TipBlat getTipBlat() {
		return tipBlat;
	}
	public void setTipBlat(TipBlat tipBlat) {
		this.tipBlat = tipBlat;
	}
	public String getTopping() {
		return topping;
	}
	public void setTopping(String topping) {
		this.topping = topping;
	}
	
	

}
