package com.mastek.inventory.dao;

import org.springframework.data.repository.CrudRepository;

import com.mastek.inventory.entities.Category;
import com.mastek.inventory.entities.Product;

public interface ProductJPADAO extends CrudRepository<Product, Integer>{

}
