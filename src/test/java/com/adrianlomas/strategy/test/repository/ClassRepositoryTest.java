package com.adrianlomas.strategy.test.repository;

import com.adrianlomas.strategy.Strategy;
import com.adrianlomas.strategy.order.HamburgerOrder;
import com.adrianlomas.strategy.order.Order;
import com.adrianlomas.strategy.order.PizzaOrder;
import com.adrianlomas.strategy.test.repository.exception.StrategyNotFoundException;
import com.adrianlomas.strategy.sampleStrategy.HamburgerStrategy;
import com.adrianlomas.strategy.sampleStrategy.PizzaStrategy;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Adrian Garcia Lomas
 */
public class ClassRepositoryTest {

    private ClassStrategyRepository classStrategyRepository;

    @Before
    public void setup(){
        classStrategyRepository = new ClassStrategyRepository();

        classStrategyRepository.add(HamburgerOrder.class,new HamburgerStrategy());
        classStrategyRepository.add(PizzaOrder.class,new PizzaStrategy());
    }


    @Test
    public void testClassStrategyRepository() throws StrategyNotFoundException {
        Order order = new HamburgerOrder();

        Strategy strategy = classStrategyRepository.search(order.getClass());

        Assert.assertEquals(strategy.getClass(), HamburgerStrategy.class);
    }

    @Test(expected = StrategyNotFoundException.class)
    public void testClassStrategyRespositoryNotFound() throws StrategyNotFoundException{
        Strategy strategy = classStrategyRepository.search(Void.class);
    }
}
