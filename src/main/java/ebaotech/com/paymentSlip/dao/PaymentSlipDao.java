package ebaotech.com.paymentSlip.dao;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import ebaotech.com.paymentSlip.entity.PaymentSlipEntity;
import ebaotech.com.paymentSlip.util.DatesUtil;

public class PaymentSlipDao {
	
	public List<PaymentSlipEntity> getPaymentSlipActive() throws Exception{
		return this.getPaymentSlip(this.qrygetPaymentSlipActive());		
	}
	
	public List<PaymentSlipEntity> getPaymentSlipCanceledByDate(Date dt) throws Exception{
		return this.getPaymentSlip(this.qrygetPaymentSlipCanceled(dt));		
	}

	private List<PaymentSlipEntity> getPaymentSlip(String qry) throws Exception {
		List<PaymentSlipEntity> paymentSlips = new ArrayList<>();
		try {

			Statement st = ConnectionMySQL.getConnectionMySQL().createStatement();
			ResultSet rs = st.executeQuery(qry);

			while (rs.next()) {
				PaymentSlipEntity paymentSlip = new PaymentSlipEntity();

				paymentSlip.setId(rs.getInt("BOLETO_ID"));
				paymentSlip.setCreatedTime(rs.getDate("CREATED_TIME"));
				paymentSlip.setAmount(rs.getDouble("AMOUNT"));
				paymentSlip.setDueDate(rs.getDate("DUE_DATE"));

				paymentSlips.add(paymentSlip);
			}
			st.close();
		} catch (Exception e) {
			throw e;
		}
		return paymentSlips;
	}
	
	private String qrygetPaymentSlipActive() {
		StringBuilder qry = new StringBuilder();
		qry.append("SELECT * ");
		qry.append("FROM ebao.BOLETOS ");
		qry.append("WHERE BOLETO_ID not in(SELECT BOLETO_ID FROM ebao.AJUSTES WHERE `STATUS` = 'CANCELADO') ");
		
		return qry.toString();		
	}		
	
	private String qrygetPaymentSlipCanceled(Date date) throws Exception {
		StringBuilder qry = new StringBuilder();
		qry.append("SELECT * ");
		qry.append("FROM ebao.BOLETOS ");
		qry.append("WHERE CREATED_TIME = '" + DatesUtil.dateToStr(date, "yyyy-MM-dd")+ "' AND  ");
		qry.append("	  BOLETO_ID in(SELECT BOLETO_ID  ");
		qry.append("                   FROM   ebao.AJUSTES  ");
		qry.append("                   WHERE `STATUS` = 'CANCELADO') ");

		
		return qry.toString();		
	}	
	
}
