package ebaotech.com.paymentSlip.dao;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ebaotech.com.paymentSlip.entity.AdjustmentEntity;

public class AdjustmentDao {

	public List<AdjustmentEntity> getAdjustmentByIdPaymentSlip(int id) throws Exception {
		List<AdjustmentEntity> adjustments = new ArrayList<>();
		try {

			Statement st = ConnectionMySQL.getConnectionMySQL().createStatement();
			ResultSet rs = st.executeQuery(this.qryAdjustmentByIdPaymentSlip(id));

			while (rs.next()) {
				AdjustmentEntity adjustment = new AdjustmentEntity();

				adjustment.setId(rs.getInt("AJUSTE_ID"));
				adjustment.setPaymentSlipId(rs.getInt("BOLETO_ID"));
				adjustment.setStatus(rs.getString("STATUS"));
				adjustment.setCreatedTime(rs.getDate("CREATED_TIME"));

				adjustments.add(adjustment);
			}
			st.close();
		} catch (Exception e) {
			throw e;
		}
		return adjustments;
	}
	
	private String qryAdjustmentByIdPaymentSlip(int id) throws Exception {
		StringBuilder qry = new StringBuilder();
		qry.append("SELECT * ");
		qry.append("FROM ebao.AJUSTES ");
		qry.append("WHERE BOLETO_ID = " + id + "");

		return qry.toString();
	}

}
