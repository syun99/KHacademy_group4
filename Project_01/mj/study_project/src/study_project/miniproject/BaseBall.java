package study_project.miniproject;

import java.util.Random;
import java.util.Scanner;

public class BaseBall {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[] user = new int[3]; //user
		int[] random = new int[3]; //com
		int strike = 0;
		int ball = 0;
		int idx = 0; //배열 인덱스
		int count = 0;
		
		Random ran = new Random();
		for(int i = 0; i < random.length; i++) {
			random[i] = ran.nextInt(9)+1; //1~9
			for(int j = 0; j < i; j++) {
				if(random[i] == random[j]) {
					i--;
				}
			}
		}
		
		
		
		//컴퓨터 배열과 사용자 배열을 서로 비교, 스트라이크, 볼인지 판단
		while(true) {
			for(int i = 0; i < 3; i++) {
				System.out.print("1~10 숫자 입력 : ");
				user[i] = sc.nextInt();
				
				idx = i;
			}
			
//			for(int i = 0; i < 3; i++) {
//				idx = i;
//			}
			
			if(random[idx] == user[idx]) {
				
			}
		}
	}
}
