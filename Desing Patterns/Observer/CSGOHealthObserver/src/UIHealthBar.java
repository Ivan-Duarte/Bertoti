/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Ivan Germano
 */
public class UIHealthBar implements HealthObserver{
    @Override
    public void update(int health) {
        System.out.println("Atualizando a barra de vida na UI: Vida atual = " + health);
    }
}
