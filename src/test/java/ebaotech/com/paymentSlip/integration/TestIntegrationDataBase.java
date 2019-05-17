package ebaotech.com.paymentSlip.integration;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import ebaotech.com.paymentSlip.business.PaymentSlipActive;
import ebaotech.com.paymentSlip.business.PaymentSlipAdjustment;
import ebaotech.com.paymentSlip.business.PaymentSlipCanceled;
import ebaotech.com.paymentSlip.entity.AdjustmentEntity;
import ebaotech.com.paymentSlip.entity.PaymentSlipEntity;
import junit.framework.TestCase;


public class TestIntegrationDataBase extends TestCase{


	public void testQtdeBoletosAtivos() throws Exception {
		PaymentSlipActive ps = new PaymentSlipActive();
		List<PaymentSlipEntity> result = ps.getPaymentSlipActive();
		String msg = "A quantidade de boletos ativos não confere";
		assertEquals(msg, 4, result.size());		
	}
	
	public void testQtdeBoletosCanceladosPorData() throws Exception {
		PaymentSlipCanceled psc = new PaymentSlipCanceled();
		Date dt = new SimpleDateFormat("yyyy-MM-dd").parse("2019-02-12");		
		List<PaymentSlipEntity> result = psc.getPaymentSlipCanceled(dt);
		String msg = "A quantidade de boletos cancelados não confere";
		assertEquals(msg, 1, result.size());		
	}
	
	public void testTabelaAjustes() throws Exception {
		PaymentSlipAdjustment psa = new PaymentSlipAdjustment();
		List<AdjustmentEntity> result = psa.getPaymentSlipAdjustment(5);
		String msg = "Quantidades de ajustes é para o boleto id 5";
		assertEquals(msg, 2, result.size());		
	}

}
