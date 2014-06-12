package com.adrianlomas.strategy.test.repository;

import com.adrianlomas.strategy.Strategy;
import com.adrianlomas.strategy.test.repository.exception.StrategyNotFoundException;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Adrian Garcia Lomas
 */
public class ClassStrategyRepository implements Repository<Class>{

    Map<Class,Strategy> strategyMap;

    public ClassStrategyRepository() {
        init();
    }

    @Override
    public void add(Class selector, Strategy strategy) {
        strategyMap.put(selector,strategy);
    }

    @Override
    public Strategy search(Class selector) throws StrategyNotFoundException {
        Strategy strategy = strategyMap.get(selector);

        if(strategy==null){
            throw new StrategyNotFoundException();
        }

        return strategy;
    }


    public void init(){
        strategyMap = new HashMap<Class, Strategy>();
    }
}
