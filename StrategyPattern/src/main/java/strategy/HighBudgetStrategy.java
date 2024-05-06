/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package strategy;

/**
 *
 * @author Ivan
 */
public class HighBudgetStrategy implements UtilityStrategy {
    @Override
    public void execute() {
        System.out.println("Compra: 2x Smoke, 2x Flashbang, 1x Molotov");
    }
}
