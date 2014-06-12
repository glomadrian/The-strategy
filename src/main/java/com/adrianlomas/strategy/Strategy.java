package com.adrianlomas.strategy;

/**
 * @author Adrian Garcia Lomas
 */
public interface Strategy <T1,T2>{

    T1 executeStrategy(T2 params);

}
