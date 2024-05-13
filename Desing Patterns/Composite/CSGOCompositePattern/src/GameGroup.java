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

public class GameGroup implements GameComponent {
    private List<GameComponent> children = new ArrayList<>();
    private String name;

    public GameGroup(String name) {
        this.name = name;
    }

    public void addComponent(GameComponent component) {
        children.add(component);
    }

    public void removeComponent(GameComponent component) {
        children.remove(component);
    }

    @Override
    public void performAction() {
        System.out.println("Grupo '" + name + "' Foi Ativado");
        for (GameComponent child : children) {
            child.performAction();
        }
    }
}
