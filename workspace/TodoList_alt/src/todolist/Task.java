package todolist;

/*
 * Les paquets permettent de regrouper les classes tout comme les répertoires permettent de regrouper les fichiers
 * Il suffit d'indiquer package suivi du nom de paquet
 * Par convention l'arborescence des paquets suivra la même arborescence que les répertoires
 */


/**
 * Définition d'une tâche classe abstraite
 * 
 * @author Arnaud Monteilhet : fr.92.arno@gm
 */

// cf http://www.oracle.com/technetwork/articles/java/index-137868.html
// for doc comments usage

/*
 * Une classe abstraite est une classe qui ne peut pas être instanciée. On utilise le mot clé abstract 
 * NB une classe qui comporte au moins une méthode abstraite est obligatoirement une classe abstraite.
 * 
 * 
 */



/**
 * 
 * @author user
 *
 */
public abstract class Task {
	private String label;
	private Boolean state;
	
	protected String getLabel() {
		return label;
	}
	protected Boolean getState() {
		return state;
	}
	protected void setLabel(String label) {
		this.label = label;
	}
	protected void setState(Boolean state) {
		this.state = state;
	}
	
	 
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
		setLabel(label);
		setState(false);
	}

	/**
	 * permet de manipuler une instance de cette classe en tant que chaîne de caractères 
	 * 
	 * @return String
	 */
	public abstract String toString();

	
	/**
	 * Passage d'une tâche à l'état fait
	 */
	public void done()
	{
		setState(true);
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
		return getState();
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
