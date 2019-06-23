public class ForPracticeProblem {
    public static void main(String[] args) {
        // 3. for 문을 이용해서 1부터 100까지의 정수 중에서 3의 배수의 총합을 구하는 코드를 작성
        System.out.print("3번.\n");
        int sum=0;
        for(int i=1; i<=100; i++) {
            if (i%3 == 0) {
                sum += i;
            }                       
        }
        System.out.println(sum);
        // 5. 중첩 for문을 이용하여 방정식 4x + 5y = 60 의 모든 해를 구해서 (x, y) 형태로 출력
        System.out.print("\n5번.\n");
        for(int i=1; i<=10; i++) {
            for(int j=1; j<=10; j++) {
                if(((4 * i) + (5 * j)) == 60) {
                    System.out.println("( " + i + ", " + j + " )");
                }
            }
        }
        // 6. for 문을 이용해서 실행 결과와 같은 삼각형을 출력하는 코드를 작성
        System.out.print("\n6번.\n");
        for(int i=1; i<=5; i++) {
            for(int j=1; j<=i; j++) {
                System.out.print("*");
            }
            System.out.print("\n");
        }
    }
}
