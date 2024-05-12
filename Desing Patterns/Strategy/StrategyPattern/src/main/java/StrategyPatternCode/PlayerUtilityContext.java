/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package StrategyPatternCode;

/**
 *
 * @author Ivan
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
