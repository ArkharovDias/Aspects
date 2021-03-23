package com.springcourse.validators;

import com.springcourse.models.food.Food;

public interface Validator {
    boolean isValid(Food food, String animalName);
}
