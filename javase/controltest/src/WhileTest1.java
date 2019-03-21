public class WhileTest1 {
    public static void main(String[] args) {
        System.out.println("1-10 까지 출력");
        int i = 0;
        while(i < 10) {
            System.out.println(++i);
        }
        System.out.println("1-10 까지의 난수를 발생");
        boolean flag = true;
        int n=0;
        while(flag) {
            int number = (int) (Math.random() * 11);
            n++;
            if(number != 0) {
                System.out.println("number == " + number);
            } else {
                System.out.println("0이 발생(" + n + "번째)되어 프로그램을 종료합니다");
                flag = false;
            }
        }
    }
}