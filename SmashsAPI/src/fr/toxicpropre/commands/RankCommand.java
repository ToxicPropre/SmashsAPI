package fr.toxicpropre.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.toxicpropre.functions.RankFunc;
import fr.toxicpropre.rank.Rank;
import fr.toxicpropre.utils.Chat;

public class RankCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label,
			String[] args) {
		
		if(sender instanceof Player){
			Player player = (Player)sender;
			
			if(new RankFunc(player).getRank() == Rank.ADMINISTRATEUR || new RankFunc(player).hasPermission("rank.use")){
				if(args.length == 2){
					Player target = Bukkit.getPlayerExact(args[0]);
					
					if(target == null){
						player.sendMessage(new Chat().getPrefix()+"§cCe joueur n'est pas connecté !");
					}else{
						if(args[1].equalsIgnoreCase("joueur")){
							if(new RankFunc(target).getRank() == Rank.JOUEUR){
								player.sendMessage(new Chat().getPrefix()+"§cCe joueur possède déjà ce grade !");
							}else{
								new RankFunc(target).setRank(Rank.JOUEUR.getLevel());
								player.sendMessage(new Chat().getPrefix()+"Vous venez de promouvoir §a"+args[0]+" §fau grade §a"+args[1]+" §f!");
								target.sendMessage(new Chat().getPrefix()+"Vous venez d'être promu au grade de §a"+args[1]+" §f! \n §7Reconnectez-vous pour voir les modifications !");
							}
						}else if(args[1].equalsIgnoreCase("vip")){
							if(new RankFunc(target).getRank() == Rank.VIP){
								player.sendMessage(new Chat().getPrefix()+"§cCe joueur possède déjà ce grade !");
							}else{
								new RankFunc(target).setRank(Rank.VIP.getLevel());
								player.sendMessage(new Chat().getPrefix()+"Vous venez de promouvoir §a"+args[0]+" §fau grade §a"+args[1]+" §f!");
								target.sendMessage(new Chat().getPrefix()+"Vous venez d'être promu au grade de §a"+args[1]+" §f! \n §7Reconnectez-vous pour voir les modifications !");
							}
						}else if(args[1].equalsIgnoreCase("vip+")){
							if(new RankFunc(target).getRank() == Rank.VIPPLUS){
								player.sendMessage(new Chat().getPrefix()+"§cCe joueur possède déjà ce grade !");
							}else{
								new RankFunc(target).setRank(Rank.VIPPLUS.getLevel());
								player.sendMessage(new Chat().getPrefix()+"Vous venez de promouvoir §a"+args[0]+" §fau grade §a"+args[1]+" §f!");
								target.sendMessage(new Chat().getPrefix()+"Vous venez d'être promu au grade de §a"+args[1]+" §f! \n §7Reconnectez-vous pour voir les modifications !");
							}
						}else if(args[1].equalsIgnoreCase("guide")){
							if(new RankFunc(target).getRank() == Rank.GUIDE){
								player.sendMessage(new Chat().getPrefix()+"§cCe joueur possède déjà ce grade !");
							}else{
								new RankFunc(target).setRank(Rank.GUIDE.getLevel());
								player.sendMessage(new Chat().getPrefix()+"Vous venez de promouvoir §a"+args[0]+" §fau grade §a"+args[1]+" §f!");
								target.sendMessage(new Chat().getPrefix()+"Vous venez d'être promu au grade de §a"+args[1]+" §f! \n §7Reconnectez-vous pour voir les modifications !");
							}
						}else if(args[1].equalsIgnoreCase("developpeur")){
							if(new RankFunc(target).getRank() == Rank.DEVELOPPEUR){
								player.sendMessage(new Chat().getPrefix()+"§cCe joueur possède déjà ce grade !");
							}else{
								new RankFunc(target).setRank(Rank.DEVELOPPEUR.getLevel());
								player.sendMessage(new Chat().getPrefix()+"Vous venez de promouvoir §a"+args[0]+" §fau grade §a"+args[1]+" §f!");
								target.sendMessage(new Chat().getPrefix()+"Vous venez d'être promu au grade de §a"+args[1]+" §f! \n §7Reconnectez-vous pour voir les modifications !");
							}
						}else if(args[1].equalsIgnoreCase("builder")){
							if(new RankFunc(target).getRank() == Rank.BUILDER){
								player.sendMessage(new Chat().getPrefix()+"§cCe joueur possède déjà ce grade !");
							}else{
								new RankFunc(target).setRank(Rank.BUILDER.getLevel());
								player.sendMessage(new Chat().getPrefix()+"Vous venez de promouvoir §a"+args[0]+" §fau grade §a"+args[1]+" §f!");
								target.sendMessage(new Chat().getPrefix()+"Vous venez d'être promu au grade de §a"+args[1]+" §f! \n §7Reconnectez-vous pour voir les modifications !");
							}
						}else if(args[1].equalsIgnoreCase("moderateur")){
							if(new RankFunc(target).getRank() == Rank.MODERATEUR){
								player.sendMessage(new Chat().getPrefix()+"§cCe joueur possède déjà ce grade !");
							}else{
								new RankFunc(target).setRank(Rank.MODERATEUR.getLevel());
								player.sendMessage(new Chat().getPrefix()+"Vous venez de promouvoir §a"+args[0]+" §fau grade §a"+args[1]+" §f!");
								target.sendMessage(new Chat().getPrefix()+"Vous venez d'être promu au grade de §a"+args[1]+" §f! \n §7Reconnectez-vous pour voir les modifications !");
							}
						}else if(args[1].equalsIgnoreCase("administrateur")){
							if(new RankFunc(target).getRank() == Rank.ADMINISTRATEUR){
								player.sendMessage(new Chat().getPrefix()+"§cCe joueur possède déjà ce grade !");
							}else{
								new RankFunc(target).setRank(Rank.ADMINISTRATEUR.getLevel());
								player.sendMessage(new Chat().getPrefix()+"Vous venez de promouvoir §a"+args[0]+" §fau grade §a"+args[1]+" §f!");
								target.sendMessage(new Chat().getPrefix()+"Vous venez d'être promu au grade de §a"+args[1]+" §f! \n §7Reconnectez-vous pour voir les modifications !");
							}
						}else{
							player.sendMessage(new Chat().getPrefix()+"Faite /rank <joueur> <rank> ! ");
						}
					}
				}else{
					player.sendMessage(new Chat().getPrefix()+"Faite /rank <joueur> <rank> ! \n"+new Chat().getPrefix()+"§6Liste des grades : §eJoueur, VIP, VIP+, Guide, Développeur, Builder, Moderateur, Administrateur");
				}
			}else{
				player.sendMessage(new Chat().getPrefix()+"§cVous devez être Administrateur pour éffectuer cette commande !");
			}
		}else{
			Player target = Bukkit.getPlayerExact(args[0]);

			if(target != null){
				if(args[1].equalsIgnoreCase("joueur")){
					if(new RankFunc(target).getRank() != Rank.JOUEUR){
						new RankFunc(target).setRank(Rank.JOUEUR.getLevel());
						target.sendMessage(new Chat().getPrefix()+"Vous venez d'être promu au grade de §a"+args[1]+" §f! \n §7Reconnectez-vous pour voir les modifications !");
					}
				}else if(args[1].equalsIgnoreCase("vip")){
					if(new RankFunc(target).getRank() != Rank.VIP){
						new RankFunc(target).setRank(Rank.VIP.getLevel());
						target.sendMessage(new Chat().getPrefix()+"Vous venez d'être promu au grade de §a"+args[1]+" §f! \n §7Reconnectez-vous pour voir les modifications !");
					}
				}else if(args[1].equalsIgnoreCase("vip+")){
					if(new RankFunc(target).getRank() != Rank.VIPPLUS){
						new RankFunc(target).setRank(Rank.VIPPLUS.getLevel());
						target.sendMessage(new Chat().getPrefix()+"Vous venez d'être promu au grade de §a"+args[1]+" §f! \n §7Reconnectez-vous pour voir les modifications !");
					}
				}else if(args[1].equalsIgnoreCase("guide")){
					if(new RankFunc(target).getRank() != Rank.GUIDE){
						new RankFunc(target).setRank(Rank.GUIDE.getLevel());
						target.sendMessage(new Chat().getPrefix()+"Vous venez d'être promu au grade de §a"+args[1]+" §f! \n §7Reconnectez-vous pour voir les modifications !");
					}
				}else if(args[1].equalsIgnoreCase("developpeur")){
					if(new RankFunc(target).getRank() != Rank.DEVELOPPEUR){
						new RankFunc(target).setRank(Rank.DEVELOPPEUR.getLevel());
						target.sendMessage(new Chat().getPrefix()+"Vous venez d'être promu au grade de §a"+args[1]+" §f! \n §7Reconnectez-vous pour voir les modifications !");
					}
				}else if(args[1].equalsIgnoreCase("builder")){
					if(new RankFunc(target).getRank() != Rank.BUILDER){
						new RankFunc(target).setRank(Rank.BUILDER.getLevel());
						target.sendMessage(new Chat().getPrefix()+"Vous venez d'être promu au grade de §a"+args[1]+" §f! \n §7Reconnectez-vous pour voir les modifications !");
					}
				}else if(args[1].equalsIgnoreCase("moderateur")){
					if(new RankFunc(target).getRank() != Rank.MODERATEUR){
						new RankFunc(target).setRank(Rank.MODERATEUR.getLevel());
						target.sendMessage(new Chat().getPrefix()+"Vous venez d'être promu au grade de §a"+args[1]+" §f! \n §7Reconnectez-vous pour voir les modifications !");
					}
				}else if(args[1].equalsIgnoreCase("administrateur")){
					if(new RankFunc(target).getRank() != Rank.ADMINISTRATEUR){
						new RankFunc(target).setRank(Rank.ADMINISTRATEUR.getLevel());
						target.sendMessage(new Chat().getPrefix()+"Vous venez d'être promu au grade de §a"+args[1]+" §f! \n §7Reconnectez-vous pour voir les modifications !");
					}
				}
			}
		}
		
		return false;
	}

}
