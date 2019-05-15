package com.kitri.event;

import java.awt.event.*;

public class BaseballController extends WindowAdapter implements ActionListener, AdjustmentListener{

	BaseBall baseBall;
	BaseballService baseballService;

	public BaseballController(BaseBall baseBall) {
		this.baseBall = baseBall;
		baseballService = new BaseballService(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object ob = e.getSource();
		if (ob == baseBall.newG) {
			baseballService.newGame();
		} else if (ob == baseBall.clear) {
			baseballService.clear();
		} else if (ob == baseBall.ans) {
			baseballService.ans();
		} else if (ob == baseBall.color) {
			baseballService.changeColor();
		} else if (ob == baseBall.exit) {
			baseballService.exit();
		} else if (ob == baseBall.tf) {
			baseballService.game();
		} else if (ob == baseBall.fontColorChooser.button) {
			baseballService.selectColor();
		}
	}

	@Override
	public void windowClosing(WindowEvent e) {
		baseballService.exit();
	}

	@Override
	public void adjustmentValueChanged(AdjustmentEvent e) {
		baseballService.check();
	}
	
	
}
