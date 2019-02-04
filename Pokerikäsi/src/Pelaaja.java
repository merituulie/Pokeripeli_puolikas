import java.util.ArrayList;


public class Pelaaja {
	private ArrayList<Kortti> käsikortit = new ArrayList<>();
	private int pelaajanro, kasiarvo;
	private String kasi;
	
	public Pelaaja(int pelaajanro) {
		this.pelaajanro = pelaajanro;
	}
	
	public int getPelaajanumero() {
		return pelaajanro;
	}
	
	public Pelaaja(ArrayList<Kortti> käsikortit) {
		this.käsikortit = käsikortit;
	}

	public ArrayList<Kortti> getKäsikortit() {
		return käsikortit;
	}

	public void setKasikortit(ArrayList<Kortti> käsikortit) {
		this.käsikortit = käsikortit;
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
		return "Pelaajan " + pelaajanro + " käsikortit: ";
	}

	
	
	
}
