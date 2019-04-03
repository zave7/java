package com.kitri.io2;

import java.awt.FileDialog;
import java.io.*;

public class NotepadService {
	NotepadController notepadController = null;
	Notepad nt = null;
	BufferedReader fin = null;
	FileReader fr = null;
	FileWriter fw = null;
	FileDialog openFile = null;
	FileDialog saveFile = null;
	public NotepadService(NotepadController notepadController) {
		this.notepadController = notepadController;
		this.nt = notepadController.notepad;
		this.openFile = notepadController.notepad.openFileDialog;
		this.saveFile = notepadController.notepad.saveFileDialog;
	}

	public void exit() {
		System.exit(0);
	}

	public void open() {
		String filepath = null;
		filepath = fileDialog("open", openFile);
		
		if (filepath != "") {
			try {

				File inFile = new File(filepath);
				notepadController.notepad.editor.setText("");
				fin = new BufferedReader(new InputStreamReader(new FileInputStream(inFile)));
				String str;
				while ((str = fin.readLine()) != null) {
					notepadController.notepad.editor.append(str + "\r\n");
				}

			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					if (fr != null)
						fr.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public void help() {

	}

	public void save() {
		String filepath = null;
		filepath = fileDialog("save", saveFile);
		if (filepath != null) {
			try {
				fw = new FileWriter(new File(filepath));
				String str = notepadController.notepad.editor.getText();
				fw.write(str.replace("\n", "\r\n"));
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					if (fw != null)
						fw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public String fileDialog(String str, FileDialog file) {
		if(str.equals("open")) {
			file.setVisible(true);
		} else {
			file.setVisible(true);
		}
		StringBuffer sb = new StringBuffer();
		sb.append(file.getDirectory());
		sb.append(file.getFile());
		return sb.toString();
	}
}