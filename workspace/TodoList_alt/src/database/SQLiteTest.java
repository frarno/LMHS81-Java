/**
 * 
 */
package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.PreparedStatement;

/**
 * @author user
 *
 */
public class SQLiteTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Connection connection = null;
		
		try {
			// 1 connexion
			connection = DriverManager.getConnection("jdbc:sqlite:sample.db");
			Statement statement = connection.createStatement();
			statement.setQueryTimeout(30);
			// 2.1 Création de la table Tasks
			try {
				statement.executeUpdate("Create table Tasks (" +
						"id integer primary key autoincrement," +
						"label string, state boolean)");
				System.out.println("Création de la table Tasks");
			} catch (SQLException e){
				System.out.println("La table Tasks existait déjà");
			}
			// 2.2 Ajout d'un enregistrement
			try {
				PreparedStatement stmt = connection.prepareStatement(
						"insert into Tasks(label, state) values (?,?)");
				stmt.setString(1,"Test");
				stmt.setInt(2, 0);
				stmt.executeUpdate();
				System.out.println("Ajout d'un enregistrement");
						
				
			} catch (SQLException e){
				System.out.println("Ajout impossible : " + e.getMessage());
			}
			// 2.3 Lecture des enregistrements
			ResultSet rs = statement.executeQuery("select * from Tasks");
			while (rs.next())
			{
				System.out.println("************");
				System.out.println("id = " + rs.getString("id"));
				System.out.println("label = " + rs.getString("label"));
				System.out.println("state = " + rs.getInt("state"));
			}
				
		} catch (Exception e){
			System.out.println("Erreur: " +  e.getMessage());
		} finally {
			// 3 Déconnexion
			try {
				if (connection != null) {
					connection.close();
					System.out.println("Déconnexon de la base de données");
				}
			} catch (SQLException e) {
				System.err.println(e);
			}
			
		}
		

	}

}
