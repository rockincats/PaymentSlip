package ebaotech.com.paymentSlip.entity;

import java.util.Date;

public class PaymentSlipEntity {
	private long id;
	private Date createdTime;
	private Double amount;
	private Date dueDate;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}
	
	public String toString() {
		return String.format("BOLETO_ID: %d, CREATED_TIME: %s, AMOUNT: %f, DUE_DATE: %s ",id,  createdTime, amount, dueDate);		
	}

}
