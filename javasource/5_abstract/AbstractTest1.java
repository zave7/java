import java.util.*;
public class AbstractTest1 {
    public static void main(String[] args) {
        //api������ ���� �׻� Ŭ���� ������ ������, ���̷�Ʈ ����Ŭ������ Ȯ��
        //1. ���� Ŭ���� ����
        //Calendar car = new GregorianCalendar();
        //2. �ڽ��� ��ü�� return �ϴ� static method.
        Calendar cal = Calendar.getInstance();
        int y = cal.get(Calendar.YEAR);
        int m = cal.get(Calendar.MONTH) + 1;
        int d = cal.get(Calendar.DAY_OF_MONTH);
        int h = cal.get(Calendar.HOUR_OF_DAY);
        int mi = cal.get(Calendar.MINUTE);
        int s = cal.get(Calendar.SECOND);
        System.out.println(y + "�� " + m + "�� " + d + "�� " + h + "�� " + mi + "�� " + s + "��");
    }
}
