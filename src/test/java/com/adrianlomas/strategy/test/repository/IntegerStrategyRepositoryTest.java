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
public class IntegerStrategyRepositoryTest {

    private IntegerStrategyRespository integerStrategyRespository;

    @Before
    public void setup(){

        integerStrategyRespository = new IntegerStrategyRespository();

        integerStrategyRespository.add(2243,new CakeStrategy() );
        integerStrategyRespository.add(9872,new PizzaStrategy());
        integerStrategyRespository.add(1000,new HamburgerStrategy());
    }


    @Test
    public void testIntegerStrategyRespository() throws StrategyNotFoundException {

        Strategy strategy = integerStrategyRespository.search(1000);

        Assert.assertEquals(strategy.getClass(),HamburgerStrategy.class);
    }

    @Test(expected = StrategyNotFoundException.class)
    public void testIntegerStrategyRespositoryNotFound() throws StrategyNotFoundException{
        Strategy strategy = integerStrategyRespository.search(5434);
    }
}
