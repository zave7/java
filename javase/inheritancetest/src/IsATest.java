import java.awt.*;
public class IsATest extends Frame{
    Button b1 = new Button(" click ");
    
    public IsATest() {
        super("Has A Test !");
        setLayout(new FlowLayout());
        //setLabel("눌러봐");
        b1.setBackground(new Color(123, 255, 125));
        add(b1);
        setSize(400, 300);
        setLocation(300,200);
        setVisible(true);
    }
    public static void main(String[] args) {
        IsATest hat = new IsATest();
    }
}
