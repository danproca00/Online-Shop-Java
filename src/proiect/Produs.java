package proiect;
/**
 * @author      Dan Proca <address @ example.com>
 * @version     1.6                 (current version number of program)
 * @since       1.2          (the version of the package this class was first added to)
 */
public abstract class Produs {
	private String nume;
	private Double pret;
	private String descriere;
	private Double cantitate;
	
	public Produs() {
		super();
	}
	public Produs(String nume, Double pret, String descriere, Double cantitate) {
		super();
		this.nume = nume;
		this.pret = pret;
		this.descriere = descriere;
		this.cantitate = cantitate;
	}
	public String getNume() {
		return nume;
	}
	public void setNume(String nume) {
		this.nume = nume;
	}
	public Double getPret() {
		return pret;
	}
	public void setPret(Double pret) {
		this.pret = pret;
	}
	public String getDescriere() {
		return descriere;
	}
	public void setDescriere(String descriere) {
		this.descriere = descriere;
	}
	public Double getCantitate() {
		return cantitate;
	}
	public void setCantitate(Double cantitate) {
		this.cantitate = cantitate;
	}
	
	
}
