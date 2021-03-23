package com.springcourse;

import com.springcourse.configuration.AnnotationConfiguration;
import com.springcourse.event.AnimalIsHungryEvent;
import com.springcourse.models.zoo.Animal;
import com.springcourse.models.zoo.Cat;
import com.springcourse.models.zoo.Dog;
import com.springcourse.models.food.Food;
import com.springcourse.models.food.FoodType;
import com.springcourse.services.AnimalService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AnnotationConfiguration.class);

        Animal cat = applicationContext.getBean("cat", Animal.class);
        Animal dog = applicationContext.getBean("dog", Animal.class);
        Animal bear = applicationContext.getBean("bear", Animal.class);

        AnimalService animalService = applicationContext.getBean(AnimalService.class);

        Food catFood = Food.builder()
                .expiredDate(LocalDateTime.now().plusHours(3))
                .foodType(FoodType.FISH)
                .value(BigDecimal.valueOf(10))
                .build();

        Food dogFood = Food.builder()
                .expiredDate(LocalDateTime.now().plusHours(4))
                .foodType(FoodType.MEAT)
                .value(BigDecimal.valueOf(15))
                .build();

        Food bearFood = Food.builder()
                .expiredDate(LocalDateTime.now().plusHours(5))
                .foodType(FoodType.HONEY)
                .value(BigDecimal.valueOf(20))
                .build();

        animalService.feedAnimal(catFood, cat, BigDecimal.valueOf(2));
        animalService.feedAnimal(dogFood, dog, BigDecimal.valueOf(3));
        animalService.feedAnimal(bearFood, bear, BigDecimal.valueOf(4));
    }
}
