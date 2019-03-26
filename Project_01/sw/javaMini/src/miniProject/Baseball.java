package miniProject; //플레이어가 같은 숫자를 입력하면 안됌

import java.util.Random;
import java.util.Scanner;

public class Baseball { // 문제 : 223이 답일 때 322면 1스트라잌 2볼인데 1s1b뜸 (기존스트라이크숫자는볼처리안하게해놔서)
	public void game() {

		Random rd = new Random();
		int idx[] = new int[10];
		int ans[] = new int[3];

		// ---------------겹치지 않는 3자리 숫자를 생성하기 위한 구문----------------------
		for (int i = 0; i < 10; i++) {
			idx[i] = i;
		}

		for (int i = 0; i < 3; i++) {
			ans[i] = idx[rd.nextInt(10)]; // idx[0~9]를 랜덤으로 불러옴
			for (int j = 0; j < i; j++) { // 조건문때문에 i, j가 둘다 0일땐 검사 안함
				if (ans[i] == ans[j]) {
					i--;
					break;
				}
			}

		}
		// ----------------------------------------------------

		Scanner sc = new Scanner(System.in);

		System.out.println("================================");
		System.out.println("       참! 재미있는 숫자 야구 GAME        ");
		System.out.println("================================");
		
		System.out.println("컴퓨터숫자 : "); // 테스트를 위한 구문
		System.out.print(ans[0]);
		System.out.print(ans[1]);
		System.out.println(ans[2]);

		while (true) {

			int choice[] = new int[3];
			System.out.println("세자리 숫자를 입력하세요 >> ");
			
			int input = sc.nextInt();
			
			choice[0] = input / 100;
			choice[1] = (input % 100) / 10;
			choice[2] = (input % 100) % 10; // 각 자리의 수를 배열에 저장하는 과정
			
			if(choice[0]==choice[1] || choice[1]==choice[2] || choice[0]==choice[2]) {
				System.out.println("중복된 숫자는 불가합니다!");
				continue; //가장 가까운 조건문인 while문의 조건문으로 올라감
			}

			int strike = 0;
			int ball = 0;

			for (int i = 0; i < 3; i++) { // 자리와 숫자 모두 일치할 때
				if (ans[i] == choice[i]) {
					strike++;
				}
				if (strike == 3) {
					System.out.print("정답을 맞추셨습니다!!\n컴퓨터의 숫자 : ");
					System.out.print(ans[0]);
					System.out.print(ans[1]);
					System.out.println(ans[2]);
					return;
				}
			}

			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					if (ans[i] == choice[j] && i != j) { // 숫자는 같지만 자리는 다를 때

						ball++;

					}
				}
			}
			
			int out = 3-strike-ball;
			
			System.out.println("스트라이크 : " + strike);
			System.out.println("볼 : " + ball);
			System.out.println("아웃 : "+out);
		}
	}

}
