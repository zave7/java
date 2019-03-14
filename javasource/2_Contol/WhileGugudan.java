public class WhileGugudan {
    public static void main(String[] args) {
        int j = 1;
        while(j < 10) {
            int i = 2;
            while (i < 10) {
                System.out.print(i + " * " + j + " = " + i * j + "  ");
                i++;
            }
            System.out.print("\n");
            j++;
        }
    }
}
