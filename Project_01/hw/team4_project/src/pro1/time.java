package pro1;

import java.util.Scanner;

//- ����ð��� �Է��ϸ� ���� �������� ���� �����ð��� ���½ð��� �������

public class time {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int endtime[] = {15, 20, 0};
		String str[] = {"��","��","��"};
		char input1 = '\0';
		char input2 = '\0';
		
		String[] save = new String[3];
		
		String scan = null;
		
//		while(true) {
//			System.out.print("�ð��� �Է��� �ּ���>> ");
//			scan = sc.nextLine();
//			
//			if(scan.length()==1) {
//				input1 = scan.charAt(0);
//				if(input1<48 || input1>57) {
//					System.out.println("\n\t�ٽ� �Է��� �ּ��� !!");
//				} else break;
//				
//			} else if(scan.length()==2) {
//				input1 = scan.charAt(0);
//				if(input1<48 || input1>50){
//					System.out.println("\n\t�ٽ� �Է����ּ���!!");
//					continue;
//					
//				} else if(input1==50) {
//					input2 = scan.charAt(1);
//					if(input2<48 || input2>52) { 
//						System.out.println("\n\t�ٽ� �Է����ּ���!!");
//					} else break;
//					
//				} else if(input1>=48 || input1<=49) {
//					input2 = scan.charAt(1);
//					if(input2<48 || input2>57) {
//						System.out.println("\n\t�ٽ� �Է����ּ���!!");
//					} else break;	
//				} 
//				
//				
//			}else {
//				System.out.println("\n\t�ٽ� �Է����ּ���!!");
//			}
//		} //while end
		
		int i=1;
		while(i!=3) {
		System.out.print(str[i]+"�� �Է��� �ּ���!! >> ");
		scan = sc.nextLine();
		
		if(scan.length()==1) { //1�ڸ� �� �Է�
			input1 = scan.charAt(0);
			if(input1<48 || input1>57) { //0~9
				System.out.println("\n\t�ٽ� �Է��� �ּ��� !!");
				continue;
			}
			
		} else if(scan.length()==2) { //2�ڸ� �� �Է�
			input1 = scan.charAt(0);
			if(input1<48 || input1>57){ //0~9���� �Է�
				System.out.println("\n\t�ٽ� �Է����ּ���!!");
				continue;
				
			} else if(input1==54) {
				input2 = scan.charAt(1);
				if(input2!=48) { 
					System.out.println("\n\t�ٽ� �Է����ּ���!!");
					continue;
				}
				
			} else if(input1>=48 || input1<=53) {
				input2 = scan.charAt(1);
				if(input2<48 || input2>57) {
					System.out.println("\n\t�ٽ� �Է����ּ���!!");
					continue;
				}	
			} 
			
			
		}else {
			System.out.println("\n\t�ٽ� �Է����ּ���!!");
			continue;
		}
		save[i] = scan;
		i++;
	} //while end		
		
		
		
		for(int j=0; j<3; j++) {
			System.out.println(save[i]+str[j]+" ");
		}
		
		
				
	}
}
