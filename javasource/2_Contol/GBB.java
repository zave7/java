/*
* 가위 바위보 게임.
  1. 0 (가위), 1 (바위), 2 (보)
  2. 컴 : 난수(0, 1, 2)
  3. 결과 Logic (이기거나, 지거나, 비기거나)
  4. 결과 출력
  		2 보          -
				이 1  1
		        지 0  2
		1 바위
				이 0  0
				지 2  -1
		0 가위
				이 2  -2
				지 1  -1
  		나 : 보, 컴 : 바위, 결과 : 이겼다
		나 : 보, 컴 : 가위, 결과 : 졌다
		나 : 보, 컴 : 보, 결과 : 비겼다
*/
public class GBB {
	public static void main(String[] args) {
		int my = 0;
		int com = (int) (Math.random() * 3);
		String smy;
		String scom;
		String result;
			//내가 푼 방식
			if(((my+1) % 3) == com) {
				result = "졌다";
			} else if(((my+2) % 3) == com) {
				result = "이겼다";
			} else {
				result = "비겼다";
			}
			//강사님이 푼 방식
			if((my - com +2) % 3 == 0) {

			} else if((my - com +2) % 3 == 1) {
			
			} else {
			
			}
			switch(my) {
				case 0 : smy = "가위"; break;
				case 1 : smy = "바위"; break;
				default : smy = "보";
			}
			switch(com) {
				case 0 : scom = "가위"; break;
				case 1 : scom = "바위"; break;
				default : scom = "보";
			}
		System.out.println("나 : " + smy + "\n컴 : " + scom + "\n결과 : " + result);

	}
}