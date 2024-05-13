# Desing Patterns

## Composite

<div style="text-align: justify;">
O padrão Composite é uma solução de design que permite tratar objetos individuais e composições de objetos de maneira uniforme, formando uma hierarquia em árvore. Ele permite que os clientes tratem objetos individuais e composições de objetos de maneira uniforme, simplificando a manipulação de estruturas complexas. Isso é especialmente útil em situações onde é necessário representar partes-todo hierárquicas, como em estruturas de árvore em sistemas de arquivos ou em interfaces de usuário compostas por elementos individuais e grupos de elementos. Este resumo oferece uma visão abreviada do padrão Composite e destaca sua utilidade em projetos de software que lidam com estruturas hierárquicas.
</div>

<br>

<div align="center">
    <img src="DCUML - Composite.PNG" style="max-width: 90%; height: auto;">
</div>

<br>

#### <span style="color: Orangered">"Game.java" - (Main)</span>
```java
import java.util.Arrays;
/**
 *
 * @author Ivan Germano
 */

public class Game {
    public static void main(String[] args) {
        // Criar equipes
        GameGroup match = new GameGroup("Partida Iniciada");
        GameGroup terrorists = new GameGroup("Terrorist Team");
        GameGroup counterTerrorists = new GameGroup("Counter-Terrorist Team");

        // Adicionar membros às equipes
        TeamMember sniperT = new TeamMember("AWP Sniper", Arrays.asList("AWP", "Glock", "Flashbang", "Smoke"));
        TeamMember leaderT = new TeamMember("IGL", Arrays.asList("AK-47", "Glock", "Smoke"));
        TeamMember entryT = new TeamMember("Entry", Arrays.asList("AK-47", "Deagle", "HE"));
        TeamMember refraggerT = new TeamMember("IGL", Arrays.asList("Galil", "Tec-9", "Smoke"));
        TeamMember supportT = new TeamMember("Lurker", Arrays.asList("CZ-29", "Molotov", "Flashbang"));
        
        TeamMember leaderCt = new TeamMember("IGL", Arrays.asList("M4A4-S", "USP-S", "Smoke"));
        TeamMember lurkerCt = new TeamMember("Lurker", Arrays.asList("P250"));
        TeamMember entryCt = new TeamMember("Entry", Arrays.asList("M4A4", "Deagle", "HE"));
        TeamMember refraggerCt = new TeamMember("Refragger", Arrays.asList("M4A4-S", "USP-S", "Flashbang"));
        TeamMember supportCt = new TeamMember("Suporte", Arrays.asList("MP9", "USP-S", "Flashbang", "Smoke", "HE", "Incendiary"));
        
        
        terrorists.addComponent(sniperT);
        terrorists.addComponent(leaderT);
        terrorists.addComponent(entryT);
        terrorists.addComponent(refraggerT);
        terrorists.addComponent(supportT);
        counterTerrorists.addComponent(leaderCt);
        counterTerrorists.addComponent(lurkerCt);
        counterTerrorists.addComponent(entryCt);
        counterTerrorists.addComponent(refraggerCt);
        counterTerrorists.addComponent(supportCt);
        

        // Adicionar equipes à partida
        match.addComponent(terrorists);
        match.addComponent(counterTerrorists);

        // Executar ações
        match.performAction();
    }
}
```

#### <span style="color: Orangered">"GameComponent.java" - (Interface - Component)</span>
```java
public interface GameComponent {
    void performAction();
}
```

#### <span style="color: Orangered">"GameGroup.java" (Composite)</span>
```java
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
```

#### <span style="color: Orangered">"TeamMember.java" (Interface - Leaf)</span>
```java
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
```