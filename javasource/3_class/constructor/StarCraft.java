public class StarCraft {
    public static void main(String[] args) {
        Marine my;
        Marine com;
        my = new Marine();
        com = new Marine();
        System.out.println("��ü�� : " + my.getHp() + " ��ü�� : " + com.getHp());
        //��ü�� : 100 ��ü�� : 100

        int count = 2;
        System.out.println("���� ���� " + count + "ȸ ����!!!!");
        my.attack(com, count);
        System.out.println("��ü�� : " + my.getHp() + " ��ü�� : " + com.getHp());
        // ��ü�� : 100 ��ü�� : 80

        count = 4;
        System.out.println("���� ���� " + count + "ȸ ����!!!!");
        com.attack(my, count);
        System.out.println("��ü�� : " + my.getHp() + " ��ü�� : " + com.getHp());
        // ��ü�� : 60 ��ü�� : 80
        
        System.out.println("��� ����!!!!");
        my.changeMode();
        System.out.println("��ü�� : " + my.getHp() + " ��ü�� : " + com.getHp());
        // ��ü�� : 35 ��ü�� : 80

        count = 3;
        System.out.println("���� ���� " + count + "ȸ ����!!!!");
        my.attack(com, count);
        System.out.println("��ü�� : " + my.getHp() + " ��ü�� : " + com.getHp());
        // ��ü�� : 35 ��ü�� : 35
        System.out.println("��� ����!!!!");
        my.changeMode();
        // ��� : ��� ���� �Ұ�~!!!!
        System.out.println("��ü�� : " + my.getHp() + " ��ü�� : " + com.getHp());
        // ��ü�� : 35 ��ü�� : 35

        count = 3;
        System.out.println("���� ���� " + count + "ȸ ����!!!!");
        my.attack(com, count);
        System.out.println("��ü�� : " + my.getHp() + " ��ü�� : " + com.getHp());
        // ��ü�� : 35 ��ü�� : die
    }
}
