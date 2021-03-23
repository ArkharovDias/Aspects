package com.springcourse.services;

import com.springcourse.models.zoo.Animal;
import com.springcourse.models.food.Food;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;

@Service
public class AnimalServiceImpl implements AnimalService {

    @Override
    public void feedAnimal(Food food, Animal animal, BigDecimal foodPortion) {
        animal.feed(food, foodPortion);
    }
}
