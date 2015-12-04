package todolist.special_task;
import todolist.Task;

/**
 * Définition d'une tâche simple
 * 
 * @author user
 *
 */
public class SimpleTask extends Task {

	/**
	 * 
	 */
	public SimpleTask() {
		
	}

	/**
	 * Constructeur d'une tâche
	 * 
	 * @param label description de la tâche
	 *
	 */
	public SimpleTask(String label) {
		super(label);
		
	}

	/* (non-Javadoc)
	 * @see Task#toString()
	 */
	/**
	 * Affichage de la tâche sous forme de chaîne de caractères
	 * 
	 *  @return le nom de la tâche suivie de son état
	 */
	@Override
	public String toString() {
		
		String done;
		if (isDone()) {
			done = "(éffectuée)";
		} else {
			done = "(à faire)";
		}
		return "Tâche simple : " + getLabel() + " " + done;
	}

}
