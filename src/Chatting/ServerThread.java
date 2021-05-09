package Chatting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;


public class ServerThread extends Thread {

	private Socket s;
	BufferedReader br;
	PrintWriter pw;
	HwiServer hserver;

	public ServerThread(Socket s,HwiServer hserver) {

		this.s = s;
		this.hserver = hserver;
		System.out.println(s.getInetAddress());
		System.out.println(s.getLocalAddress());

		try {
			//소켓에서 메시지 가져오기
			br = new BufferedReader(new InputStreamReader(s.getInputStream()));
			//소켓에 메시지 보내기
			pw = new PrintWriter(new OutputStreamWriter(s.getOutputStream()),true); 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e);
		}
	}

	public void sendMessage(String msg) {

		System.out.println("전달"+msg);
		pw.println(msg);


	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		String msg = "";
		try {
			while((msg = br.readLine())!= null) {
				System.out.println("broadCasting");
				hserver.broadCasting(msg);
			}

		} catch (IOException e) {
			System.out.println(s.getInetAddress()+"의 연결이 종료되었습니다.");
			hserver.remove(this);

			try {
				s.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}finally {
			pw.close();
		}
	}

}
