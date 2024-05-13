/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Ivan Germano
 */
public class Game {
    public static void main(String[] args) {
        HealthData healthData = new HealthData(100);
        UIHealthBar uiHealthBar = new UIHealthBar();
        SoundAlert soundAlert = new SoundAlert();

        healthData.addObserver(uiHealthBar);
        healthData.addObserver(soundAlert);

        // Simula mudanças na vida do personagem
        healthData.setHealth(90);
        healthData.setHealth(50);
        healthData.setHealth(15);
    }
}
