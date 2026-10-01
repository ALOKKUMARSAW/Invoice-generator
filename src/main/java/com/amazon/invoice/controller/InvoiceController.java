package com.amazon.invoice.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amazon.invoice.request.response.InvoiceRequest;
import com.amazon.invoice.request.response.InvoiceResponse;
import com.amazon.invoice.service.InvoiceService;



@RestController
@RequestMapping("invoice")
public class InvoiceController {
	@Autowired
	InvoiceService invoiceService;

	@PostMapping("create")
	public ResponseEntity<InvoiceResponse> createInvoice(@RequestBody InvoiceRequest invoiceRequest) 
	{
		InvoiceResponse response = invoiceService.createInvoice(invoiceRequest);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(response);
	}

}