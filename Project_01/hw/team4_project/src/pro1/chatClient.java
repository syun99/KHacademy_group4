package pro1;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

//+ Client class
////������
//+ Client_1on1()
//Socket ����
//chat(Socket);
//
//+ chat(Socket): void
//new Sender(Socket).start();
//new Receiver(Socket).start();
//
//+ main()
//new Client_1on1();

public class chatClient {
	public static void main(String[] args) {
		
		Socket sock = null;
		
		try {
			sock = new Socket("localhost", 9988);
			System.out.println("+ + + Ŭ���̾�Ʈ ���� + + +");
		
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
