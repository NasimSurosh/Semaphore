package description1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Application1 {

  public static void main(String[] args) throws InterruptedException {
   
    ExecutorService executor = Executors.newCachedThreadPool();
    
    for(int i = 0; i < 300; i++) {
      executor.submit(new Runnable() {

        @Override
        public void run() {
          Messages.getValue().send();
          
        }
        
      });
    }
    
    executor.shutdown();
    executor.awaitTermination(1, TimeUnit.HOURS);

  }

}
