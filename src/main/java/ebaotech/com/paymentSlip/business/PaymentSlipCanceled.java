package ebaotech.com.paymentSlip.business;

import java.util.Date;
import java.util.List;

import ebaotech.com.paymentSlip.dao.PaymentSlipDao;
import ebaotech.com.paymentSlip.entity.PaymentSlipEntity;

public class PaymentSlipCanceled {

	public List<PaymentSlipEntity> getPaymentSlipCanceled(Date dataBoletoCancelado2) throws Exception {
		PaymentSlipDao dao = new PaymentSlipDao();
		List<PaymentSlipEntity> result;
		
		result = dao.getPaymentSlipCanceledByDate(dataBoletoCancelado2);
		
		return result;				
	}
	
}
