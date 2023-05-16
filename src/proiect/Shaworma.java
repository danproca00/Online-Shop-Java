package proiect;
/**
 * @author      Dan Proca <address @ example.com>
 * @version     1.6                 (current version number of program)
 * @since       1.2          (the version of the package this class was first added to)
 */
public class Shaworma extends Produs{
	private TipCarne tipCarne;
	private TipLipie tipLipie;
	private Boolean areSalata;
	
	
	public Shaworma(TipCarne tipCarne, TipLipie tipLipie, Boolean areSalata) {
		super();
		this.tipCarne = tipCarne;
		this.tipLipie = tipLipie;
		this.areSalata = areSalata;
	}
	
	
	public Shaworma(String nume, String descriere, Double pret, Double cantitate,TipCarne tipCarne, TipLipie tipLipie, Boolean areSalata) {
		super(nume, pret, descriere, cantitate);
		this.tipCarne = tipCarne;
		this.tipLipie = tipLipie;
		this.areSalata = areSalata;
	}


	public Shaworma() {
		// TODO Auto-generated constructor stub
	}


	public TipCarne getTipCarne() {
		return tipCarne;
	}
	public void setTipCarne(TipCarne tipCarne) {
		this.tipCarne = tipCarne;
	}
	public TipLipie getTipLipie() {
		return tipLipie;
	}
	public void setTipLipie(TipLipie tipLipie) {
		this.tipLipie = tipLipie;
	}
	public Boolean getAreSalata() {
		return areSalata;
	}
	public void setAreSalata(Boolean areSalata) {
		this.areSalata = areSalata;
	}
	
	
	
	
}

