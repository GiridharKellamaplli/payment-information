package com.paypall.paymentinformation.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Details about the Payment")
public class Payment implements Serializable{
	
	@ApiModelProperty(notes="Unique payment id for each payment")
	private Long paymentId;
	
	@ApiModelProperty(notes = "Local Payment time which considered default system time zone.")
	private LocalTime paymentTime;
	private LocalDate paymentDate;
	
	@ApiModelProperty(notes = "The account number of customer")
	private Long accountNumber;
	private Double amount;
	
	
	public Payment() {
		// TODO Auto-generated constructor stub
	}


	public Payment(Long paymentId,LocalDate paymentDate, LocalTime paymentTime, Long accountNumber, Double amount) {
		super();
		this.paymentId = paymentId;
		this.paymentDate = paymentDate;
		this.paymentTime = paymentTime;
		this.accountNumber = accountNumber;
		this.amount = amount;
	}


	public Long getPaymentId() {
		return paymentId;
	}


	public void setPaymentId(Long paymentId) {
		this.paymentId = paymentId;
	}


	public LocalTime getPaymentTime() {
		return paymentTime;
	}


	public void setPaymentTime(LocalTime paymentTime) {
		this.paymentTime = paymentTime;
	}


	public Long getAccountNumber() {
		return accountNumber;
	}


	public void setAccountNumber(Long accountNumber) {
		this.accountNumber = accountNumber;
	}


	public Double getAmount() {
		return amount;
	}


	public void setAmount(Double amount) {
		this.amount = amount;
	}


	public LocalDate getPaymentDate() {
		return paymentDate;
	}


	public void setPaymentDate(LocalDate paymentDate) {
		this.paymentDate = paymentDate;
	}
	
	
	
	
	

}
