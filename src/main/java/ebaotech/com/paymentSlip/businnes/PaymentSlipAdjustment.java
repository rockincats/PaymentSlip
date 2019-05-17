package ebaotech.com.paymentSlip.businnes;

import java.util.List;

import ebaotech.com.paymentSlip.dao.AdjustmentDao;
import ebaotech.com.paymentSlip.entity.AdjustmentEntity;

public class PaymentSlipAdjustment {

	public List<AdjustmentEntity> getPaymentSlipAdjustment(int id) throws Exception {
		AdjustmentDao dao = new AdjustmentDao();
		List<AdjustmentEntity> result;

		result = dao.getAdjustmentByIdPaymentSlip(id);

		return result;
	}

}
