/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Ivan Germano
 */
public class HealthData {
    private List<HealthObserver> observers = new ArrayList<>();
    private int health;

    public HealthData(int health) {
        this.health = health;
    }

    public void addObserver(HealthObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(HealthObserver observer) {
        observers.remove(observer);
    }

    public void notifyObservers() {
        for (HealthObserver observer : observers) {
            observer.update(health);
        }
    }

    public void setHealth(int health) {
        this.health = health;
        notifyObservers();
    }

    public int getHealth() {
        return health;
    }
}
