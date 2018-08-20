package com.kodilla.patterns2;


import decorator.pizza.BasicPizza;
import decorator.pizza.BasicPizzaOrder;
import decorator.pizza.TypicalPizzaDecorator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DecoratorTests {

    @Test
    public void basicPizzaDecoratorTestPrice() {

        //Given
        BasicPizza theOrder = new BasicPizzaOrder();

        //When
        BigDecimal calculatedPrice = theOrder.getPrice();

        //Then
        assertEquals(new BigDecimal(12), calculatedPrice);
    }

    @Test
    public void basicPizzaDecoratorTestDescription() {

        //Given
        BasicPizza theOrder = new BasicPizzaOrder();


        //When
        String description = theOrder.getDescription();

        //Then
        assertEquals("Ser, szynka i pieczarki", description);
    }

    @Test
    public void typicalPizzaDecoratorTestPrice() {

        //Given
        BasicPizza theOrder = new BasicPizzaOrder();
        theOrder = new TypicalPizzaDecorator(theOrder);

        //When
        BigDecimal calculatedPrice = theOrder.getPrice();

        //Then
        assertEquals(new BigDecimal(29), calculatedPrice);
    }

    @Test
    public void typicalPizzaDecoratorTestDescription() {

        //Given
        BasicPizza theOrder = new BasicPizzaOrder();
        theOrder = new TypicalPizzaDecorator(theOrder);


        //When
        String description = theOrder.getDescription();

        //Then
        assertEquals("Ser, szynka i pieczarki z dodatkowym serem i oliwkami", description);
    }
}