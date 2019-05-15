/*
* lotto
1 ~ 3 까지의 서로다른 난수 3개 발생.
    3 1 2
    3 2 1
조금더 효율적인 프로그래밍을 하자
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
        System.out.println("금주 당첨 번호 : " + num1 + " "+ num2 + " " + num3);
    }
}
