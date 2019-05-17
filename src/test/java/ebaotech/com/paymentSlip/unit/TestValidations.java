package ebaotech.com.paymentSlip.unit;

import static org.junit.Assert.assertNotEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import ebaotech.com.paymentSlip.validations.InputValidation;
import junit.framework.TestCase;

public class TestValidations extends TestCase {
	private InputValidation validation = new InputValidation();
	private Date dt;
	
	public TestValidations() throws ParseException {
		dt = new SimpleDateFormat("dd/MM/yyyy").parse("31/01/2019");  
	}

	public void testValidDateFormat() {
		validation.validateDate("31/01/2019");
		Date date = validation.getData();
		assertEquals(dt, date);		
	}
	
	public void testInvalidDateFormart() {
		validation.validateDate("2019-01-31");
		Date date = validation.getData();
		assertNotEquals(dt, date);		
	}
	
	public void testInvalidDateDataType() {
		validation.validateDate("A");
		Date date = validation.getData();
		assertNotEquals(dt, date);		
	}

	public void testValidNumberDataType() {
		validation.validateNumber("1");
		int number = validation.getId();
		assertEquals(1, number);
	}

	public void testInvalidNumberDataTipe() {
		validation.validateNumber("A");
		int number = validation.getId();
		assertEquals(0, number);
	}

}
