package pro1;

import java.util.Scanner;

//- 현재시간을 입력하면 집에 갈때까지 남은 수업시간과 쉬는시간을 계산해줌

public class time {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int endtime[] = {15, 20, 0};
		String str[] = {"시","분","초"};
		char input1 = '\0';
		char input2 = '\0';
		
		String[] save = new String[3];
		
		String scan = null;
		
//		while(true) {
//			System.out.print("시간을 입력해 주세요>> ");
//			scan = sc.nextLine();
//			
//			if(scan.length()==1) {
//				input1 = scan.charAt(0);
//				if(input1<48 || input1>57) {
//					System.out.println("\n\t다시 입력해 주세요 !!");
//				} else break;
//				
//			} else if(scan.length()==2) {
//				input1 = scan.charAt(0);
//				if(input1<48 || input1>50){
//					System.out.println("\n\t다시 입력해주세요!!");
//					continue;
//					
//				} else if(input1==50) {
//					input2 = scan.charAt(1);
//					if(input2<48 || input2>52) { 
//						System.out.println("\n\t다시 입력해주세요!!");
//					} else break;
//					
//				} else if(input1>=48 || input1<=49) {
//					input2 = scan.charAt(1);
//					if(input2<48 || input2>57) {
//						System.out.println("\n\t다시 입력해주세요!!");
//					} else break;	
//				} 
//				
//				
//			}else {
//				System.out.println("\n\t다시 입력해주세요!!");
//			}
//		} //while end
		
		int i=1;
		while(i!=3) {
		System.out.print(str[i]+"을 입력해 주세요!! >> ");
		scan = sc.nextLine();
		
		if(scan.length()==1) { //1자리 수 입력
			input1 = scan.charAt(0);
			if(input1<48 || input1>57) { //0~9
				System.out.println("\n\t다시 입력해 주세요 !!");
				continue;
			}
			
		} else if(scan.length()==2) { //2자리 수 입력
			input1 = scan.charAt(0);
			if(input1<48 || input1>57){ //0~9까지 입력
				System.out.println("\n\t다시 입력해주세요!!");
				continue;
				
			} else if(input1==54) {
				input2 = scan.charAt(1);
				if(input2!=48) { 
					System.out.println("\n\t다시 입력해주세요!!");
					continue;
				}
				
			} else if(input1>=48 || input1<=53) {
				input2 = scan.charAt(1);
				if(input2<48 || input2>57) {
					System.out.println("\n\t다시 입력해주세요!!");
					continue;
				}	
			} 
			
			
		}else {
			System.out.println("\n\t다시 입력해주세요!!");
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
