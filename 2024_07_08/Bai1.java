import java.util.concurrent.locks.*;

/**
 * Bai1
 */
public class Bai1 {
    static Lock myLock = new ReentrantLock(true);

    public static void main(String[] args) {
        
        Runnable odd = () -> {   
            for(int i = 1; i <= 20; i++) {
                if (i % 2 == 1) {
                    myLock.lock();
                    try {    
                        System.out.println("Odd number from oddThread: " + i);
                    } 
                    catch (Exception e) {
                        System.err.println(e.getMessage());
                    }
                    finally {
                        myLock.unlock();
                    }   
                }
            }
        };

        Runnable even = () -> {       
            for(int i = 1; i <= 20; i++) {
                if (i % 2 == 0) {
                    myLock.lock();
                    try {
                        System.out.println("Even number from evenThread: " + i);
                    } 
                    catch (Exception e) {
                        System.err.println(e.getMessage());
                    }
                    finally {
                        myLock.unlock();
                    }     
                }
            }
            
        };

        Thread threadOdd = new Thread(odd);
        Thread threadEven = new Thread(even);

        threadOdd.start();
        threadEven.start();

    }
}