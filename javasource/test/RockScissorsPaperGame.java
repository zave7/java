import java.io.*;
public class RockScissorsPaperGame {

    private int com;
    private int select;
    private String myStr;
    private String comStr;
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    private void comRandom() {
        com = (int)(Math.random() * 10) % 3;
    }
    public void menu() throws Exception {
        System.out.print("\n����(0), ����(1), ��(2) �����ϼ���. : " );
        select = Integer.parseInt(in.readLine());
        comRandom();
        if(select<0 || select>2) {
            System.out.println("\n0~2 �� �ϳ��� �Է� �����մϴ�.\n");
            menu();
        }
    }
    public void game() throws Exception {
        System.out.println("==== ��ǻ�Ϳ� ���������� ����!!! ====");
        String result;
        while(true) {
            System.out.print("------------------------------------------------");
            menu();
            if((select+2)%3 == com)
                result = "�̰��";
            else if((select+1)%3 == com)
                result = "����";
            else
                result = "����";
            System.out.println("\n�� : " + setStr(select) + "\t��ǻ�� : " + 
                                    setStr(com) + "\t��� : " + result);
            exit();
        }
    }
    public void exit() throws Exception {
        int checkExit;
        System.out.print("\n���� ���(1), ����(0)�� �Է��ϼ��� : ");
        checkExit = Integer.parseInt(in.readLine());
        if(checkExit < 0 || checkExit > 1) {
            System.out.println("\n[0] �Ǵ� [1]�� �Է����ּ���.");
            exit();
        }
        if(checkExit == 0) {
            System.out.println("���α׷��� �����մϴ�!!!");
            System.exit(0);
        }
    }
    public String setStr(int num) {
        switch(num) {
            case 0: return "����";
            case 1: return "����";
            case 2: return "��";
            default: return "�����Դϴ�";
        }
    }

    public int getSelect() {
        return select;
    }
    public void setSelect() {
        select += 1;
    }
}
