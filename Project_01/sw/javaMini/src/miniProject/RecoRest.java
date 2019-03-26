package miniProject; //choice와 food배ㅑ열을 합쳐서 계속 덮어씌우는식으로 가본다

import java.util.Random;
import java.util.Scanner;

public class RecoRest {

	public void recommend() {

		Scanner sc = new Scanner(System.in);

		// 16개의 음식종류~
		String food[] = { "떡볶이", "라면", "샌드위치", "햄버거", "냉면", "김치찌개", "콩나물국밥", "빵", "수육", "달달한커피", "도시락", "수제비", "김밥", "탕수육", "마음의양식", "짜장면" };

		System.out.println("================================");
		System.out.println("     F o O d 이 상 형 월 드 컵        ");
		System.out.println("================================");

		int round = 16;

		while (true) {
			
			int index = 0; //choice배열의 인덱스
			int arr[] = new int[round]; // 중복방지를 위한 인덱스넘버를 담고있는 배열
			int arr2[] = new int[round];

			for (int i = 0; i < round; i++) {
				arr[i] = i; // 0~15까지의 인덱스
			}

			Random rd = new Random();

			for (int i = 0; i < round; i++) {

				arr2[i] = arr[rd.nextInt(round)];

				for (int j = 0; j < i; j++) {// 중복제거를 위한 구문
					if (arr2[i] == arr2[j]) {
						i--;
						break;
					}
				}

			}

			if (round != 2)
				System.out.println("+ + + + + " + round + "강 시작 + + + + +");
			else
				System.out.println("+ + + + + 결 승 + + + + +");

				
			String choice[] = new String[round/2];
			
			for (int i = 0; i < round - 1; i += 2) {
				
				System.out.println("1. "+food[arr2[i]] + " [VS] 2. " + food[arr2[(i + 1)]]); 

				int choiceNum = sc.nextInt();

				if (choiceNum == 1) {

					choice[index] = food[arr2[i]];
					index++;
				}

				else if (choiceNum == 2) {
					choice[index] = food[arr2[i + 1]];
					index++;
					
				}

			}
			
			for(int i =0; i<round/2; i++) {
				food[i] = choice[i];
			}
			
			

			if (round == 2) {
				System.out.println(food[0] + "(이/가) 최종적으로 선정되었습니다!");
				System.out.println(food[0] + "을 먹을 수 있는 식당 목록입니다 ^ ^");
				return;
			} else
				round = round / 2;
		}

	}

}
