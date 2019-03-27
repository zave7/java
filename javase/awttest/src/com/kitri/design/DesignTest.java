package com.kitri.design;

import java.awt.*;

//	1. Frame을 상속
//	2. 선언부에 필요한 객체 생성
//	3. 배치부에서 design(component 배치)
//	※ 작업은 소 >> 대
public class DesignTest extends Frame{
	//선언부
	Panel pN = new Panel();
	Panel pS = new Panel();
	
	Label l = new Label("입력", Label.CENTER); // 디폴트가 왼쪽이다
	TextField tf = new TextField();
	Button send = new Button("전송");
	
	TextArea ta = new TextArea(); //스크롤바 자동으로 만들어 진다
	
	Choice ch = new Choice();
	Button exit = new Button("종료");
//	----------------------------------------------------------------

	
	public DesignTest() {
//		배치부
//		-------------------------------------------------------------
		super("DesignTest");
		setLayout(new BorderLayout(0, 10));
		pN.setLayout(new BorderLayout(10, 0)); 	//이 갭은 컴포넌트와 컴포넌트의 갭이다
												//벽하고는 안떨어진다
		l.setBackground(new Color(255, 0, 0));
		//l.setForeground(new Color(45, 35, 241));
		l.setForeground(Color.GREEN);
		Font font = new Font("굴림", Font.BOLD, 20);
		l.setFont(font);
		tf.setFont(font);
		send.setFont(font);
		pN.add(l, "West");
		pN.add(tf, "Center");
		pN.add(send, "East");
		
		pS.setLayout(new GridLayout(1, 2, 10, 0)); // 10픽셀 떨어뜨리기
		ch.add("서울");
		ch.add("경기");
		ch.add("인천");
		ch.add("부산");
		pS.add(ch);
		pS.add(exit);
		
		add(pN, "North");
		add(pS, BorderLayout.SOUTH);
		//메모리 상의 작업
//		setSize(300, 400);
//		setLocation(300, 200);
		setResizable(false);
		setBounds(300, 200, 300, 500);
		setVisible(true); // 배치부의 마지막에 비저블
	}
	public static void main(String[] args) {
		new DesignTest(); // 이름 없이 객체 생성
	}
}
