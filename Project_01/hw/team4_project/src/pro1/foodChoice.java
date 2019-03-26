package pro1;

import java.util.Random;
import java.util.Scanner;

public class foodChoice {
	public foodChoice() {
		Scanner sc = new Scanner(System.in);
		Random ran = new Random();
		
		int round=1;
		String str[] = {"Ä®±¹¼ö", "±èÄ¡Âò", "¼öÀ°", "LA°¥ºñ", "»ï°ã»ì", "¹°³Ã¸é", "ºñºö³Ã¸é", "¼øµÎºÎ", "ºñÁöÀå", "Äá±¹¼ö",
			    	    "½ºÅ×ÀÌÅ©", "µ·±î½º", "°¥ºñÅÁ", "½ºÆÄ°ÔÆ¼", "µ·ºÎ¸®", "ÃÊ¹ä", "È¸", "ÇÖµµ±×", "»÷µåÀ§Ä¡", "ÇÜ¹ö°Å",
				        "ººÀ½¹ä","Àü°ñ","µ¿ÅÂÂò","°íµî¾î±¸ÀÌ","±¹¹ä","¼ø´ë","ÅÁ¼öÀ°","±ñÇ³±â","Â¥Àå¸é","Â«»Í","¿ìµ¿","±ñ¼î»õ¿ì"};
		
		int rank_round = 16;
		String[] str1 = new String[rank_round];
		String[] str2 = new String[rank_round/2];
		char ch = '\0';
		String sch = null;
		
		int[] arr = new int[rank_round];
		
		System.out.println("----À½½Ä ¿ùµåÄÅ----\n");
		
		while(true) {
			int n=0;
			//·»´ı»Ñ¸®±â
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

			if(rank_round==16)	System.out.println("-------["+rank_round+"°­]-------");
			else if(rank_round==8)	System.out.println("-------["+rank_round+"°­]-------");
			else if(rank_round==4)	System.out.println("-------[ÁØ°á½Â]-------");
			else if(rank_round==2)	System.out.println("-------[°á½Â]-------");
			
			round=1;
			for(int i=0; i<rank_round; i++) {
				if(rank_round==2)	System.out.println("[FINAL]");
				else	System.out.println("[Round"+round+"]");
				
				System.out.println("1."+str1[i] + " VS "+ "2."+ str1[i+1]);
				while(ch<49 || ch>50) {
					System.out.print("À½½Ä¼±ÅÃ (1 or 2): ");
					sch = sc.nextLine();
					if(sch.length()==1) {
						ch = sch.charAt(0);
						if(ch<49 || ch>50) System.out.println("\t>>´Ù½ÃÀÔ·Â!!");
					}
					else System.out.println("\t>>´Ù½ÃÀÔ·Â!!");
				}
				if(ch==49) {
					str2[n]= str1[i];
					System.out.println("\t>>["+str1[i]+"]À» ¼±ÅÃ!!\n");
				} else if(ch==50) {
					str2[n]= str1[i+1];
					System.out.println("\t>>["+str1[i+1]+"]À» ¼±ÅÃ!!\n");
				}
				i++;
				n++;
				ch=0;
				round++;
			}
			
			rank_round /= 2;
			if(rank_round<2) {
				System.out.println("\n\t>>¿ì½Â : "+str2[0]+"\n");
				break;
			}
		}
	}	
}