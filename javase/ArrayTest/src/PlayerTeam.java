//0 ����Ÿ��
//1 ����
//2 ����
//3 1���
//4 2���
//5 3���
//6 ���ݼ�
//7 ���ͼ�
//8 �߰߼�
//9 ���ͼ�
//Ÿ�� : Ÿ��
//���� : �����
public class PlayerTeam {
	public static void main(String[] args) {
		
		PlayerDto player[] = new PlayerDto[5];
		PlayerDto t1 = new PlayerDto(24,"�����", 4, 0.321);
		PlayerDto t2 = new PlayerDto(13, "����", 5, 0.351);
		PlayerDto t3 = new PlayerDto(34, "�����", 1, 0.001);
		PlayerDto t4 = new PlayerDto(9, "�丣������", 3, 0.421);
		PlayerDto t5 = new PlayerDto(38, "�����", 7, 0.384);
		player[0] = t1;
		player[1] = t2;
		player[2] = t3;
		player[3] = t4;
		player[4] = t5;
		
		int len = player.length; //for������ �ѹ��� ������ ���� ������ �����ؼ� ��
		for (int i = 0; i < len; i++) {
			System.out.println(player[i]);
		}
	}
}
