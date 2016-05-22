package fr.toxicpropre;

import org.bukkit.plugin.java.JavaPlugin;

import fr.toxicpropre.managers.CommandsManager;
import fr.toxicpropre.managers.ListenersManager;

public class API extends JavaPlugin{

	private static API instance;
	
	public static API getInstance(){
		return instance;
	}
	
	public void onEnable(){
		instance = this;
		new ListenersManager(this).registerListeners();
		new CommandsManager(this).registerCommands();
	}
	
	public void onDisable(){
	}
	
}
