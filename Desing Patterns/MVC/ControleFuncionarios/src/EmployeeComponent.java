/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

/**
 *
 * @author Ivan Germano
 */
public interface EmployeeComponent {
    void performAction();
    void add(EmployeeComponent employee);
    void remove(EmployeeComponent employee);
    void notifyObservers();
    void addObserver(Observer observer);
}
