package TCPClient;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ConnectException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;

public class ClientClass {

	public static void main(String[] args) {
		try { Socket s1; 
		InputStream is1; 
		DataInputStream is2; 
		OutputStream os1; 
		DataOutputStream os2; 
		String sendString = "Hello Friends! kopo40!(client -> server)"; 
		s1 = new Socket("192.168.23.",5432); 
		is1 = s1.getInputStream(); 
		is2 = new DataInputStream(is1); 
		String st = new String(is2.readUTF()); 
		System.out.println(st);
		os1 = s1.getOutputStream(); 
		os2 = new DataOutputStream(os1); 
		os2.writeUTF("<전송시작>" + sendString + "<전송마침>"); 
		os2.close();
		os1.close();
		is2.close();
		is2.close();
		s1.close(); 
		} 
		catch(ConnectException connExc) {
			System.err.println("서버연결실패"); 
		} catch(IOException e) {
			e.printStackTrace();
		}
	} 
}


