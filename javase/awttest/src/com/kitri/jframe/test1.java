package com.kitri.jframe;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JScrollBar;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.Panel;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;
import java.awt.Color;

public class test1 extends JFrame {

	private JPanel contentPane;
	private JTextField tf;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					test1 frame = new test1();
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
	public test1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 428, 445);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("입력");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(12, 371, 50, 25);
		contentPane.add(lblNewLabel);
		
		tf = new JTextField();
		tf.setBounds(72, 371, 229, 25);
		contentPane.add(tf);
		tf.setColumns(10);
		
		Panel panel = new Panel();
		panel.setBounds(307, 10, 95, 351);
		contentPane.add(panel);
		panel.setLayout(new GridLayout(5, 1, 0, 10));
		
		JButton newG = new JButton("새게임");
		newG.setBorder(new LineBorder(new Color(0, 0, 0)));
		newG.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel.add(newG);
		
		JButton clear = new JButton("지우기");
		clear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel.add(clear);
		
		JButton btnNewButton_3 = new JButton("정답");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("글자색");
		panel.add(btnNewButton_4);
		
		JButton btnNewButton_1 = new JButton("종료");
		panel.add(btnNewButton_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(282, 10, 19, 351);
		contentPane.add(scrollPane);
	}
}
