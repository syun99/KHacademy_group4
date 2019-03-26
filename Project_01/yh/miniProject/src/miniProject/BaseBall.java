package miniProject;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class BaseBall {
	Random rd = new Random();
	Scanner sc = new Scanner(System.in);

	// 생성자 - 객체 생성시 바로 게임 실행
	public BaseBall() {
		baseball();
	}

	// 난수 발생(컴퓨터의 배열 랜덤 설정)
	public int[] rand() {

		int[] ranArr = new int[3];

		for (int i = 0; i < ranArr.length; i++) {

			ranArr[i] = rd.nextInt(ranArr.length);

			for (int j = 0; j < i; j++) {

				if (ranArr[i] == ranArr[j]) {
					i--;
				}
				
			}
			
		}
		// 본 게임 메소드에서 사용할 리턴값
		return ranArr;
	}


	// 본격적인 게임 진행 메소드
	public void baseball() {

		int[] comArr = rand(); // 난수 발생 메소드의 리턴배열을 받아서 컴퓨터 배열로 대입

		int[] arr = new int[3]; // 내가 입력할 배열 - 이 배열과 컴퓨터 배열을 비교해서 strike, ball, out 판단

		int round = 1; // 현재 몇 라운드인지 알려줄 변수

		System.out.println("# 숫자야구 게임 시작! #\n");

		// 끝을 볼 때까지 게임 진행
		while (true) {

			// 라운드 결과를 알려줄 변수들
			int strike = 0;
			int ball = 0;
			int out = 0;

//			System.out.println(Arrays.toString(comArr)); --> 컴퓨터 배열 확인용 코드
			
			System.out.println("[ " + round + " ROUND ]");
			System.out.println("숫자 3개를 입력하세요");

			// 사용자에게 숫자를 입력받아서 배열에 순서대로 대입
			for (int i = 0; i < arr.length; i++) {

				while (true) {

					try { // 사용자 입력값이 정수형 데이터가 아닌 경우 예외처리
						arr[i] = sc.nextInt(); // 입력을 받아서 배열의 i번째 인덱스에 대입
					
						if(arr[i] > 9 || arr[i] < 0) { // 만약 입력값의 범위가 0~9를 벗어난다면 입력을 처음부터 다시 받는다(i = -1;)
							System.out.println("@입력 가능한 숫자의 범위 : 0 ~ 9 ");
							System.out.println("@처음부터 다시 입력합니다.\n");
							i=-1; // 왜 i를 0이 아닌 -1로 되돌리는가? --> 지금이 0번째 for문 실행중이기 때문
						}
						
						break; // while문 종료, for문 계속 진행
						
					} catch (InputMismatchException e) { // 사용자 입력값이 정수형 데이터가 아닌 경우
						System.out.println("@[ERROR] 입력 가능한 수 : 0 ~ 9");
						System.out.println("@처음부터 다시 입력합니다.\n");
						sc = new Scanner(System.in); // 왜인지는 모르겠는데 입력객체를 다시 초기화해줘야 제대로 동작한다.
						// 이 코드가 빠지면 입력을 다시 받지 못하고, 무한루프만 돌아간다.
						
						i = -1; // 위 구문의 i = -1;와 동일
						break;
					}
				}
			}

			System.out.println("당신이 선택한 숫자 : " + Arrays.toString(arr)+"\n");

			/*
			 * 컴퓨터 배열과 내 배열 비교.
			 * 컴퓨터의 배열에 내가 입력한 숫자가 있다면(comArr[i] == arr[j])
			 * 배열의 자릿수가 일치하는지 비교하고(i==j)
			 * 같다면 strike에 1 더함 / 같지 않다면 ball에 1 더함
			 * 
			 * 위의 작업을 끝낸 후에 strike와 ball이 0이라면 out에 1 더함
			 * 
			 */
			for (int i = 0; i < arr.length; i++) {

				int outCounter = 0; // out인지 아닌지 판별해줄 변수. 이 변수의 값이 0일 경우  out으로 간주한다

				for (int j = 0; j < arr.length; j++) {

					if (comArr[i] == arr[j]) {

						if (i == j) {
							strike++;
							outCounter++; // 만약 이 값이 strike라면, outCounter에 1을 더해줘서 0이 아닌 상태로 변경해준다
						} else {
							ball++;
							outCounter++;
						}

					}
				}

				// 배열들을 비교해서 strike와 ball이 카운트되지 않는다면 outCount도 카운트되지 않고, 그런 경우는 out이다
				if (outCounter == 0) {
					out++;
				}
				
				// 반복
			}
			
			// 스트라이크가 3이면 다 맞힌거니까, 이 코드는 설명 필요없음
			if (strike == 3) {
				System.out.println("# HOME RUN!! #");
				System.out.println("# 게임을 종료합니다 #");
				return; // 메소드 종료
			}
			
			System.out.println("--------- " + round + " ROUND 결과 ---------");
			System.out.println("[strike: " + strike + " ball: " + ball + " out: " + out + " ]\n");
			round++;
			
		}

	}

	// 메인 메소드(실행용)
	public static void main(String[] args) {
		new BaseBall();
	}

}
