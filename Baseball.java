package miniProject;

import java.util.Random;
import java.util.Scanner;

public class Baseball {
	public void game() {

		Random rd = new Random(); // 0~9 까지의 랜덤변수생성
		int ans[] = new int[3];
		ans[0] = rd.nextInt(10);
		ans[1] = rd.nextInt(10);
		ans[2] = rd.nextInt(10); // 세자리의 랜덤변수 생성

//		System.out.print(ans[0]);
//		System.out.print(ans[1]);
//		System.out.print(ans[2]);

		Scanner sc = new Scanner(System.in);
		int choice[] = new int[3];
		System.out.println("세자리 숫자를 입력하세요");

		int input = sc.nextInt();
		choice[0] = input / 100;
		choice[1] = (input % 100) / 10;
		choice[2] = (input % 100) % 10; // 각 자리의 수를 배열에 저장하는 과정

//		System.out.println("첫째자리"+choice[0]);
//		System.out.println("둘째자리"+choice[1]);
//		System.out.println("셋째자리"+choice[2]);
		int strike = 0;
		int ball = 0;
		
		for (int i = 0; i < 3; i++) {
			if (ans[i] == choice[i])
				strike++;
		}
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (choice[i] == ans[j]&& i!=j) {
					ball++;
				}
			}
		}
		System.out.println("컴퓨터숫자 : ");
		System.out.print(ans[0]);
		System.out.print(ans[1]);
		System.out.print(ans[2]);
		System.out.println();
		System.out.println("스트라이크 : "+strike);
		System.out.println("볼 : "+ball);
	}

}
