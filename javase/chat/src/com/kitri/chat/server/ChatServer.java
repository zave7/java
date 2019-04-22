package com.kitri.chat.server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.StringTokenizer;
import java.util.Vector;

import com.kitri.chat.util.ChatConstance;

public class ChatServer implements Runnable {
	// 유저를 담을 벡터 생성
	Vector<ChatClient> list = new Vector<ChatServer.ChatClient>();
	// 서버소켓 생성
	ServerSocket ss;

	public ChatServer() {
		try {
			ss = new ServerSocket(ChatConstance.PORT); // 포트 열었다
			System.out.println("클라이언트 접속 대기중............");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() { // 접속 처리
		while (true) { // 실행 되는 순간 부터 클라이언트 접속을 기다린다
			try {
				Socket socket = ss.accept(); // socket에 클라이언트 정보 저장
				System.out.println("클라이언트 접속 성공 : " + socket);
				new ChatClient(socket).start();
				;
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	class ChatClient extends Thread {
		// 유저 정보를 담는 객체를 생성하기 위해 이너 클래스를 정의한다
		// 그리고 유저 객체가 생성될 때마다 벡터에 담는다
		String name;
		BufferedReader in;
		OutputStream out;
		Socket socket;
		public ChatClient(Socket socket) {
			try {
				this.socket = socket;
				in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				out = socket.getOutputStream();

			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		@Override
		public void run() { // 메세지 처리
			boolean flag = true;
			while (flag) {
				try {
					String msg = in.readLine(); 
					System.out.println("클라이언트가 보낸 메세지 : " + msg); // protocol|메세지형식
					StringTokenizer st = new StringTokenizer(msg, "|");
					int protocol = Integer.parseInt(st.nextToken());
					switch (protocol) {
					case ChatConstance.CS_CONNECT: {
//						100|안효인
						name = st.nextToken();
//						int size = list.size();
//						for (int i = 0; i < size; i++) {
//							ChatClient cc = list.get(i);
//						}
						multicast((ChatConstance.SC_CONNECT + "|" + name));
							//나를 제외한 다른 사람들에게 내가 접속했다는 것을 알림
						list.add(this);
						for(ChatClient cc : list) {
							unicast(ChatConstance.SC_CONNECT + "|" + cc.name);
						}	//나한테 접속해있는 사람들의 정보를 보내줌
					}
						break;
					case ChatConstance.CS_ALL: {
						String tmp = st.nextToken();
						System.out.println("내용" + tmp);
							multicast(ChatConstance.SC_MASSAGE + "|[" + name + "]" + tmp);
					}
						break;
					case ChatConstance.CS_TO: {
						String to = st.nextToken(); // 이름
						String tmp = st.nextToken(); // 내용
						for(ChatClient cc : list) {
							if(cc.name.equals(to)) {
								cc.unicast(ChatConstance.SC_MASSAGE + "|★" + name + "★로 부터 : " + tmp);
								break;
							}
						}
					}
						break;
					case ChatConstance.CS_PAPER: {
						String to = st.nextToken();
						String tmp = st.nextToken();
						for(ChatClient cc : list) {
							if(cc.name.equals(to)) {
								cc.unicast(ChatConstance.SC_PAPER + "|" + name + "|" + tmp);
								break;
							}
						}
					}
						break;
					case ChatConstance.CS_RENAME: {
						String tmp = name;
						name = st.nextToken();
							multicast(ChatConstance.SC_RENAME + "|" + tmp + "|" + name);
					}
						break;
					case ChatConstance.CS_DISCONNECT: {
//						900|
						multicast(ChatConstance.SC_DISCONNECT + "|" + name);
						list.remove(this);
						flag = false;
						in.close(); // null이면 여기까지 못온다
						out.close();
						socket.close();
					}
						break;

					}
				} catch (IOException e) {
					e.printStackTrace();
					break;
				}
			}
		}
		private void multicast(String msg) {
				for(ChatClient cc : list) {
					cc.unicast(msg);
			}
		}
		private void unicast(String msg) {
			try {
				out.write((msg + "\n").getBytes());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
//		ChatServer cs = new ChatServer();  
//		Thread t = new Thread(cs); 
//		t.start();
		new Thread(new ChatServer()).start();
	}
}
