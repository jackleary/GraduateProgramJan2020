package com.mastek.inventory.dao;

import org.springframework.data.repository.CrudRepository;

import com.mastek.inventory.entities.Category;
import com.mastek.inventory.entities.Ingredient;

public interface IngredientJPADAO extends CrudRepository<Ingredient, Integer> {

}
