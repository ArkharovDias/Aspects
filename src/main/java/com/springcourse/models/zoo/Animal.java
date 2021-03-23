package com.springcourse.models.zoo;

import com.springcourse.models.food.Food;

import java.math.BigDecimal;

public interface Animal {

    void voice();

    void feed(Food food, BigDecimal foodPortion);

    Food getFood();

    void eat();
}
