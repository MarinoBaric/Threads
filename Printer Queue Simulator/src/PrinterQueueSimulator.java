/*
 🧪 Objective:
Simulate a printer queue where 3 users (threads) send print jobs to a shared printer.
The printer can only print one job at a time, and each user sends 5 print jobs.

📝 Instructions:
Create a class named PrinterQueueSimulator.

Define:

A shared method print(String userName, int jobId) that simulates printing by sleeping for 500 ms.

A private Object lock = new Object();

In the constructor:

Create and start 3 threads, each representing a user: "User A", "User B", "User C".

Each user (thread) should loop 5 times and try to print:

Call print() with its user name and current job ID.

Use join() on all threads.

After all jobs are printed, print: "All print jobs completed."
 */

public class PrinterQueueSimulator {
    private Object lock = new Object();

    public PrinterQueueSimulator(){
        Thread userA = new Thread(new User("User A"));
        Thread userB = new Thread(new User("User B"));
        Thread userC = new Thread(new User("User C"));

        userA.start();
        userB.start();
        userC.start();

        try {
            userA.join();
            userB.join();
            userC.join();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        System.out.println("All print jobs completed.");
    }

    public void print(String userName, int jobId){
        synchronized(lock){
            System.out.println(userName + " is printing job " + jobId + "...");

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            System.out.println(userName + " finished printing job " + jobId);
        }
    }
    public static void main(String[] args) throws Exception {
        new PrinterQueueSimulator();
    }

    public class User implements Runnable {
        private String name = "";

        public User(String name){
            this.name = name;
        }

        @Override
        public void run() {
            for(int i=0; i<5; i++){
                print(name, i);
            }
        }
        
    }
}


/*
User A is printing job 1...
User A finished printing job 1.
User C is printing job 1...
User C finished printing job 1.
User B is printing job 1...
...
All print jobs completed.

💡 Tips:
In print(), use synchronized(lock) so that only one thread can access the printer at a time.

Sleep inside print() to simulate printing.

Use a loop in each thread to simulate 5 jobs.
 */