package com.kitri.event;

import java.awt.Button;

public class CalculatorService {

	CalculatorController calculatorController;
	Calculator calculator;
	String operState = "";
	double temp = 0;
	double result = 0;
	boolean isFirst = true;
	int operCheck = 0;
	public CalculatorService(CalculatorController calculatorController) {
		this.calculatorController = calculatorController;
		this.calculator = calculatorController.calculator;
	}

	public void operationMain(Object obj) {
		Button btn = (Button)obj;
		String getLabel = btn.getLabel();
		
		char getCharLabel = btn.getLabel().charAt(0);
		if(Character.isDigit(getCharLabel)) {
			addNumber(getLabel);
			System.out.println("input num " + getLabel);
		} else if(getLabel.equals("c")){
			System.out.println("초기화 " + getLabel);
			initialization();
		} else {
			System.out.println("input " + getLabel);
			operatinon(getLabel);
		}
	}
	
	public void addNumber(String getLabel) {
//		1. 버튼의 라벨값을 얻어와서 numL 에 append 한다
		if(operCheck>0) {
			calculator.numL.setText("");
			System.out.println("임시테스트");
		}
		if(operCheck==2) {
			result = 0;
			operState = "";
			calculator.OperL.setText("");
		}
		String numZone = calculator.numL.getText();
		calculator.numL.setText(numZone + getLabel);
		operCheck = 0;
	}

	public void exit() {
		System.exit(0);
	}

	private void operatinon(String getOper) {
		if((operCheck==0)) { 
			System.out.println("operation start !!" + getOper);
			temp = Integer.parseInt(calculator.numL.getText());
			System.out.println("임시테스트2"+temp);
			String globalOper = this.operState;
			
			if(getOper.charAt(0) == '=') {
				if(!isFirst) {
				System.out.println("= start");
				detailLogic(this.operState);
				calculator.numL.setText(Double.toString(result));
				calculator.OperL.setText("");
				operCheck++;
				System.out.println("= end");
				}
			} else if (!isFirst) {
				System.out.println("isEmpty() start");
				detailLogic(globalOper);
				System.out.println("result = " + result);
				calculator.numL.setText(Double.toString(result));
				System.out.println("!isFirst temp " + temp);
				System.out.println("!isFirst result " + result);
				System.out.println("isEmpty() end");
			} else {
				System.out.println("first start");
				detailLogic(getOper);
			this.operState = getOper;
			calculator.OperL.setText(getOper);
			isFirst = false;
	//		calculator.numL.setText("");
			
			System.out.println("temp " + temp);
			System.out.println("result " + result);
			System.out.println("first end");
			}
		}
		if(isFirst) {
			System.out.println("첫번째 연산");
			calculator.numL.setText(Double.toString(temp));
		}
		operCheck++;
		System.out.println("operation end !!" + getOper);
	}

	private void initialization() {
		isFirst = true;
		operState = "";
		temp = 0;
		result = 0;
		calculator.numL.setText("");
		calculator.OperL.setText("");
	}

	private void detailLogic(String operState) {
		System.out.println("detailLogic start");
		switch(operState.charAt(0)) {
			case '+': result += temp;
						break;
			case '-': result -= temp;
						break;
			case '*': if(isFirst) { result = temp; } 
						else {result *= temp;}
						break;
			case '/': if(isFirst) result = temp;
						else {result /= temp;}
						break;
		}
		System.out.println("detailLogic end");
	}
	
}
