package ebaotech.com.paymentSlip.validations;

import java.util.Date;

import ebaotech.com.paymentSlip.util.DatesUtil;

public class InputValidation {
	private String msgValidation = "";
	private Date data;
	private int id;

	public void validation(String date, String id) throws Exception {
		this.validateDate(date);
		this.validateNumber(id);
		if (!msgValidation.equals("")) {
			throw new Exception(msgValidation);
		}
	}

	public void validateDate(String date) {
		try {
			data = DatesUtil.strToDateUtil(date, "dd/MM/yyyy");
		} catch (Exception e) {
			this.createErrorMessage("Erro ao validar data do Boleto [" + date + "]");
		}
	}

	public void validateNumber(String number) {
		try {
			id = Integer.parseInt(number);
		} catch (Exception e) {
			this.createErrorMessage("Erro ao validar id do Boleto [" + number + "]");
		}
	}
	
	private String createErrorMessage(String msg) {
		if (msgValidation.equals(""))		
			msgValidation = msg;
		else
			msgValidation = msgValidation + "\n" + msg;
		return msg;				
	}

	public Date getData() {
		return data;
	}

	public int getId() {
		return id;
	}
	
	

}
