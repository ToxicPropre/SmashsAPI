package fr.toxicpropre.rank;

import java.util.HashMap;

public enum Rank {

	JOUEUR(10, "§7Joueur", "§7[Joueur]", "§7"),
	VIP(20, "§bVIP", "§b[VIP]", "§b"),
	VIPPLUS(30, "§eVIP+", "§e[VIP+]", "§e"),
	GUIDE(60, "§3Guide", "§3[Guide]", "§3"),
	DEVELOPPEUR(70, "§2Développeur", "§3[Développeur]", "§3"),
	BUILDER(80, "§aBuilder", "§a[builder]", "§a"),
	MODERATEUR(90, "§6Modérateur", "§6[Modérateur]", "§6"),
	ADMINISTRATEUR(100, "§cAdministrateur", "§c[Administrateur]", "§c");
	
	private int level;
	private String name, prefix, color;
	
	Rank(int level, String name, String prefix, String color){
		this.level = level;
		this.name = name;
		this.prefix = prefix;
		this.color = color;
	}
	
	private static HashMap<Integer, Rank> ID = new HashMap<Integer, Rank>();
	
	static{
		for(Rank rank : values()){
			ID.put(rank.level, rank);
		}
	}
	
	public static Rank getFromLevel(int level){
		return ID.get(level);
	}
	
	public Integer getLevel(){
		return level;
	}
	
	public String getName(){
		return name;
	}
	
	public String getPrefix(){
		return prefix;
	}
	
	public String getColor(){
		return color;
	}
	
}
