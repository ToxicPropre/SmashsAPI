package fr.toxicpropre.managers;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;

import fr.toxicpropre.API;
import fr.toxicpropre.listeners.PlayerJoin;

public class ListenersManager {

	private API api;
	
	public ListenersManager(API api){
		this.api = api;
	}
	
	public void registerListeners(){
		PluginManager pm = Bukkit.getPluginManager();
		pm.registerEvents(new PlayerJoin(), api);
	}
	
}
