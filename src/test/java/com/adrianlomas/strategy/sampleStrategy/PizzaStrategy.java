package com.adrianlomas.strategy.sampleStrategy;

/**
 * @author Adrian Garcia Lomas
 */
public class PizzaStrategy implements  AbstracFoodMakerStrategy {
    @Override
    public String executeStrategy(Integer amount) {

        for(int i=0;i<amount;i++){
            System.out.println( "Making pizza "+i);
        }

        return "Complete";
    }
}
