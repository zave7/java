import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//0. com, my 3�ڸ� �迭
//1. com ���ڸ� ���� �߻�. >> comRandom()
//2. 1.�� ���ڴ� �ߺ����� x 
//			0���� ���� x
//3. ���� �Է��� 3�ڸ� ���ڸ� My�迭�� �ֱ�
//4. com�� My ���ڿ� �ڸ���
//5. ���ڰ� ���ٸ� 
//	5-1 �ڸ��� ���ٸ� strike ����
//	5-2 �ڸ��� �ٸ��ٸ� ball ����
//6. 5�� ���
//	6-1 strike�� 3 : 
//	xxx�� x��° ���� �����Դϴ�. 
//	���(1), ����(0) : 
//	6-2 strike�� 3�� �ƴ϶�� 
//	1. xxx�� x��Ʈ����ũ x�� �Դϴ�  >>  3������
public class NumberBaseball {
	private int my[] = new int[3];
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
			System.out.print("���� �Է� : ");
			int myNum = getNumber();
			count++;
			my[0] = myNum / 100;
			my[1] = (myNum / 10) % 10; 
			my[2] = myNum % 10; 
			
			//���ڿ� �ڸ��� ��
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
			//���
			if(strike != 3) {
				System.out.println(myNum + "�� " + strike + " ��Ʈ����ũ " + ball + " �� �Դϴ�.");
				strike=0;
				ball=0;
			} else {
				System.out.println(myNum + " ��" + count + "���� �����Դϴ�.");
				System.out.print("��� (1), ���� (0) : ");
				if(getNumber()==0) {
					System.out.println("������ �����մϴ�.");
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