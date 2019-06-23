package com.kitri.event;

import java.awt.Color;
import java.util.Random;

public class BaseballService {
	int my[]; // 선언부에서 값을 할당한는 것 보다는 생성자에서
	int com[];
	int gameLength;
	int count = 0;
	private FontColorChooser fcc;
	private BaseBall bb;
	Random random = new Random();
	BaseballController baseballController;
	int r;
	int g;
	int b;

	public BaseballService(BaseballController baseballController) {
		this.baseballController = baseballController;
		this.bb = baseballController.baseBall;
		this.fcc = bb.fontColorChooser;
		gameLength = 3;
		my = new int[gameLength];
		com = new int[gameLength];
		newGame();
	}

	public void newGame() {
		clear();
		bb.tf.setEnabled(true);
		com[0] = random.nextInt(9) + 1;
		do {
			com[1] = random.nextInt(10);
		} while (com[0] == com[1]);
		do {
			com[2] = random.nextInt(10);
		} while (com[0] == com[2] || com[1] == com[2]);
		viewResult("새로운 게임을 시작합니다!");
		System.out.println("ans : " + com[0] + com[1] + com[2]);
	}

	public void clear() {
		bb.ta.setText(" ");
	}

	public void ans() {
		viewResult("정답은 : " + com[0] + com[1] + com[2] + "입니다\n");
		viewResult("새게임 또는 종료를 누르세요");
		bb.ta.setEditable(false);
		bb.tf.setEnabled(false);
	}

	public void changeColor() {
		bb.fontColorChooser.setVisible(true);
		check();
	}

	public void exit() {
		System.exit(0);
	}

	public void game() {
		int strike = 0;
		int ball = 0;
		String myNumStr = bb.tf.getText().trim();
		bb.tf.setText("");
		if (myNumStr.length() != gameLength) {
			viewResult(gameLength + "자리 숫자를 입력해 주세요");
			return;
		}
		if (!isNumber(myNumStr)) {
			viewResult("숫자만 입력해야합니다");
			return;
		}

		for (int i = 0; i < gameLength; i++) {
			my[i] = myNumStr.charAt(i) - 48;
		}
		for (int c = 0; c < gameLength; c++) {
			for (int m = 0; m < gameLength; m++) {
				if (com[c] == my[m]) {
					if (c == m) {
						strike++;
					} else {
						ball++;
					}
					break;
				}
			}
		}
		count++;

		if (strike != gameLength) {
			viewResult(myNumStr + "는 " + strike + " 스트라이크 " + ball + " 볼 입니다.");
		} else {
			viewResult(myNumStr + "는 " + count + "번만에 정답입니다");
			viewResult("새게임 또는 종료를 누르세요");
			bb.ta.setEditable(false);
			bb.tf.setEnabled(false);
			count = 0;
		}

	}

	private void viewResult(String msg) {
		bb.ta.append(msg + "\n");
	}

	private boolean isNumber(String msg) {
		boolean flag = true;
		for (int i = 0; i < gameLength; i++) {
			if (msg.charAt(i) > 57 || msg.charAt(i) < 48) {
				System.out.println(msg + " 은 숫자가 아닙니다");
				flag = false;
				break;
			}
		}
		return flag;
	}

	public void check() {
		r = fcc.sr.getValue();
		g = fcc.sg.getValue();
		b = fcc.sb.getValue();
		fcc.pen.setBackground(new Color(r, g, b));
		fcc.colorL.setText("r = " + r + " g = " + g + " b = " + b);
	}

	public void selectColor() {
		bb.ta.setForeground(new Color(r, g, b));
		fcc.setVisible(false);
	}

}
