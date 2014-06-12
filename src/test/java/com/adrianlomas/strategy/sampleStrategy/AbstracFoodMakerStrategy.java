package com.adrianlomas.strategy.sampleStrategy;

import com.adrianlomas.strategy.Strategy;

/**
 * @author Adrian Garcia Lomas
 */
public interface AbstracFoodMakerStrategy extends Strategy<String,Integer> {

    @Override
    public abstract String executeStrategy(Integer amount);
}
