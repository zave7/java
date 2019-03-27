package com.kitri.design;

import java.awt.*;

public class ListTest extends Frame {

	Panel pw = new Panel(new BorderLayout(0, 10));
	Panel pc = new Panel(new GridLayout(6, 1, 0, 10));
	Panel pe = new Panel(new BorderLayout(0, 10));
	List l1 = new List(20);
	List l2 = new List(20);
	TextField tfl = new TextField();
	TextField tfr = new TextField();
	Button btR = new Button("btR 한글");
	Button btRAll = new Button("btRAll");
	Button btL = new Button("btL");
	Button btLAll = new Button("btLAll");

	public ListTest() {
		l1.add("Mercury");
		l1.add("Venus");
		l1.add("Earth");
		l1.add("JavaSoft");
		l1.add("Mars");
		l1.add("Jupiter");
		l1.add("Saturn");
		l1.add("Uranus");
		l1.add("Neptune");
		l1.add("Pluto");
		pw.add(l1, "Center");
		pw.add(tfl, "South");
		pc.add(new Panel());
		pc.add(btL);
		pc.add(btLAll);
		pc.add(btR);
		pc.add(btRAll);
		pc.add(new Panel());

		pe.add(l2, "Center");
		pe.add(tfr, "South");
		setLayout(new BorderLayout(10, 0));
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
