/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package StrategyPatternCode;

/**
 *
 * @author Ivan
 */
import strategy.HighBudgetStrategy;
import strategy.LowBudgetStrategy;

public class StrategyPattern {
    public static void main(String[] args) {
        PlayerUtilityContext context = new PlayerUtilityContext(new HighBudgetStrategy());
        context.executeStrategy();

        context.setStrategy(new LowBudgetStrategy());
        context.executeStrategy();
    }
}
