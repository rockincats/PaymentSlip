package ebaotech.com.paymentSlip;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import ebaotech.com.paymentSlip.businnes.PaymentSlipAdjustment;
import ebaotech.com.paymentSlip.businnes.PaymentSlipActive;
import ebaotech.com.paymentSlip.businnes.PaymentSlipCanceled;
import ebaotech.com.paymentSlip.entity.AdjustmentEntity;
import ebaotech.com.paymentSlip.entity.PaymentSlipEntity;
import ebaotech.com.paymentSlip.validations.InputValidation;
import ebaotech.com.paymentSlip.view.DisplayPaymentSlipAdjustment;
import ebaotech.com.paymentSlip.view.DisplayPaymentSlipActive;
import ebaotech.com.paymentSlip.view.DisplayPaymentSlipCanceled;

/**
 * https://gitlab.com/ebaoInterview/boleto
 *
 */
public class App {
	
	private static Date datePaymentSlipCanceled;
	private static int paymentSlipAdjustmentId;
	
	public static void main(String[] args) {

		
		try {
			System.out.println("**********************************************");
			System.out.println("* RELATORIO DE BOLETOS                       *");
			System.out.println("**********************************************");
			System.out.println("*  1: Boletos Ativos                         *");
			System.out.println("*  2: Boletos Cancelados                     *");
			System.out.println("*  3: Ajustes de Boletos                     *");
			System.out.println("**********************************************");
			System.out.println();
			Scanner sc = new Scanner(System.in);
			
			System.out.print("   1) Informe uma data (dd/mm/aaaa) para o relatório de Boletos Cancelados: ");			
			String datePaymentSlip = sc.next();
			System.out.print("   2) Informe o ID de um Boleto para demonstrar os Ajustes: ");
			String paymentSlipId = sc.next();
			System.out.println();
			System.out.println("**********************************************");
			
			validateInputs(datePaymentSlip,paymentSlipId);
			processPaymentSlipActive();
			processPaymentSlipCanceled(datePaymentSlipCanceled);
			processPaymentSlipAdjustment(paymentSlipAdjustmentId);
			
			
		} catch (Exception e) {
			System.err.println(e);
		}
	
	}
	
	private static void validateInputs(String dt, String id) throws Exception {
		InputValidation validaton = new InputValidation();
		validaton.validation(dt, id);
		datePaymentSlipCanceled = validaton.getData();
		paymentSlipAdjustmentId = validaton.getId();
	}

	private static void processPaymentSlipActive() throws Exception {
		PaymentSlipActive paymentSlipActive = new PaymentSlipActive();
		List<PaymentSlipEntity> result = paymentSlipActive.getPaymentSlipActive();
		DisplayPaymentSlipActive displayPaymentSlipActive = new DisplayPaymentSlipActive();		
		displayPaymentSlipActive.createReport(result);
	}
	
	private static void processPaymentSlipCanceled(Date dt) throws Exception {
		PaymentSlipCanceled paymentSlipCanceled = new PaymentSlipCanceled();
		List<PaymentSlipEntity> result = paymentSlipCanceled.getPaymentSlipCanceled(dt);
		DisplayPaymentSlipCanceled displayPaymentSlipActive = new DisplayPaymentSlipCanceled();		
		displayPaymentSlipActive.createReport(result);
	}
	
	private static void processPaymentSlipAdjustment(int id) throws Exception {
		PaymentSlipAdjustment PaymentSlipAdjustment = new PaymentSlipAdjustment();
		List<AdjustmentEntity> result = PaymentSlipAdjustment.getPaymentSlipAdjustment(id);
		DisplayPaymentSlipAdjustment displayPaymentSlipAdjustment = new DisplayPaymentSlipAdjustment();		
		displayPaymentSlipAdjustment.createReport(result);
	}
	
}
