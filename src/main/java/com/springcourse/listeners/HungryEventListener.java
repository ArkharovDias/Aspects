package com.springcourse.listeners;

import com.springcourse.event.AnimalIsHungryEvent;
import com.springcourse.models.food.Food;
import com.springcourse.models.food.FoodType;
import com.springcourse.models.zoo.Animal;
import com.springcourse.models.zoo.Bear;
import com.springcourse.models.zoo.Cat;
import com.springcourse.models.zoo.Dog;
import com.springcourse.services.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Random;

@Component
public class HungryEventListener {

    private final AnimalService animalService;
    private final Map<String, List<FoodType>> animalsValidFoodMap;

    @Autowired
    public HungryEventListener(AnimalService animalService, Map<String, List<FoodType>> animalsValidFoodMap) {
        this.animalService = animalService;
        this.animalsValidFoodMap = animalsValidFoodMap;
    }

    @EventListener
    public void dogIsHungryListener(AnimalIsHungryEvent<Dog> dogIsHungryEvent){
        System.out.println("Feeding dog event");
        feedAnimal(dogIsHungryEvent, LocalDateTime.now().plusHours(3), BigDecimal.valueOf(3), BigDecimal.valueOf(20));
    }

    @EventListener
    public void catIsHungryListener(AnimalIsHungryEvent<Cat> catIsHungryEvent){
        System.out.println("Feeding cat event");
        feedAnimal(catIsHungryEvent, LocalDateTime.now().plusHours(4), BigDecimal.valueOf(2), BigDecimal.valueOf(15));
    }

    @EventListener
    public void bearIsHungryListener(AnimalIsHungryEvent<Bear> bearIsHungryEvent){
        System.out.println("Feeding bear event");
        feedAnimal(bearIsHungryEvent, LocalDateTime.now().plusHours(5), BigDecimal.valueOf(2), BigDecimal.valueOf(15));
    }


    private <T extends Animal> void feedAnimal(AnimalIsHungryEvent<T> animalIsHungryEvent, LocalDateTime expireDate, BigDecimal foodPortion , BigDecimal foodValue){
        List<FoodType> foodTypeList = animalsValidFoodMap.get(animalIsHungryEvent.getAnimal().getClass().getSimpleName().toLowerCase(Locale.ROOT));

        Food food = Food.builder()
                .foodType(foodTypeList.get(new Random().nextInt(foodTypeList.size())))
                .expiredDate(expireDate)
                .value(foodValue)
                .build();

        animalService.feedAnimal(food, animalIsHungryEvent.getAnimal(), foodPortion);
    }
}
