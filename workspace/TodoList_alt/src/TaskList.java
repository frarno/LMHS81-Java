/**
 * Définition d'une liste de tâches
 * 
 * @author Arnaud Monteilhet : fr.92.arno@gm
 */

public class TaskList {
	
	public Task[] tasks = new Task[10];
	public int nbTasks = 0;
	/*
	 * <=> to define default ctor and initialize attributes
	 */
	
	/**
	 * Affichage de la liste de tâche sous forme de chaîne de caractères
	 * 
	 *  @return la liste de tâches et leur état
	 */
	public String toString() {
		
		String result = "";
		for (int i = 0; i< nbTasks; i++) {
			result += i + 1 + " / " + nbTasks + ": " + tasks[i] + "\n"; 
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
		if (nbTasks == 10) {
			return false;
		} else {
			tasks[nbTasks++] = newTask;
			return true;
		}
	}

	/**
	 * Ajout d'une tâche
	 * @param label label de la tâche à ajouter
	 * @return <ul>
	 *   <li>true: la tâche a été ajoutée </li>
	 *   <li>false: la tâche n'a pas été ajoutée </li>
	 * </ul>
	 */
	public Boolean addTask(String label) {
		Task newTask = new Task(label);

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
		if ((idTask < 0) || (idTask >= nbTasks)) {
			return false;
		} else {
			tasks[idTask].done();
			return true;
		}
		
	}
}
