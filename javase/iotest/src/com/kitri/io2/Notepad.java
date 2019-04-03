package com.kitri.io2;

import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;

public class Notepad extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Notepad frame = new Notepad();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	JPanel panel = new JPanel();
	JMenuBar mb = new JMenuBar();
	JMenu file = new JMenu("파일");
	JMenuItem open = new JMenuItem("열기");
	JMenuItem save = new JMenuItem("저장");
	JMenuItem exit = new JMenuItem("종료");
	JMenu help = new JMenu("도움말");
	JMenuItem mntmNewMenuItem_3 = new JMenuItem("도움말");
	JTextArea editor = new JTextArea();
	FileDialog openFileDialog = new FileDialog(this, "파일 선택", FileDialog.LOAD);
	FileDialog saveFileDialog = new FileDialog(this, "파일 선택", FileDialog.SAVE);
	/**
	 * Create the frame.
	 */
	public Notepad() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 389, 371);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		mb.setBounds(0, 0, 363, 21);
		panel.add(mb);
		
		mb.add(file);
		
		file.add(open);
		file.add(save);
		file.add(exit);
		
		mb.add(help);
		
		help.add(mntmNewMenuItem_3);
		
		
		editor.setBounds(0, 20, 363, 303);
		panel.add(editor);
		
		//이벤트 등록
		NotepadController notepadController = new NotepadController(this);
		
		open.addActionListener(notepadController);
		save.addActionListener(notepadController);
		exit.addActionListener(notepadController);
		help.addActionListener(notepadController);
		addWindowListener(notepadController);
	}
}
