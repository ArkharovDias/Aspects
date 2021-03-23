package com.springcourse.services;

import com.springcourse.models.zoo.Animal;
import com.springcourse.models.food.Food;

import java.math.BigDecimal;

public interface AnimalService {
    void feedAnimal(Food food, Animal animal, BigDecimal foodPortion);
}
