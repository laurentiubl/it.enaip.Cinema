package it.enaip.cinema;

public class Biglietto {

	int posizione;
	int prezzo;
	
	Spettatore sp;
	
public double applicaRiduzioneAnziani() {
	
	double prezzo=0;
	if(sp.getDataNasita().getYear() >= 70) {
		 prezzo = 0.9 * prezzo;
	}
	return prezzo;
}


public double calcolaRiduzioneBambini() {
	
	double prezzo=0;
	if(sp.getDataNasita().getYear()<= 5) {
		 prezzo = 0.9 * prezzo;
	}
	return prezzo;
}
	

}
