package description1;

import java.util.concurrent.Semaphore;

public class Messages {
  
  private int messages =0;
  
  private static Messages value = new Messages();
  private Semaphore semaphore = new Semaphore(20);
    
  private Messages(){
    
  }
  
  public static Messages getValue() {
    return value;
  }
  
  public void send() {
    
    try {
      semaphore.acquire();
    } catch (InterruptedException e) {
      
      e.printStackTrace();
    }
    
    try {
      
      sendMsg();
      
    }finally {
      semaphore.release();
    }
  }
  
  public void sendMsg() {
    
    
    synchronized (this) {
      messages++;
      System.out.println("Current messages: " + messages);
      
    }
    
    try {
      Thread.sleep(3000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    
    synchronized(this) {
      messages--;
    }
    
  }

}
