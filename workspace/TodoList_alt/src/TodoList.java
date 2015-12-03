/**
 * 
 */

/**
 * Java type de base ou primitif:
 * boolean /def= false
 * byte    /def= 0
 * char    /def= 'u\0000'
 * double  /def= 0.0
 * float   /def= 0.0
 * int     /def= 0 
 * long    /def= 0 
 * short   /def= 0 
 */


/**
 * @author user
 *
 */
public class TodoList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Task t0 = new Task();
		System.out.println(t0);
		
		Task t = new Task("Test");
		
		System.out.println("Tâche '" + t.label + "' => " + t.state);
		// <=> System.out.printf("Tâche ''%s' => %s", t.label, t.state);
		// cf https://docs.oracle.com/javase/tutorial/java/data/numberformat.html

		Task t2 = new Task("2ème tâche de test");
		System.out.printf("Tâche ''%s' => %s \n", t2.label, t2.state);
		
		t2.done();
		System.out.println(t2);
		if (t2.isDone()) {
			System.out.println("Tâche éffectuée !");
		} else {
			System.out.println("Tâche à faire !");
		}
		System.out.println("------------------------------------------------------");
		TaskList list = new TaskList();
		list.addTask("Test");
		list.addTask("Test 2");
		list.taskDone(0);

		
		System.out.println(list);
		
		// System.out.printf("test %d",t.test());
	}

}
