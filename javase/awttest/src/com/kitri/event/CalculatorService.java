package com.kitri.calculator;

import java.awt.Button;
import java.awt.Color;

public class CalculatorService {
	CalculatorController calculatorController;
	Calculator calculator;
	private String operState = ""; // 이전에 눌렀던 연산을 저장하는 변수
	private double numZone = 0; // 현재 text field 의 값을 가져오는 변수
	private double result = 0; // 연산버튼을 누르거나 '='를 누를경우마다 연산되는 값을 저장하는 변수
	private boolean isFirst = true; // 처음시작인지 판별하는 변수
	private int checkOper = 0; // 이전에 어떤 연산을 눌렀었는지 판별하는 변수 (text field의 값을 지우기위해) 0(안눌렀), 1(+-*/), 2 (=)
	private double lastNum = 0; // '=' 버튼을 연속으로 누르면 마지막 연산을 계속 해주기 위해 필요한 임시저장 변수 1
	private double tempResult = 0; // '=' 버튼을 연속으로 누르면 마지막 연산을 계속 해주기 위해 필요한 임시저장 변수 2
	private String lastOper = ""; // '=' 버튼을 연속으로 누르면 마지막 연산을 계속 해주기 위해 필요한 임시저장 변수 3
	private int count = 0; //글자색 변경
	private Color c1 = new Color(139,69,19);
	private Color c2 = new Color(70,130,180);
	private Color black = new Color(0,0,0);
	public CalculatorService(CalculatorController calculatorController) {
		this.calculatorController = calculatorController;
		this.calculator = calculatorController.calculator;
	}
	public void operationMain(Object obj) { // 'exit' 를 제외한 나머지 버튼을 눌렀을 경우
		Button btn = (Button) obj;
		String getLabel = btn.getLabel();
		char getCharLabel = btn.getLabel().charAt(0);
		if (Character.isDigit(getCharLabel)) { // 숫자인지 아닌지 판별
			addNumber(getCharLabel);
		} else if (getLabel.equals("c")) { // c 눌렀을 경우
			initialization();
		} else { // 나머지 버튼을 눌렀을 경우
			operatinon(getLabel);
		}
	}
	
	private void addNumber(char getNumber) { // 숫자 버튼을 눌렀을 경우
//		※ 0 을 입력할 경우의 수
//		1. 0 하나만 입력하는 것은 허용하되 0을 입력하고 다른 숫자를 입력하면 0을 지우고 다른 숫자를 이어 붙어야 함
//		2. 맨 앞이 0으로 시작하지 않으면 중간에 입력되는 0들은 연속을 허용
//		3. 0으로 숫자를 나누면 0으로 나눌수 없다고 출력하고 계산 초기화 작업
		if (checkOper == 1) { // 이전에 연산을 눌렀었다면 text field 초기화
			calculator.numL.setText("");
			if((count%=2)==0)
				calculator.numL.setForeground(c1);
			else 
				calculator.numL.setForeground(c2);
			count++;
		} else if(checkOper == 2) {// 이전에 '=' 을 눌렀었다면 완전 초기화
			initText();
			lastOperInitialization();
		}
		String getNumTemp = "";
		getNumTemp = calculator.numL.getText();
		if(getNumTemp.equals("0")) {	// 1번과 2번 경우 처리
			calculator.numL.setText(getNumber+"");
			numZone = getNumber - 48;
			checkOper = 0;
			return;
		}
		if (isFirst) // '=' 누르고 다음 계산값 입력할 경우 text field 를 지워준다
			calculator.operL.setText("");
		calculator.numL.setText(getNumTemp + getNumber); // 현재 누른 숫자를 text field에 이어준다
		numZone = Integer.parseInt(calculator.numL.getText()); // 이어준 text field 값을 저장
		checkOper = 0; // 연산이 아닌 숫자를 눌렀다는 것을 알려준다
	}
	private void operatinon(String getOper) { // ('+', '-', 'x', '/', '=') 을 눌렀을 경우
		if (checkOper==1 && !isFirst) { // 연산을 눌렀는데 다른 연산을 눌러 연산을 바꿀경우 처리 ('=' 제외)
			if(!getOper.equals("=")) {
			operState = getOper;
			calculator.operL.setText(getOper);
			} else { // 연산을 누른 이후 '=' 를 누를경우 아무 반응 없도록 처리
				return;
			}
			return;
		} else if (checkOper==2 && isFirst && !getOper.equals("=")|| isFirst && calculator.numL.getText().isEmpty()) {
			return; // '='를 눌러 결과값을 보여주고 난후 다른 연산을 눌렀을경우와 맨 처음에 연산버튼을 눌렀을 경우 아무 반응 없도록 처리
		} else if (operState.isEmpty() && getOper.equals("=") && !(checkOper==2)) // 숫자를 입력하고 연산을 누르지 않고 '=' 를 눌렀을 경우 아무 반응 없도록 처리
			return; 															  // 바로이전 '=' 를 눌렀을 경우는 통과 (바로이전의 계산 반복)

		if (!isFirst) { // 처음이 아닐 경우
			if (!(getOper.charAt(0) == '=')) { // ( +, -, x, / 를 눌렀을 경우 
				setText(detailLogic(operState, numZone),getOper);
				operState = getOper; // 현재 입력한 연산을 저장
			} else { // '=' 눌렀을경우
				clickEq(getOper);
			}
		} else { // 처음 연산일경우
			if(checkOper==2) { // 만약 이전에 눌렀던 버튼이 '=' 버튼이였다면 마지막 연산을 한번 더 해주기 위한 조건
				clickEq(getOper);
			} else {
			checkOper++; // 연산 후 연산체크
			result = numZone; // 
			operState = getOper;
			calculator.operL.setText(getOper);
			isFirst = false;
			}
		}
	}
	private String detailLogic(String operState, double number) { // 세부적인 연산 로직
		checkOper++; // 연산 후 연산체크
		lastOper = operState; // '=' 연속으로 누를 경우 대비
		lastNum = number; // '=' 연속으로 누를 경우 대비
		switch (operState.charAt(0)) {
		case '+': 	result += number; tempResult = result; return result + "";
		case '-': 	result -= number; System.out.println(result);tempResult = result; return result + "";
		case 'x': 	result *= number; tempResult = result; return result + "";
		case '/':	if(numZone != 0) {
						result /= number;
						tempResult = result;
						return result+"";
					} else {
						return "0으로 나눌 수 없습니다";
					}
		default:	return "알 수 없는 오류";
		}
	}
	private void lastOperInitialization() { // '=' 를 눌렀을 경우 처리
		isFirst = true;
		operState = "";
		numZone = 0;
		result = 0;
	}
	private void initialization() { // 'c' 버튼을 눌렀을 경우
		lastOperInitialization();
		initText();
		calculator.numL.setForeground(black);
	}
	private void setText(String setNumL, String getOper) {
		calculator.numL.setText(setNumL); // 이전에 눌렀던 연산을 수행하여 화면에 결과값을 뿌려준다
		calculator.operL.setText(numZone != 0 ? getOper : "!"); // 0으로 나눌 경우 오퍼존에 경고 느낌표
	}
	private void clickEq(String getOper) {
		calculator.numL.setForeground(black); // 색상 
		if(checkOper==2) { // '=' 버튼을 연속으로 누를 경우
			numZone = 1;
			result = tempResult; // '='를 누르면 기본적으로 result가 초기화 되기 때문에 임시로 갖고있던 result를 다시 넣어 준다
			setText(detailLogic(lastOper, lastNum), "=");
			checkOper--;
		} else {
			checkOper++;
			setText(detailLogic(operState, numZone),getOper);
			lastOperInitialization(); // 다음 계산을 위한 준비를 한다
			}
	}
	private void initText() {
		calculator.numL.setText("");
		calculator.operL.setText("");
	}
	public void exit() { // 'exit' 를 눌렀을 경우 시스템 종료
		System.exit(0);
	}
	
}