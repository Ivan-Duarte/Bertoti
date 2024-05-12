# Desing Patterns

## Strategy

<div style="text-align: justify;">
O padrão de projeto "Strategy" oferece uma maneira flexível de encapsular algoritmos e permitir que eles sejam trocados dinamicamente durante a execução do programa. Esta abordagem promove a flexibilidade e a manutenção do código, permitindo que diferentes algoritmos sejam facilmente intercambiáveis. Este README fornece uma introdução ao padrão "Strategy" e seu uso em projetos de software.
</div>

<br>

<div style="text-align: center;">
    <img src="DCUML - Strategy.PNG" style="max-width: 90%; height: auto;">
</div>

<br>

#### <span style="color: Orangered">"StrategyPatternCode.java" - (Main)</span>
```java
 package StrategyPatternCode;

/**
 *
 * @author Ivan Germano
 */
public class StrategyPattern {
    public static void main(String[] args) {
        PlayerUtilityContext context = new PlayerUtilityContext(500); //Exemplo sendo Echo
        context.executeStrategy();
        
        context = new PlayerUtilityContext(1500); //Exemplo sendo meia compra
        context.executeStrategy();
        
        context = new PlayerUtilityContext(3000); //Exemplo sendo FullBuy
        context.executeStrategy();
    }
}
```

#### <span style="color: Orangered">"PlayerUtilityContext.java" - (Contexto)</span>
```java
 package StrategyPatternCode;

/**
 *
 * @author Ivan Germano
 */
import strategy.UtilityStrategy;
import strategy.FullBuyBudgetStrategy;
import strategy.MeiaCompraBudgetStrategy;
import strategy.EchoBudgetStrategy;

public class PlayerUtilityContext {
    private UtilityStrategy strategy;
    private int budget; //Economia do Player

    public PlayerUtilityContext(int budget) {
        this.budget = budget;
        setStrategyBasedOnBudget(budget);  //Define a estratégia baseado na Economia do Player
    }
    
    private void setStrategyBasedOnBudget(int budget){
        if (budget < 1000){ 
            this.strategy = new EchoBudgetStrategy();
        } else if (budget >= 1000 && budget < 2000){
            this.strategy = new MeiaCompraBudgetStrategy();
        } else {
            this.strategy = new FullBuyBudgetStrategy();
        }
    }
    
    public void executeStrategy(){
        strategy.execute();
    }
}
```

#### <span style="color: Orangered">"UtilityStrategy.java" (Interface)</span>
```java
package strategy;

/**
 *
 * @author Ivan Germano
 */
public interface UtilityStrategy {
    void execute();
}
```

#### <span style="color: Orangered">"EchoBudgetStrategy.java" (Estratégia)</span>
```java
package strategy;

/**
 *
 * @author Ivan Germano
 */
public class EchoBudgetStrategy implements UtilityStrategy {
    @Override
    public void execute() {
        System.out.println("Não compra nada, faz Echo!!!");
    }
}
```

#### <span style="color: Orangered">"MeiaCompraBudgetStrategy.java" (Estratégia)</span>
```java
package strategy;

/**
 *
 * @author Ivan Germano
 */
public class MeiaCompraBudgetStrategy implements UtilityStrategy {
    @Override
    public void execute() {
        System.out.println("| 1x Smoke + 1x Flashbang | ou | 1x Flashbang + 1x HE |");
    }
}
```

#### <span style="color: Orangered">"FullBuyBudgetStrategy.java" (Estratégia)</span>
```java
package strategy;

/**
 *
 * @author Ivan Germano
 */
public class FullBuyBudgetStrategy implements UtilityStrategy {
    @Override
    public void execute() {
        System.out.println("Compra tudo que tem direito!!!");
    }
}
```