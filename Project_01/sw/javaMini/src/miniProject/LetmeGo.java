package miniProject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class LetmeGo {
	public void Letmego() throws ParseException {
		

		// (1) Calendar��ü�� ��´�.

		Calendar cal = Calendar.getInstance();

		// (2) ��� ���¸� �����ϱ� ���� Formatter�� ��´�.

		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy:MM:dd-hh:mm:ss");

		// (3) ������¿� �´� ���ڿ��� ��´�.

		String datetime1 = sdf1.format(cal.getTime());

		System.out.println("����ð� :  " + datetime1);


		// (4) ���������� ����� �ú����� ���� ���� ���� �ִ�.

		int year = cal.get(Calendar.YEAR);

		int month = cal.get(Calendar.MONTH);

		int day = cal.get(Calendar.DAY_OF_MONTH);

		int hour = cal.get(Calendar.HOUR);
		
//		System.out.println(hour);

		int minute = cal.get(Calendar.MINUTE);
		
		int second = cal.get(Calendar.SECOND);

		int millisecond = cal.get(Calendar.MILLISECOND);
		
		int endHour = 3;
		int endMinute = 20;
		
		int home_Hour;
		int home_Minute;
		
		if(endHour<hour) {
			
			home_Hour = hour-endHour;
			home_Minute = minute-endMinute;
			System.out.println("������������ ���� �ð� : "+home_Hour);
			
		}else { //endHour>hour �̰ų� �������
 
			home_Hour = endHour-hour;
			System.out.println("������������ ���� �ð� : "+home_Hour);
			
		}
		
		if(endMinute<minute) {
			home_Minute = endMinute-minute;
			System.out.println("������������ ���� �� : "+home_Minute);
		}else if (endMinute>minute) {
			home_Minute = minute - endMinute;
			System.out.println("������������ ���� �� : "+home_Minute);
		}
		
		
		


		
	}
} 