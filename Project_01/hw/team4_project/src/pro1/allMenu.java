package pro1;

import java.util.Random;
import java.util.Scanner;
//---Main Menu---
//1. 밥집 추천프로그램 
// 방식1) 양식, 중식 등 원하는 종류의 카테고리 내에서 랜덤추천
// 방식2) 이상형 월드컵 식으로 하나씩 지워나가는 식으로 최종결정
//
//2. 밥값 몰아주기 게임 
// -둘이서or 여럿이서 할 수 있는 게임으로 순위를 매겨 꼴찌가 식사값을 냄
//  숫자야구게임
//
//3. 메신저 프로그램
// -여러명 대화 가능하도록?
//
//4. 집가고싶다
// - 현재시간을 입력하면 집에 갈때까지 남은 수업시간과 쉬는시간을 계산해줌
//
//5. 시간표 출력
// - 외부 파일을 읽어와서 콘솔에 출력해주는 식으로?
public class allMenu {
	
	public static void main(String[] args) {
		main_menu();
//		food();
		
//		game();
	}
	
	public static void main_menu() {
		Scanner sc = new Scanner(System.in);
		int choice_menu=0;
		while(true) {
			System.out.println("----------- Main Menu -----------");
			System.out.println("1.밥집 추천프로그램");
			System.out.println("2.밥값 몰아주기 게임 - 숫자야구게임");
			System.out.println("3.메신저 프로그램");
			System.out.println("4.집 가고싶다");
			System.out.println("5.시간표 출력");
			System.out.println("6.*프로그램 종료*");
			System.out.println("---------------------------------");

			while(choice_menu<1 || choice_menu>6) {
				System.out.print("원하는 메뉴를 선택해 주세요 :");
				choice_menu = sc.nextInt();
				if(choice_menu<1 || choice_menu>6) System.out.println("\n    >>다시 입력해 주세요!!\n");
			}
			switch(choice_menu) {
			case 1: food(); break;
			case 2: game();	break;
			case 3: System.out.println("hi3"); break;
			case 4: System.out.println("hi4"); break;
			case 5: System.out.println("hi5"); break;
			case 6: System.out.println("프로그램을 종료 합니다."); return;
			}
			choice_menu=0;
		}
	}
	
	public static void food() {
		
		Scanner sc = new Scanner(System.in);
		Random ran = new Random();
		
		int round=1;
		int ch = 0;
		String str[] = {"칼국수", "김치찜", "수육", "LA갈비", "삼겹살", "물냉면", "비빔냉면", "순두부", "비지장", "콩국수",
			    	    "스테이크", "돈까스", "갈비탕", "스파게티", "돈부리", "초밥", "회", "핫도그", "샌드위치", "햄버거",
				        "볶음밥","전골","동태찜","고등어구이","국밥","순대","탕수육","깐풍기","짜장면","짬뽕","우동","깐쇼새우"};
		
		int rank_round = 32;
		String[] str1 = new String[rank_round];
		String[] str2 = new String[rank_round/2];

		int[] arr = new int[rank_round];
		
		System.out.println("----음식 월드컵----\n");
		
		while(true) {
			int n=0;
			//렌덤뿌리기
			for(int i=0; i<rank_round; i++) {
				arr[i] = ran.nextInt(rank_round);
				for(int j=0; j<i; j++) {
					if(arr[i]==arr[j]) {
						i--;
					}
				}
			}

			for(int i=0; i<rank_round; i++) {
				if(rank_round==32) {
					str1[i] = str[arr[i]];
				} else {
					str1[i] = str2[arr[i]];
				}
			}

			if(rank_round==32)		System.out.println("-------["+rank_round/2+"강]-------");
			else if(rank_round==16)	System.out.println("-------["+rank_round/2+"강]-------");
			else if(rank_round==8)	System.out.println("-------["+rank_round/2+"강]-------");
			else if(rank_round==4)	System.out.println("-------[준결승]-------");
			else if(rank_round==2)	System.out.println("-------[결승]-------");
			
			round=1;
			for(int i=0; i<rank_round; i++) {
				if(rank_round==2)	System.out.println("[FINAL]");
				else	System.out.println("[Round"+round+"]");
				
				System.out.println("1."+str1[i] + " VS "+ "2."+ str1[i+1]);
				while(ch<1 || ch>2) {
					System.out.print("음식선택 (1 or 2): ");
					ch = sc.nextInt();
					if(ch<1 || ch>2) System.out.println("\t>>다시입력!!");
				}
				if(ch==1) {
					str2[n]= str1[i];
					System.out.println("\t>>["+str1[i]+"]을 선택!!\n");
				} else if(ch==2) {
					str2[n]= str1[i+1];
					System.out.println("\t>>["+str1[i+1]+"]을 선택!!\n");
				}
				i++;
				n++;
				ch=0;
				round++;
			}
			
			rank_round /= 2;
			if(rank_round<2) {
				System.out.println("\n\t>>우승 : "+str2[0]+"\n");
				break;
			}
		}
	
	}
	
	public static void game() {
//		-스트라이크(STRIKE): 숫자와 위치가 모두 맞음
//		-볼(BALL): 숫자는 맞지만 위치가 틀림
//		-아웃(OUT): 숫자와 위치가 모두 틀림
//		-홈런(HOMERUN): 수비팀의 숫자를 정확히 맞힘
		
		Random ran = new Random();
		Scanner sc = new Scanner(System.in);
		System.out.print("몇개의 공을 치시겠습니까?");
		int MAX = sc.nextInt();

		int[] com_num = new int[MAX];	//컴퓨터
		int[] user_num = new int[MAX];	//사용자
		int[] strike_num = new int[MAX];
		int num=0;
		
		int strike =0;
		int ball = 0;
		int out = 0;
		int round=1;
		
		for(int i=0; i<MAX; i++) {
			com_num[i] = ran.nextInt(9)+1;
			for(int j=0; j<i; j++) {
				if(com_num[i]==com_num[j]) {
					i--;
				}
			}
		}
		
		System.out.println("\n----------숫자 야구 게임-----------");
		System.out.println("스트라이크(STRIKE): 숫자와 위치가 모두 맞음");
		System.out.println("볼(BALL): 숫자는 맞지만 위치가 틀림");
		System.out.println("아웃(OUT): 숫자와 위치가 모두 틀림");
		System.out.println("홈런(HOMERUN): 수비팀의 숫자를 정확히 맞힘");
		System.out.println("-------------------------------");
		
		while(true) {
			System.out.println("\n[ROUND"+round+"]");
			System.out.println("1~9까지의 숫자를 "+MAX+"번 입력해 주세요");
			for(int i=0; i<MAX; i++) {
				while(num<1 || num>9) {
					System.out.print((i+1)+"번째 수 입력 >> ");
					num=sc.nextInt();
					if(num<1 || num>9) System.out.println("\n\t>>다시 입력해 주세요!!\n");
				}
				user_num[i] = num;
				num=0;
			}
			
			for(int i=0; i<MAX; i++) {
				for(int j=0; j<MAX; j++) {
					if(com_num[i] == user_num[j]) {
						if(i==j) {
							strike++;
							strike_num[i] = user_num[j];
							if( strike == MAX) {
								System.out.println("\n\t>>"+round+"라운드 홈런~~\n");
								
								return;
							}
						}
						else ball++;
					}
				}
			}
			out = MAX-ball-strike;
			System.out.println("\n[STRIKE : " + strike+"\tBALL   : " + ball+"\tOUT    : " + out+"]\n");
			
			System.out.println("\n\nRound"+round+" STRIKE 결과\n");
			for(int i=0; i<MAX; i++) {
				System.out.print((i+1)+"."+strike_num[i]+"\t");
			}
			round++;
			strike = 0;
			ball = 0;
			out = 0;
		}
	}
	
	
	
	
}
