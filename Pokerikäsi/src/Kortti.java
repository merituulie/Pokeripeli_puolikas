
public class Kortti {
	private int maa;
	private int arvo;
	private String maanimi;

	public Kortti() {
		
	}

	public Kortti(int maa, int arvo) {
		this.maa = maa;
		this.arvo = arvo;
	}

	public int getMaa() {
		return maa;
	}
	
	public void setKortti(int maa, int arvo) {
		this.maa = maa;
		this.arvo = arvo;
	}

	public void setMaa(int maa) {
		this.maa = maa;
	}

	public int getArvo() {
		return arvo;
	}

	public void setArvo(int arvo) {
		this.arvo = arvo;
	}
	
	public String getMaanimi() {
		return maanimi;
	}
	
	public void setMaanimi(String maanimi) {
		this.maanimi = maanimi;
	}

	@Override
	public String toString() {
		return "Kortin maa: " + maanimi + ",  arvo: " + arvo;
	}
	
}
