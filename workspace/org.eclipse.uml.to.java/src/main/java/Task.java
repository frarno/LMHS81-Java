/*******************************************************************************
 * 2015, All rights reserved.
 *******************************************************************************/

// Start of user code (user defined imports)

// End of user code

/**
 * Description of Task.
 * 
 * @author user
 */
public class Task {
	/**
	 * Description of the property label.
	 */
	public String label = "";

	/**
	 * Description of the property state.
	 */
	public Boolean state = false;

	// Start of user code (user defined attributes for Task)

	// End of user code

	/**
	 * The constructor.
	 */
	public Task() {
		// Start of user code constructor for Task)
		super();
		// End of user code
	}

	/**
	 * Description of the method toString.
	 * @return 
	 */
	public String toString() {
		// Start of user code for method toString
		String toString = "";
		return toString;
		// End of user code
	}

	/**
	 * Description of the method done.
	 */
	public void done() {
		// Start of user code for method done
		// End of user code
	}

	/**
	 * Description of the method isDone.
	 * @return 
	 */
	public Boolean isDone() {
		// Start of user code for method isDone
		Boolean isDone = Boolean.FALSE;
		return isDone;
		// End of user code
	}

	// Start of user code (user defined methods for Task)

	// End of user code
	/**
	 * Returns label.
	 * @return label 
	 */
	public String getLabel() {
		return this.label;
	}

	/**
	 * Sets a value to attribute label. 
	 * @param newLabel 
	 */
	public void setLabel(String newLabel) {
		this.label = newLabel;
	}

	/**
	 * Returns state.
	 * @return state 
	 */
	public Boolean getState() {
		return this.state;
	}

	/**
	 * Sets a value to attribute state. 
	 * @param newState 
	 */
	public void setState(Boolean newState) {
		this.state = newState;
	}

}
