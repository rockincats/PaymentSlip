package ebaotech.com.paymentSlip.unit;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import ebaotech.com.paymentSlip.util.DatesUtil;
import junit.framework.TestCase;

public class TestConversions extends TestCase{	
	private Date dt;
	
	public TestConversions() throws ParseException {
		dt = new SimpleDateFormat("dd/MM/yyyy").parse("01/01/2019");  
	}

	public void testDateToString() throws Exception {
		String date = DatesUtil.dateToStr(dt, "dd/MM/yyyy"); 
		String msg = "Erro ao converter data para String";
		assertEquals(msg, "01/01/2019", date);	
	}
	
	public void testStringToDate() throws Exception {			
		Date date = DatesUtil.strToDateUtil("01/01/2019", "dd/MM/yyyy"); 
		String msg = "Erro ao converter String para data";
		assertEquals(msg, dt, date);	
	}
}
