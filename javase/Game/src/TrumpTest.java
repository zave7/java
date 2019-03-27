
public class TrumpTest {

	public static void main(String[] args) {
		TrumpCard t = new TrumpCard();
		int i;
		char[] result;
		for(i = 0; i < 52; i++) {
		result = t.getTrumpCard();
		System.out.println(i + "번째 " + result[0] + " : " + result[1]);
		
		
		}
		System.out.println("마지막 : " + i);
//		System.out.println((int) (Math.random() * 4));
	}
}