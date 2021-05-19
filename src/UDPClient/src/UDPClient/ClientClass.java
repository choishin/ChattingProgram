package UDPClient;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class ClientClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try { DatagramSocket ds = new DatagramSocket(); 
		InetAddress ia= InetAddress.getByName("localhost");
		String str;
		str= "гогого"; 
		byte[] bf = str.getBytes(); 
		DatagramPacket dp= new DatagramPacket(bf, bf.length, ia, 9999); 
		ds.send(dp); 
		} catch(Exception e)
		{ System.out.println(e);

		} 

	}

}
