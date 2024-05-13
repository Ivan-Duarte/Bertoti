/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Ivan Germano
 */
public class SoundAlert implements HealthObserver{
    @Override
    public void update(int health) {
        if (health < 20) {
            System.out.println("Alerta de vida baixa! Emitindo som de alerta.");
        }
    }
}
