package miniProject;

import java.util.Random;

class ranMaker {
public void ranNum() { //중복하지 않는 랜덤변수 생성함수, 비교대상을 사용자에게 랜덤하게 보여줄 것임

	int arr[] = new int[16]; // 중복방지를 위한 인덱스넘버를 담고있는 배열
	int arr2[] = new int[16];
	
	for (int i = 0; i < 16; i++) {
		arr[i] = i + 1;
	}

	System.out.println("--------------------");
	Random rd = new Random();
	
	for (int i = 0; i < 16; i++) {
		arr2[i] = arr[rd.nextInt(16)];
		for (int j = 0; j < i; j++) {// 중복제거를 위한 구문
			if (arr2[i] == arr2[j]) {
				i--;
				break;
			}
		}

	}
//	for (int i = 0; i < 16; i++) { // 중복되지 않는 0~16범위 16개의 숫자 출력
//		System.out.println(arr2[i]);
//	}

}
}
