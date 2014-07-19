package com.example.simplify;

import com.simplify.payments.PaymentsApi;
import com.simplify.payments.PaymentsMap;
import com.simplify.payments.domain.Payment;
import com.simplify.payments.exception.ApiCommunicationException;
import com.simplify.payments.exception.AuthenticationException;
import com.simplify.payments.exception.InvalidRequestException;
import com.simplify.payments.exception.NotAllowedException;
import com.simplify.payments.exception.SystemException;

public class SimplifyTest {

	private static final String PRIVATE_KEY = "+h78riukmgKzQ30EktbTWwCtXlORxN3nMbeiT9GjxrV5YFFQL0ODSXAOkNtXTToq";
	private static final String PUBLIC_KEY = "sbpb_Y2VlM2M0MDItZmRiMS00ZDg1LWJmMjQtYzdlNjA4ZDhkODMw";
//	PaymentsApi.PUBLIC_KEY = "YOUR_PUBLIC_API_KEY";
	
	
	public void runTest(){

	    PaymentsApi.PUBLIC_KEY = PUBLIC_KEY;
	    PaymentsApi.PRIVATE_KEY = PRIVATE_KEY;
	    Payment payment;
	    
		try 
		{
			payment = Payment.create(new PaymentsMap()
			    .set("currency", "USD")
			    .set("token", "f21da65e-f0ab-45cb-b8e6-40b493c3671f") // returned by JavaScript call
			    .set("amount", 1000) // In cents e.g. $10.00
			    .set("description", "prod description"));
			if ("APPROVED".equals(payment.get("paymentStatus"))) 
			{
				System.out.println("Payment approved");
			}
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}

	}
	
}
