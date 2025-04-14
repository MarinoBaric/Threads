/*
 Simulate 4 bank teller threads processing withdrawals from a shared bank account.
Each teller will try to withdraw money safely, and when the account runs out of money, 
the simulation ends.

📝 Instructions:
Create a class called BankTransactionSimulator.

Inside the class, define:

A shared variable int balance = 120;

A private Object lock = new Object();

In the constructor:

Create 4 threads, each named "Teller 1", "Teller 2", etc.

Start them and join() them.

After all threads finish, print the final balance.

Each thread should:

Loop continuously.

Inside a synchronized(lock) block:

Check if balance >= 10. If yes:

Subtract 10 from balance

Print: "Teller X withdrew 10. Balance: YY"

If not:

Exit the loop.

After the synchronized block, sleep for 5 milliseconds (to simulate delay).
 */

public class BankTransactionSimulator {
    private int balance = 120;
    private Object lock = new Object();

    public BankTransactionSimulator(){

        Thread teller1 = new Thread(new InnerBankTransactionSimulator("1"));
        Thread teller2 = new Thread(new InnerBankTransactionSimulator("2"));
        Thread teller3 = new Thread(new InnerBankTransactionSimulator("3"));
        Thread teller4 = new Thread(new InnerBankTransactionSimulator("4"));
        
        teller1.start();
        teller2.start();
        teller3.start();
        teller4.start();

        try {
            teller1.join();
            teller2.join();
            teller3.join();
            teller4.join();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public static void main(String[] args) throws Exception {
        new BankTransactionSimulator();
    }

    public class InnerBankTransactionSimulator implements Runnable{
        private String name = "";

        public InnerBankTransactionSimulator(String name){
            this.name = name;
        }

        @Override
        public void run() {
            for(int i=0; i<10; i++){

                synchronized(lock){
                    if(balance >= 10){
                        balance = balance - 10;
                        System.out.println("Teller " + name + " withdrew 10. Balance: " + balance);
                    } else{
                        break;
                    }
                }

                try {
                    Thread.sleep(5);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

            }
        }


        
    }
}

/*
Teller 1 withdrew 10. Balance: 110  
Teller 3 withdrew 10. Balance: 100  
Teller 2 withdrew 10. Balance: 90  
...
Teller 4 withdrew 10. Balance: 0  
Main: All transactions done. Final balance: 0
 */