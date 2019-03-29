package com.kitri.event;

import java.awt.*;
import java.awt.event.*;

public class ItemTest extends Frame{

//	1. Frame을 상속
//	2. 선언부에 필요한 객체 생성
//	3. 배치부에서 design(component 배치)
//	※ 작업은 소 >> 대
	//선언부

	Panel pn = new Panel(new GridLayout(2, 2));
	Panel ps = new Panel(new BorderLayout(5, 0));
	
	CheckboxGroup cbg = new CheckboxGroup();
	Checkbox menu1 = new Checkbox("아침", cbg, true);
	Checkbox menu2 = new Checkbox("점심", cbg, false);
	Checkbox menu3 = new Checkbox("저녁", cbg, false);
	Checkbox apple = new Checkbox("사과", true);
	Checkbox banana = new Checkbox("바나나");
	Checkbox st = new Checkbox("딸기");
	
	TextArea ta = new TextArea();
	Choice ch = new Choice();
	Button b = new Button("종료");
	ItemLogic logic;
//	---------------------------------------------------------------
//		//배치부
		public ItemTest() {
//		---------------------------------------------------------------
		pn.add(menu1);
		pn.add(menu2);
		pn.add(menu3);
		pn.add(apple);
		pn.add(banana);
		pn.add(st);
		ch.add("아침");
		ch.add("점심");
		ch.add("저녁");
		ps.add(ch, "Center");
		ps.add(b, "East");
		add(pn, "North");
		add(ta, "Center");
		add(ps, "South");
//		setLayout(new BorderLayout(0, 10));
		setBounds(300, 200, 300, 500);
		setVisible(true); // 배치부의 마지막에 비저블
		
		
		logic = new ItemLogic(this);
		b.addActionListener(logic);
		menu1.addItemListener(logic);
		menu2.addItemListener(logic);
		menu3.addItemListener(logic);
		apple.addItemListener(logic);
		banana.addItemListener(logic);
		st.addItemListener(logic);
		ch.addItemListener(logic);

	}
	public static void main(String[] args) {
		new ItemTest(); // 이름 없이 객체 생성
	}
}
