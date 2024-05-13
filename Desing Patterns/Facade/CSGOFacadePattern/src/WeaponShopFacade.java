


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

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
        // Adicione todas as outras categorias
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
