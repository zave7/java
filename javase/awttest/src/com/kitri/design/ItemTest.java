package com.kitri.design;

import java.awt.*;

public class ItemTest extends Frame{

//	1. Frame을 상속
//	2. 선언부에 필요한 객체 생성
//	3. 배치부에서 design(component 배치)
//	※ 작업은 소 >> 대
	//선언부

	Panel pn = new Panel(new GridLayout(2, 2));
	Panel ps = new Panel(new GridLayout(1, 3));
	
	CheckboxGroup cbg = new CheckboxGroup();
	Checkbox cb = new Checkbox();
	TextArea ta = new TextArea();
	Choice ch = new Choice();
	Button b = new Button("종료");
	Dimension ds = new Dimension(300, 250);
	String m1 = "사과";
	String m2 = "바나나";
	String m3 = "딸기";
//	---------------------------------------------------------------
//		//배치부
		public ItemTest() {
//		---------------------------------------------------------------
		pn.add(new Checkbox("아침", cbg, true));
		pn.add(new Checkbox("점심", cbg, false));
		pn.add(new Checkbox("저녁", cbg, false));
		pn.add(new Checkbox(m1, true));
		pn.add(new Checkbox(m2, false));
		pn.add(new Checkbox(m3, false));
		ch.add(m1);
		ch.add(m2);
		ch.add(m3);
		ch.setSize(ds);
		ps.add(ch);
		ps.add(b);
		add(pn, "North");
		add(ta, "Center");
		add(ps, "South");
//		setLayout(new BorderLayout(0, 10));
		setBounds(300, 200, 300, 500);
		setVisible(true); // 배치부의 마지막에 비저블

	}
	public static void main(String[] args) {
		new ItemTest(); // 이름 없이 객체 생성
	}
}
