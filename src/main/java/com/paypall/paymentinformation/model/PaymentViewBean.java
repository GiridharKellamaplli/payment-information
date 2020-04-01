package com.paypall.paymentinformation.model;

import java.util.List;

public class PaymentViewBean {
	
	private List<Payment> payments;
	private boolean isSuccess;
	private String errorMessage;
	
	public PaymentViewBean() {
		// TODO Auto-generated constructor stub
	}

	public PaymentViewBean(List<Payment> payments, boolean isSuccess, String errorMessage) {
		super();
		this.payments = payments;
		this.isSuccess = isSuccess;
		this.errorMessage = errorMessage;
	}

	public List<Payment> getPayments() {
		return payments;
	}

	public void setPayments(List<Payment> payments) {
		this.payments = payments;
	}

	public boolean isSuccess() {
		return isSuccess;
	}

	public void setSuccess(boolean isSuccess) {
		this.isSuccess = isSuccess;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
	

}
