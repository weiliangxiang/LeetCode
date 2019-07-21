package demo20180107;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	public static void main(String[] args) {
		//DateDemo();
	}
	public static String getCurrentTime() {
		Date date= new Date();
		SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH_mm_ss");
		String dateString=dateFormat.format(date);
		return dateString;
}
}
