import java.awt.*;
import java.awt.event.*;
public class AbstractTest3 extends Frame{
    Button b1 = new Button(" click ");
    
    public AbstractTest3() {
        super("Has A Test !");
        setLayout(new FlowLayout());
        // setLabel("눌러봐");
        b1.setBackground(new Color(123, 255, 125));
        add(b1);
        setSize(400, 300);
        setLocation(300,200);
        setVisible(true);
        WindowListener wl = new WindowAdapter(){
        // WindowAdapter wl = new WindowAdapter() 이렇게 해도 상관없음
                                public void windowClosing(WindowEvent e) {
                                    System.exit(0);
                                }
                                public void windowIconified(WindowEvent e) {
                                    System.out.println("아이콘화!!");
                                }
                            };
        addWindowListener(wl);// 추상클래스인데 추상메소드가 없는 클래스는 하나 이상의 메소드만 오버라이드 하면 된다
    }
    public static void main(String[] args) {
        AbstractTest3 hat = new AbstractTest3();
    }
}