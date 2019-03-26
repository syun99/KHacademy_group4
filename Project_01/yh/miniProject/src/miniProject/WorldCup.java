package miniProject;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class WorldCup {
	// 메뉴 이상형월드컵

	Scanner sc = new Scanner(System.in);
	Random rd = new Random();
	String[] arr; // 맨 처음으로 메뉴를 받을 배열
	String[] arr2; // 선택받은 메뉴를 담을 배열
	String select; // 메뉴 가짓수를 입력받을 변수
	
	public static void main(String[] args) {
		WorldCup wc = new WorldCup();
	}
	
	// 생성자 - 객체가 실행되면 메뉴 가짓수를 입력받고, 입력받은 값을 메뉴입력 메소드의 전달인자로 넘긴다(배열의 크기 결정)
	public WorldCup() {
		do {
			System.out.println("몇 개의 메뉴?\n4, 8, 16 중 입력");
			select = sc.next(); // int -> String으로 입력받을 값 바꾼 이유 : InputTypeMisMatchException 방지

			switch (select) {
			case "4":
				inputMenu(Integer.parseInt(select)); // 입력받은 값을 정수형 데이터로 변환 후 인자값 전달
				break;
			case "8":
				inputMenu(Integer.parseInt(select));
				break;
			case "16":
				inputMenu(Integer.parseInt(select));
				break;
			default:
				System.out.println("잘못된 입력입니다.\n");
				break;
			}
		} while (!(select == "4" || select == "8" || select == "16")); // 입력값이 4, 8, 16이 아니면 다시 입력받음

	}

	// 토너먼트할 메뉴를 입력받는 메소드
	public void inputMenu(int var) {
		arr = new String[var]; // 생성자에서 입력받은 메뉴 가짓수만큼의 배열을 생성한다 - 이 배열에 메뉴 입력받을거임
		System.out.println("===========");
		System.out.println("메뉴를 입력하세요");
		System.out.println("===========");

		for (int i = 0; i < arr.length; i++) { // 메뉴를 입력받아 배열에 넣어주는 조건문
			System.out.print("후보 " + (i+1) + "번 : ");
			arr[i] = sc.next();
		}
		
		worldcup(var); // 입력이 완료되면 토너먼트 메소드에 인자를 전달해 실행함
	}

	// 난수발생(중복x)을 위한 메서드
	public int[] random(int var) {
		int[] ranArr = new int[var];
		for (int i = 0; i < ranArr.length; i++) {
			ranArr[i] = rd.nextInt(ranArr.length);
			for (int j = 0; j < i; j++) {
				if (ranArr[i] == ranArr[j]) {
					i--;
				}
			}
		}

		return ranArr; // 난수를 담은 배열을 반환
	}

	// 본격적인 토너먼트 메소드
	public void worldcup(int var) {
		System.out.println("# 후보 메뉴 리스트 #");
		System.out.println(Arrays.toString(arr));
		System.out.println();
		int[] r = random(var); // 난수발생 메소드의 리턴 배열을 사용하기위해 새로운 배열에 담는다
		
		while(arr.length == 2&&arr[0]!=null) { // 메뉴를 담은 배열의 크기가 2라면, 결승전이다. 또, 배열의 0번째 인덱스 값이 널이 아니라면 반복한다
			System.out.println("# 결승전 #");
			System.out.println("[1:  "+arr[0] + "] vs [2: " + arr[1] + "]");
			System.out.print(">> ");
			String a = sc.next();
			
			if (Integer.parseInt(a) == 1) { // 입력받은 값이 1이라면, 배열이 0번째 인덱스값이 우승
				System.out.println("우승은 : " + arr[0].toString());
				arr[0]=null; // 반복문 중단을 위한 널값 부여
				select="4"; // select값을 변경을 안 해주면 다시 처음으로 돌아감. 생성자 내의 while문 조건 문제인 것 같은데 ..
				return; // 결승이 끝났으므로 메소드 종료
			} else if (Integer.parseInt(a) == 2) { // 배열의 1번째값이 우승
				System.out.println("우승은 : " + arr[1].toString());
				arr[0]=null;
				select="4";
				return; // 결승이 끝났으므로 메소드 종료
			} else {
				System.out.println("잘못된 입력입니다.\n");
			}
		}
		
		arr2 = new String[var / 2]; // 선택받은 메뉴를 담을 배열 - 토너먼트를 진행하면 절반의 메뉴가 선택받을 것이므로 배열의 크기는 전달받은 값의 절반
		System.out.println("===========");
		System.out.println("# " + arr.length + "강 시작 #");
		System.out.println("===========");

		int x = 0; // 선택받은 값을 담을 배열의 인덱스를 움직여줄 변수
		
		for (int i = 0; i < arr.length; i += 2) { // 토너먼트 진행 조건문
			System.out.println((x+1)+" R O U N D");
			System.out.println("[1: "+arr[r[i]] + "] vs [2: " + arr[r[i + 1]]+"]"); // 메뉴배열[난수배열의 i번째 인덱스] vs 메뉴배열[난수배열i+1번째]
			System.out.print(">> ");
			String a = sc.next();
			
			if (Integer.parseInt(a) == 1) { // 1번이 선택되었다면
				arr2[x] = arr[r[i]]; // 다음 토너먼트를 위한 배열 0번째 인덱스부터 선택받은 1번을 대입한다
				x++; // 다음 인덱스로

			} else if (Integer.parseInt(a) == 2) { // 2번, 위와 동일
				arr2[x] = arr[r[i + 1]];
				x++; // 다음 인덱스로
				
			} else { // 1이나 2가 아닌 다른 값을 입력받은 경우
				System.out.println("잘못된 입력입니다\n");
				i -= 2; // continue 방지, 이거 안 넣어주면 Round가 그냥 넘어감
			}

		}
		arr = arr2.clone(); // 다음게임(현재 16강이라면 8강)을 위해 메뉴배열을 선택받은 메뉴 배열로 초기화
		worldcup(var / 2); // 토너먼트 메소드 호출 - 현재 16강이라면 16을 /2한 8이 인자값으로 전달
	}

}
