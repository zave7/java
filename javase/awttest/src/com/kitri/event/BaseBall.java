package com.kitri.event;

import java.awt.*;

public class BaseBall extends Frame {

	Panel pw = new Panel();
	Panel pe = new Panel();
	Panel pws = new Panel();
	
	Button newG = new Button("새게임");
	Button clear = new Button("지우기");
	Button ans = new Button("정  답");
	Button color = new Button("글자색");
	Button exit = new Button("종료");
	
	TextArea ta = new TextArea();
	TextField tf = new TextField();
	
	Label l = new Label("입력");
	FontColorChooser fontColorChooser = new FontColorChooser();

	public BaseBall() {
		pe.setLayout(new GridLayout(5, 1, 0, 10));
		pe.add(newG);
		pe.add(clear);
		pe.add(ans);
		pe.add(color);
		pe.add(exit);
		pws.setLayout(new BorderLayout());
		pws.add(l, "West");
		pws.add(tf, "Center");
		pw.setLayout(new BorderLayout(0, 10));

		ta.setEditable(false);// 사용못하게 막아버리기
		ta.setFont(new Font("굴림", Font.BOLD, 16));
		pw.add(ta, "Center");
		pw.add(pws, "South");
		setLayout(new BorderLayout(10, 0));
		add(pe, "East");
		add(pw, "Center");

		setBounds(300, 300, 400, 400);
		setVisible(true);

		BaseballController baseballController = new BaseballController(this);
//		baseball창 이벤트 등록
		newG.addActionListener(baseballController);
		clear.addActionListener(baseballController);
		ans.addActionListener(baseballController);
		exit.addActionListener(baseballController);
		color.addActionListener(baseballController);
		tf.addActionListener(baseballController);
//		fontcolorchooser 창 이벤트 등록
		fontColorChooser.sr.addAdjustmentListener(baseballController);
		fontColorChooser.sg.addAdjustmentListener(baseballController);
		fontColorChooser.sb.addAdjustmentListener(baseballController);
		fontColorChooser.button.addActionListener(baseballController);

	}

	public static void main(String[] args) {
		new BaseBall();
	}
}
