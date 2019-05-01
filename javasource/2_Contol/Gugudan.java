public class Gugudan {
    public static void main(String[] args) {
        System.out.println("****************************************** 备备窜1 ******************************************");

        for(int x=1; x<10; x++) {
            for(int y=2; y<10; y++) {
                System.out.print(y + " * " + x +" = " + y * x + "  ");
            }
            System.out.println("\n");
        }
        System.out.println("****************************************** 备备窜2 ******************************************");

        for(int x=2; x<10; x++) {
            for(int y=1; y<10; y++) {
                System.out.print(x + " * " + y + " = " + x * y + "  ");
            }
            System.out.println("\n");
        }
    }
}