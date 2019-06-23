public class MultipleCheck {
    static int count2 = 0;
    static int count3 = 0;
    static int count5 = 0;
    public static void main(String[] args) {

        int n = 20;
        System.out.println("반복 횟수를 입력하세요 : " + n);
        for(int i = 1; i<=n; i++) {
            System.out.print(i + ". ");
            if2ModZero(i);
            if3ModZero(i);
            if5ModZero(i);
            System.out.print("\n");
        }
        System.out.println("===== 출력 횟수 =====");
        System.out.println("2의 배수 : " + count2);
        System.out.println("3의 배수 : " + count3);
        System.out.println("5의 배수 : " + count5);
    }
        
    static void if2ModZero(int n) {
        if(n % 2 == 0) {
            System.out.print("2의 배수 ");
            count2++;
        }
    }
        
    static void if3ModZero(int n) {
        if(n % 3 == 0) {
            System.out.print("3의 배수 ");
            count3++;
        }
    }

    static void if5ModZero(int n) {
        if(n % 5 == 0) {
            System.out.print("5의 배수");
            count5++;
        }
    }

}
