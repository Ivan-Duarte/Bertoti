


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
public class Employee implements EmployeeComponent {
    private String name;
    private double salary;
    private List<Observer> observers = new ArrayList<>();
    private SalaryStrategy salaryStrategy;

    public Employee(String name, SalaryStrategy strategy) {
        this.name = name;
        this.salaryStrategy = strategy;
    }

    @Override
    public void performAction() {
        this.salary = salaryStrategy.calculateSalary();
        notifyObservers();
    }

    @Override
    public void add(EmployeeComponent employee) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void remove(EmployeeComponent employee) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }
}
