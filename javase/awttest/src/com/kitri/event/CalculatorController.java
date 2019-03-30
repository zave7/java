package com.kitri.calculator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorController implements ActionListener{
	
	Calculator calculator;
	CalculatorService calculatorService;
	public CalculatorController(Calculator calculator) {
		this.calculator = calculator;
		calculatorService = new CalculatorService(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		
		if(obj == calculator.exit) {
			calculatorService.exit();
		} else {
			calculatorService.operationMain(obj);
		}
	}
	
}
