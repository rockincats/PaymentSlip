package ebaotech.com.paymentSlip.businnes;

import java.util.List;

import ebaotech.com.paymentSlip.dao.PaymentSlipDao;
import ebaotech.com.paymentSlip.entity.PaymentSlipEntity;

public class PaymentSlipActive{
	
	public List<PaymentSlipEntity> getPaymentSlipActive() throws Exception {
		PaymentSlipDao dao = new PaymentSlipDao();
		List<PaymentSlipEntity> result;
		
		result = dao.getPaymentSlipActive();
		
		return result;				
	}

}
