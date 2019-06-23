package com.kitri.chat.client;

import java.awt.event.*;
import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.StringTokenizer;
import java.util.UUID;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import com.kitri.chat.util.ChatConstance;

public class Login extends JFrame implements ActionListener, Runnable, ListSelectionListener {

	String myid;
	Socket socket;

	JLabel ip;
	JLabel name;
	JTextField ipTf;
	JTextField nameTf;
	JButton cancel;
	JButton ok;

	Chat chat;
	Paper paper;
	Rename rename;

	BufferedReader in;
	OutputStream out;

	String uuid;
	
	public Login() {
		super("Login!!");
		initGUI();

		chat = new Chat();
		paper = new Paper();
		rename = new Rename();

		// Login 창 이벤트 등록 -------------------------------------------
		nameTf.addActionListener(this);
		ok.addActionListener(this);
		cancel.addActionListener(this);
		// chat 창 이벤트 등록 -------------------------------------------
		chat.globalsend.addActionListener(this);
		chat.whomsend.addActionListener(this);
		chat.paper.addActionListener(this);
		chat.rename.addActionListener(this);
		chat.exit.addActionListener(this);
		chat.list.addListSelectionListener(this);
		chat.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				closeProcess();
			}
		});
		// paper 창 이벤트 등록 -------------------------------------------
//		JLabel fl; 라벨
//		JLabel tl; 라벨
//		JLabel to; 보낼 사람 이름
//		JLabel from; 누구로부터
//		JTextArea letter; 쪽지 메세지
//		JButton answer; 답장
//		JPanel cardp; 카드레이아웃 적용할 패널
//		JButton cancel; 취소
//		JButton ok; 보내기
//		CardLayout card;
		paper.ok.addActionListener(this);
		paper.answer.addActionListener(this);
		paper.cancel.addActionListener(this);
//		paper.letter.addKeyListener(this);
		// rename 창 이벤트 등록 -------------------------------------------
		rename.ok.addActionListener(this);
		rename.cancel.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object ob = e.getSource();
		if (ob == nameTf || ob == ok) {
			connectProcess();
		} else if (ob == cancel) {
			System.exit(0);
		} else if (ob == chat.globalsend) {
			globalsendProcess();
		} else if (ob == chat.paper) {
			setPaper(); // 쪽지보내기를 눌렀을 때
		} else if (ob == chat.rename) {
			setRenameFrame();
		} else if (ob == chat.whomsend) {
			whomsendProcess();
		} else if (ob == chat.exit) {
			closeProcess();
		} else if (ob == paper.ok) {
			paperProcess(); // 보내기를 눌렀을 때
		} else if (ob == paper.answer) {
			setPaperReply(); // 답장을 눌렀을 때
		} else if (ob == paper.cancel) {
			clearPaper(); // 취소를 눌렀을 때
		} else if (ob == rename.cancel) {
			rename.newname.setText("");
			rename.setVisible(false);
		} else if (ob == rename.ok) {
			sendName();
		}
	}

	private void sendName() {
		
		if(rename.newname.getText().indexOf(" ") != -1) {
			JOptionPane.showMessageDialog(rename, "이름에 공백을 넣을 수 없습니다", "이름 변경 오류", JOptionPane.ERROR_MESSAGE);
			return;
		}
		if (rename.newname.getText().trim().isEmpty()) {
			JOptionPane.showMessageDialog(rename, "변경할 이름을 입력해 주세요", "이름 변경 오류", JOptionPane.ERROR_MESSAGE);
			return;
		}
		if(rename.newname.getText().equals(rename.oldname.getText())) {
			JOptionPane.showMessageDialog(rename, "기존의 닉네임과 같습니다", "이름 변경 오류", JOptionPane.ERROR_MESSAGE);
			return;
		}
		myid = rename.newname.getText();
		sendMassage(ChatConstance.CS_RENAME + "|" + rename.newname.getText());
		rename.newname.setText("");
		rename.setVisible(false);
	}

	private void setRenameFrame() {
		rename.oldname.setText(myid);
		rename.setVisible(true);
	}

//	private void closePaper() {
//		paper.to.setText("");
//		paper.from.setText("");
//		paper.letter.setText("");
//		paper.setVisible(false);
//	}

	private void clearPaper() {
		paper.from.setText("");
		paper.to.setText("");
		paper.letter.setText("");
		paper.setVisible(false);
	}

	private void paperProcess() {
		sendMassage(
				ChatConstance.CS_PAPER + "|" + paper.to.getText() + "|" + paper.letter.getText().replace("\n", "`z]>$&`*"));
		clearPaper();

	}

	private void setPaper() {
		String to;
		if (chat.whom.getText().isEmpty()) {
			JOptionPane.showMessageDialog(chat, "리스트에서 쪽지를 보낼 유저를 선택해주세요", "대상자 미선택", JOptionPane.ERROR_MESSAGE);
			return;
		}
		if (chat.whom.getText().equals(myid)) {
			JOptionPane.showMessageDialog(chat, "자신에게는 쪽지를 보낼 수 없습니다", "대상자 선택 오류", JOptionPane.ERROR_MESSAGE);
			return;
		}
		to = chat.whom.getText();
		paper.from.setText(myid); // from 에 자기 아이디 박기
		paper.to.setText(to); // to에 선택한 아이디 박기
		paper.letter.setEditable(true);
		paper.card.show(paper.cardp, "ok");
//		paper.card.show(paper.cardp, "answer"); 이건 쪽지를 받았을 때 해주자
		paper.setVisible(true);
	}

	private void setPaperReply() {
		String temp;
		temp = paper.from.getText();
		paper.from.setText(myid); // from 에 자기 아이디 박기
		paper.to.setText(temp.replace("`z]>$&`*", "\n")); // to에 from 박기
		paper.letter.append("\n-----받은 쪽지 내용-----");
		paper.letter.setEditable(true);
		paper.card.show(paper.cardp, "ok");
		paper.setVisible(true);
	}

	private void setViewPaper(String from, String letter) {
		paper.from.setText(from); //
		paper.to.setText(myid); //
		paper.letter.setText(letter.replace("`z]>$&`*", "\n"));
		paper.card.show(paper.cardp, "answer"); // 이건 쪽지를 받았을 때 해주자
		paper.letter.setEditable(false);
		paper.setVisible(true);
	}

	private void closeProcess() {
//		1. 
		sendMassage(ChatConstance.CS_DISCONNECT + "|");
	}
	private void whomsendProcess() {
//		1. 대상자, 메세지 get(유효성 검사 대상자, 자신, 메세지)
//		2. server로 전송
		String msg = chat.whomsend.getText().trim();
		chat.whomsend.setText("");
		if (msg.isEmpty())
			return;
		String to = chat.whom.getText();
		if (to.isEmpty()) {
			JOptionPane.showMessageDialog(chat, "대상자를 선택하세요.", "대상자 오류", JOptionPane.ERROR_MESSAGE);
			return;
		}
		if (to.equals(myid)) {
			JOptionPane.showMessageDialog(chat, "자신에게 귓속말을 보낼수 없습니다.", "대상자 오류", JOptionPane.INFORMATION_MESSAGE);
			return;
		}
		sendMassage(ChatConstance.CS_TO + "|" + to + "|" + msg);
		viewMassage("★" + to + "★에게 : " + msg);
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		String selName = chat.list.getSelectedValue();
		chat.whom.setText(selName);
	}

//	1. 메세지를 얻어내야한다 (유효성검사)
//	2. server로 메세지 전송
	private void globalsendProcess() {
		String msg = chat.globalsend.getText().trim();
		chat.globalsend.setText("");
		if (msg.isEmpty())
			return; // 1번
		try {
			System.out.println("CS_ALL");
			out.write((ChatConstance.CS_ALL + "|" + msg + "\n").getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void sendMassage(String msg) {
		try {
			out.write((msg + "\n").getBytes()); // BufferedReader는 enter key 기준
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void connectProcess() {
//		1. ip, 대화명 get(유효성 검사(대화명 3자 이상))
//		2. 1의 ip를 이용해서 Socket 생성
//		3. IO(BufferedReader, OutputStream)생성
//		4. login창 닫고, chat창 열기
//		5. server로 메세지 전송
//		6. Thread 실행
		String ip = ipTf.getText().trim();
		try {
			socket = new Socket(ip, ChatConstance.PORT);
			myid = nameTf.getText().trim();
			if (myid.length() < 3) {
				JOptionPane.showMessageDialog(this, "대화명을 3자 이상 입력해주세요", "대화명 오류", JOptionPane.WARNING_MESSAGE);
				return;
			}
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = socket.getOutputStream();
			this.setVisible(false);
			chat.setVisible(true);
			sendMassage(ChatConstance.CS_CONNECT + "|" + myid); // 받는쪽에서 엔터를 기준으로 데이터를 받기 때문에 \n를 마지막에 붙여줘야 한다
			new Thread(this).start();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		boolean flag = true;
		while (flag) {
			try {
				String msg = in.readLine(); // 얘는 엔터를 기준으로 "\n"
				System.out.println("서버가 보낸 메세지 : " + msg); // protocol|메세지형식
				StringTokenizer st = new StringTokenizer(msg, "|"); // 여기서 바로 프로토콜 얻어온다
				int protocol = Integer.parseInt(st.nextToken());
				switch (protocol) {
				case ChatConstance.SC_CONNECT: {
//					100|접속자대화명
					String tmp = st.nextToken();
					chat.listData.add(tmp); // 벡터에 저장한후
					chat.list.setListData(chat.listData);
				}
					break;
				case ChatConstance.SC_MASSAGE: {
//					200|안효인|안녕하세요
					String tmp = st.nextToken();
					viewMassage(tmp);
				}
					break;
				case ChatConstance.SC_PAPER: {
					String from = st.nextToken();
					String tmp = st.nextToken();
					setViewPaper(from, tmp);
				}
					break;
				case ChatConstance.SC_RENAME: {
					String oldName = st.nextToken();
					String newName = st.nextToken();
					viewMassage("[알림] <" + oldName + "> 님이 닉네임을 <" + newName + ">으로 변경하였습니다.");
//					for(String s : chat.listData) {
//						if(s.equals(oldName)) // 벡터에 저장한후
//							s = newName;
//					}
//					int size = chat.listData.size();
//					for (int i = 0; i < size; i++) {
//						if(chat.listData.get(i).equals(oldName)) // 벡터에 저장한후
//						chat.listData.set(i, newName);
//						break;
//					}
					chat.listData.set(chat.listData.indexOf(oldName), newName);
					chat.list.setListData(chat.listData);
					for(String s : chat.listData) {
							System.out.println("바꾼 벡터 : "+s);
					}
				}
					break;
				case ChatConstance.SC_DISCONNECT: {
//					900|나가는사람
					String tmp = st.nextToken(); // 나가는 사람
					if (!tmp.equals(myid)) {
						viewMassage("[알림] " + tmp + "님이 접속을 종료하였습니다.");
						chat.listData.remove(tmp);
						chat.list.setListData(chat.listData);
					} else {
//						flag = false;
						in.close(); // null이면 여기까지 못온다
						out.close();
						socket.close();
//						chat.setVisible(false);
						System.exit(0);
					}
				}
					break;

				}
			} catch (IOException e) {
				e.printStackTrace();
				break;
			}
		}
	}

	private void viewMassage(String msg) {
		chat.area.append(msg + "\n");
		chat.area.setCaretPosition(chat.area.getDocument().getLength());
	}

	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			getContentPane().setBackground(new java.awt.Color(244, 243, 242));
			{
				ip = new JLabel();
				getContentPane().add(ip);
				ip.setText("\uc544\uc774\ud53c");
				ip.setBounds(12, 12, 60, 30);
				ip.setBorder(BorderFactory.createEtchedBorder(BevelBorder.LOWERED));
				ip.setFocusable(false);
				ip.setRequestFocusEnabled(false);
				ip.setHorizontalAlignment(SwingConstants.CENTER);
			}
			{
				name = new JLabel();
				getContentPane().add(name);
				name.setText("\ub300\ud654\uba85");
				name.setBounds(12, 47, 60, 30);
				name.setBorder(BorderFactory.createEtchedBorder(BevelBorder.LOWERED));
				name.setFocusable(false);
				name.setRequestFocusEnabled(false);
				name.setHorizontalAlignment(SwingConstants.CENTER);
			}
			{
				ipTf = new JTextField("127.0.0.1");
				getContentPane().add(ipTf);
				ipTf.setBounds(78, 12, 209, 30);
			}
			{
				nameTf = new JTextField();
				getContentPane().add(nameTf);
				nameTf.setBounds(78, 47, 209, 30);
			}
			{
				ok = new JButton();
				getContentPane().add(ok);
				ok.setText("\ub85c\uadf8\uc778");
				ok.setBounds(83, 83, 61, 32);
				ok.setBackground(new java.awt.Color(237, 236, 233));
				ok.setBorder(new LineBorder(new java.awt.Color(0, 0, 0), 1, false));
			}
			{
				cancel = new JButton();
				getContentPane().add(cancel);
				cancel.setText("\ucde8 \uc18c");
				cancel.setBounds(153, 83, 59, 32);
				cancel.setBackground(new java.awt.Color(237, 236, 233));
				cancel.setBorder(new LineBorder(new java.awt.Color(0, 0, 0), 1, false));
			}
			pack();
			this.setSize(303, 150);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				Login inst = new Login();
				inst.setLocationRelativeTo(null);
				inst.setResizable(false);
				inst.setVisible(true);
			}
		});
	}

}
