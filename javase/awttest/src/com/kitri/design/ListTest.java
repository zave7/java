package com.kitri.design;

import java.awt.*;

public class ListTest extends Frame {

	Panel pw = new Panel();
	Panel pc = new Panel();
	Panel pe = new Panel();
	List l1 = new List(20);
	List l2 = new List(20);
	TextField tfl = new TextField();
	TextField tfr = new TextField();
	Button btR = new Button("▷");
	Button btRAll = new Button("▶");
	Button btL = new Button("◁");
	Button btLAll = new Button("◀");

	public ListTest() {
//		l1.add("Mercury");
//		l1.add("Venus");
//		l1.add("Earth");
//		l1.add("JavaSoft");
//		l1.add("Mars");
//		l1.add("Jupiter");
//		l1.add("Saturn");
//		l1.add("Uranus");
//		l1.add("Neptune");
//		l1.add("Pluto");
		pw.setLayout(new BorderLayout(0, 10));
		pw.add(l1, "Center");
		pw.add(tfl, "South");
		pc.setLayout(new GridLayout(6, 1, 0, 10));
		pc.add(new Panel());
		pc.add(btL);
		pc.add(btLAll);
		pc.add(btR);
		pc.add(btRAll);
//		pc.add(new Panel());
		pe.setLayout(new BorderLayout(0, 10));
		pe.add(l2, "Center");
		pe.add(tfr, "South");
		setLayout(new GridLayout(1, 3, 10, 0));
		add(pw, "West");
		add(pc, "Center");
		add(pe, "East");
		setBounds(300, 300, 400, 500);
		setVisible(true);
	}

	public static void main(String[] args) {
		new ListTest();
	}
}
