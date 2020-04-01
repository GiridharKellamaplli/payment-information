package com.paypall.paymentinformation.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.paypall.paymentinformation.model.Payment;
import com.paypall.paymentinformation.model.PaymentViewBean;
import com.paypall.paymentinformation.service.PaymentService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/v1/api/payment")
public class PaymentController {

	@Autowired
	private PaymentService paymentService;

	@GetMapping("/lastThirtyDaysPayments/{accountNumber}")
	@ApiOperation(value = "Find last thirty days payments by account number.", notes = "Provide an account number to look up specific customer's last thirty days payment history.")
	@ApiResponses(value = { @ApiResponse(code = 412, message = "You requested account number is invalid or empty"),
			@ApiResponse(code = 500, message = "System is overloaded. Please try after some time.") })
	public ResponseEntity<PaymentViewBean> getUserPayments(
			@ApiParam(defaultValue = "968574123", value="Customer Account Number.", required = true)
			@PathVariable("accountNumber") final String accountNumber) {

		PaymentViewBean paymentViewBean = new PaymentViewBean();
		paymentViewBean.setSuccess(Boolean.FALSE);
		try {
			boolean isValidAccountNumber = false;
			Long accNumber = Long.valueOf(accountNumber);
			isValidAccountNumber = paymentService.isvalidAccountNumber(accNumber);
			if (isValidAccountNumber) {
				List<Payment> payments = paymentService.getUserPayments(accNumber);
				paymentViewBean.setPayments(payments);
				paymentViewBean.setSuccess(Boolean.TRUE);
				return new ResponseEntity<PaymentViewBean>(paymentViewBean, HttpStatus.OK);
			}
			paymentViewBean.setErrorMessage("The given account number is invalid. ");
			return new ResponseEntity<PaymentViewBean>(paymentViewBean, HttpStatus.PRECONDITION_FAILED);
		} catch (NumberFormatException ne) {
			paymentViewBean.setErrorMessage("The given account number should contains only numbers");
			return new ResponseEntity<PaymentViewBean>(paymentViewBean, HttpStatus.PRECONDITION_FAILED);
		} catch (Exception e) {
			paymentViewBean.setErrorMessage(
					"System failed while fetch the information. Please try after some time or Contact Customer Support");
			return new ResponseEntity<>(paymentViewBean, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

}
