import java.awt.*;
public class HasATest {
    
    Frame f = new Frame("Has A Test !");
    Button b = new Button(" click ");
    
    public HasATest() {
        f.setLayout(new FlowLayout());
        //b.setLabel("������");
        f.add(b);
        f.setSize(400, 300);
        //f.setTitle("Has A Test !");
        f.setLocation(300,200);
        f.setVisible(true);
    }
    public static void main(String[] args) {
        HasATest hat = new HasATest();
    }
}