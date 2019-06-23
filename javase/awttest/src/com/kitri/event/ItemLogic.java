package com.kitri.event;

import java.awt.Checkbox;
import java.awt.event.*;

public class ItemLogic implements ActionListener, ItemListener{
	ItemTest itemtest;
	
	public ItemLogic(ItemTest it) {
		this.itemtest = it;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		System.exit(0);
	}
	
	@Override
	public void itemStateChanged(ItemEvent e) {
		Object event = e.getSource();
		System.out.println("안녕");
		if(event == itemtest.ch) {
			String str = itemtest.ch.getSelectedItem();
			System.out.println(str);
			if(str.equals("아침"))
				itemtest.menu1.setState(true);
			else if(str.equals("점심"))
				itemtest.menu2.setState(true);
			else if(str.equals("저녁"))
				itemtest.menu3.setState(true);
		}
		
		Checkbox sel = itemtest.cbg.getSelectedCheckbox();
		String selStr = sel.getLabel();
		System.out.println(selStr);
		itemtest.ta.setText("-----" + selStr + "-----");
		itemtest.ta.append("\n1. 사과 : " + eat(itemtest.apple.getState()));
		itemtest.ta.append("\n2. 바나나 : " + eat(itemtest.banana.getState()));
		itemtest.ta.append("\n3. 딸기 : "+ eat(itemtest.st.getState()));
		
		itemtest.ch.select(selStr);
	}
	private String eat(boolean flag) {
		return flag == true ? "먹었다" : "안먹었다";
	}
}
