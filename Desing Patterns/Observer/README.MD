# Desing Patterns

## Observer

<div style="text-align: justify;">
O padrão Observer é uma solução de design que permite que objetos, conhecidos como observadores, sejam notificados automaticamente sobre as mudanças de estado de um objeto observado, também chamado de sujeito. Isso promove um acoplamento fraco entre os observadores e o sujeito, permitindo que múltiplos observadores sejam adicionados ou removidos sem modificar o código do sujeito. Essa flexibilidade é especialmente útil em cenários onde várias partes do sistema precisam reagir dinamicamente a mudanças em um estado compartilhado. Este resumo oferece uma visão geral sucinta do padrão Observer e destaca sua aplicabilidade em projetos de software.
</div>

<br>

<div style="text-align: center;">
    <img src="DCUML - Observer.PNG" style="max-width: 90%; height: auto;">
</div>

<br>

#### <span style="color: Orangered">"Game.java" - (Main)</span>
```java
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
```

#### <span style="color: Orangered">"HealthData" - (Publisher)</span>
```java
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
```

#### <span style="color: Orangered">"HealthObserver.java" (Interface - Subscriber)</span>
```java
/**
 *
 * @author Ivan Germano
 */
public interface HealthObserver {
    void update(int health);
}

```

#### <span style="color: Orangered">"UIHealthBar.java" (Concret Subscriber)</span>
```java
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
```

#### <span style="color: Orangered">"SoundAlert.java" (Concret Subscriber)</span>
```java
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

```