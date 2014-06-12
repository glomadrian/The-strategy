package com.adrianlomas.strategy.test;

import com.adrianlomas.strategy.order.HamburgerOrder;
import com.adrianlomas.strategy.order.PizzaOrder;
import com.adrianlomas.strategy.test.repository.ClassStrategyRepository;
import com.adrianlomas.strategy.test.repository.IntegerStrategyRespository;
import com.adrianlomas.strategy.test.repository.StringStrategyRepository;
import com.adrianlomas.strategy.test.repository.exception.StrategyNotFoundException;
import com.adrianlomas.strategy.sampleStrategy.CakeStrategy;
import com.adrianlomas.strategy.sampleStrategy.HamburgerStrategy;
import com.adrianlomas.strategy.sampleStrategy.PizzaStrategy;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Adrian Garcia Lomas
 */
public class CompleteTest {

    private ClassStrategyRepository classStrategyRepository;
    private IntegerStrategyRespository integerStrategyRespository;
    private StringStrategyRepository stringStrategyRepository;

    @Before
    public void setup(){

        integerStrategyRespository = new IntegerStrategyRespository();
        integerStrategyRespository.add(2243,new CakeStrategy());
        integerStrategyRespository.add(9872,new PizzaStrategy());
        integerStrategyRespository.add(1000,new HamburgerStrategy());

        classStrategyRepository = new ClassStrategyRepository();
        classStrategyRepository.add(HamburgerOrder.class,new HamburgerStrategy());
        classStrategyRepository.add(PizzaOrder.class,new PizzaStrategy());

        //Create repository
        stringStrategyRepository = new StringStrategyRepository();

        //Add strategy to repository
        stringStrategyRepository.add("cake_order",new CakeStrategy());
        stringStrategyRepository.add("hamburger_order",new HamburgerStrategy());
        stringStrategyRepository.add("pizza_order",new PizzaStrategy());
    }


    @Test
    public void completeTest() throws StrategyNotFoundException {

        integerStrategyRespository.search(2243).executeStrategy(2);
        integerStrategyRespository.search(9872).executeStrategy(1);
        integerStrategyRespository.search(1000).executeStrategy(3);

        classStrategyRepository.search(HamburgerOrder.class).executeStrategy(5);

        stringStrategyRepository.search("cake_order").executeStrategy(3);

    }

}
