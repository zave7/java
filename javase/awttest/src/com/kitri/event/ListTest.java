package com.kitri.event;

import java.awt.*;
import java.awt.event.*;

public class ListTest extends Frame implements ActionListener{

	Panel pw = new Panel();
	Panel pc = new Panel();
	Panel pe = new Panel();
	List l1 = new List(1);
	List l2 = new List(1, true);
	TextField tfl = new TextField();
	TextField tfr = new TextField();
	Button btR = new Button("btR");
	Button btRAll = new Button("btRAll");
	Button btL = new Button("btL");
	Button btLAll = new Button("btLAll");

	public ListTest() {
		super("리스트입니다");
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

		tfl.addActionListener(this);
		tfr.addActionListener(this);
		btR.addActionListener(this);
		btRAll.addActionListener(this);
		btL.addActionListener(this);
		btLAll.addActionListener(this);
	}

	public static void main(String[] args) {
		new ListTest();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj == tfl) {
//			1. tfl의 값 get
//			2. 리스트에 add 하고 tfl 값 없애기
//			3.
			String str1 = tfl.getText();
			String str2 = str1.trim();
			if (!str2.isEmpty()) {
				l1.add(str1);
				tfl.setText("");
			}
		} else if (obj == tfr) {

			String str1 = tfr.getText();
			String str2 = str1.trim();
			if (!str2.isEmpty()) {
				l2.add(str1);
				tfr.setText("");
			}

		} else if (obj == btR) {
//			1. 선택한 아이템 문자열 가져오기
//			2. 오른쪽 리스트에 추가
//			3. 1의 값을 리스트에서 제거
			String str = l1.getSelectedItem();
			if (str == null) {
				return;
			}
			l2.add(str);
			l1.remove(str);

		} else if (obj == btRAll) {
//			1. 왼쪽리스트 문자열 모두 가져오기
			String str[] = l1.getItems();
//			2. 1값을 오른쪽 리스트에 모두 추가
			int len = str.length;
			for (int i = 0; i < len; i++) {
				l2.add(str[i]);
			}
//			3. 왼쪽리스트 문자열 모두 제거
//			System.out.println(l1.getItemCount());
//			for (int i = l1.getItemCount()-1; i >= 0; i--) {
//				l1.remove(i);
//			}
			l1.removeAll();
		} else if (obj == btL) {
			String str = l2.getSelectedItem();
			if (str == null) {
				return;
			}
			l1.add(str);
			l2.remove(str);
		} else if (obj == btLAll) {
//			1. 선택되어있는 애들의 값 get
			int sel[] = l2.getSelectedIndexes();
			if (sel.length > 0) {
//			2. 가져온 인덱스를 바탕으로 문자열을 왼쪽 리스트에 추가
				int len = sel.length;
				for (int i = 0; i < len; i++) {
					l1.add(l2.getItem(sel[i]));
					System.out.println(sel[i]);
				}
//			3. 오른쪽 선택되었던 리스트 모두 제거
				for (int i = len - 1; i >= 0; i--) {
					l2.remove(sel[i]);
				}
			} else {
//			-----------아무것도 선택하지 않았을 경우-------------
//			1. 왼쪽리스트 문자열 모두 가져오기
				String str[] = l2.getItems();
//			2. 1값을 오른쪽 리스트에 모두 추가
				int len = str.length;
				for (int i = 0; i < len; i++) {
					l1.add(str[i]);
				}
//			3. 왼쪽리스트 문자열 모두 제거
//			System.out.println(l1.getItemCount());
//			for (int i = l1.getItemCount()-1; i >= 0; i--) {
//				l1.remove(i);
//			}
				l2.removeAll();
			}
		}

	}
}
