package com.paypall.paymentinformation.dao;

import java.util.List;

import com.paypall.paymentinformation.model.Payment;

public interface PaymentDAO {
	
	public List<Payment> getUserPayments(Long accountNumber);

}
