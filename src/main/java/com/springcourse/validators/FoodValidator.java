package com.springcourse.validators;

import com.springcourse.models.food.Food;
import com.springcourse.models.food.FoodType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Component
public class FoodValidator implements Validator{

    private final Map<String, List<FoodType>> animalsValidFoodMap;

    @Autowired
    public FoodValidator(Map<String, List<FoodType>> animalsValidFoodMap) {
        this.animalsValidFoodMap = animalsValidFoodMap;
    }

    @Override
    public boolean isValid(Food food, String animalName) {
        return animalsValidFoodMap.get(animalName) != null &&
                animalsValidFoodMap.get(animalName).contains(food.getFoodType()) &&
                food.getExpiredDate().isAfter(LocalDateTime.now());
    }
}
