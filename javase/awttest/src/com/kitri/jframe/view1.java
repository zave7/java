package com.kitri.jframe;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class view1 extends JPanel {

	/**
	 * Create the panel.
	 */
	public view1() {
		setLayout(null);
		
		JButton btnNewButton = new JButton("메인화면");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(12, 10, 139, 23);
		add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("카테고리");
		btnNewButton_1.setBounds(22, 43, 129, 23);
		add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("전체");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_2.setBounds(48, 76, 103, 23);
		add(btnNewButton_2);
		
		JButton button = new JButton("티셔츠");
		button.setForeground(Color.BLACK);
		button.setBackground(Color.WHITE);
		button.setBounds(61, 98, 90, 23);
		add(button);
		
		JButton button_1 = new JButton("스웨터");
		button_1.setBounds(61, 122, 90, 23);
		add(button_1);
		
		JButton button_2 = new JButton("티셔츠");
		button_2.setBounds(61, 145, 90, 23);
		add(button_2);
		
		JButton button_3 = new JButton("티셔츠");
		button_3.setBounds(61, 167, 90, 23);
		add(button_3);
		
		JButton button_4 = new JButton("티셔츠");
		button_4.setBounds(61, 190, 90, 23);
		add(button_4);
		
		JButton button_5 = new JButton("티셔츠");
		button_5.setBounds(61, 211, 90, 23);
		add(button_5);

	}

}
