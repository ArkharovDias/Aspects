package com.springcourse.models.food;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@ToString
public class Food {
    private LocalDateTime expiredDate;
    private FoodType foodType;
    private BigDecimal value;
}
