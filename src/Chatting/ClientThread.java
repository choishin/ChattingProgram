package Chatting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ClientThread extends Thread{
	private Socket s;
	BufferedReader sbr = null;
	
	public ClientThread(Socket s) throws IOException {
		this.s = s;
		sbr = new BufferedReader(new InputStreamReader(s.getInputStream()));
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		String str="";
		try {
			while ((str = sbr.readLine())!=null) {
				System.out.println(str);
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
	
	
	

}
