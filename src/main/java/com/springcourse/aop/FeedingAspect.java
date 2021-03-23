package com.springcourse.aop;

import com.springcourse.exceptions.InvalidFoodException;
import com.springcourse.models.food.Food;
import com.springcourse.validators.FoodValidator;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Aspect
@Component
public class FeedingAspect {

    private final FoodValidator foodValidator;

    public FeedingAspect(FoodValidator foodValidator) {
        this.foodValidator = foodValidator;
    }

    @Pointcut("execution(* com.springcourse.models.zoo.Animal.feed(..))")
    public void feedPoint(){}

    @Before(value = "feedPoint() && args(food)")
    public void beforeFeed(JoinPoint joinPoint, Food food){
        String animalName = joinPoint.getTarget().getClass().getSimpleName().toLowerCase(Locale.ROOT);
        if (!foodValidator.isValid(food, animalName)){
            throw new InvalidFoodException("Not Valid Food");
        }
    }
}
