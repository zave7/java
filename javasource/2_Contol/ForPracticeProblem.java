public class ForPracticeProblem {
    public static void main(String[] args) {
        // 3. for ���� �̿��ؼ� 1���� 100������ ���� �߿��� 3�� ����� ������ ���ϴ� �ڵ带 �ۼ�
        System.out.print("3��.\n");
        int sum=0;
        for(int i=1; i<=100; i++) {
            if (i%3 == 0) {
                sum += i;
            }                       
        }
        System.out.println(sum);
        // 5. ��ø for���� �̿��Ͽ� ������ 4x + 5y = 60 �� ��� �ظ� ���ؼ� (x, y) ���·� ���
        System.out.print("\n5��.\n");
        for(int i=1; i<=10; i++) {
            for(int j=1; j<=10; j++) {
                if(((4 * i) + (5 * j)) == 60) {
                    System.out.println("( " + i + ", " + j + " )");
                }
            }
        }
        // 6. for ���� �̿��ؼ� ���� ����� ���� �ﰢ���� ����ϴ� �ڵ带 �ۼ�
        System.out.print("\n6��.\n");
        for(int i=1; i<=5; i++) {
            for(int j=1; j<=i; j++) {
                System.out.print("*");
            }
            System.out.print("\n");
        }
    }
}
