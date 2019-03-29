package com.kitri.event;

import java.awt.*;

public class Calculator extends Frame{
	
	Panel pn = new Panel(new BorderLayout(5, 0));
	Panel pc = new Panel(new GridLayout(4, 4, 5, 5));
	
	Label numL = new Label("", Label.RIGHT);
	Label OperL = new Label("", Label.CENTER);
	Button exit = new Button("exit");
	Button btn[] = new Button[16];
	
	String menu[] = {"7", "8", "9", "+", "4", "5", "6", "-", "1", "2", "3", "*", "0", "c", "=", "/"};
	public Calculator() {
		super("계산기");
		pn.add(numL, "Center");
		pn.add(OperL, "East");
		numL.setBackground(new Color(209,216,224));
		
		int n = 0;
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				Button b = new Button(menu[n]);
				b.setBackground(new Color((i+j)*27, 200, 255));
				b.setForeground(Color.WHITE);
				btn[n] = b;
				pc.add(b);
				n++;
			}
		}
//		for (int i = 0; i < 16; i++) {
//			Button b = new Button(menu[i]);
//			b.setBackground(new Color(i*9, 200, 255));
//			b.setForeground(Color.WHITE);
//			pc.add(b);
//			
//		}
		setLayout(new BorderLayout(0, 5));
		add(pn, "North");
		add(pc, "Center");
		add(exit, "South");
		setBounds(300, 300, 300, 400);
		setVisible(true);
		
		CalculatorController calculatorController = new CalculatorController(this);
		for (int i = 0; i < 16; i++) {
			btn[i].addActionListener(calculatorController);
		}
		exit.addActionListener(calculatorController);
		
		
	}
	public static void main(String[] args) {
		new Calculator();
	}
}