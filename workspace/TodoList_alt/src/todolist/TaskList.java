package todolist;
/**
 * Définition d'une liste de tâches
 * 
 * @author Arnaud Monteilhet : fr.92.arno@gm
 */

import java.util.ArrayList;
import java.util.Iterator;

import todolist.special_task.RDV;
import todolist.special_task.SimpleTask;
import todolist.MonException;

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
