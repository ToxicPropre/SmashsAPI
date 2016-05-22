package fr.toxicpropre.functions;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.bukkit.entity.Player;

public class Accounts {

	 public static String url = "jdbc:mysql://localhost/smashs";
	 public static String user = "root";
	 public static String db_password = "";
	 public static String table = "players";
	 public static Connection connection = null;
	 public static Statement statement = null;
	 public static ResultSet result = null;
	
	private Player player;
	
	public Accounts(Player player){
		this.player = player;
	}
	
	public boolean hasAccount(){
		boolean isRegistered = false;
	    try
	    {
	      try
	      {
	        Class.forName("com.mysql.jdbc.Driver");
	      }
	      catch (ClassNotFoundException localClassNotFoundException) {}
	      connection = DriverManager.getConnection(url, user, db_password);
	      statement = connection.createStatement();
	      result = statement.executeQuery("SELECT * FROM "+table+" WHERE uuid='"+player.getUniqueId().toString()+"'");
	      if (result.next()) {
	        isRegistered = true;
	      }
	      result.close();
	      statement.close();
	      connection.close();
	    }catch (Exception localException) {}
	    return isRegistered;
	}
	
	public void createAccount(){
		if(!hasAccount()){
			try{
				try{
					Class.forName("com.mysql.jdbc.Driver");
				}
	      	catch (ClassNotFoundException localClassNotFoundException) {}
	      	connection = DriverManager.getConnection(url, user, db_password);
	      	statement = connection.createStatement();
	      	statement.executeUpdate("INSERT INTO " + table + " (name, uuid, ip, rank, coins) VALUES ('"+player.getName()+"', '"+player.getUniqueId().toString()+"', '"+player.getAddress().getAddress()+"', '10', '100')");
	      	result.close();
	      	statement.close();
	      	connection.close();
	    	}catch (Exception localException) {}
		}
	}
	
	public void change(){
		try
	    {
	      try
	      {
	        Class.forName("com.mysql.jdbc.Driver");
	      }
	      catch (ClassNotFoundException localClassNotFoundException) {}
	      connection = DriverManager.getConnection(url, user, db_password);
	      statement = connection.createStatement();
	      statement.executeUpdate("UPDATE INTO "+table+" (name, uuid, ip) VALUES ('"+player.getName()+"', '"+player.getUniqueId().toString()+"', '"+player.getAddress().getHostName()+"'");
	      result.close();
	      statement.close();
	      connection.close();
	    }catch (Exception localException) {}
	}
	
}
