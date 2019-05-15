package com.kitri.temp;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.GridLayout;
import javax.swing.JLabel;
import java.awt.Dimension;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Color;

public class ReName extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReName frame = new ReName();
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
	public ReName() {
		setTitle("대화명 변경");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 369, 218);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(200, 190, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(200, 190, 255));
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Old Name : ");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(28, 26, 105, 32);
		panel_1.add(lblNewLabel);
		
		JLabel lblNewName = new JLabel("New Name : ");
		lblNewName.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewName.setBounds(28, 84, 105, 32);
		panel_1.add(lblNewName);
		
		JLabel label_1 = new JLabel("");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setBounds(145, 26, 159, 32);
		panel_1.add(label_1);
		
		textField = new JTextField();
		textField.setBounds(145, 84, 159, 32);
		panel_1.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("변경");
		btnNewButton.setBounds(61, 137, 97, 23);
		panel_1.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("취소");
		btnNewButton_1.setBounds(185, 137, 97, 23);
		panel_1.add(btnNewButton_1);
	}
}
