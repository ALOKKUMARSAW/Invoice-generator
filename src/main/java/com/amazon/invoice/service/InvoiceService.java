package com.amazon.invoice.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amazon.invoice.entity.InvoiceEntity;
import com.amazon.invoice.repository.InvoiceRespository;
import com.amazon.invoice.request.response.InvoiceRequest;
import com.amazon.invoice.request.response.InvoiceResponse;



@Service
public class InvoiceService {

	@Autowired
	InvoiceRespository invoiceRespository;

	public InvoiceResponse createInvoice(InvoiceRequest invoiceRequest) {
		InvoiceEntity entity = new InvoiceEntity();

		entity.setCustomerName(invoiceRequest.getCustomerName());
		entity.setGst(invoiceRequest.getGst());
		entity.setStatus("PAID");
		entity.setInvId("INV1234");
		
		entity = invoiceRespository.save(entity);
		InvoiceResponse invoiceResponse = new InvoiceResponse();
		if (entity.getId() > 0) {
			invoiceResponse.setCustomerName(entity.getCustomerName());
			invoiceResponse.setGst(entity.getGst());
			invoiceResponse.setStatus(entity.getStatus());
			invoiceResponse.setInvId(entity.getInvId());
			invoiceResponse.setId(entity.getId());
		}
		return invoiceResponse;
	}

}