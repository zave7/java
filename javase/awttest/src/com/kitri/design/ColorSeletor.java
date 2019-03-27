package com.kitri.design;

import java.awt.*;

public class ColorSeletor extends Frame{
	
	
	
	Panel pw = new Panel(new GridLayout(3, 1));
	Panel pwn = new Panel();
	Panel pwc = new Panel(new GridLayout(3, 2));
	Panel pws = new Panel();
	Panel pe = new Panel(new BorderLayout());
	Panel pen = new Panel();
	Panel pes = new Panel(new BorderLayout());
	Label r = new Label("빨강", Label.CENTER);
	Label g = new Label("초록", Label.CENTER);
	Label b = new Label("파랑", Label.CENTER);
	Label colorL = new Label("color");
	Scrollbar rr = new Scrollbar(Scrollbar.HORIZONTAL, 0, 10, 0, 256);
	Scrollbar rg = new Scrollbar(Scrollbar.HORIZONTAL, 0, 10, 0, 256);
	Scrollbar rb = new Scrollbar(Scrollbar.HORIZONTAL, 0, 10, 0, 256);
	Button button = new Button("확인"); 
	
	public ColorSeletor() {
		pwc.add(r);
		pwc.add(rr);
		pwc.add(g);
		pwc.add(rg);
		pwc.add(b);
		pwc.add(rb);
		
		pw.add(pwn);
		pw.add(pwc);
		pw.add(pws);
		
		pes.add(colorL, "Center");
		pes.add(button, "East");
		
		pe.add(pen, "Center");
		pe.add(pes, "South");
		
		setLayout(new GridLayout(1, 2));
		add(pw);
		add(pe);
		
		setBounds(300, 300, 300, 400);
		setVisible(true);
	}
	public static void main(String[] args) {
		new ColorSeletor();
	}
}