package miniProject; //choice�� food������� ���ļ� ��� �����½����� ������

import java.util.Random;
import java.util.Scanner;

public class RecoRest {

	public void recommend() {

		Scanner sc = new Scanner(System.in);

		// 16���� ��������~
		String food[] = { "������", "���", "������ġ", "�ܹ���", "�ø�", "��ġ�", "�ᳪ������", "��", "����", "�޴���Ŀ��", "���ö�", "������", "���", "������", "�����Ǿ��", "¥���" };

		System.out.println("================================");
		System.out.println("     F o O d �� �� �� �� �� ��        ");
		System.out.println("================================");

		int round = 16;

		while (true) {
			
			int index = 0; //choice�迭�� �ε���
			int arr[] = new int[round]; // �ߺ������� ���� �ε����ѹ��� ����ִ� �迭
			int arr2[] = new int[round];

			for (int i = 0; i < round; i++) {
				arr[i] = i; // 0~15������ �ε���
			}

			Random rd = new Random();

			for (int i = 0; i < round; i++) {

				arr2[i] = arr[rd.nextInt(round)];

				for (int j = 0; j < i; j++) {// �ߺ����Ÿ� ���� ����
					if (arr2[i] == arr2[j]) {
						i--;
						break;
					}
				}

			}

			if (round != 2)
				System.out.println("+ + + + + " + round + "�� ���� + + + + +");
			else
				System.out.println("+ + + + + �� �� + + + + +");

				
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
				System.out.println(food[0] + "(��/��) ���������� �����Ǿ����ϴ�!");
				System.out.println(food[0] + "�� ���� �� �ִ� �Ĵ� ����Դϴ� ^ ^");
				return;
			} else
				round = round / 2;
		}

	}

}
