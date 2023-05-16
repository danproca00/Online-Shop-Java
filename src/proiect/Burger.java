package proiect;
/**
 * @author      Dan Proca <address @ example.com>
 * @version     1.6                 (current version number of program)
 * @since       1.2          (the version of the package this class was first added to)
 */
public class Burger extends Produs{
	
	private TipCarne tipCarne;
	private TipChifla tipChifla;
	private Boolean areSalata;
	
	public Burger(TipCarne tipCarne, TipChifla tipChifla, Boolean areSalata) {
		super();
		this.tipCarne = tipCarne;
		this.tipChifla = tipChifla;
		this.areSalata = areSalata;
	}
	
	
	public Burger(String nume, String descriere , Double pret, Double cantitate,TipCarne tipCarne, TipChifla tipChifla, Boolean areSalata) {
		super(nume, pret, descriere, cantitate);
		this.tipCarne = tipCarne;
		this.tipChifla = tipChifla;
		this.areSalata = areSalata;
	}


	public Burger() {
	}


	public TipCarne getTipCarne() {
		return tipCarne;
	}
	public void setTipCarne(TipCarne tipCarne) {
		this.tipCarne = tipCarne;
	}
	public TipChifla getTipChifla() {
		return tipChifla;
	}
	public void setTipChifla(TipChifla tipChifla) {
		this.tipChifla = tipChifla;
	}
	public Boolean getAreSalata() {
		return areSalata;
	}
	public void setAreSalata(Boolean areSalata) {
		this.areSalata = areSalata;
	}
}