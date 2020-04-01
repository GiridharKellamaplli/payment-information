package com.paypall.paymentinformation.dao;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.paypall.paymentinformation.model.Payment;

@Repository
public class PaymentDAOImpl implements PaymentDAO {

	@Override
	public List<Payment> getUserPayments(Long accountNumber) {
		// Talk to DB and get the last thirty days user payments for this account number.
		List<Payment> payments = buildUserPayments(accountNumber);
		return payments;
	}
	
	private List<Payment> buildUserPayments(Long accountNumber) {
		ZoneId systemDefaultZoneId = ZoneId.systemDefault();
		LocalTime systemDefaultLocalTime = LocalTime.now(systemDefaultZoneId);
		LocalDate systemDefaultLocalDate = LocalDate.now(systemDefaultZoneId);
		
		Payment payment1 = new Payment(1234L, systemDefaultLocalDate, systemDefaultLocalTime, accountNumber, 250.69);
		Payment payment2 = new Payment(1234L, systemDefaultLocalDate, systemDefaultLocalTime, accountNumber, 150.79);
		Payment payment3 = new Payment(1234L, systemDefaultLocalDate, systemDefaultLocalTime, accountNumber, 100.00);
		List<Payment>  payments = Arrays.asList(payment1, payment2,payment3);
		return payments;
	}

}
