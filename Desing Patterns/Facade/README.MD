# Desing Patterns

## Strategy

<div style="text-align: justify;">
O padrão de projeto "Strategy" oferece uma maneira flexível de encapsular algoritmos e permitir que eles sejam trocados dinamicamente durante a execução do programa. Esta abordagem promove a flexibilidade e a manutenção do código, permitindo que diferentes algoritmos sejam facilmente intercambiáveis. Este README fornece uma introdução ao padrão "Strategy" e seu uso em projetos de software.
</div>

<br>

<div align="center">
    <img src="DCUML - Facade.PNG" style="max-width: 90%; height: auto;">
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
        WeaponShopFacade shop = new WeaponShopFacade();
        
        shop.buyWeapon("pistol", "Glock");
        shop.buyWeapon("shotgun", "XM1014");
        
        shop.discardWeapon("pistol", "Glock");
        shop.discardWeapon("shotgun", "XM1014");
    }
}
```

#### <span style="color: Orangered">"WeaponInventory.java" - (Interface Subsystem Class)</span>
```java
public interface WeaponInventory {
    void addWeapon(String weapon);
    void removeWeapon(String weapon);
}
```

#### <span style="color: Orangered">"WeaponShopFacade.java" (Facade)</span>

```java
import java.util.HashMap;
import java.util.Map;
/**
 *
 * @author Ivan Germano
 */
public class WeaponShopFacade {
    private Map<String, WeaponInventory> inventories;

    public WeaponShopFacade() {
        inventories = new HashMap<>();
        inventories.put("pistol", new PistolsInventory());
        inventories.put("shotgun", new ShotgunsInventory());
    }

    public void buyWeapon(String category, String weapon) {
        if (inventories.containsKey(category)) {
            inventories.get(category).addWeapon(weapon);
        } else {
            System.out.println("Category not supported: " + category);
        }
    }

    public void discardWeapon(String category, String weapon) {
        if (inventories.containsKey(category)) {
            inventories.get(category).removeWeapon(weapon);
        } else {
            System.out.println("Categoria inexistente " + category);
        }
    }
}
```

#### <span style="color: Orangered">"PistolsInventory.java" (Subsystem Class)</span>
```java
/**
 *
 * @author Ivan Germano
 */
public class PistolsInventory implements WeaponInventory {
    @Override
    public void addWeapon(String weapon) {
        System.out.println("Você equipou a pistola: " + weapon);
    }

    @Override
    public void removeWeapon(String weapon) {
        System.out.println("Você dropou a pistola: " + weapon);
    }
}
```

#### <span style="color: Orangered">"ShotgunsInventory.java" (Subsystem Class)</span>
```java
/**
 *
 * @author Ivan Germano
 */
public class ShotgunsInventory implements WeaponInventory {
    @Override
    public void addWeapon(String weapon) {
        System.out.println("Calibre 12 adicionada: " + weapon);
    }

    @Override
    public void removeWeapon(String weapon) {
        System.out.println("Você dropou a Calibre 12 " + weapon);
    }
}
```
