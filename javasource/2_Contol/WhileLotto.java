/*
* lotto
1 ~ 3 ������ ���δٸ� ���� 3�� �߻�.
    3 1 2
    3 2 1
���ݴ� ȿ������ ���α׷����� ����
*/
public class WhileLotto {
    public static void main(String[] args) {
        int num1 = (int) Math.random() * 3 + 1;
        int num2 = (int) Math.random() * 3 + 1;
        int num3 = (int) Math.random() * 3 + 1;
        boolean result = true;
        while(result) {
            if(num2 == num1) {
            num2 = (int) Math.random() * 3 + 1;
            }
            if(num3 == num2) {
            num3 = (int) Math.random() * 3 + 1;
            result = false;
            }
            
        }
        System.out.println("���� ��÷ ��ȣ : " + num1 + " "+ num2 + " " + num3);
    }
}
