package pro1;

import java.util.Random;
import java.util.Scanner;

public class foodChoice {
	public foodChoice() {
		Scanner sc = new Scanner(System.in);
		Random ran = new Random();
		
		int round=1;
		String str[] = {"Į����", "��ġ��", "����", "LA����", "����", "���ø�", "����ø�", "���κ�", "������", "�ᱹ��",
			    	    "������ũ", "���", "������", "���İ�Ƽ", "���θ�", "�ʹ�", "ȸ", "�ֵ���", "������ġ", "�ܹ���",
				        "������","����","������","�����","����","����","������","��ǳ��","¥���","«��","�쵿","������"};
		
		int rank_round = 16;
		String[] str1 = new String[rank_round];
		String[] str2 = new String[rank_round/2];
		char ch = '\0';
		String sch = null;
		
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
				if(rank_round==16) {
					str1[i] = str[arr[i]];
				} else {
					str1[i] = str2[arr[i]];
				}
			}

			if(rank_round==16)	System.out.println("-------["+rank_round+"��]-------");
			else if(rank_round==8)	System.out.println("-------["+rank_round+"��]-------");
			else if(rank_round==4)	System.out.println("-------[�ذ��]-------");
			else if(rank_round==2)	System.out.println("-------[���]-------");
			
			round=1;
			for(int i=0; i<rank_round; i++) {
				if(rank_round==2)	System.out.println("[FINAL]");
				else	System.out.println("[Round"+round+"]");
				
				System.out.println("1."+str1[i] + " VS "+ "2."+ str1[i+1]);
				while(ch<49 || ch>50) {
					System.out.print("���ļ��� (1 or 2): ");
					sch = sc.nextLine();
					if(sch.length()==1) {
						ch = sch.charAt(0);
						if(ch<49 || ch>50) System.out.println("\t>>�ٽ��Է�!!");
					}
					else System.out.println("\t>>�ٽ��Է�!!");
				}
				if(ch==49) {
					str2[n]= str1[i];
					System.out.println("\t>>["+str1[i]+"]�� ����!!\n");
				} else if(ch==50) {
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
}