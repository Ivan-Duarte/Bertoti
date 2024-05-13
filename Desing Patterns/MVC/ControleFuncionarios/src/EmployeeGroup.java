


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
public class EmployeeGroup implements EmployeeComponent {
    private List<EmployeeComponent> employees = new ArrayList<>();

    @Override
    public void performAction() {
        for (EmployeeComponent employee : employees) {
            employee.performAction();
        }
    }

    @Override
    public void add(EmployeeComponent employee) {
        employees.add(employee);
    }

    @Override
    public void remove(EmployeeComponent employee) {
        employees.remove(employee);
    }

    @Override
    public void notifyObservers() {
        for (EmployeeComponent employee : employees) {
            employee.notifyObservers();
        }
    }

    @Override
    public void addObserver(Observer observer) {
        for (EmployeeComponent employee : employees) {
            employee.addObserver(observer);
        }
    }
}
