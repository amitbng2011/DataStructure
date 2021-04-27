package src.main.java.random;

/**
 * @Note: Since we are using synchronized, no 2 thread can access that block at same time.
 * As we all know we have different level of cache in OS L1, L2, L3 and 
 * if we write to a variable in one thread it is not guaranteed to be visible to other.
 * 
 * Since its lazy way of creating object so chances are there that once 1st thread comes out, 2nd thread gets the lock
 * and value for Singleton instance created by 1st thread is not visible to 2nd thread.
 * 
 * In that case 2nd thread will also create instance for Singleton
 * 
 * --> Volatile make sure that instance reference is being called from the main memory rather than thread
 *
 */
public class Singleton {

	private static volatile Singleton resource;
	private static final Object LOCK = new Object();
	
	private Singleton() {
		
	}
	
	public static Singleton getInstance() {
		if(resource == null) { 
            synchronized(LOCK) {
                if(resource == null) {
                    resource = new Singleton();
                }
            }
        }
        return resource;
	}
}
