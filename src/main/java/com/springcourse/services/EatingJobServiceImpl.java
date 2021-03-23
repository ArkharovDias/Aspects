package com.springcourse.services;

import com.springcourse.event.AnimalIsHungryEvent;
import com.springcourse.models.zoo.Animal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class EatingJobServiceImpl implements JobService{

    private List<Animal> animalList;

    private final ApplicationEventPublisher applicationEventPublisher;

    @Autowired
    public EatingJobServiceImpl(List<Animal> animalList, ApplicationEventPublisher applicationEventPublisher) {
        this.animalList = animalList;
        this.applicationEventPublisher = applicationEventPublisher;
    }

    @Scheduled(cron = "*/2 * * * * *")
    @Override
    public void executeJob() {
        for (Animal animal: animalList) {
            animal.eat();
            if (animal.getFood().getValue().compareTo(BigDecimal.ZERO) < 0){
                System.out.println("I am hungry");
                animal.voice();
                applicationEventPublisher.publishEvent(new AnimalIsHungryEvent<>(animal));
            }
        }

        animalList.forEach(System.out::println);
    }
}
