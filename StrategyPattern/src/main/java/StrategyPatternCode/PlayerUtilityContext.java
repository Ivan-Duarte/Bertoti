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

public class PlayerUtilityContext {
    private UtilityStrategy strategy;

    public PlayerUtilityContext(UtilityStrategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(UtilityStrategy strategy) {
        this.strategy = strategy;
    }

    public void executeStrategy() {
        strategy.execute();
    }
}
