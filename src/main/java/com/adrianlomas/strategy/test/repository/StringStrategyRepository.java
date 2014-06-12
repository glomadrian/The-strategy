package com.adrianlomas.strategy.test.repository;

import com.adrianlomas.strategy.Strategy;
import com.adrianlomas.strategy.test.repository.exception.StrategyNotFoundException;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Adrian Garcia Lomas
 */
public class StringStrategyRepository implements Repository<String> {

    Map<String,Strategy> strategyMap;

    public StringStrategyRepository() {
        init();
    }

    @Override
    public void add(String selector, Strategy strategy) {
       strategyMap.put(selector,strategy);
    }

    @Override
    public Strategy search(String selector) throws StrategyNotFoundException {

        Strategy strategy = strategyMap.get(selector);

        if(strategy==null){
            throw new StrategyNotFoundException();
        }

        return strategy;
    }

    private void init(){
        strategyMap = new HashMap<String, Strategy>();
    }
}
