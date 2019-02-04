import java.util.ArrayList;
import java.util.Collections;


public class Testi { // luokka, jolla testattu metodeja tarpeen mukaan.
	private static ArrayList<Kortti> kasikortit = new ArrayList<>();
	private static String maanimi = "";
	private static int arvo = 0, maa;
	
	public static void main(String[] args) {
		
		for (int i = 0; i<=4;i++) {
			Kortti k = new Kortti();
			maanimi = "Hertta";
			arvo = i;
			k.setMaanimi(maanimi);
			k.setArvo(arvo);
			kasikortit.add(k);
			System.out.println(kasikortit.get(i).getArvo() + ", " + arvo +"\n"
					+ kasikortit.get(i).getMaanimi());
		}
		System.out.println();
		System.out.println(onkoSuora(kasikortit));
		System.out.println(onkoVari(kasikortit));
		System.out.println(onkoVariSuora(kasikortit));
		System.out.println();
	
		kasikortit.clear();
		for (int i = 0; i<=4;i++) {
			Kortti k = new Kortti();
			if (i==1) {
				maa=0;
				arvo = i+1;
			} else {
			maa = 3;
			arvo = i;
			}
			k.setMaa(maa);
			k.setMaanimi(mikaMaa(maa));
			k.setArvo(arvo);
			kasikortit.add(k);
			System.out.println(kasikortit.get(i).getArvo() + ", " + arvo +"\n"
					+ kasikortit.get(i).getMaanimi());
		}
		System.out.println();
		System.out.println(onkoSuora(kasikortit));
		System.out.println(onkoVari(kasikortit));
		System.out.println(onkoVariSuora(kasikortit));
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