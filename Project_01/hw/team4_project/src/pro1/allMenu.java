package pro1;

import java.util.Random;
import java.util.Scanner;
//---Main Menu---
//1. ���� ��õ���α׷� 
// ���1) ���, �߽� �� ���ϴ� ������ ī�װ� ������ ������õ
// ���2) �̻��� ������ ������ �ϳ��� ���������� ������ ��������
//
//2. �䰪 �����ֱ� ���� 
// -���̼�or �����̼� �� �� �ִ� �������� ������ �Ű� ��� �Ļ簪�� ��
//  ���ھ߱�����
//
//3. �޽��� ���α׷�
// -������ ��ȭ �����ϵ���?
//
//4. ������ʹ�
// - ����ð��� �Է��ϸ� ���� �������� ���� �����ð��� ���½ð��� �������
//
//5. �ð�ǥ ���
// - �ܺ� ������ �о�ͼ� �ֿܼ� ������ִ� ������?
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
			System.out.println("1.���� ��õ���α׷�");
			System.out.println("2.�䰪 �����ֱ� ���� - ���ھ߱�����");
			System.out.println("3.�޽��� ���α׷�");
			System.out.println("4.�� ����ʹ�");
			System.out.println("5.�ð�ǥ ���");
			System.out.println("6.*���α׷� ����*");
			System.out.println("---------------------------------");

			while(choice_menu<1 || choice_menu>6) {
				System.out.print("���ϴ� �޴��� ������ �ּ��� :");
				choice_menu = sc.nextInt();
				if(choice_menu<1 || choice_menu>6) System.out.println("\n    >>�ٽ� �Է��� �ּ���!!\n");
			}
			switch(choice_menu) {
			case 1: food(); break;
			case 2: game();	break;
			case 3: System.out.println("hi3"); break;
			case 4: System.out.println("hi4"); break;
			case 5: System.out.println("hi5"); break;
			case 6: System.out.println("���α׷��� ���� �մϴ�."); return;
			}
			choice_menu=0;
		}
	}
	
	public static void food() {
		
		Scanner sc = new Scanner(System.in);
		Random ran = new Random();
		
		int round=1;
		int ch = 0;
		String str[] = {"Į����", "��ġ��", "����", "LA����", "����", "���ø�", "����ø�", "���κ�", "������", "�ᱹ��",
			    	    "������ũ", "���", "������", "���İ�Ƽ", "���θ�", "�ʹ�", "ȸ", "�ֵ���", "������ġ", "�ܹ���",
				        "������","����","������","�����","����","����","������","��ǳ��","¥���","«��","�쵿","������"};
		
		int rank_round = 32;
		String[] str1 = new String[rank_round];
		String[] str2 = new String[rank_round/2];

		int[] arr = new int[rank_round];
		
		System.out.println("----���� ������----\n");
		
		while(true) {
			int n=0;
			//�����Ѹ���
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

			if(rank_round==32)		System.out.println("-------["+rank_round/2+"��]-------");
			else if(rank_round==16)	System.out.println("-------["+rank_round/2+"��]-------");
			else if(rank_round==8)	System.out.println("-------["+rank_round/2+"��]-------");
			else if(rank_round==4)	System.out.println("-------[�ذ��]-------");
			else if(rank_round==2)	System.out.println("-------[���]-------");
			
			round=1;
			for(int i=0; i<rank_round; i++) {
				if(rank_round==2)	System.out.println("[FINAL]");
				else	System.out.println("[Round"+round+"]");
				
				System.out.println("1."+str1[i] + " VS "+ "2."+ str1[i+1]);
				while(ch<1 || ch>2) {
					System.out.print("���ļ��� (1 or 2): ");
					ch = sc.nextInt();
					if(ch<1 || ch>2) System.out.println("\t>>�ٽ��Է�!!");
				}
				if(ch==1) {
					str2[n]= str1[i];
					System.out.println("\t>>["+str1[i]+"]�� ����!!\n");
				} else if(ch==2) {
					str2[n]= str1[i+1];
					System.out.println("\t>>["+str1[i+1]+"]�� ����!!\n");
				}
				i++;
				n++;
				ch=0;
				round++;
			}
			
			rank_round /= 2;
			if(rank_round<2) {
				System.out.println("\n\t>>��� : "+str2[0]+"\n");
				break;
			}
		}
	
	}
	
	public static void game() {
//		-��Ʈ����ũ(STRIKE): ���ڿ� ��ġ�� ��� ����
//		-��(BALL): ���ڴ� ������ ��ġ�� Ʋ��
//		-�ƿ�(OUT): ���ڿ� ��ġ�� ��� Ʋ��
//		-Ȩ��(HOMERUN): �������� ���ڸ� ��Ȯ�� ����
		
		Random ran = new Random();
		Scanner sc = new Scanner(System.in);
		System.out.print("��� ���� ġ�ðڽ��ϱ�?");
		int MAX = sc.nextInt();

		int[] com_num = new int[MAX];	//��ǻ��
		int[] user_num = new int[MAX];	//�����
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
		
		System.out.println("\n----------���� �߱� ����-----------");
		System.out.println("��Ʈ����ũ(STRIKE): ���ڿ� ��ġ�� ��� ����");
		System.out.println("��(BALL): ���ڴ� ������ ��ġ�� Ʋ��");
		System.out.println("�ƿ�(OUT): ���ڿ� ��ġ�� ��� Ʋ��");
		System.out.println("Ȩ��(HOMERUN): �������� ���ڸ� ��Ȯ�� ����");
		System.out.println("-------------------------------");
		
		while(true) {
			System.out.println("\n[ROUND"+round+"]");
			System.out.println("1~9������ ���ڸ� "+MAX+"�� �Է��� �ּ���");
			for(int i=0; i<MAX; i++) {
				while(num<1 || num>9) {
					System.out.print((i+1)+"��° �� �Է� >> ");
					num=sc.nextInt();
					if(num<1 || num>9) System.out.println("\n\t>>�ٽ� �Է��� �ּ���!!\n");
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
								System.out.println("\n\t>>"+round+"���� Ȩ��~~\n");
								
								return;
							}
						}
						else ball++;
					}
				}
			}
			out = MAX-ball-strike;
			System.out.println("\n[STRIKE : " + strike+"\tBALL   : " + ball+"\tOUT    : " + out+"]\n");
			
			System.out.println("\n\nRound"+round+" STRIKE ���\n");
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
