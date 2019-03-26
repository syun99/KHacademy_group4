package study_project.miniproject;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Reco_res_02 {
	
	private static final int ranTot = 8;
	private static final int ranCnt = 7;
	
	private static Scanner sc;
	private static Random ran;
	private static String[] arr = new String[ranTot];
	private static String[] buf = new String[ranTot];
//	private static int com;
	private static String ch;
	
	public static void input() {
		
		sc = new Scanner(System.in);
		System.out.println("먹고 싶은 메뉴 입력 : ");
		
		for(int i = 0; i < ranTot; i++) {
			arr[i] = sc.nextLine();
		}
		
		System.out.println(Arrays.toString(arr));
		
	}
	
	public static void run() {
		
		random();
		
		System.out.println("선택한 메뉴는 " + ch + "입니다");	
		
	}
	
	public static void random() {
		
		sc = new Scanner(System.in);
		ran = new Random();
		
		
		for(int i = 0; i < ranTot; i++) {
			buf[i] = arr[ran.nextInt(arr.length)];
			for(int j = 0; j < i; j++) {
				if(buf[i] == buf[j]) {
					i--;
				}
			}
		}	
		
		System.out.println(Arrays.toString(buf));
		
		for(int i = 0; i < 1; i++) {
			if(buf[i] != buf[i+1]) {
				System.out.println(buf[i] + " vs " + buf[i+1]);
				System.out.print("메뉴선정 > ");
				ch = sc.nextLine(); 
				System.out.println(ch + " 선택");
			}
		}
		
		for(int i = 0; i < ranCnt; i++) {
			if(ch != buf[i]) {
				System.out.println(ch + " vs " + buf[i]);
				System.out.print("메뉴선정 > ");
				ch = sc.nextLine(); 
				System.out.println(ch + " 선택");
			}
		}
	}
	
	public static void main(String[] args) {
		input();
		run();
	}
}
