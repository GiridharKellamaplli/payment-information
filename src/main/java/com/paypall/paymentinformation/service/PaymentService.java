package com.paypall.paymentinformation.service;

import java.util.List;

import com.paypall.paymentinformation.model.Payment;

public interface PaymentService {
	
	public List<Payment> getUserPayments(Long accountNumber);

	public boolean isvalidAccountNumber(Long accountNumber);

}
