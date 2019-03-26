package miniProject;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class MenuRecommend {

	// 메뉴 추천받는 프로그램
	
	Scanner sc = new Scanner(System.in); // 입력객체

	ArrayList korean = new ArrayList(); // 한식 카테고리 리스트
	ArrayList chinese = new ArrayList(); // 주식 카테고리 리스트
	ArrayList japanese = new ArrayList(); // 일실 카테고리 리스트
	ArrayList western = new ArrayList(); // 양식 카테고리 리스트

	ArrayList allRandom = null; // 전체 카테고리 랜덤을 위한 리스트(모든 리스트의 값을 집어넣어줄것임)
	
	ArrayList menu = new ArrayList(); // 이 리스트에 다른 리스트들을 담아서 코드를 줄여보려고 썼는데 별 효과 없었음.
	// 맵을 사용한다면 내가 원하는대로 구현을 할 수 있을 지도 모르겠지만, 맵에 익숙하지 않아서 사용하지 못했음. --> * 맵 공부하기 *

	// 생성자, 메뉴 리스트에 리스트들을 넣어주고, 프로그램의 메인 메뉴 메서드 실행
	public MenuRecommend() {

		menu.add(0, korean);
		menu.add(1, chinese);
		menu.add(2, japanese);
		menu.add(3, western);

		mainSelect();

	}

	// 프로그램의 메인 메뉴 메서드
	public void mainSelect() {

		System.out.println("# 메뉴 추천 프로그램 #\n");
		do {
			System.out.println("\n[M a i n M e n u]");
			System.out.println("\n1. 메뉴 확인 및 수정\n");
			System.out.println("2. 메뉴 랜덤 추천\n");

			String str = sc.next();

			switch (str) { // 사용자의 입력을 받아서 하위 메뉴(메서드)를 실행한다

			case "1": checkModify(); // 음식 메뉴 확인, 추가 및 삭제가 가능한 메서드
				break;
			case "2": randomReco(); // 랜덤 추천 메서드
				break;
			default: System.out.println("@ 잘못된 입력입니다.\n");
				break;

			}
			
		} while(true); // 프로그램 종료는 넣지않았음

	}

	// 음식 메뉴의 추가 및 삭제가 가능한 메서드
	public void checkModify() {

		System.out.println("#     메뉴 확인     #\n");
		System.out.println("===== 메뉴 리스트 ====="); // 메서드가 실행되면 음식 메뉴 리스트를 보여준다
		System.out.println("# 한식 " + korean.toString());
		System.out.println("# 중식 " + chinese.toString());
		System.out.println("# 일식 " + japanese.toString());
		System.out.println("# 양식 " + western.toString());
		System.out.println("");

		while (true) {
			System.out.println("===== 메뉴 수정 =====");
			System.out.println("[1] 한식 [2] 중식 [3] 일식 [4] 양식");
			System.out.println("[0] 돌아가기");

			String str = sc.next();

			switch (str) {
			case "1": menuModify(0); // 전달인자는 ArrayList menu의 인덱스로 활용. (0 = 한식리스트, 1 = 중식 ... --> 생성자 참고)
				break;
			case "2": menuModify(1);
				break;
			case "3": menuModify(2);
				break;
			case "4": menuModify(3);
				break;

			case "0": // 0 입력받으면 메서드 종료되면서 이전 메서드로 돌아감(stack)
				return;

			default: System.out.println("@ 잘못된 입력입니다.\n");
				break;

			}
		}
	}

	public void menuModify(int var) {

		if(var==0) System.out.println("===== 한식 =====\n"); // 사용자가 어떤 카테고리를 선택했는지 알려주기
		if(var==1) System.out.println("===== 중식 =====\n");
		if(var==2) System.out.println("===== 일식 =====\n");
		if(var==3) System.out.println("===== 양식 =====\n");

		while (true) {
			System.out.println("===== 메뉴 리스트 =====");
			System.out.println(menu.get(var).toString()); // 예를 들어 menu.get(0).toString이라면 menu의 0번째 인덱스(한식 리스트)를 꺼내서 .toString 해주는 코드
															// --> 한식 리스트에 저장된 음식 목록을 보여주겠져?
			System.out.println("\n[1] 추가 [2] 삭제 [0] 돌아가기");

			String str = sc.next();

			switch (str) {
			case "1": menuAdd(var); // 입력값이 "추가"에 해당하는 "1"이라면 메뉴 추가 메서드 실행
				break;
			case "2": menuDel(var); // -- 메뉴 삭제 메서드 실행
				break;

			case "0": // 입력값 0이면 메서드 종료, 이전 메서드로 돌아감(stack)
				return;
				
			default : System.out.println("@ 잘못된 입력입니다.\n");
				break;
			}
		}
	}
	
	// 메뉴 추가 메서드
	public void menuAdd(int var) {
		String input = null; // switch-case구문을 위에서 써서, 아래에 또 같은 구문을 작성하고 싶지 않아서 사용한 메서도 종료 조건 변수
		
		do {
			System.out.println("추가할 메뉴 입력");
			System.out.print(">> ");
			String str = sc.next();
			
			// 입력받은 그대로 해당 리스트에 add해주는 구문
			switch (var) {
			case 0: korean.add(str); 
				break;
			case 1: chinese.add(str);
				break;
			case 2: japanese.add(str);
				break;
			case 3: western.add(str);
				break;
			}
			
			System.out.println("\n[" + str + "] 추가 완료\n");
			
			System.out.println("===== 리스트 확인 =====");
			System.out.println(menu.get(var).toString());
			System.out.println("===================\n");
			System.out.println("[1] 계속 추가 [0] 돌아가기");
			
			input = sc.next();
			
			if (input.equals("0")) return; // input의 값이 "0"과 같다면 메서드 종료. "2"나 "3"을 입력받아도 "1"을 입력받은 것처럼 계속 반복문이 돈다
											// 고쳐야하지만 일단 놔뒀음(귀찮)
			
		} while (true);
	}
	
	// 메뉴 삭제 메서드 -- 동작 방식이 위의 메뉴 추가 메서드와 동일하므로 설명하지 않겠음
	public void menuDel(int var) {
		String input = null;
		
		do {
			System.out.println("삭제할 메뉴 입력");
			System.out.print(">> ");
			String str = sc.next();
			
			switch (var) {
			case 0: korean.remove(str);
				break;
			case 1: chinese.remove(str);
				break;
			case 2: japanese.remove(str);
				break;
			case 3: western.remove(str);
				break;
			}
			
			System.out.println("\n[" + str + "] 삭제 완료\n");
			System.out.println("===== 리스트 확인 =====");
			System.out.println(menu.get(var).toString());
			System.out.println("===================\n");
			System.out.println("[1] 계속 삭제 [0] 돌아가기");
			
			input = sc.next();
			
			if (input.equals("0")) return;
			
		} while (true);
		
	}
	
	// 랜덤 추천 메뉴 메서드
	public void randomReco() {
		
		while(true) {
		
			System.out.println("===== 랜덤 메뉴 추천 =====\n");
			
			System.out.println("[1] 전체 랜덤 [2] 카테고리 랜덤 [0] 돌아가기\n");
			String str = sc.next();
		
			switch(str) {
			case "1" : System.out.println("# 전체 랜덤 결과 : " + allRan() + "\n"); // 전체 랜덤 결과 보여주기
				break;
			case "2" : categoryRan(); // 카테고리 랜덤 메서드 실행
				break;
			case "0" :
				return;
			default : System.out.println("@ 잘못된 입력입니다.\n");
				break;
			}
		
		}

	}

	// 난수 발생 메서드, 이 메서드의 반환값을 사용해서 카테고리, 전체 랜덤을 뽑아낼거임
	public int random(int var) {
		Random rd = new Random();
		return rd.nextInt(var);
	}
	
	// 전체 메뉴 랜덤 추천 메서드
	public String allRan() {
		
		allRandom = new ArrayList(); // 모든 카테고리의 메뉴를 저장할 메서드

		// 리스트의 요소를 하나씩 꺼내와서 전체메뉴 리스트에 담는다
		// 리스트의 크기가 서로 다를 수 있으므로 각각 for문 사용
		for(int i = 0; i < korean.size(); i++) { 
			allRandom.add(korean.get(i));
		}
		for(int i = 0; i < chinese.size(); i++) {
			allRandom.add(chinese.get(i));
		}
		for(int i = 0; i < japanese.size(); i++) {
			allRandom.add(japanese.get(i));
		}
		for(int i = 0; i < western.size(); i++) {
			allRandom.add(western.get(i));
		}
		
		String str; // 리턴할 값을 담을 변수
		
		if(allRandom.isEmpty()) { // 전체 메뉴 리스트가 비어있다면
			str = "\n@ 모든 카테고리가 비어있습니다.";
		} else { // 하나의 요소라도 가지고 있다면									//	5					2		1					3		4
			str = allRandom.get(random(allRandom.size())).toString(); // str에 대입 전체메뉴리스트의(난수발생(전체메뉴리스트의 크기만큼))번째요소를가져와서.문자열로파싱
		}
		return str;
	}
	
	// 카테고리별 랜덤 추천 메서드
	public void categoryRan() {
		
		while(true) {
			System.out.println("===== 카테고리 랜덤 =====\n");
		
			System.out.println("[1] 한식 [2] 중식 [3] 일식 [4] 양식 [0] 돌아가기\n");
			String str = sc.next();

			switch(str) {
			case "1" : 
				if(korean.isEmpty()) {System.out.println("@ 해당 카테고리가 비어있습니다."); break;}
				System.out.println("# 한식 랜덤 결과 : "+korean.get(random(korean.size())).toString()+"\n");
				break;
			case "2" :
				if(chinese.isEmpty()) {System.out.println("@ 해당 카테고리가 비어있습니다."); break;}
				System.out.println("# 중식 랜덤 결과 : "+chinese.get(random(chinese.size())).toString()+"\n");
				break;
			case "3" :
				if(japanese.isEmpty()) {System.out.println("@ 해당 카테고리가 비어있습니다."); break;}
				System.out.println("# 일식 랜덤 결과 : "+japanese.get(random(japanese.size())).toString()+"\n");
				break;
			case "4" : 
				if(western.isEmpty()) {System.out.println("@ 해당 카테고리가 비어있습니다."); break;}
				System.out.println("# 양식 랜덤 결과 : "+western.get(random(western.size())).toString()+"\n");
				break;
	
			case "0" :
				return;
		
			default : System.out.println("@ 잘못된 입력입니다.\n");
				break;
		
			}
		}
		
	}
	
	// 메인 메서드
	public static void main(String[] args) {
		new MenuRecommend(); // 객체 생성하면, 생성자에 의해 자동으로 프로그램 진행
		
	}

}
