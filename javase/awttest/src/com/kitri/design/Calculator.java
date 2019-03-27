package com.kitri.design;

import java.awt.*;

public class Calculator extends Frame{
	Panel pn = new Panel(new BorderLayout(5, 0));
	Panel pc = new Panel(new GridLayout(4, 4));
	
	Label numL = new Label("12345");
	
	Label OperL = new Label("계산");
	Button exit = new Button("종료");
	Button btn[] = new Button[16];
	String menu[] = {"7", "8", "9", "+", "4", "5", "6", "-", "1", "2", "3", "*", "0", "c", "=", "/"};
	public Calculator() {
		setLayout(new BorderLayout(0, 10));
		pn.add(numL, "Center");
		pn.add(OperL, "East");
		for (int i = 0; i < 16; i++) {
			pc.add(new Button(menu[i]));
		}
		add(pn, "North");
		add(pc, "Center");
		add(exit, "South");
		setBounds(300, 300, 300, 400);
		setVisible(true); 
		
		
		
	}
	public static void main(String[] args) {
		new Calculator();
	}
}