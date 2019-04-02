package com.kitri.temp;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.*;

import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Paper extends JFrame {
	Dimension dsLabel = new Dimension(30, 60); 
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
		setTitle("쪽지 보내기");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 320, 374);
		contentPane = new JPanel();
		contentPane.setBackground(Color.YELLOW);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.YELLOW);
		contentPane.add(panel_1, BorderLayout.SOUTH);
		
		JButton send = new JButton("보내기");
		panel_1.add(send);
		
		JButton cancel = new JButton("취소");
		panel_1.add(cancel);
		
		JTextArea textArea = new JTextArea();
		contentPane.add(textArea, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.YELLOW);
		contentPane.add(panel, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("From : ");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setPreferredSize(new Dimension(50, 20));
		panel.add(lblNewLabel);
		
		JLabel label = new JLabel("");
		label.setOpaque(true);
		label.setBackground(Color.ORANGE);
		label.setPreferredSize(new Dimension(50, 20));
		panel.add(label);
		
		JLabel lblTo = new JLabel("To : ");
		lblTo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTo.setPreferredSize(new Dimension(50, 20));
		panel.add(lblTo);
		
		JLabel label_1 = new JLabel("");
		label_1.setBackground(Color.ORANGE);
		label_1.setOpaque(true);
		label_1.setPreferredSize(new Dimension(50, 20));
		panel.add(label_1);
	}

}
