package pro1;

import java.util.Scanner;

public class menu {
	
	public static void main(String[] args) {
		mainMenu();
	}
	
	public static void mainMenu() {
		Scanner sc = new Scanner(System.in);
		String input_key=null;
		char choice_menu='\0';
		
		while(true) {
			System.out.println("------------ Main Menu ------------");
			System.out.println("1.���� ��õ���α׷�");
			System.out.println("2.�䰪 �����ֱ� ���� - ���ھ߱�����");
			System.out.println("3.�޽��� ���α׷�");
			System.out.println("4.�� ����ʹ�");
			System.out.println("5.�ð�ǥ ���\n");
			System.out.println("\t\t/EXIT >> [���α׷� ����]");
			System.out.println("-----------------------------------");

			while(choice_menu<49 || choice_menu>53) {
				System.out.print("���ϴ� �޴��� ������ �ּ��� :");
				input_key = sc.nextLine();
				if("/EXIT".equals(input_key)) {
					System.out.println("\n\t[���α׷��� ���� �մϴ�]"); 
					return;
				} else if(input_key.length()==1) {
					choice_menu = input_key.charAt(0);
					if(choice_menu<49 || choice_menu>53) System.out.println("\n    >>�ٽ� �Է��� �ּ���!!\n");
				} else System.out.println("\n    >>�ٽ� �Է��� �ּ���!!\n");
			}
			
			switch(choice_menu) {
			case 49: new foodChoice();			break; // �ϼ�
			case 50: new baseBall();			break; // �ϼ�
			case 51: new chatServer();			break; // �н�
			case 52: System.out.println("hi4"); break; // �ۼ���
			case 53: System.out.println("hi5"); break;
			}
			choice_menu=0;
		}
	}
}