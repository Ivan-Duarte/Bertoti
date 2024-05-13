# Desing Patterns - Arquitetura de Software

##  Model-View-Controller (MVC)

<div style="text-align: justify;">
O padrão Model-View-Controller (MVC) é uma arquitetura de software amplamente utilizada que separa a aplicação em três componentes principais: o Modelo (Model), a Visão (View) e o Controlador (Controller). O Modelo representa os dados e a lógica de negócios da aplicação, a Visão é responsável pela apresentação da interface do usuário e o Controlador coordena as interações entre o Modelo e a Visão, respondendo a eventos do usuário e atualizando o Modelo conforme necessário. O MVC promove a modularidade, a reutilização de código e a separação de preocupações, facilitando o desenvolvimento, a manutenção e a escalabilidade de aplicações de software. Este resumo oferece uma visão abrangente do padrão MVC e destaca sua utilidade em projetos que exigem uma arquitetura bem organizada e fácil de manter.
</div>

<br>

<div align="center">
    <img src="DCUML - MVC.PNG" style="max-width: 90%; height: auto;">
</div>

<br>

#### <span style="color: Orangered">"Main.java" - (Main)</span>
```java
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
```

#### <span style="color: Orangered">"EmployeeComponent.java" (Interface)</span>
```java
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
```

#### <span style="color: Orangered">"Observer.java" - (Interface)</span>
```java
/**
 *
 * @author Ivan Germano
 */
public interface Observer {
    void update();
}
```

#### <span style="color: Orangered">"SalaryStrategy.java" (Interface)</span>
```java
/**
 *
 * @author Ivan Germano
 */
public interface SalaryStrategy {
    double calculateSalary();
}
```

#### <span style="color: Orangered">"Employee.java" (Conposite - Publisher)</span>
```java
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
```

#### <span style="color: Orangered">"EmployeeGroup.java" (Composite - Publisher)</span>
```java
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
```

#### <span style="color: Orangered">"InternStrategy.java" (Estratégia)</span>
```java
public class InternStrategy implements SalaryStrategy {
    @Override
    public double calculateSalary() {
        return 1000.00;
    }
}
```

#### <span style="color: Orangered">"TemporaryStrategy.java" (Estratégia)</span>
```java
public class TemporaryStrategy implements SalaryStrategy {
    @Override
    public double calculateSalary() {
        return 3000.00;
    }
}

```

#### <span style="color: Orangered">"PermanentStrategy.java" (Estratégia)</span>
```java
public class PermanentStrategy implements SalaryStrategy {
    @Override
    public double calculateSalary() {
        return 5000.00;
    }
}
```
