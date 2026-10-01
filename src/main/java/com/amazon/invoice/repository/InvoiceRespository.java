package com.amazon.invoice.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.amazon.invoice.entity.InvoiceEntity;



@Repository
public interface InvoiceRespository extends CrudRepository<InvoiceEntity, Integer> 
{

}