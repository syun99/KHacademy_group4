package miniProject;

import java.text.ParseException;
import java.util.Scanner;

public class KhTest {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		RecoRest rr = new RecoRest();
		Baseball bb = new Baseball();
		LetmeGo LG = new LetmeGo();

		System.out.println("WELCOME!!");
		System.out.println("원하는 기능을 선택해주세요");
		System.out.print("1. 밥집 찾기 이상형월드컵    2.밥값 내기 숫자야구게임 3.집에보내줘\n>>");

		switch (sc.nextInt()) {
		case 1:
			rr.recommend();
			break;
		case 2:
			bb.game();
			break;
		case 3:
			try {
				LG.Letmego();
			} catch (ParseException e) {
				
				e.printStackTrace();
			}
			

		}

	}

}
