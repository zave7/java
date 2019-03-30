package com.kitri.calculator;

import java.awt.*;

public class Calculator extends Frame{
	
	Panel pn = new Panel(new BorderLayout());
	Panel pc = new Panel(new GridLayout(4, 4, 5, 5));
	
	Label numL = new Label("", Label.RIGHT);
	Label operL = new Label("", Label.CENTER);
	Button exit = new Button("exit");
	Button btn[] = new Button[16];
	String menu[] = {"7", "8", "9", "+", "4", "5", "6", "-", "1", "2", "3", "x", "0", "c", "=", "/"};
	
	public Calculator() {
		super("권영찬의 완벽한 계산기");
		operL.setBackground(new Color(210, 180, 140));
		pn.add(numL, "Center");
		pn.add(operL, "East");
		numL.setBackground(new Color(209,216,224));
		
		int n = 0;
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				Button b = new Button(menu[n]);
				b.setFont(new Font("맑은고딕", Font.BOLD, 16));
				b.setBackground(new Color((i+j)*37, 200, 255));
				b.setForeground(Color.WHITE);
				btn[n] = b;
				pc.add(b);
				n++;
			}
		}
		setLayout(new BorderLayout(0, 5));
		add(pn, "North");
		add(pc, "Center");
		add(exit, "South");
		setBounds(300, 300, 313, 420);
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