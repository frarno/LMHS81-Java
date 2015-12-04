package todolist;
/**
 * Définition d'une liste de tâches
 * 
 * @author Arnaud Monteilhet : fr.92.arno@gm
 */

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.PreparedStatement;

import todolist.special_task.RDV;
import todolist.special_task.SimpleTask;
import todolist.MonException;

public class TaskList {
	
	private ArrayList<Task> tasks = new ArrayList<Task>();
	private String base = null;
	private Connection connection = null;
	/*
	 * <=> to define default ctor and initialize attributes
	 */
	
	public TaskList() {}
	
	/**
	 * Constructeur  de TassList
	 * @param base Nom de la base de données
	 */
	public TaskList(String base) {
		this.base = base;
		try {
			// 1 connexion
			connection = DriverManager.getConnection("jdbc:sqlite:" + this.base);
			Statement statement = connection.createStatement();
			statement.setQueryTimeout(30);
			// 2.1 Création de la table Tasks
			try {
				statement.executeUpdate("Create table Tasks (" +
						"id integer primary key autoincrement," +
						"label string, state boolean," + 
						"day integer default 0 , month integer default 0," +
						"year integer default 0 ,hour integer default 0," +
						"minute integer default 0)");
				System.out.println("Création de la table Tasks");
			} catch (SQLException e){
				System.out.println("La table Tasks existait déjà");
			}
			// 2.2 Lecture des enregistrements
			ResultSet rs = statement.executeQuery("select * from Tasks");
			while (rs.next())
			{
				if (rs.getInt("year") == 0) {
					SimpleTask t = new SimpleTask(rs.getString("label"));
					tasks.add(t);
				}
				else
				{
					RDV rdv = new RDV(rs.getString("label"), rs.getInt("day"), rs.getInt("month"),
							rs.getInt("year"), rs.getInt("hour"), rs.getInt("minute"));
						tasks.add(rdv);
				}
			}
				
		} catch (Exception e){
			System.out.println("Erreur: " +  e.getMessage());
		} 
	}

	/**
	 * Méthode exécutée à la destruction de l'objet
	 */
	public void finalize() {
		
		// Déconnnexion
		try {
			if (connection != null) {
				connection.close();
				System.out.println("Déconnexon de la base de données");
			}
		} catch (SQLException e) {
			System.err.println(e);
		}
	}
	


	
	/**
	 * Affichage de la liste de tâche sous forme de chaîne de caractères
	 * 
	 *  @return la liste de tâches et leur état
	 */
	public String toString() {

		int len = tasks.size();
		String result = "";
/*		
		// classical for loop
		for (int i = 0; i< len; i++) {
			result += i + 1 + " / " + len + ": " + tasks.get(i) + "\n"; 
		}
*/
/*		
		// using for each style
		int i = 0;
		for (Task t : tasks) {
			result += i++ + 1 + " / " + len + ": " + t + "\n";
		}
*/
		// using an iterator
		int i = 0;
		Iterator<Task> iterator = tasks.iterator();
		while (iterator.hasNext()) {
			result += i++ + 1 + "/" + len + ": " + iterator.next() + "\n"; 
		}
		
		return result;
		
	}
	
	/**
	 * Ajout d'une tâche
	 * @param newTask Tâche à ajouter
	 * @return <ul>
	 *   <li>true: la tâche a été ajoutée </li>
	 *   <li>false: la tâche n'a pas été ajoutée </li>
	 * </ul>
	 */
	public Boolean addTask(Task newTask) {

		if (base != null) {
			PreparedStatement stmt = null;
			// 2.2 Ajout d'un enregistrement
			try {
				if (newTask instanceof SimpleTask) {
					stmt = connection.prepareStatement(
							"insert into Tasks(label, state) values (?,?)");
					stmt.setString(1,"Test");
					stmt.setInt(2, 0);
					
				}else {
					stmt = connection.prepareStatement(
							"insert into Tasks(label, state, day, month, year, hour, minute) values (?,?,?,?,?,?,?)");
					stmt.setString(1,newTask.getLabel());
					stmt.setInt(2, 0);
					stmt.setInt(3, ((RDV)newTask).getDate().get(Calendar.DAY_OF_MONTH));
					stmt.setInt(4, ((RDV)newTask).getDate().get(Calendar.MONTH));
					stmt.setInt(5, ((RDV)newTask).getDate().get(Calendar.YEAR));
					stmt.setInt(6, ((RDV)newTask).getDate().get(Calendar.HOUR));
					stmt.setInt(7, ((RDV)newTask).getDate().get(Calendar.MINUTE));
			
				}
				
				stmt.executeUpdate();
				System.out.println("Ajout d'un enregistrement");

				
			} catch (SQLException e){
				System.out.println("Ajout impossible : " + e.getMessage());
			}
		}

		
		return tasks.add(newTask);
	}

	/**
	 * Ajout d'une tâche simple
	 * @param label label de la tâche à ajouter
	 * @return <ul>
	 *   <li>true: la tâche a été ajoutée </li>
	 *   <li>false: la tâche n'a pas été ajoutée </li>
	 * </ul>
	 */
	public Boolean addTask(String label) {
		Task newTask = new SimpleTask(label);

		return addTask(newTask);
	}

	/**
	 * Ajout d'un rendez-vous
	 * @param label label du rendez-vous
	 * @return <ul>
	 *   <li>true: le rendez-vous a été ajoutée </li>
	 *   <li>false: le rendez-vous n'a pas été ajoutée </li>
	 * </ul>
	 */

	public Boolean addTask(String label , int day, int month, int year, int hour, int minutes) {
		Task newTask = new RDV(label, day, month, year, hour, minutes );

		return addTask(newTask);
	}

	
	
	/**
	 * Passage d'une taĉhe de la liste à l'état "fait" 
	 * @param idTask Index de la tâche dans la liste
	 * @return <ul>
	 *   <li>true: la tâche a été noté comme effectuée </li>
	 *   <li>false: l'état n'a pas pu être modifié </li>
	 * </ul>
	 */
	
	// https://docs.oracle.com/javase/8/docs/api/java/lang/Exception.html
	public Boolean taskDone(int idTask) throws MonException {
		// index out of bounds
		if ((idTask < 0) || (idTask >= tasks.size())) {
			throw new MonException(1, "Index hors limites");
		} else {
			if (tasks.get(idTask).isDone()) {
				return false;
			} else {
				tasks.get(idTask).done();
				return true;
			}
		}
		
	}
}
