package com.mastek.inventory.dao;

import org.springframework.data.repository.CrudRepository;

import com.mastek.inventory.entities.Category;
import com.mastek.inventory.entities.Order;

public interface OrderJPADAO extends CrudRepository<Order, Integer>{

}
