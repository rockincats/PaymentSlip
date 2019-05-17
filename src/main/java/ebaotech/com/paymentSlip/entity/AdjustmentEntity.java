package ebaotech.com.paymentSlip.entity;

import java.util.Date;

public class AdjustmentEntity {

	private long id;
	private long paymentSlipId;
	private String status;
	private Date createdTime;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getPaymentSlipId() {
		return paymentSlipId;
	}

	public void setPaymentSlipId(long id) {
		this.paymentSlipId = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}

	public String toString() {
		return String.format("AJUSTE_ID: %d, BOLETO_ID: %d, STATUS: %s, CREATED_TIME: %s", id, paymentSlipId, status, createdTime);
	}

}
