/**
 * Définition d'une tâche
 * 
 * @author Arnaud Monteilhet : fr.92.arno@gm
 */

// cf http://www.oracle.com/technetwork/articles/java/index-137868.html
// for doc comments usage

public class Task {
	public String label;
	public Boolean state;
	
	 
	/**
	 * Default ctor
	 */
	public Task() { }
	
	/**
	 * Constructeur d'une tâche
	 * 
	 * @param label description de la tâche
	 *
	 */
	public Task(String label)
	{
		this.label = label;
		this.state = false;
	}

	/**
	 * permet de manipuler une instance de cette classe en tant que chaîne de caractères 
	 * 
	 * @return String
	 */
	public String toString()
	{
		return "Tâche '" + this.label + "' => " + this.state;
	}
	
	/**
	 * Passage d'une tâche à l'état fait
	 */
	public void done()
	{
		state = true;
	}
	
	/**
	 * Inidque l'état de la tâche
	 * 
	 * @return état de la tâche :<ul>
	 *  <li>true : fait </li>
	 *  <li>false : à faire </li>
	 *  </ul>
	 */
	public Boolean isDone() {
		return state;
	}
	
	
	public int test(){
		return 5;
	}

/* duplicate method
  	public int test(){
		return -1;
	}
 */
	
	
}
