
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//0. com, my 3�ڸ� �迭.
//1. com ���ڸ� ���� �߻�. >> comRandom()
//2. 1�� ���ڴ� �ߺ� ���� X
//            0���� ���� X
//3. ���� �Է��� 3�ڸ����ڸ� my �迭�� �ֱ�
//4. com�� my�� ���ڿ� �ڸ���
//5. ���ڰ� ���ٸ�
//  5-1. �ڸ��� ���ٸ� strike ����
//  5-2. �ڸ��� �ٸ��ٸ� ball ����.
//6. 5�� ���
//  6-1. strike�� 3 : 
//	xxx�� x��°���� �����Դϴ�. 
//	���(1), ����(0) : 
//  6-2. strike�� 3�� �ƴ϶��
//   1. xxx�� x��Ʈ����ũ x���Դϴ�. >> 3������


public class NumberBaseball2 {
	
	private int my[];
	private int com[];
	BufferedReader in;
	int gameLength;
	
	public NumberBaseball2() {
		gameLength = 3;
		my = new int[gameLength];
		com = new int[gameLength];
		comRandom();
		in = new BufferedReader(new InputStreamReader(System.in));
	}
	
	private void comRandom() {
		com[0] = (int) (Math.random() * 9) + 1;	
		do {
			com[1] = (int) (Math.random() * 10);
		}while (com[0] == com[1]);
		do {
			com[2] = (int) (Math.random() * 10);
		}while (com[0] == com[2] || com[1] == com[2]);	
		System.out.println("���� : " + com[0] + com[1] + com[2]);
	}
	
	private void game() {
		int count = 0;
		int strike;
		int ball;
		while(true) {
			strike = 0;
			ball = 0;
			System.out.print("�����Է� : ");
			int myNum = getNumber();//149
			my[0] = myNum / 100;//1
			my[1] = myNum / 10 % 10;//4
			my[2] = myNum % 10;//9
			
//			���ڿ� �ڸ��� ��
//			328		149
			for (int m = 0; m < gameLength; m++) {
				for (int c = 0; c < gameLength; c++) {
					if(my[m] == com[c]) { //���� ���ڶ��..
						if(m == c)//�ڸ��� ���ٸ�...
							strike++;
						else
							ball++;
					}
				}
			}
			count++;
			
			
//			���
			if(strike == 3) {
				System.out.println(myNum + "�� " + count + "������ �����Դϴ�.");
				System.out.print("���(1), ����(0) : ");
				int num = getNumber();
				if(num == 1) {
					comRandom();
//					strike = 0;
//					ball = 0;
					count = 0;
				} else {
					System.out.println("���α׷��� �����մϴ�.!!!");
					System.exit(0);
				}
			} else {
				System.out.println(count + ". " + myNum + "�� " + strike + "��Ʈ����ũ " + ball + "���Դϴ�.");
			}
		}
	}
	
	private int getNumber() {
		int num = 0;
		try {
			num = Integer.parseInt(in.readLine());
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return num;
	}

	public static void main(String[] args) {
		NumberBaseball2 nbb = new NumberBaseball2();
		nbb.game();
	}
}