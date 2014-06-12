package com.adrianlomas.strategy.test.repository;

import com.adrianlomas.strategy.Strategy;
import com.adrianlomas.strategy.test.repository.exception.StrategyNotFoundException;

/**
 * @author Adrian Garcia Lomas
 */
public interface Repository<T1> {

    void add(T1 selector,Strategy strategy);
    Strategy search(T1 selector) throws StrategyNotFoundException;
}
