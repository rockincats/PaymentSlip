package ebaotech.com.paymentSlip.view;

import java.util.List;

import ebaotech.com.paymentSlip.entity.PaymentSlipEntity;

public class DisplayPaymentSlipCanceled {
	public void createReport(List<PaymentSlipEntity> lstPaymentSlip) {
		this.createHeaderReport();
		this.createHeaderGrid();
		this.createGrid(lstPaymentSlip);
	}
	
	private void createHeaderReport() {
		System.out.println("");
		System.out.println(" LISTAGEM DE BOLETOS CANCELADOS");
		System.out.println("");
	}
	
	private void createHeaderGrid() {

		System.out.println(" BOLETO_ID | CREATED_TIME | AMOUNT | DUE_DATE");
		System.out.println("-----------|--------------|--------|-----------");		
	}
	
	private void createGrid(List<PaymentSlipEntity> lstPaymentSlip) {			
		for (PaymentSlipEntity ps : lstPaymentSlip) {
			String id = String.format(" %-10s", ps.getId());
			String createTime = String.format(" %-13s", ps.getCreatedTime());
			String amount = String.format(" %-7s", ps.getAmount());
			String dueDate = String.format(" %-8s", ps.getDueDate());
						
			System.out.println(String.format("%s|%s|%s|%s",id,createTime,amount,dueDate));				
		}
		System.out.println("-----------|--------------|--------|-----------");	
	}
	
}