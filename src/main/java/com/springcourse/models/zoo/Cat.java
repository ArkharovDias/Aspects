package com.springcourse.models.zoo;

import com.springcourse.models.food.Food;
import lombok.ToString;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@ToString
public class Cat implements Animal{

    private Food food;
    private BigDecimal foodPortion;

    @Override
    public void voice() {
        System.out.println("Mi");
    }

    @Override
    public void feed(Food food, BigDecimal foodPortion) {
        this.food = food;
        this.foodPortion = foodPortion;
    }

    @Override
    public Food getFood() {
        return food;
    }

    @Override
    public void eat() {
        food.setValue(food.getValue().subtract(foodPortion));
    }
}