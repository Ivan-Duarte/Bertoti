/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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
