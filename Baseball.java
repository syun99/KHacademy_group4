package miniProject;

import java.util.Random;
import java.util.Scanner;

public class Baseball {
	public void game() {

		Random rd = new Random(); // 0~9 ������ ������������
		int ans[] = new int[3];
		ans[0] = rd.nextInt(10);
		ans[1] = rd.nextInt(10);
		ans[2] = rd.nextInt(10); // ���ڸ��� �������� ����

//		System.out.print(ans[0]);
//		System.out.print(ans[1]);
//		System.out.print(ans[2]);

		Scanner sc = new Scanner(System.in);
		int choice[] = new int[3];
		System.out.println("���ڸ� ���ڸ� �Է��ϼ���");

		int input = sc.nextInt();
		choice[0] = input / 100;
		choice[1] = (input % 100) / 10;
		choice[2] = (input % 100) % 10; // �� �ڸ��� ���� �迭�� �����ϴ� ����

//		System.out.println("ù°�ڸ�"+choice[0]);
//		System.out.println("��°�ڸ�"+choice[1]);
//		System.out.println("��°�ڸ�"+choice[2]);
		int strike = 0;
		int ball = 0;
		
		for (int i = 0; i < 3; i++) {
			if (ans[i] == choice[i])
				strike++;
		}
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (choice[i] == ans[j]&& i!=j) {
					ball++;
				}
			}
		}
		System.out.println("��ǻ�ͼ��� : ");
		System.out.print(ans[0]);
		System.out.print(ans[1]);
		System.out.print(ans[2]);
		System.out.println();
		System.out.println("��Ʈ����ũ : "+strike);
		System.out.println("�� : "+ball);
	}

}
