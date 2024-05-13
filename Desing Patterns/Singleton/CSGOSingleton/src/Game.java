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
        
        

        // Configurações podem ser acessadas e modificadas de qualquer parte do jogo
    }
}
