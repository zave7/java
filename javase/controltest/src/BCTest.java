public class BCTest {
    public static void main(String[] args) {
        int count = 0;
        while (count<10) {
            count++;
            int number = (int) (Math.random() * 10);
            if(number == 0) {
                System.out.println("number가 0이 나왔습니다. \n 프로그램 종료합니다");
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
                System.out.println("number가 0이 나왔습니다 \n 다음으로 진행합니다");
                //continue;
        }
        System.out.println(count + ". number = " + number);
    }
}