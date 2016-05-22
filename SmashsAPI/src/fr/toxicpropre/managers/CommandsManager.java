package fr.toxicpropre.managers;

import fr.toxicpropre.API;
import fr.toxicpropre.commands.RankCommand;

public class CommandsManager {

	private API api;
	
	public CommandsManager(API api){
		this.api = api;
	}
	
	public void registerCommands(){
		api.getCommand("rank").setExecutor(new RankCommand());
	}
	
}
