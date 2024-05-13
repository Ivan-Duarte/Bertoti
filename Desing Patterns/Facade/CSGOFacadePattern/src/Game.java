/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

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
