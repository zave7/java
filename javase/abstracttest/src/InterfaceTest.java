import java.awt.*;
import java.awt.event.*;
public class InterfaceTest extends Frame implements WindowListener, ActionListener{
    Button b1 = new Button(" click ");
    
    public InterfaceTest() {
        super("Interface Test !");
        setLayout(new FlowLayout());
        //setLabel("눌러봐");
        b1.setBackground(new Color(123, 255, 125));
        add(b1);
        setSize(400, 300);
        setLocation(300,200);
        setVisible(true);
        
        b1.addActionListener(this);
        //WindowListener wl = new InterfaceTest();
        addWindowListener(this);
    }
    public void actionPerformed(ActionEvent e) {
        int r = (int)(Math.random() * 256);
        int g = (int)(Math.random() * 256);
        int b = (int)(Math.random() * 256);    
        setBackground(new Color(r, g, b));    
    }
    public void windowDeactivated(WindowEvent e) {
        
    }
    public void windowActivated(WindowEvent e) {
        
    }
    public void windowDeiconified(WindowEvent e) {
        
    }
    public void windowIconified(WindowEvent e) {
        
    }
    public void windowClosed(WindowEvent e) {
        
    }
    public void windowClosing(WindowEvent e) {
        System.exit(0);
    }
    public void windowOpened(WindowEvent e) {
        
    }
    

    public static void main(String[] args) {
        InterfaceTest hat = new InterfaceTest();
    }
}
