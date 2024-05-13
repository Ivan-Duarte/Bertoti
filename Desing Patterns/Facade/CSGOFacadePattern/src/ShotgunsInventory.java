/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

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
