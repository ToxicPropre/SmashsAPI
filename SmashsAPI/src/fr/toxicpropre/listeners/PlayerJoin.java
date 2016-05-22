package fr.toxicpropre.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import fr.toxicpropre.functions.Accounts;

public class PlayerJoin implements Listener {

	@EventHandler
	public void onJoin(PlayerJoinEvent event){
		Player player = event.getPlayer();
		
		Accounts accounts = new Accounts(player);
		accounts.createAccount();
		accounts.change();
	}
	
}
