package com.kitri.event;

import java.awt.*;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;

public class FontColorChooser extends Frame {
	
	
	
	Panel pw = new Panel();
	Panel pw1 = new Panel();
	Panel pw2 = new Panel();
	Panel pw3 = new Panel();
	Panel pe = new Panel();
	Panel pen = new Panel();
	Panel pes = new Panel();
	Label r = new Label("빨강", Label.CENTER);
	Label g = new Label("초록", Label.CENTER);
	Label b = new Label("파랑", Label.CENTER);
	Scrollbar sr = new Scrollbar(Scrollbar.HORIZONTAL, 127, 10, 0, 265);
	Scrollbar sg = new Scrollbar(Scrollbar.HORIZONTAL, 127, 10, 0, 265);
	Scrollbar sb = new Scrollbar(Scrollbar.HORIZONTAL, 127, 10, 0, 265);
	Label colorL = new Label("color");
	Button button = new Button("확인"); 
	
	public FontColorChooser() {
		pw1.setLayout(new BorderLayout(10, 0));
//		r.setBackground(c);
		pw1.add(r, "West");
		pw1.add(sr, "Center");
		
		pw2.setLayout(new BorderLayout(10, 0));
		pw2.add(g, "West");
		pw2.add(sg, "Center");
		
		pw3.setLayout(new BorderLayout(10, 0));
		pw3.add(b, "West");
		pw3.add(sb, "Center");
		
		pw.setLayout(new GridLayout(5, 1, 0, 20));
		pw.add(new Label(""));
		pw.add(pw1);
		pw.add(pw2);
		pw.add(pw3);
		
		pes.setLayout(new BorderLayout(10, 0));
		r.setBackground(Color.red);
		g.setBackground(Color.green);
		b.setBackground(Color.blue);
		r.setForeground(Color.WHITE);
		g.setForeground(Color.WHITE);
		b.setForeground(Color.WHITE);
		pes.add(colorL, "Center");
		pes.add(button, "East");
		
		pe.setLayout(new BorderLayout(0, 10));
		pe.add(pen, "Center");
		pe.add(pes, "South");
		
		
		setLayout(new GridLayout(1, 2, 10, 0));
		add(pw);
		add(pe);
		
		setBounds(710, 300, 600, 300);
		
	}
}