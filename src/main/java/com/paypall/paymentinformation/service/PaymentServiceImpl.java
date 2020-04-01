package com.paypall.paymentinformation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paypall.paymentinformation.dao.PaymentDAO;
import com.paypall.paymentinformation.model.Payment;

@Service
public class PaymentServiceImpl implements PaymentService {

	@Autowired
	private PaymentDAO paymentDAO;
	
	
	@Override
	public List<Payment> getUserPayments(Long accountNumber) {
		List<Payment> payments = paymentDAO.getUserPayments(accountNumber);
		return payments;
	}


	@Override
	public boolean isvalidAccountNumber(Long accountNumber) {
		// Talk to db to validate the account number. If this accountNumber exist and active.
		return true;
	}

}
