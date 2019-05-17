package ebaotech.com.paymentSlip.view;

import java.util.List;

import ebaotech.com.paymentSlip.entity.AdjustmentEntity;

public class DisplayPaymentSlipAdjustment {
	public void createReport(List<AdjustmentEntity> lstPaymentSlip) {
		this.createHeaderReport();
		this.createHeaderGrid();
		this.createGrid(lstPaymentSlip);
	}

	private void createHeaderReport() {
		System.out.println("");
		System.out.println(" LISTAGEM DE AJUSTES DE BOLETOS ");
		System.out.println("");
	}

	private void createHeaderGrid() {

		System.out.println(" AJUSTE_ID | BOLETO_ID | STATUS    | CREATED_TIME");
		System.out.println("-----------|-----------|-----------|--------------");
	}

	private void createGrid(List<AdjustmentEntity> lstAdjustment) {
		for (AdjustmentEntity aj : lstAdjustment) {
			String id = String.format(" %-10s", aj.getId());			
			String paymentSlipId = String.format(" %-10s", aj.getPaymentSlipId());
			String status = String.format(" %-10s", aj.getStatus());
			String createTime = String.format(" %-11s", aj.getCreatedTime());
			
			System.out.println(String.format("%s|%s|%s|%s", id, paymentSlipId, status, createTime));
		}
		System.out.println("-----------|-----------|-----------|--------------");
	}
}
