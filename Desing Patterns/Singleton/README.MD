# Desing Patterns

## Singleton

<div style="text-align: justify;">
O padrão Singleton é uma solução de design que garante que uma classe tenha apenas uma instância e fornece um ponto de acesso global para essa instância. Ele é útil em situações onde é necessário ter exatamente uma instância de uma classe em todo o sistema, como em objetos de configuração, pools de conexão de banco de dados ou gerenciadores de cache. O Singleton promove o encapsulamento do acesso à instância única, facilitando a manutenção e evitando problemas de concorrência em ambientes multithread. Este resumo oferece uma breve descrição do padrão Singleton e destaca sua aplicabilidade em projetos de software que requerem instâncias únicas de classes.
</div>

<br>

<div align="center">
    <img src="DCUML - Singleton.PNG" style="max-width: 90%; height: auto;">
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
        UserSettings settings = UserSettings.getInstance();

        System.out.println("Resolução de Tela Atual: " + settings.getScreenResolution());
        System.out.println("Qualidade Gráfica: " + settings.getGraphicsQuality());
        System.out.println("Atalho de Teclas: " + settings.getKeyMappings());
        
        
        settings.setScreenResolution("2560x1440");
        System.out.println("Resolução de Tela Atualizada: " + settings.getScreenResolution());
        
        settings.setGraphicsQuality("Performance");
        System.out.println("Qualidade Gráfica Atualizada: " + settings.getGraphicsQuality());
        
        settings.setKeyMapping("Jump Throw ", "+Space -Mouse1");
        System.out.println("Atalho de Teclas Atualizado " + settings.getKeyMappings());
    }
}
```

#### <span style="color: Orangered">"UserSettings.java" - (Singleton)</span>
```java
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Ivan Germano
 */
public class UserSettings {
    private static UserSettings model;

    // Configurações
    private String screenResolution;
    private String graphicsQuality;
    private Map<String, String> keyMappings;

    // Construtor privado para evitar instanciação externa
    private UserSettings() {
        // Configuração Padrão
        this.screenResolution = "1920x1080";
        this.graphicsQuality = "High";
        this.keyMappings = new HashMap<>();
        keyMappings.put("Fire ", "Mouse1");
        keyMappings.put("Jump ", "Space");
    }

    // Método para acessar a instância
    public static synchronized UserSettings getInstance() {
        if (model == null) {
            model = new UserSettings();
        }
        return model;
    }

    // Getters e Setters das Configurações
    public String getScreenResolution() {
        return screenResolution;
    }

    public void setScreenResolution(String screenResolution) {
        this.screenResolution = screenResolution;
    }

    public String getGraphicsQuality() {
        return graphicsQuality;
    }

    public void setGraphicsQuality(String graphicsQuality) {
        this.graphicsQuality = graphicsQuality;
    }

    public Map<String, String> getKeyMappings() {
        return new HashMap<>(keyMappings);
    }

    public void setKeyMapping(String function, String key) {
        keyMappings.put(function, key);
    }
}
```
