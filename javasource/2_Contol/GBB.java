/*
* ���� ������ ����.
  1. 0 (����), 1 (����), 2 (��)
  2. �� : ����(0, 1, 2)
  3. ��� Logic (�̱�ų�, ���ų�, ���ų�)
  4. ��� ���
  		2 ��          -
				�� 1  1
		        �� 0  2
		1 ����
				�� 0  0
				�� 2  -1
		0 ����
				�� 2  -2
				�� 1  -1
  		�� : ��, �� : ����, ��� : �̰��
		�� : ��, �� : ����, ��� : ����
		�� : ��, �� : ��, ��� : ����
*/
public class GBB {
	public static void main(String[] args) {
		int my = 0;
		int com = (int) (Math.random() * 3);
		String smy;
		String scom;
		String result;
			//���� Ǭ ���
			if(((my+1) % 3) == com) {
				result = "����";
			} else if(((my+2) % 3) == com) {
				result = "�̰��";
			} else {
				result = "����";
			}
			//������� Ǭ ���
			if((my - com +2) % 3 == 0) {

			} else if((my - com +2) % 3 == 1) {
			
			} else {
			
			}
			switch(my) {
				case 0 : smy = "����"; break;
				case 1 : smy = "����"; break;
				default : smy = "��";
			}
			switch(com) {
				case 0 : scom = "����"; break;
				case 1 : scom = "����"; break;
				default : scom = "��";
			}
		System.out.println("�� : " + smy + "\n�� : " + scom + "\n��� : " + result);

	}
}