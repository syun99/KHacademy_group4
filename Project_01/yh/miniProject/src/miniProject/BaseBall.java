package miniProject;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class BaseBall {
	Random rd = new Random();
	Scanner sc = new Scanner(System.in);

	// ������ - ��ü ������ �ٷ� ���� ����
	public BaseBall() {
		baseball();
	}

	// ���� �߻�(��ǻ���� �迭 ���� ����)
	public int[] rand() {

		int[] ranArr = new int[3];

		for (int i = 0; i < ranArr.length; i++) {

			ranArr[i] = rd.nextInt(ranArr.length);

			for (int j = 0; j < i; j++) {

				if (ranArr[i] == ranArr[j]) {
					i--;
				}
				
			}
			
		}
		// �� ���� �޼ҵ忡�� ����� ���ϰ�
		return ranArr;
	}


	// �������� ���� ���� �޼ҵ�
	public void baseball() {

		int[] comArr = rand(); // ���� �߻� �޼ҵ��� ���Ϲ迭�� �޾Ƽ� ��ǻ�� �迭�� ����

		int[] arr = new int[3]; // ���� �Է��� �迭 - �� �迭�� ��ǻ�� �迭�� ���ؼ� strike, ball, out �Ǵ�

		int round = 1; // ���� �� �������� �˷��� ����

		System.out.println("# ���ھ߱� ���� ����! #\n");

		// ���� �� ������ ���� ����
		while (true) {

			// ���� ����� �˷��� ������
			int strike = 0;
			int ball = 0;
			int out = 0;

//			System.out.println(Arrays.toString(comArr)); --> ��ǻ�� �迭 Ȯ�ο� �ڵ�
			
			System.out.println("[ " + round + " ROUND ]");
			System.out.println("���� 3���� �Է��ϼ���");

			// ����ڿ��� ���ڸ� �Է¹޾Ƽ� �迭�� ������� ����
			for (int i = 0; i < arr.length; i++) {

				while (true) {

					try { // ����� �Է°��� ������ �����Ͱ� �ƴ� ��� ����ó��
						arr[i] = sc.nextInt(); // �Է��� �޾Ƽ� �迭�� i��° �ε����� ����
					
						if(arr[i] > 9 || arr[i] < 0) { // ���� �Է°��� ������ 0~9�� ����ٸ� �Է��� ó������ �ٽ� �޴´�(i = -1;)
							System.out.println("@�Է� ������ ������ ���� : 0 ~ 9 ");
							System.out.println("@ó������ �ٽ� �Է��մϴ�.\n");
							i=-1; // �� i�� 0�� �ƴ� -1�� �ǵ����°�? --> ������ 0��° for�� �������̱� ����
						}
						
						break; // while�� ����, for�� ��� ����
						
					} catch (InputMismatchException e) { // ����� �Է°��� ������ �����Ͱ� �ƴ� ���
						System.out.println("@[ERROR] �Է� ������ �� : 0 ~ 9");
						System.out.println("@ó������ �ٽ� �Է��մϴ�.\n");
						sc = new Scanner(System.in); // �������� �𸣰ڴµ� �Է°�ü�� �ٽ� �ʱ�ȭ����� ����� �����Ѵ�.
						// �� �ڵ尡 ������ �Է��� �ٽ� ���� ���ϰ�, ���ѷ����� ���ư���.
						
						i = -1; // �� ������ i = -1;�� ����
						break;
					}
				}
			}

			System.out.println("����� ������ ���� : " + Arrays.toString(arr)+"\n");

			/*
			 * ��ǻ�� �迭�� �� �迭 ��.
			 * ��ǻ���� �迭�� ���� �Է��� ���ڰ� �ִٸ�(comArr[i] == arr[j])
			 * �迭�� �ڸ����� ��ġ�ϴ��� ���ϰ�(i==j)
			 * ���ٸ� strike�� 1 ���� / ���� �ʴٸ� ball�� 1 ����
			 * 
			 * ���� �۾��� ���� �Ŀ� strike�� ball�� 0�̶�� out�� 1 ����
			 * 
			 */
			for (int i = 0; i < arr.length; i++) {

				int outCounter = 0; // out���� �ƴ��� �Ǻ����� ����. �� ������ ���� 0�� ���  out���� �����Ѵ�

				for (int j = 0; j < arr.length; j++) {

					if (comArr[i] == arr[j]) {

						if (i == j) {
							strike++;
							outCounter++; // ���� �� ���� strike���, outCounter�� 1�� �����༭ 0�� �ƴ� ���·� �������ش�
						} else {
							ball++;
							outCounter++;
						}

					}
				}

				// �迭���� ���ؼ� strike�� ball�� ī��Ʈ���� �ʴ´ٸ� outCount�� ī��Ʈ���� �ʰ�, �׷� ���� out�̴�
				if (outCounter == 0) {
					out++;
				}
				
				// �ݺ�
			}
			
			// ��Ʈ����ũ�� 3�̸� �� �����Ŵϱ�, �� �ڵ�� ���� �ʿ����
			if (strike == 3) {
				System.out.println("# HOME RUN!! #");
				System.out.println("# ������ �����մϴ� #");
				return; // �޼ҵ� ����
			}
			
			System.out.println("--------- " + round + " ROUND ��� ---------");
			System.out.println("[strike: " + strike + " ball: " + ball + " out: " + out + " ]\n");
			round++;
			
		}

	}

	// ���� �޼ҵ�(�����)
	public static void main(String[] args) {
		new BaseBall();
	}

}
