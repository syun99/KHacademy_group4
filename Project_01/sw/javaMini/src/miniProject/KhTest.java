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
		System.out.println("���ϴ� ����� �������ּ���");
		System.out.print("1. ���� ã�� �̻���������    2.�䰪 ���� ���ھ߱����� 3.����������\n>>");

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
