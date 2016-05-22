package fr.toxicpropre.functions;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.bukkit.entity.Player;

import fr.toxicpropre.rank.Rank;

public class RankFunc {

private Player player;
	
	public static String url = "jdbc:mysql://localhost/smashs";
	public static String user = "root";
	public static String db_password = "";
	public static String table = "players";
	public static Connection connection = null;
	public static Statement statement = null;
	public static ResultSet result = null;

	public RankFunc(Player player){
		this.player = player;
	}
	
	public void setRank(int rank){
		try{
			try{
				Class.forName("com.mysql.jdbc.Driver");
			}
      	catch (ClassNotFoundException localClassNotFoundException) {}
      	connection = DriverManager.getConnection(url, user, db_password);
      	statement = connection.createStatement();
      	statement.executeUpdate("UPDATE INTO "+table+" rank='"+rank+"' WHERE uuid='"+player.getUniqueId().toString()+"'");
      	result.close();
      	statement.close();
      	connection.close();
    	}
    	catch (Exception localException) {}
	}
	
	public Rank getRank(){
		Rank rank = null;
		try{
	      try{
	        Class.forName("com.mysql.jdbc.Driver");
	      }
	      catch (ClassNotFoundException localClassNotFoundException) {}
	      connection = DriverManager.getConnection(url, user, db_password);
	      statement = connection.createStatement();
	      result = statement.executeQuery("SELECT * FROM "+table+" WHERE uuid='"+player.getUniqueId().toString()+"'");
	      if (result.next()) {
	        rank = Rank.getFromLevel(result.getInt("rank"));
	      }
	      result.close();
	      statement.close();
	      connection.close();
	    }catch (Exception localException) {}
		return rank;
	}
	
	public boolean hasPermission(String permission){
		try{
	      try{
	        Class.forName("com.mysql.jdbc.Driver");
	      }catch (ClassNotFoundException localClassNotFoundException) {}
	      connection = DriverManager.getConnection(url, user, db_password);
	      statement = connection.createStatement();
	      result = statement.executeQuery("SELECT permissions FROM "+table+" WHERE uuid='"+player.getUniqueId().toString()+"'");
	      if (result.getString("permissions").contains(permission)) {
	        return true;
	      }
	      result.close();
	      statement.close();
	      connection.close();
	    }catch (Exception localException) {}
		return false;
	}
	
	public void addPermission(String permission){
		try{
			try{
				Class.forName("com.mysql.jdbc.Driver");
			}
      	catch (ClassNotFoundException localClassNotFoundException) {}
      	connection = DriverManager.getConnection(url, user, db_password);
      	statement = connection.createStatement();
      	statement.executeUpdate("UPDATE INTO "+table+" permissions='"+permission+"' WHERE uuid='"+player.getUniqueId().toString()+"'");
      	result.close();
      	statement.close();
      	connection.close();
    	}
    	catch (Exception localException) {}
	}
	
	public void removePermission(String permission){
		try{
			try{
				Class.forName("com.mysql.jdbc.Driver");
			}
      	catch (ClassNotFoundException localClassNotFoundException) {}
      	connection = DriverManager.getConnection(url, user, db_password);
      	statement = connection.createStatement();
      	statement.executeUpdate("REMOVE INTO "+table+" permissions='"+permission+"' WHERE uuid='"+player.getUniqueId().toString()+"'");
      	result.close();
      	statement.close();
      	connection.close();
    	}
    	catch (Exception localException) {}
	}
	
}
