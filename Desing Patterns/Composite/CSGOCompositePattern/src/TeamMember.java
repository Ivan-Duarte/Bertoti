/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.util.List;
/**
 *
 * @author Ivan Germano
 */

public class TeamMember implements GameComponent {
    private String role;
    private List<String> equipment;

    public TeamMember(String role, List<String> equipment) {
        this.role = role;
        this.equipment = equipment;
    }

    @Override
    public void performAction() {
        System.out.println("'" + role + "' - com o equipamento " + equipment.toString() + " está jogando");
    }
}
