package com.kitri.jframe;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.CardLayout;

public class MainFrame extends JFrame implements ActionListener{

	JPanel panel = new JPanel();
	private JPanel contentPane;
	private JButton b1;
	private JButton b2;
	view1 v1 = new view1();
	view2 v2 = new view2();
	CardLayout card = new CardLayout();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainFrame() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 502, 477);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel.setLayout(card);
		panel.add("v2", v2);
		panel.add("v1", v1);
		panel.setBounds(12, 43, 472, 396);
		contentPane.add(panel);
		//panel.setLayout(new CardLayout(0, 0));
		
		b1 = new JButton("제품검색");
		b1.setBounds(12, 10, 103, 23);
		contentPane.add(b1);
		
		b2 = new JButton("회원정보");
		b2.setBounds(127, 10, 103, 23);
		contentPane.add(b2);
		b1.addActionListener(this);
		b2.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object ob = e.getSource();
		System.out.println("log");
		if(ob == b1) {
			card.show(panel, "v1");
		} else if(ob == b2) {
			card.show(panel, "v2");
		}
	}
}
