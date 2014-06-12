package com.adrianlomas.strategy.test.repository;

import com.adrianlomas.strategy.Strategy;
import com.adrianlomas.strategy.test.repository.exception.StrategyNotFoundException;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Adrian Garcia Lomas
 */
public class IntegerStrategyRespository implements Repository<Integer>{

    Map<Integer,Strategy> strategyMap;

    public IntegerStrategyRespository() {
        init();
    }

    @Override
    public void add(Integer selector, Strategy strategy) {
        strategyMap.put(selector,strategy);
    }

    @Override
    public Strategy search(Integer selector) throws StrategyNotFoundException {
        Strategy strategy = strategyMap.get(selector);

        if(strategy==null){
            throw new StrategyNotFoundException();
        }

        return strategy;
    }

    private void init(){
        strategyMap = new HashMap<Integer, Strategy>();
    }

}
