package com.kitri.temp;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.CardLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Color;

public class Paper extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Paper frame = new Paper();
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
	public Paper() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 335, 377);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.YELLOW);
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("From : ");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(12, 22, 69, 28);
		panel.add(lblNewLabel);
		
		JLabel label = new JLabel("");
		label.setOpaque(true);
		label.setBackground(Color.ORANGE);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(77, 22, 69, 28);
		panel.add(label);
		
		JLabel lblTo = new JLabel("   To : ");
		lblTo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTo.setBounds(146, 22, 69, 28);
		panel.add(lblTo);
		
		JLabel label_2 = new JLabel("");
		label_2.setBackground(Color.ORANGE);
		label_2.setOpaque(true);
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setBounds(215, 22, 69, 28);
		panel.add(label_2);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(26, 60, 259, 204);
		panel.add(textArea);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(77, 287, 75, 32);
		panel.add(panel_1);
		panel_1.setLayout(new CardLayout(0, 0));
		
		JButton button_1 = new JButton("답변");
		panel_1.add(button_1, "name_1061305650288");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JButton btnNewButton = new JButton("보내기");
		panel_1.add(btnNewButton, "name_989811126353");
		
		JButton button = new JButton("취소");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button.setBounds(162, 287, 75, 32);
		panel.add(button);
	}
}
