package ebaotech.com.paymentSlip.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DatesUtil {

	public static java.util.Date strToDateUtil(String date, String format) throws Exception {
		SimpleDateFormat sd = new SimpleDateFormat(format);
		java.util.Date finalDate = null;
		finalDate = sd.parse(date);

		return finalDate;
	}

	public static String dateToStr(Date date, String format) throws Exception {
		if (date != null) {
			String text;
			DateFormat df = new SimpleDateFormat(format);
			text = df.format(date);
			return text;
		} else {
			return "";
		}
	}
}
