/*
    Create a class that implements Runnable.

    Each thread should have a name like "Number Thread 1", "Number Thread 2", etc.

    In the run() method:

    Loop 5 times.

    Generate a random number between 1 and 100.

    Print: "Number Thread X: 37" (replace 37 with actual random number).

    Add a small delay: Thread.sleep(700);

    In the main method:

    Create and start 3 threads.

    Use join() to wait for them to finish.

    After all threads finish, print: "All threads have finished announcing numbers."

    🔁 Output will vary each time, since random numbers are used and threads interleave.
💡  Use java.util.Random or Math.random() to generate random numbers.
 */

import java.util.Random;

public class FunWithThreads5 {
    

    public FunWithThreads5(){

        Thread t1 = new Thread(new RandomThread("1"));
        Thread t2 = new Thread(new RandomThread("2"));
        Thread t3 = new Thread(new RandomThread("3"));

        t1.start();
        t2.start();
        t3.start();

        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        System.out.println("All threads have finished announcing numbers.");
    }

    public static void main(String[] args) throws Exception {
        new FunWithThreads5();
    }

    class RandomThread implements Runnable{
        private String name = "";

        public RandomThread(String name){
            this.name = name;
        }

        @Override
        public void run() {

            Random rand = new Random();
            
            
            for(int i=0; i<5; i++){
                int randd = rand.nextInt(100) + 1;
                System.out.println("Thread " + name +":" + " " + randd);

                try {
                    Thread.sleep(700);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                
            }
        }


    }
}
