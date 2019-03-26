package study_project.miniproject;

import java.util.Random;
import java.util.Scanner;

public class Reco_res_01 {	
	
	private static String[] res_k = {"김밥[0]", "수제비[1]", "김치찌개[2]"};
	private static String[] res_c = {"짜장면[0]", "짬뽕[1]", "탕수육[2]"};
	private static String[] res_e = {"햄버거[0]", "도리아[1]", "피자[2]"};
	private static String[] res_j = {"돈부리[0]", "우동[1]", "스시[2]"};
	
	public static void main(String[] args) {
	
		Random ran = new Random();
		
		String[] category = {"한식","일식", "중식", "양식"};
		String ch;
		int com;
		
		do {
		
			Scanner sc = new Scanner(System.in);
			System.out.print("한식, 일식, 중식, 양식 중 택 1 : ");
			ch = sc.nextLine();
			
			com = ran.nextInt(3);
			
//			if(ch == "exit") {
//				System.out.println("종료");
//				break;
//			}
		
			switch(ch) {
			case "한식":
				if(com == 0) {
					System.out.println(res_k[0]);
				}
				else if(com == 1) {
					System.out.println(res_k[1]);
				}
				else if(com == 2) {
					System.out.println(res_k[2]);
				}
				break;
			case "일식":
				if(com == 0) {
					System.out.println(res_j[0]);
				}
				else if(com == 1) {
					System.out.println(res_j[1]);
				}
				else if(com == 2) {
					System.out.println(res_j[2]);
				}
				break;
			case "중식":
				if(com == 0) {
					System.out.println(res_c[0]);
				}
				else if(com == 1) {
					System.out.println(res_c[1]);
				}
				else if(com == 2) {
					System.out.println(res_c[2]);
				}
				break;
			case "양식":
				if(com == 0) {
					System.out.println(res_e[0]);
				}
				else if(com == 1) {
					System.out.println(res_e[1]);
				}
				else if(com == 2) {
					System.out.println(res_e[2]);
				}
				break;
			case "exit":
				System.out.println("종료");
				return;
			}	
			
		}while(ch != "exit");
	}
}
