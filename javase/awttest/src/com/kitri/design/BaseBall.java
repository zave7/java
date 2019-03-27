package com.kitri.design;

import java.awt.*;

public class BaseBall extends Frame{
	
	Panel pw = new Panel(new BorderLayout(0, 10));
	Panel pe = new Panel(new GridLayout(5, 1));
	Panel pwn = new Panel(new BorderLayout());
	Panel pws = new Panel(new BorderLayout());
	Button b1 = new Button("새게임");
	Button b2 = new Button("지우기");
	Button b3 = new Button("정  답");
	Button b4 = new Button("글자색");
	Button b5 = new Button("종료");
	TextArea ta = new TextArea();
	TextField tf = new TextField();
	Label l = new Label("숫자");
	public BaseBall() {
		pe.add(b1);
		pe.add(b2);
		pe.add(b3);
		pe.add(b4);
		pe.add(b5);
		
		pwn.add(ta, "Center");
		pws.add(l, "West");
		pws.add(tf, "Center");
		pw.add(pwn, "Center");
		pw.add(pws, "South");
		setLayout(new BorderLayout(10, 0));
		add(pe, "East");
		add(pw, "Center");
		
		setBounds(300, 300, 400, 400);
		setVisible(true);
		
	}
	public static void main(String[] args) {
		new BaseBall();
	}
}
