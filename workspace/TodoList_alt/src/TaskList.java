/**
 * Définition d'une liste de tâches
 * 
 * @author Arnaud Monteilhet : fr.92.arno@gm
 */

import java.util.ArrayList;

public class TaskList {
	
	private ArrayList<Task> tasks = new ArrayList<Task>();
	/*
	 * <=> to define default ctor and initialize attributes
	 */
	
	/**
	 * Affichage de la liste de tâche sous forme de chaîne de caractères
	 * 
	 *  @return la liste de tâches et leur état
	 */
	public String toString() {
		
		int len = tasks.size();
		String result = "";
		for (int i = 0; i< len; i++) {
			result += i + 1 + " / " + len + ": " + tasks.get(i) + "\n"; 
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
	public Boolean taskDone(int idTask) {
		// index out of bounds
		if ((idTask < 0) || (idTask >= tasks.size())) {
			return false;
		} else {
			tasks.get(idTask).done();
			return true;
		}
		
	}
}
