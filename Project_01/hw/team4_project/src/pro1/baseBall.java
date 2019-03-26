package pro1;

import java.util.Random;
import java.util.Scanner;

public class baseBall {
	public baseBall() {
		Random ran = new Random();
		Scanner sc = new Scanner(System.in);

		int chance=0;
		System.out.println("\n\t>> [���� �߱� ���� START!!]");
		while(chance<3 || chance>9) {
			System.out.println("\n[3~9 ���� ����] ");
			System.out.print("��� ���� ġ�ðڽ��ϱ�?");
			chance = sc.nextInt();

			if(chance<3 || chance>9) System.out.println("\n\t�ٽ� �Է����ּ���!!");
		}
		int max = 0;
		max = chance;

		int[] com_num = new int[max];
		int[] user_num = new int[max];
		int[] strike_num = new int[max];
		int num=0;

		int strike =0;
		int ball = 0;
		int out = 0;
		int round=1;

		for(int i=0; i<max; i++) {
			com_num[i] = ran.nextInt(9)+1;
			for(int j=0; j<i; j++) {
				if(com_num[i]==com_num[j]) {
					i--;
				}
			}
		}

		System.out.println("\n\n------------- ���� ��Ģ -------------");
		System.out.println("��Ʈ����ũ(STRIKE): ���ڿ� ��ġ�� ��� ����");
		System.out.println("��(BALL): ���ڴ� ������ ��ġ�� Ʋ��");
		System.out.println("�ƿ�(OUT): ���ڿ� ��ġ�� ��� Ʋ��");
		System.out.println("Ȩ��(HOMERUN): �������� ���ڸ� ��Ȯ�� ����");
		System.out.println("--------------------------------");

		while(true) {
			System.out.println("\n\n[ROUND"+round+"]");
			System.out.println("1~9������ ���ڸ� "+max+"�� �Է��� �ּ���");
			for(int i=0; i<max; i++) {
				while(num<1 || num>9) {
					System.out.print((i+1)+"��° �� �Է� >> ");
					num=sc.nextInt();
					if(num<1 || num>9) System.out.println("\n\t>>�ٽ� �Է��� �ּ���!!\n");

				}
				user_num[i] = num;
				num=0;
			}
			for(int i=0; i<max; i++) {
				for(int j=0; j<max; j++) {
					if(com_num[i] == user_num[j]) {
						if(i==j) {
							strike++;
							strike_num[i] = user_num[j];
							if( strike == max) {
								System.out.println("\n\t>>"+round+"���� Ȩ��~~\n");

								return;
							}
						}
						else ball++;
					}
				}
			}
			out = max-ball-strike;
			System.out.println("\n[Round"+round+"���]");
			System.out.println("[STRIKE : " + strike+"\tBALL   : " + ball+"\tOUT    : " + out+"]");

			System.out.println("\n\n[���ݱ��� ���� ���ڿ� �ڸ�]");
			System.out.print("[");
			for(int i=0; i<max; i++) {
				System.out.print((i+1)+". "+strike_num[i]);
				if(i<max-1) System.out.print("\t");
			}
			System.out.println("]");
			
			round++;
			strike = 0;
			ball = 0;
			out = 0;
		}
	}
}