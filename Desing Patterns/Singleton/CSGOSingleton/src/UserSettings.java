


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
