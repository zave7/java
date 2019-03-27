import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//0. com, my 3자리 배열
//1. com 세자리 난수 발생. >> comRandom()
//2. 1.의 숫자는 중복숫자 x 
//			0으로 시작 x
//3. 내가 입력한 3자리 숫자를 My배열에 넣기
//4. com과 My 숫자와 자리비교
//5. 숫자가 같다면 
//	5-1 자리수 같다면 strike 증가
//	5-2 자리수 다르다면 ball 증가
//6. 5의 결과
//	6-1 strike가 3 : 
//	xxx는 x번째 만에 정답입니다. 
//	계속(1), 종료(0) : 
//	6-2 strike가 3이 아니라면 
//	1. xxx는 x스트라이크 x볼 입니다  >>  3번으로
public class NumberBaseball {
	private int my[] = new int[3]; //선언부에서 값을 할당한는 것 보다는 생성자에서
	private int com[] = new int[3];
	BufferedReader in;
	
	public NumberBaseball() {
		comRandom();
		in = new BufferedReader(new InputStreamReader(System.in));
	}


	private void comRandom() {
		
		com[0] = (int)(Math.random() * 9 + 1);
		do {
			com[1] = (int)(Math.random() * 10);
		} while (com[0] == com[1]);
		do {
			com[2] = (int)(Math.random() * 10);
		} while (com[0] == com[2] || com[1] == com[2]);

		
	}


	public static void main(String[] args) {
		NumberBaseball nbb = new NumberBaseball();
		nbb.game();
	}


	public void game() {
		int strike = 0;
		int ball = 0;
		int count = 0;
		while(true) {
			System.out.print("숫자 입력 : ");
			int myNum = getNumber();
			my[0] = myNum / 100;
			my[1] = (myNum / 10) % 10; 
			my[2] = myNum % 10; 
			
			//숫자와 자릿수 비교
			int comLen = com.length;
								   
			int myLen = my.length; 
								   
			for (int c = 0; c < comLen; c++) {
				for (int m = 0; m < myLen; m++) {
					if (com[c] == my[m]) {
						if(c==m) {
							strike++;
						} else {
							ball++;
						}
						break;
					}
				}
			}
			count++;
			//경과
			if(strike != 3) {
				System.out.println(myNum + "는 " + strike + " 스트라이크 " + ball + " 볼 입니다.");
				strike=0;
				ball=0;
			} else {
				System.out.println(myNum + " 는" + count + "만에 정답입니다.");
				System.out.print("계속 (1), 종료 (0) : ");
				if(getNumber()==0) {
					System.out.println("게임을 종료합니다.");
					break;
				}
				count=0;
				comRandom();
			}
		}
	}
	private int getNumber() {
		int num = 0;
//		do {
			try {
				num = Integer.parseInt(in.readLine());
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
//		}while();
		return num;
	}
}