package com.kitri.temp;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Color;

public class Chat extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Chat frame = new Chat();
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
	public Chat() {
		setTitle("즐거운 채팅..");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 356);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 190, 255));
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JList list = new JList();
		list.setBounds(310, 10, 102, 201);
		panel.add(list);
		
		JButton rename = new JButton("대화명변경");
		rename.setBounds(310, 214, 102, 28);
		panel.add(rename);
		
		JButton paper = new JButton("쪽지보내기");
		paper.setBounds(310, 245, 102, 28);
		panel.add(paper);
		
		JButton close = new JButton("나가기");
		close.setBounds(310, 276, 102, 28);
		panel.add(close);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(12, 10, 291, 234);
		panel.add(textArea);
		
		textField = new JTextField();
		textField.setBounds(12, 249, 291, 24);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(72, 278, 231, 24);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel whom = new JLabel("귓속말");
		whom.setHorizontalAlignment(SwingConstants.CENTER);
		whom.setBounds(12, 280, 51, 21);
		panel.add(whom);
	}
}
