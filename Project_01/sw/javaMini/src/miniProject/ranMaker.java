package miniProject;

import java.util.Random;

class ranMaker {
public void ranNum() { //�ߺ����� �ʴ� �������� �����Լ�, �񱳴���� ����ڿ��� �����ϰ� ������ ����

	int arr[] = new int[16]; // �ߺ������� ���� �ε����ѹ��� ����ִ� �迭
	int arr2[] = new int[16];
	
	for (int i = 0; i < 16; i++) {
		arr[i] = i + 1;
	}

	System.out.println("--------------------");
	Random rd = new Random();
	
	for (int i = 0; i < 16; i++) {
		arr2[i] = arr[rd.nextInt(16)];
		for (int j = 0; j < i; j++) {// �ߺ����Ÿ� ���� ����
			if (arr2[i] == arr2[j]) {
				i--;
				break;
			}
		}

	}
//	for (int i = 0; i < 16; i++) { // �ߺ����� �ʴ� 0~16���� 16���� ���� ���
//		System.out.println(arr2[i]);
//	}

}
}
