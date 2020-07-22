package it.enaip.cinema;

import java.util.Date;



public class Spettatore {

	private int idSpettatore;
	private String nome;
	private String cognome;
	private Date dataNasita;
	
	
	
	@SuppressWarnings("deprecation")
	public boolean isMinor() {
		
		if(dataNasita.getYear()<18) {
			return true;
		}
		return false;
	}
	
	public double sconto() {
		
		double prezzo=0;
		
		if(dataNasita.getYear() >= 70) {
			 prezzo = 0.9 * prezzo;
		}if(dataNasita.getYear()<= 5) {
			 prezzo = prezzo/2;
		}
		return prezzo;
	}
	
	
	
	  private Spettatore(SpettatoreBuilder builder) {
	        this.idSpettatore = builder.idSpettatore;
	        this.nome = builder.nome;
	        this.cognome = builder.cognome;
	        this.dataNasita = builder.dataNasita;
	  
	    }
	
	
	
	public Spettatore(int idSpettatore, String nome, String cognome, Date dataNasita) {
		super();
		this.idSpettatore = idSpettatore;
		this.nome = nome;
		this.cognome = cognome;
		this.dataNasita = dataNasita;
	}



	public int getIdSpettatore() {
		return idSpettatore;
	}



	public void setIdSpettatore(int idSpettatore) {
		this.idSpettatore = idSpettatore;
	}



	public String getNome() {
		return nome;
	}



	public void setNome(String nome) {
		this.nome = nome;
	}



	public String getCognome() {
		return cognome;
	}



	public void setCognome(String cognome) {
		this.cognome = cognome;
	}



	public Date getDataNasita() {
		return dataNasita;
	}



	public void setDataNasita(Date dataNasita) {
		this.dataNasita = dataNasita;
	}


	
	 public static class SpettatoreBuilder 
	    {
		 
		 
			private int idSpettatore;
			private String nome;
			private String cognome;
			private Date dataNasita;
		 
			   public SpettatoreBuilder(String nome) {
					
					this.nome = nome;
				}
			   
			   public SpettatoreBuilder dataNasita(Date dataNasita) {
					 this.dataNasita = dataNasita;
					 return this;
				 }
			   
			   public SpettatoreBuilder cognome(String cognome) {
					 this.cognome = cognome;
					 return this;
				 }
			   
			   public SpettatoreBuilder idSpettatore(int idSpettatore) {
					 this.idSpettatore = idSpettatore;
					 return this;
				 }
			   
			   public Spettatore build() {
				   Spettatore Spettatore = new Spettatore(this);
					 return Spettatore;
				 }
		 
		 
	    }
	 


	
	
	
	
}
