package com.adrianlomas.strategy.sampleStrategy;

/**
 * @author Adrian Garcia Lomas
 */
public class CakeStrategy implements  AbstracFoodMakerStrategy {
    @Override
    public String executeStrategy(Integer amount) {

        for(int i=0;i<amount;i++){
            System.out.println( "Making cake "+i);
        }

        return "Complete";
    }
}
