package com.kitri.io2;

import java.awt.event.*;

public class NotepadController extends WindowAdapter implements ActionListener {

	Notepad notepad;
	NotepadService notepadService = null;
	public NotepadController(Notepad notepad) {
		this.notepad = notepad;
		this.notepadService = new NotepadService(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object ob = e.getSource();
		if(ob == notepad.open) {
			notepadService.open();
		} else if(ob == notepad.save) {
			notepadService.save();
		} else if(ob == notepad.exit) {
			notepadService.exit();
		} else if(ob == notepad.help) {
			notepadService.help();
		} 
	}
	@Override
	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}
	
	
}
