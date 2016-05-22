package fr.toxicpropre.utils;

import net.minecraft.server.v1_9_R2.IChatBaseComponent;
import net.minecraft.server.v1_9_R2.IChatBaseComponent.ChatSerializer;
import net.minecraft.server.v1_9_R2.PacketPlayOutTitle;
import net.minecraft.server.v1_9_R2.PacketPlayOutTitle.EnumTitleAction;

import org.bukkit.craftbukkit.v1_9_R2.entity.CraftPlayer;
import org.bukkit.entity.Player;



public class Title {

	private Player player;
	private String title, subTitle;
	
	public Title(Player player, String title, String subTitle){
		this.player = player;
		this.title = title;
		this.subTitle = subTitle;
	}
	
	public void send(){
		IChatBaseComponent chat = ChatSerializer.a("{\"text\": \""+this.title+"\"}");
		PacketPlayOutTitle packet = new PacketPlayOutTitle(EnumTitleAction.TITLE, chat);
		
		IChatBaseComponent chat2 = ChatSerializer.a("{\"text\": \""+this.subTitle+"\"}");
		PacketPlayOutTitle packet2 = new PacketPlayOutTitle(EnumTitleAction.SUBTITLE, chat2);
		
		((CraftPlayer) player).getHandle().playerConnection.sendPacket(packet);
		((CraftPlayer) player).getHandle().playerConnection.sendPacket(packet2);
	}
	
}
