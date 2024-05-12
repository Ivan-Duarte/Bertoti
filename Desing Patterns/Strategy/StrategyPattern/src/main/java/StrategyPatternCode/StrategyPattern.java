/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package StrategyPatternCode;

/**
 *
 * @author Ivan
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
