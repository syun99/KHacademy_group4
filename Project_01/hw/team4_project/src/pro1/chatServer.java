package pro1;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

//+ Server class
//������
//+ Server_1on1()
//	ServerSocket ����
//	accept();
//	chat(Socket);
//
//+ chat(Socket): void
//new Sender(Socket).start();
//new Receiver(Socket).start();
//
//+ main()
//	new Server_1on1();

public class chatServer {
	public chatServer() {
		
		ServerSocket servSock = null;
		Socket sock = null;
		
		try {
			servSock = new ServerSocket(9988);
			System.out.println("+ + + ���� ���� + + +");
			
			System.out.println("����.....");
			sock = servSock.accept();
			
			InetAddress ip = sock.getInetAddress();
			
			System.out.println("\n\t"+ip.getHostAddress()+"Ŭ���̾�Ʈ ����!!");
			
			chat(sock);
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public void chat(Socket sock) {
		
	}
	
}
