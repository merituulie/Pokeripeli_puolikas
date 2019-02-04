import java.util.ArrayList;


public class Pelaaja {
	private ArrayList<Kortti> k�sikortit = new ArrayList<>();
	private int pelaajanro, kasiarvo;
	private String kasi;
	
	public Pelaaja(int pelaajanro) {
		this.pelaajanro = pelaajanro;
	}
	
	public int getPelaajanumero() {
		return pelaajanro;
	}
	
	public Pelaaja(ArrayList<Kortti> k�sikortit) {
		this.k�sikortit = k�sikortit;
	}

	public ArrayList<Kortti> getK�sikortit() {
		return k�sikortit;
	}

	public void setKasikortit(ArrayList<Kortti> k�sikortit) {
		this.k�sikortit = k�sikortit;
	}

	public int getKasiarvo() {
		return kasiarvo;
	}

	public void setKasiarvo(int kasiarvo) {
		this.kasiarvo = kasiarvo;
	}

	public String getKasi() {
		return kasi;
	}

	public void setKasi(String kasi) {
		this.kasi = kasi;
	}

	@Override
	public String toString() {
		return "Pelaajan " + pelaajanro + " k�sikortit: ";
	}

	
	
	
}
