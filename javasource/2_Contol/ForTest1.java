public class ForTest1 {
	public static void main(String[] args) {
		/*
		for(int i=1; i<=10; i++) {
			System.out.print(i + "\t");
		}
        */
        //1~10 Ȧ����
        for(int i=1; i<=10; i+=2) {
            System.out.println(i + "  ");
        }
        //1~100 10�� ������ �ٹٲ�
        for(int i=1; i<=100; i++) {
            System.out.print(i+"  ");
            if(i%10==0) {
                System.out.println("\n");
            }
        }
	}
}
