package com.mastek.inventory.dao;

import org.springframework.data.repository.CrudRepository;

import com.mastek.inventory.entities.Category;

public interface CategoryJPADAO extends CrudRepository<Category, Integer>{

}
