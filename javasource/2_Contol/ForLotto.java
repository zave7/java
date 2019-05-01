/*
* lotto
1 ~ 3 까지의 서로다른 난수 3개 발생.
    3 1 2
    3 2 1
조금더 효율적인 프로그래밍을 하자
*/

public class ForLotto {
    public static void main(String[] args) {
        //int num1, num2, num3;
        int num1 = 0;
        int num2 = 0;
        int num3 = 0;
        num1 = (int)(Math.random() * 3 + 1);
        for(;;) {

            num2 = (int)(Math.random() * 3 + 1);
            if((num1 != num2)) {
                break;
            }
        }
        for(;;) {
            num3 = (int)(Math.random() * 3 + 1);
            if((num1 != num3) && (num2 != num3)) {
                break;
            }           
        }
        System.out.println("금주 당첨 번호 : " + num1 + " "+ num2 + " " + num3);
    }
}
