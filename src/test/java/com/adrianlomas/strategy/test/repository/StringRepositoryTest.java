package com.adrianlomas.strategy.test.repository;

import com.adrianlomas.strategy.Strategy;
import com.adrianlomas.strategy.test.repository.exception.StrategyNotFoundException;
import com.adrianlomas.strategy.sampleStrategy.CakeStrategy;
import com.adrianlomas.strategy.sampleStrategy.HamburgerStrategy;
import com.adrianlomas.strategy.sampleStrategy.PizzaStrategy;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Adrian Garcia Lomas
 */
public class StringRepositoryTest {

    private StringStrategyRepository orderStringRepository;

    @Before
    public void setup(){

        //Create repository
        orderStringRepository = new StringStrategyRepository();

        //Add strategy to repository
        orderStringRepository.add("cake_order",new CakeStrategy());
        orderStringRepository.add("hamburger_order",new HamburgerStrategy());
        orderStringRepository.add("pizza_order",new PizzaStrategy());
    }

    @Test
    public void testingStringRepository() throws StrategyNotFoundException {

        Strategy orderStrategy = orderStringRepository.search("cake_order");
        Assert.assertEquals(orderStrategy.getClass(),CakeStrategy.class);

    }

    @Test(expected = StrategyNotFoundException.class)
    public void testStringRespositoryNotFound() throws StrategyNotFoundException {

      Strategy orderStrategy = orderStringRepository.search("coffe_order");

    }

}
