package miniProject;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class MenuRecommend {

	// �޴� ��õ�޴� ���α׷�
	
	Scanner sc = new Scanner(System.in); // �Է°�ü

	ArrayList korean = new ArrayList(); // �ѽ� ī�װ� ����Ʈ
	ArrayList chinese = new ArrayList(); // �ֽ� ī�װ� ����Ʈ
	ArrayList japanese = new ArrayList(); // �Ͻ� ī�װ� ����Ʈ
	ArrayList western = new ArrayList(); // ��� ī�װ� ����Ʈ

	ArrayList allRandom = null; // ��ü ī�װ� ������ ���� ����Ʈ(��� ����Ʈ�� ���� ����־��ٰ���)
	
	ArrayList menu = new ArrayList(); // �� ����Ʈ�� �ٸ� ����Ʈ���� ��Ƽ� �ڵ带 �ٿ������� ��µ� �� ȿ�� ������.
	// ���� ����Ѵٸ� ���� ���ϴ´�� ������ �� �� ���� ���� �𸣰�����, �ʿ� �ͼ����� �ʾƼ� ������� ������. --> * �� �����ϱ� *

	// ������, �޴� ����Ʈ�� ����Ʈ���� �־��ְ�, ���α׷��� ���� �޴� �޼��� ����
	public MenuRecommend() {

		menu.add(0, korean);
		menu.add(1, chinese);
		menu.add(2, japanese);
		menu.add(3, western);

		mainSelect();

	}

	// ���α׷��� ���� �޴� �޼���
	public void mainSelect() {

		System.out.println("# �޴� ��õ ���α׷� #\n");
		do {
			System.out.println("\n[M a i n M e n u]");
			System.out.println("\n1. �޴� Ȯ�� �� ����\n");
			System.out.println("2. �޴� ���� ��õ\n");

			String str = sc.next();

			switch (str) { // ������� �Է��� �޾Ƽ� ���� �޴�(�޼���)�� �����Ѵ�

			case "1": checkModify(); // ���� �޴� Ȯ��, �߰� �� ������ ������ �޼���
				break;
			case "2": randomReco(); // ���� ��õ �޼���
				break;
			default: System.out.println("@ �߸��� �Է��Դϴ�.\n");
				break;

			}
			
		} while(true); // ���α׷� ����� �����ʾ���

	}

	// ���� �޴��� �߰� �� ������ ������ �޼���
	public void checkModify() {

		System.out.println("#     �޴� Ȯ��     #\n");
		System.out.println("===== �޴� ����Ʈ ====="); // �޼��尡 ����Ǹ� ���� �޴� ����Ʈ�� �����ش�
		System.out.println("# �ѽ� " + korean.toString());
		System.out.println("# �߽� " + chinese.toString());
		System.out.println("# �Ͻ� " + japanese.toString());
		System.out.println("# ��� " + western.toString());
		System.out.println("");

		while (true) {
			System.out.println("===== �޴� ���� =====");
			System.out.println("[1] �ѽ� [2] �߽� [3] �Ͻ� [4] ���");
			System.out.println("[0] ���ư���");

			String str = sc.next();

			switch (str) {
			case "1": menuModify(0); // �������ڴ� ArrayList menu�� �ε����� Ȱ��. (0 = �ѽĸ���Ʈ, 1 = �߽� ... --> ������ ����)
				break;
			case "2": menuModify(1);
				break;
			case "3": menuModify(2);
				break;
			case "4": menuModify(3);
				break;

			case "0": // 0 �Է¹����� �޼��� ����Ǹ鼭 ���� �޼���� ���ư�(stack)
				return;

			default: System.out.println("@ �߸��� �Է��Դϴ�.\n");
				break;

			}
		}
	}

	public void menuModify(int var) {

		if(var==0) System.out.println("===== �ѽ� =====\n"); // ����ڰ� � ī�װ��� �����ߴ��� �˷��ֱ�
		if(var==1) System.out.println("===== �߽� =====\n");
		if(var==2) System.out.println("===== �Ͻ� =====\n");
		if(var==3) System.out.println("===== ��� =====\n");

		while (true) {
			System.out.println("===== �޴� ����Ʈ =====");
			System.out.println(menu.get(var).toString()); // ���� ��� menu.get(0).toString�̶�� menu�� 0��° �ε���(�ѽ� ����Ʈ)�� ������ .toString ���ִ� �ڵ�
															// --> �ѽ� ����Ʈ�� ����� ���� ����� �����ְ���?
			System.out.println("\n[1] �߰� [2] ���� [0] ���ư���");

			String str = sc.next();

			switch (str) {
			case "1": menuAdd(var); // �Է°��� "�߰�"�� �ش��ϴ� "1"�̶�� �޴� �߰� �޼��� ����
				break;
			case "2": menuDel(var); // -- �޴� ���� �޼��� ����
				break;

			case "0": // �Է°� 0�̸� �޼��� ����, ���� �޼���� ���ư�(stack)
				return;
				
			default : System.out.println("@ �߸��� �Է��Դϴ�.\n");
				break;
			}
		}
	}
	
	// �޴� �߰� �޼���
	public void menuAdd(int var) {
		String input = null; // switch-case������ ������ �Ἥ, �Ʒ��� �� ���� ������ �ۼ��ϰ� ���� �ʾƼ� ����� �޼��� ���� ���� ����
		
		do {
			System.out.println("�߰��� �޴� �Է�");
			System.out.print(">> ");
			String str = sc.next();
			
			// �Է¹��� �״�� �ش� ����Ʈ�� add���ִ� ����
			switch (var) {
			case 0: korean.add(str); 
				break;
			case 1: chinese.add(str);
				break;
			case 2: japanese.add(str);
				break;
			case 3: western.add(str);
				break;
			}
			
			System.out.println("\n[" + str + "] �߰� �Ϸ�\n");
			
			System.out.println("===== ����Ʈ Ȯ�� =====");
			System.out.println(menu.get(var).toString());
			System.out.println("===================\n");
			System.out.println("[1] ��� �߰� [0] ���ư���");
			
			input = sc.next();
			
			if (input.equals("0")) return; // input�� ���� "0"�� ���ٸ� �޼��� ����. "2"�� "3"�� �Է¹޾Ƶ� "1"�� �Է¹��� ��ó�� ��� �ݺ����� ����
											// ���ľ������� �ϴ� ������(����)
			
		} while (true);
	}
	
	// �޴� ���� �޼��� -- ���� ����� ���� �޴� �߰� �޼���� �����ϹǷ� �������� �ʰ���
	public void menuDel(int var) {
		String input = null;
		
		do {
			System.out.println("������ �޴� �Է�");
			System.out.print(">> ");
			String str = sc.next();
			
			switch (var) {
			case 0: korean.remove(str);
				break;
			case 1: chinese.remove(str);
				break;
			case 2: japanese.remove(str);
				break;
			case 3: western.remove(str);
				break;
			}
			
			System.out.println("\n[" + str + "] ���� �Ϸ�\n");
			System.out.println("===== ����Ʈ Ȯ�� =====");
			System.out.println(menu.get(var).toString());
			System.out.println("===================\n");
			System.out.println("[1] ��� ���� [0] ���ư���");
			
			input = sc.next();
			
			if (input.equals("0")) return;
			
		} while (true);
		
	}
	
	// ���� ��õ �޴� �޼���
	public void randomReco() {
		
		while(true) {
		
			System.out.println("===== ���� �޴� ��õ =====\n");
			
			System.out.println("[1] ��ü ���� [2] ī�װ� ���� [0] ���ư���\n");
			String str = sc.next();
		
			switch(str) {
			case "1" : System.out.println("# ��ü ���� ��� : " + allRan() + "\n"); // ��ü ���� ��� �����ֱ�
				break;
			case "2" : categoryRan(); // ī�װ� ���� �޼��� ����
				break;
			case "0" :
				return;
			default : System.out.println("@ �߸��� �Է��Դϴ�.\n");
				break;
			}
		
		}

	}

	// ���� �߻� �޼���, �� �޼����� ��ȯ���� ����ؼ� ī�װ�, ��ü ������ �̾Ƴ�����
	public int random(int var) {
		Random rd = new Random();
		return rd.nextInt(var);
	}
	
	// ��ü �޴� ���� ��õ �޼���
	public String allRan() {
		
		allRandom = new ArrayList(); // ��� ī�װ��� �޴��� ������ �޼���

		// ����Ʈ�� ��Ҹ� �ϳ��� �����ͼ� ��ü�޴� ����Ʈ�� ��´�
		// ����Ʈ�� ũ�Ⱑ ���� �ٸ� �� �����Ƿ� ���� for�� ���
		for(int i = 0; i < korean.size(); i++) { 
			allRandom.add(korean.get(i));
		}
		for(int i = 0; i < chinese.size(); i++) {
			allRandom.add(chinese.get(i));
		}
		for(int i = 0; i < japanese.size(); i++) {
			allRandom.add(japanese.get(i));
		}
		for(int i = 0; i < western.size(); i++) {
			allRandom.add(western.get(i));
		}
		
		String str; // ������ ���� ���� ����
		
		if(allRandom.isEmpty()) { // ��ü �޴� ����Ʈ�� ����ִٸ�
			str = "\n@ ��� ī�װ��� ����ֽ��ϴ�.";
		} else { // �ϳ��� ��Ҷ� ������ �ִٸ�									//	5					2		1					3		4
			str = allRandom.get(random(allRandom.size())).toString(); // str�� ���� ��ü�޴�����Ʈ��(�����߻�(��ü�޴�����Ʈ�� ũ�⸸ŭ))��°��Ҹ������ͼ�.���ڿ����Ľ�
		}
		return str;
	}
	
	// ī�װ��� ���� ��õ �޼���
	public void categoryRan() {
		
		while(true) {
			System.out.println("===== ī�װ� ���� =====\n");
		
			System.out.println("[1] �ѽ� [2] �߽� [3] �Ͻ� [4] ��� [0] ���ư���\n");
			String str = sc.next();

			switch(str) {
			case "1" : 
				if(korean.isEmpty()) {System.out.println("@ �ش� ī�װ��� ����ֽ��ϴ�."); break;}
				System.out.println("# �ѽ� ���� ��� : "+korean.get(random(korean.size())).toString()+"\n");
				break;
			case "2" :
				if(chinese.isEmpty()) {System.out.println("@ �ش� ī�װ��� ����ֽ��ϴ�."); break;}
				System.out.println("# �߽� ���� ��� : "+chinese.get(random(chinese.size())).toString()+"\n");
				break;
			case "3" :
				if(japanese.isEmpty()) {System.out.println("@ �ش� ī�װ��� ����ֽ��ϴ�."); break;}
				System.out.println("# �Ͻ� ���� ��� : "+japanese.get(random(japanese.size())).toString()+"\n");
				break;
			case "4" : 
				if(western.isEmpty()) {System.out.println("@ �ش� ī�װ��� ����ֽ��ϴ�."); break;}
				System.out.println("# ��� ���� ��� : "+western.get(random(western.size())).toString()+"\n");
				break;
	
			case "0" :
				return;
		
			default : System.out.println("@ �߸��� �Է��Դϴ�.\n");
				break;
		
			}
		}
		
	}
	
	// ���� �޼���
	public static void main(String[] args) {
		new MenuRecommend(); // ��ü �����ϸ�, �����ڿ� ���� �ڵ����� ���α׷� ����
		
	}

}
