/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

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
