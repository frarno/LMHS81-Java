/**
 * Définition d'une tâche de type rendez-vous
 * 
 * @author user
 *
 */

/*
 * Pour utiliser les classes externes on fait appel à la directive import suivi du nom de la classe
 * Dans le cas de classes appartenant à la bibliothèque standard : java. suivi du nom du sous-paquetage suivi du nom de la classe
 * 
 */

import java.util.GregorianCalendar;
import java.util.TimeZone;
import java.util.Calendar;


public class RDV extends Task {

	protected GregorianCalendar date;
	
	/**
	 * 
	 */
	public RDV() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param label
	 */
	public RDV(String label, int day, int month, int year, int hour, int minutes) {
		super(label);
		date = new GregorianCalendar(TimeZone.getTimeZone("Europe/Paris"));
		date.set(year, month, day, hour, minutes, 0);
		
	}

	/* (non-Javadoc)
	 * @see Task#toString()
	 */

	/**
	 * Affichage d'un rendez vous sous forme de chaîne de caractères
	 * 
	 *  @return le nom du RDV suivie de la date, de l'heure et de son état
	 */
	@Override
	public String toString() {
		
		String done;
		if (isDone()) {
			done = "(éffectuée)";
		} else {
			done = "(à faire)";
		}
		return "Rendez-vous \"" + getLabel() + "\" le " + 
		date.get(Calendar.DAY_OF_MONTH) + "/" +
		date.get(Calendar.MONTH) + "/" + date.get(Calendar.YEAR) + 
		" à " + date.get(Calendar.HOUR) + ":" + date.get(Calendar.MINUTE) + " " + done;
		
	}

	/**
	 * Vérifie si un rendez-vous est dépassé ou non
	 * @return <ul>
	 *   <li>true: rendez-vous dépassé</li>
	 *   <li>false: rendez-vous toujours valide</li>
	 * </ul>
	 */
	public Boolean isLate() {
		GregorianCalendar now = new GregorianCalendar(TimeZone.getTimeZone("Europe/Paris"));
		// NB compareTo return -1 if param is later than date, 0 if equals, 1 if sooner
		if (date.compareTo(now) == -1) {
			return true;
		} else {
			return false;
		}
		
	}
	
	
}
