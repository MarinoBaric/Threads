/*
🧪 Objective:
    Create 3 threads. Each thread should print a simple message like "Hello from Thread X" five times.

📝 Instructions:
    Use Runnable interface to define the thread's behavior.

    Each thread should have a name like "Thread 1", "Thread 2", etc.

    In the run() method, loop 5 times:

    Print the thread name and the loop index.

    Sleep for 1 second (Thread.sleep(1000);).

    Start all three threads from the main method.

🔁 Output will vary on each run due to concurrent execution.
 */

public class FunWithThreads4 {
    public FunWithThreads4(){
        System.out.println("Thread Start");

        Thread t1 = new Thread(new InnerClass("1"));
        Thread t2 = new Thread(new InnerClass("2"));
        Thread t3 = new Thread(new InnerClass("3"));

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


        System.out.println("Thread end");
    }
    public static void main(String[] args) throws Exception {
        new FunWithThreads4();
    }

    class InnerClass implements Runnable{
        private String name = "";

        public InnerClass(String name){
            this.name = name;
        }

        @Override
        public void run() {
            

            for(int i=0; i<5; i++){
                System.out.println("Hello from " + name);

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }

    }

}
