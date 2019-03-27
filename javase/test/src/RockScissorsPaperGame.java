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
        System.out.print("\n가위(0), 바위(1), 보(2) 선택하세요. : " );
        select = Integer.parseInt(in.readLine());
        comRandom();
        if(select<0 || select>2) {
            System.out.println("\n0~2 중 하나만 입력 가능합니다.\n");
            menu();
        }
    }
    public void game() throws Exception {
        System.out.println("==== 컴퓨터와 가위바위보 한판!!! ====");
        String result;
        while(true) {
            System.out.print("------------------------------------------------");
            menu();
            if((select+2)%3 == com)
                result = "이겼다";
            else if((select+1)%3 == com)
                result = "졌다";
            else
                result = "비겼다";
            System.out.println("\n나 : " + setStr(select) + "\t컴퓨터 : " + 
                                    setStr(com) + "\t결과 : " + result);
            exit();
        }
    }
    public void exit() throws Exception {
        int checkExit;
        System.out.print("\n게임 계속(1), 종료(0)을 입력하세요 : ");
        checkExit = Integer.parseInt(in.readLine());
        if(checkExit < 0 || checkExit > 1) {
            System.out.println("\n[0] 또는 [1]만 입력해주세요.");
            exit();
        }
        if(checkExit == 0) {
            System.out.println("프로그램을 종료합니다!!!");
            System.exit(0);
        }
    }
    public String setStr(int num) {
        switch(num) {
            case 0: return "가위";
            case 1: return "바위";
            case 2: return "보";
            default: return "오류입니다";
        }
    }

    public int getSelect() {
        return select;
    }
    public void setSelect() {
        select += 1;
    }
}
