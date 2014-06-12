The Property
=========

The property is a library that help you to create Strategy Pattern
  - Create Strategies implements the Strategy Interface
  - You dont need to use any if else or factory to select the Strategy, use the Respository included in this Library
  - Extends the Repository interface for create new Repositories




How to use
----

Create your own Strategy class implements the Strategy interface, use the Generics for customice input and output


```java

    public interface AbstracFoodMakerStrategy extends Strategy<String,Integer> {

    @Override
    public abstract String executeStrategy(Integer amount);
}

```
Create espeficific strategies extending your custom AbstractStrategy

```java

public class PizzaStrategy implements  AbstracFoodMakerStrategy {
    @Override
    public String executeStrategy(Integer amount) {

        for(int i=0;i<amount;i++){
            System.out.println( "Making pizza "+i);
        }

        return "Complete";
    }
}

```

Now use one of the Repositories included in the library or create new one extending the Repository interface

Using the ClassStrategyRepository, adding strategies, the first parameter is used to perform searchs and the second the strategy that correspond width this parameter


```java
   classStrategyRepository = new ClassStrategyRepository();
   classStrategyRepository.add(PizzaOrder.class,new PizzaStrategy());

```

Now somewhere in your code, when you need to decide what kind of strategy use


```java
     Order order = new PizzaOrder();
     Strategy strategy = classStrategyRepository.search(order.getClass());

```

See the test code for more examples
