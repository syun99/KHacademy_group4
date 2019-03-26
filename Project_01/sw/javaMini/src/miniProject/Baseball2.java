package miniProject; //플레이어가 같은 숫자를 중복 입력했을 때에도 오류없이 결과를 출력함

import java.util.Random;
import java.util.Scanner;

public class Baseball2 { // 문제 : 223이 답일 때 322면 1스트라잌 2볼인데 1s1b뜸 (기존스트라이크숫자는볼처리안하게해놔서)
	public void game() {

		Random rd = new Random();
		int idx[] = new int[10];
		int ans[] = new int[3];

		// ---------------겹치지 않는 3자리 숫자를 생성하기 위한 구문----------------------
		for (int i = 0; i < 10; i++) {
			idx[i] = i;
		}

		for (int i = 0; i < 3; i++) {
			ans[i] = idx[rd.nextInt(10)]; //idx[0~9]를 랜덤으로 불러옴
			for (int j = 0; j < i; j++) { //조건문때문에 i, j가 둘다 0일땐 검사 안함
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

			int strike = 0;
			int ball = 0;
			int strArr[] = new int[3];
			int strIndex = 0;

			for (int i = 0; i < 3; i++) { // 자리와 숫자 모두 일치할 때
				if (ans[i] == choice[i]) {

					strArr[strIndex] = choice[i]; // 밑에서 볼을 검증할 때 스트라이크 난 전적이 있는 숫자인지 판별하기 위한 배열
					strike++;
					strIndex++;
				}
				if (strike == 3) {
					System.out.println("정답을 맞추셨습니다!!");
					return;
				}
			}

			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					if (ans[i] == choice[j] && i != j) { // 숫자는 같지만 자리는 다를 때
						for (int k = 0; k < strArr.length; k++) { // 바로 ball추가하지 않고 스트라이크 전적이 있는지 확인
							if (strArr[k] == choice[j])
								// 스트라이크가 난숫자와 일치하면 추가로 볼을 내지 않는다.
								break;
							else if ((strArr[k] != choice[j]) && (k == strArr.length - 1))
								// 스트라이크 전적이 없고, 스트라이크난 숫자를 저장한 배열을 모두 돌아서 검증이 끝났을 때 비로소 ball을 추가
								ball++;
						}
					}
				}
			}

			System.out.println("스트라이크 : " + strike);
			System.out.println("볼 : " + ball);
		}
	}

}

