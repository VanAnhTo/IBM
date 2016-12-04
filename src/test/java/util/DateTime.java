package util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateTime {
	
	public static String convertDateToString (Date date, String format){
		 DateFormat df = new SimpleDateFormat(format);
		 String reportDate = df.format(date);
		 return reportDate;
	}

	public static Date convertToDate(String content, String format) throws ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat(format);
		try {
			Date result = formatter.parse(content);
			return result;
		} catch (ParseException e) {
			formatter = new SimpleDateFormat(format);
			return formatter.parse(content);
		}
	}

	public static int getWeekOfDate(String content, String format) {
		SimpleDateFormat formatter = new SimpleDateFormat(format);
		int weekOfDate = 0;
		try {
			Calendar cal = Calendar.getInstance();
			Date date = formatter.parse(content);
			cal.setTime(date);
			weekOfDate = cal.get(Calendar.WEEK_OF_YEAR);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return weekOfDate;
	}

	public static int getDayOfWeek(String content, String format) {
		SimpleDateFormat formatter = new SimpleDateFormat(format);
		int dayOfWeek = 0;
		try {
			Calendar cal = Calendar.getInstance();
			Date date = formatter.parse(content);
			cal.setTime(date);
			dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return dayOfWeek;
	}

}
