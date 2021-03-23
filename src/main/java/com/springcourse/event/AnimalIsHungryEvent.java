package com.springcourse.event;

import com.springcourse.models.zoo.Animal;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.ApplicationEvent;
import org.springframework.core.ResolvableType;
import org.springframework.core.ResolvableTypeProvider;

@Getter
@Setter
public class AnimalIsHungryEvent<T extends Animal> extends ApplicationEvent implements ResolvableTypeProvider {
    private T animal;

    public AnimalIsHungryEvent(T animal) {
        super(animal);
        this.animal = animal;
    }

    @Override
    public ResolvableType getResolvableType() {
        return ResolvableType.forClassWithGenerics(getClass(), ResolvableType.forInstance(getSource()));
    }
}
