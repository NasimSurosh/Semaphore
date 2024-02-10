package description;

import java.util.concurrent.Semaphore;

public class Application {

  public static void main(String[] args) {
    
    Semaphore semaphore = new Semaphore(4);
    
    
    
    semaphore.release();         // to increment by one     it has the similar impact as the unlock() from reentrantLock
    
    try {
      
      semaphore.acquire();        // to decrement by one   it has the similar impact as the lock() from reentrantLock
    } catch (InterruptedException e) {
      
      e.printStackTrace();
    }
    System.out.println("Number of permits: " + semaphore.availablePermits());
    

  }

}
