import java.awt.*;
import java.awt.event.*;
public class AbstractTest3 extends Frame{
    Button b1 = new Button(" click ");
    
    public AbstractTest3() {
        super("Has A Test !");
        setLayout(new FlowLayout());
        // setLabel("������");
        b1.setBackground(new Color(123, 255, 125));
        add(b1);
        setSize(400, 300);
        setLocation(300,200);
        setVisible(true);
        WindowListener wl = new WindowAdapter(){
        // WindowAdapter wl = new WindowAdapter() �̷��� �ص� �������
                                public void windowClosing(WindowEvent e) {
                                    System.exit(0);
                                }
                                public void windowIconified(WindowEvent e) {
                                    System.out.println("������ȭ!!");
                                }
                            };
        addWindowListener(wl);// �߻�Ŭ�����ε� �߻�޼ҵ尡 ���� Ŭ������ �ϳ� �̻��� �޼ҵ常 �������̵� �ϸ� �ȴ�
    }
    public static void main(String[] args) {
        AbstractTest3 hat = new AbstractTest3();
    }
}