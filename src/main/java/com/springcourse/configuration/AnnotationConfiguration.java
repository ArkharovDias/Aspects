package com.springcourse.configuration;

import com.springcourse.models.food.Food;
import com.springcourse.models.food.FoodType;
import org.springframework.context.annotation.*;
import org.springframework.scheduling.annotation.EnableScheduling;
import java.util.*;

@Configuration
@ComponentScan(value = {"com"})
@PropertySource("classpath:application.properties")
@EnableAspectJAutoProxy
@EnableScheduling
public class AnnotationConfiguration {

    @Bean
    public Map<String, List<FoodType>> animalsValidFoodMap(){
        Map<String, List<FoodType>> animalsValidFoodMap = new HashMap<>();
        animalsValidFoodMap.put("cat", Arrays.asList(FoodType.FISH, FoodType.MILK));
        animalsValidFoodMap.put("dog", Arrays.asList(FoodType.MEAT));
        animalsValidFoodMap.put("bear", Arrays.asList(FoodType.HONEY));
        return animalsValidFoodMap;
    }
}
