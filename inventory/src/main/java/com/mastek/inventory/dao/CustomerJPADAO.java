package com.mastek.inventory.dao;

import org.springframework.data.repository.CrudRepository;

import com.mastek.inventory.entities.Customer;

public interface CustomerJPADAO extends CrudRepository<Customer, Integer> {

}
