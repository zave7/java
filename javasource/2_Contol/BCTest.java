public class BCTest {
    public static void main(String[] args) {
        int count = 0;
        while (count<10) {
            count++;
            int number = (int) (Math.random() * 10);
            if(number == 0) {
                System.out.println("number�� 0�� ���Խ��ϴ�. \n ���α׷� �����մϴ�");
                break;
            }
            System.out.println("number = " + number);
        }
        System.out.println("------------------------------------------------------");
        count = 0;
        while (count<10) 
            count++;
            int number = (int) (Math.random() * 10);
            if(number == 0) {
                System.out.println("number�� 0�� ���Խ��ϴ� \n �������� �����մϴ�");
                continue;
            }
            System.out.println(count + ". number = " + number);
        }
    }
}