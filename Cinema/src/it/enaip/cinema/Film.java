package it.enaip.cinema;

public class Film {


	private String titolo;
	private String autore;
	private String productore;
	private int durata;
	private Genere genere;
	
	public Genere getGenere() {
		return genere;
	}

	public void setGenere(Genere genere) {
		this.genere = genere;
	}

	public enum Genere {
		Drama,Horor,Action;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public String getAutore() {
		return autore;
	}

	public void setAutore(String autore) {
		this.autore = autore;
	}

	public String getProductore() {
		return productore;
	}

	public void setProductore(String productore) {
		this.productore = productore;
	}

	public int getDurata() {
		return durata;
	}

	public void setDurata(int durata) {
		this.durata = durata;
	}

	public Film(String titolo, String autore, String productore, int durata, Genere genere) {
		super();
		this.titolo = titolo;
		this.autore = autore;
		this.productore = productore;
		this.durata = durata;
		this.genere = genere;
	}


	
}
