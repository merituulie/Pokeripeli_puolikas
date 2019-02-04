
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class KorttiPakka {
	private static ArrayList<Kortti> pakka = new ArrayList<>();
	private static ArrayList<Kortti> kasikortit = new ArrayList<>();
	private static ArrayList<Integer> vertailupakka = new ArrayList<>();
	private static ArrayList<Integer> arvot = new ArrayList<>();
	private static ArrayList<Integer> arvot2 = new ArrayList<>();

	public static void main(String[] args) {
		teePakka(); // luodaan pakka
		sekoitaPakka(); // sekoitetaan luotu pakka
		jaaKortit();
	}

	public static ArrayList<Kortti> teePakka() {
		int maa, arvo,i;
		i=0;
		
		for (maa = 0; maa < 4;maa++){
			for (arvo = 1; arvo <=13; arvo++){
				Kortti apu = new Kortti();
				apu.setMaa(maa);
				apu.setArvo(arvo);
				apu.setMaanimi(mikaMaa(apu.getMaa()));
				pakka.add(i, apu);
				i++;
			}
		}
		return pakka;
	}
	
	public static void sekoitaPakka() {
		Collections.shuffle(pakka);
	}
	
	public static void jaaKortit() {
		
		for (int i=0; i<3;i++) {
			kasikortit.clear();
			Pelaaja pelaaja = new Pelaaja(i+1); //luodaan kolme pelaajaa,
			System.out.println(pelaaja);		//jaetaan kaikille viisi korttia
			for (int j=0; j<5;j++) {
				System.out.println(pakka.get(j));
				kasikortit.add(pakka.get(j));
				pakka.remove(j);
			}
			pelaaja.setKasiarvo(tutkiKasi(kasikortit)); 		// tutkitaan, mink�lainen
			pelaaja.setKasi(mikaKasi(pelaaja.getKasiarvo()));	//k�si kullakin pelaajalla on
			System.out.println(pelaaja.getKasi());  //tulostetaan k�dest� mahdollisesti
			System.out.println();					//l�ytyv� kokonaisuus.
		}
	}
	
	public static int tutkiKasi(ArrayList<Kortti> kasikortit) {
		int kasiarvo=0, arvo=0, samaArvo=0, i, j;
		vertailupakka.clear(); // tyhjennet��n listat uutta pelaajaa varten
		arvot.clear();
		arvot2.clear();
		
		for (i=0;i<5;i++) {
			arvo = kasikortit.get(i).getArvo();
			vertailupakka.add(arvo); //t�ytet��n vertailupakka k�sikorttien
		}							//arvoilla.
		for (i = 0; i < vertailupakka.size(); i++) { //vertaillaan kortteja
		  for (j = i+1; j < vertailupakka.size(); j++) {
			  if (vertailupakka.get(i)==vertailupakka.get(j)) {
				  samaArvo=vertailupakka.get(i);
				  if (arvot.size()!=0 && samaArvo!=arvot.get(0)) {
				  arvot2.add(samaArvo); //mik�li samoja arvoja l�ytyy,
				  } else {				//otetaan ne talteen useampaan
				  arvot.add(samaArvo);	// listaan, jotta l�ydet��n
				  }						//kaikki parit, ym.
			  }
		  }
		}
		kasiarvo =  onkoKasi(kasikortit); //katsotaan, l�ytyyk�
		return kasiarvo;				//k�si�, sek� asetetaan
		}								//arvot niille, jotta voidaan
										//halutessa selvitt�� voittajat
	public static int onkoKasi(ArrayList<Kortti> kasikortit) {
		int kasiarvo;					//pudotetaan metodit switch
										//case -rakenteeseen
		if (onkoVariSuora(kasikortit)) {
			kasiarvo = 1;
			return kasiarvo;
		} else if (onkoTaysKasi()){
			kasiarvo = 2;
			return kasiarvo;
		} else if (onkoVari(kasikortit)) {
			kasiarvo = 4;
			return kasiarvo;
		} else if (onkoSuora(kasikortit)) {
			kasiarvo = 5;
			return kasiarvo;
		} else if (onkoNeloset()) {
			kasiarvo = 3;
			return kasiarvo;
		} else if (onkoKolmoset()) {
			kasiarvo = 6;
			return kasiarvo;
		} else if (onkoKaksiParia()) {
			kasiarvo = 7;
			return kasiarvo;
		} else if (onkoPari()) {
			kasiarvo = 8;
			return kasiarvo;
		} else {
			kasiarvo = 0;
			return kasiarvo;
		}
	}
	
	public static String mikaKasi(int i) {
		String  kasi = "";
		
		switch(i){
		case  1:
			kasi = "V�risuora!";
			break;
		case  2:
			kasi = "T�ysk�si!";
			break;
		case  3:
			kasi = "Neloset!";
			break;
		case  4:
			kasi = "V�ri!";
			break;
		case  5:
			kasi = "Suora!";
			break;
		case  6:
			kasi = "Kolmoset!";
			break;
		case  7:
			kasi = "Kaksi paria!";
			break;
		case  8:
			kasi = "Pari!";
			break;
		case  0:
			kasi = "Ei kokonaisuuksia!";
			break;
		default:
			kasi = "Ohjelmavirhe!";
		}
		return  kasi;
	}
	
	private static boolean onkoPari() {
		if (arvot.size() == 1 && arvot2.size() == 0) {
			return true;
		} else if (arvot.size() == 0 && arvot.size() == 1) {
			return true;
		}
		return false;
	}
	
	private static boolean onkoKaksiParia() {
		if (arvot.size() == 1 && arvot2.size() == 1) {
			return true;
		}
		return false;
	}
	
	private static boolean onkoKolmoset() {
		if (arvot.size() == 3 && arvot2.size() == 0) {
			return true;
		} else if (arvot.size() == 0 && arvot2.size() == 3) {
			return true;
		}
		return false;
	}
	
	private static boolean onkoNeloset() {
		if (arvot.size() == 6 && arvot2.size() == 0) {
			return true;
		} else if (arvot.size() == 0 && arvot2.size() == 6) {
			return true;
		}
		return false;
	}
	
	private static boolean onkoSuora(ArrayList<Kortti> kasikortit) {
		ArrayList<Integer> arvot = new ArrayList<>();
		
		for (Kortti k : kasikortit) {
			arvot.add(k.getArvo());
		}
		Collections.sort(arvot);
		for (int i=0;i<4;i++) {
			if (arvot.get(i) != arvot.get(i+1)-1) {
				return false;
			}
		}
		return true;
	}
	
	private static boolean onkoTaysKasi() {
		if (arvot.size() == 3 && arvot2.size() == 1) {
			return true;
		} else if (arvot.size() == 1 && arvot2.size() == 3) {
			return true;
		}
		return false;
	}
	
	private static boolean onkoVari(ArrayList<Kortti> kasikortit) {
		ArrayList<Integer> maat = new ArrayList<>();
		
		for (int i = 0; i<=4; i++) {
			maat.add(kasikortit.get(i).getMaa());
		}
		for (int i=0;i<4;i++) {
			if (maat.get(i) != maat.get(i+1)) {
				return false;
			}
		}
		return true;
	}

    private static boolean onkoVariSuora(ArrayList<Kortti> kasikortit) {
        if (onkoVari(kasikortit) == true && onkoSuora(kasikortit) == true) {
            return true;
        }
        return false;
    }

	public static String mikaMaa(int i) {
		String  maanimi = "";
		
		switch(i){
		case  0:
			maanimi = "Hertta";
			break;
		case  1:
			maanimi = "Ruutu";
			break;
		case  2:
			maanimi = "Pata";
			break;
		case  3:
			maanimi = "Risti";
			break;
		default:
			maanimi = "Ohjelmavirhe!!!";
		}
		return  maanimi;
	}
}