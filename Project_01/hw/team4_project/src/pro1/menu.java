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
			System.out.println("1.밥집 추천프로그램");
			System.out.println("2.밥값 몰아주기 게임 - 숫자야구게임");
			System.out.println("3.메신저 프로그램");
			System.out.println("4.집 가고싶다");
			System.out.println("5.시간표 출력\n");
			System.out.println("\t\t/EXIT >> [프로그램 종료]");
			System.out.println("-----------------------------------");

			while(choice_menu<49 || choice_menu>53) {
				System.out.print("원하는 메뉴를 선택해 주세요 :");
				input_key = sc.nextLine();
				if("/EXIT".equals(input_key)) {
					System.out.println("\n\t[프로그램을 종료 합니다]"); 
					return;
				} else if(input_key.length()==1) {
					choice_menu = input_key.charAt(0);
					if(choice_menu<49 || choice_menu>53) System.out.println("\n    >>다시 입력해 주세요!!\n");
				} else System.out.println("\n    >>다시 입력해 주세요!!\n");
			}
			
			switch(choice_menu) {
			case 49: new foodChoice();			break; // 완성
			case 50: new baseBall();			break; // 완성
			case 51: new chatServer();			break; // 패스
			case 52: System.out.println("hi4"); break; // 작성중
			case 53: System.out.println("hi5"); break;
			}
			choice_menu=0;
		}
	}
}