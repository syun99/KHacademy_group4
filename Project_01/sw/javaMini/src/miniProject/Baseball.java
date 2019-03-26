package miniProject; //�÷��̾ ���� ���ڸ� �Է��ϸ� �ȉ�

import java.util.Random;
import java.util.Scanner;

public class Baseball { // ���� : 223�� ���� �� 322�� 1��Ʈ��� 2���ε� 1s1b�� (������Ʈ����ũ���ڴº�ó�����ϰ��س���)
	public void game() {

		Random rd = new Random();
		int idx[] = new int[10];
		int ans[] = new int[3];

		// ---------------��ġ�� �ʴ� 3�ڸ� ���ڸ� �����ϱ� ���� ����----------------------
		for (int i = 0; i < 10; i++) {
			idx[i] = i;
		}

		for (int i = 0; i < 3; i++) {
			ans[i] = idx[rd.nextInt(10)]; // idx[0~9]�� �������� �ҷ���
			for (int j = 0; j < i; j++) { // ���ǹ������� i, j�� �Ѵ� 0�϶� �˻� ����
				if (ans[i] == ans[j]) {
					i--;
					break;
				}
			}

		}
		// ----------------------------------------------------

		Scanner sc = new Scanner(System.in);

		System.out.println("================================");
		System.out.println("       ��! ����ִ� ���� �߱� GAME        ");
		System.out.println("================================");
		
		System.out.println("��ǻ�ͼ��� : "); // �׽�Ʈ�� ���� ����
		System.out.print(ans[0]);
		System.out.print(ans[1]);
		System.out.println(ans[2]);

		while (true) {

			int choice[] = new int[3];
			System.out.println("���ڸ� ���ڸ� �Է��ϼ��� >> ");
			
			int input = sc.nextInt();
			
			choice[0] = input / 100;
			choice[1] = (input % 100) / 10;
			choice[2] = (input % 100) % 10; // �� �ڸ��� ���� �迭�� �����ϴ� ����
			
			if(choice[0]==choice[1] || choice[1]==choice[2] || choice[0]==choice[2]) {
				System.out.println("�ߺ��� ���ڴ� �Ұ��մϴ�!");
				continue; //���� ����� ���ǹ��� while���� ���ǹ����� �ö�
			}

			int strike = 0;
			int ball = 0;

			for (int i = 0; i < 3; i++) { // �ڸ��� ���� ��� ��ġ�� ��
				if (ans[i] == choice[i]) {
					strike++;
				}
				if (strike == 3) {
					System.out.print("������ ���߼̽��ϴ�!!\n��ǻ���� ���� : ");
					System.out.print(ans[0]);
					System.out.print(ans[1]);
					System.out.println(ans[2]);
					return;
				}
			}

			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					if (ans[i] == choice[j] && i != j) { // ���ڴ� ������ �ڸ��� �ٸ� ��

						ball++;

					}
				}
			}
			
			int out = 3-strike-ball;
			
			System.out.println("��Ʈ����ũ : " + strike);
			System.out.println("�� : " + ball);
			System.out.println("�ƿ� : "+out);
		}
	}

}
