/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Ivan Germano
 */
public class Main {
    public static void main(String[] args) {
        // Criar estratégias de salário
        SalaryStrategy permanentStrategy = new PermanentStrategy();
        SalaryStrategy temporaryStrategy = new TemporaryStrategy();
        SalaryStrategy internStrategy = new InternStrategy();

        // Criar funcionários e atribuir estratégias
        Employee employee1 = new Employee("Ivan", permanentStrategy);
        Employee employee2 = new Employee("Isaque", temporaryStrategy);
        Employee employee3 = new Employee("Leandro", internStrategy);

        // Criar um observador
        Observer hrObserver = new Observer() {
            @Override
            public void update() {
                System.out.println("RH notificado sobre a mudança de salário.");
            }
        };

        // Adicionar observadores aos funcionários
        employee1.addObserver(hrObserver);
        employee2.addObserver(hrObserver);
        employee3.addObserver(hrObserver);

        // Criar um grupo de funcionários
        EmployeeGroup department = new EmployeeGroup();
        department.add(employee1);
        department.add(employee2);
        department.add(employee3);

        // Ações para acionar o Observer
        System.out.println("Atualizando Salários:");
        employee1.performAction();  
        employee2.performAction();  
        employee3.performAction();  
    }
}
