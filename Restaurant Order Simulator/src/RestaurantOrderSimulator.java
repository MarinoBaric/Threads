/*
 🧪 Objective:
Simulate 3 waiters (threads) taking and processing food orders at a restaurant.
All waiters access a shared queue of orders and only one waiter can take an order at a time.

📝 Instructions:
Create a class called RestaurantOrderSimulator.

Inside it:

Create a shared list of 10 predefined food orders (strings like "Burger", "Pizza", etc.).

Use a private Object lock = new Object();

In the constructor:

Create and start 3 threads, each named "Waiter 1", "Waiter 2", "Waiter 3".

Each waiter thread keeps taking orders from the shared list until it's empty.

Use join() to wait for all waiters to finish.

After all orders are taken, print: "All orders have been served!"

In each waiter thread:

Inside a synchronized(lock) block:

If the order list is not empty, remove the first order from the list and print: "Waiter X is serving: [order]"

If the list is empty, exit the loop.

Sleep for 200 ms to simulate processing.
 */

import java.util.ArrayList;
import java.util.List;

public class RestaurantOrderSimulator {
    private List<String> order = new ArrayList<String>();
    private Object lock = new Object();

    public RestaurantOrderSimulator(){

        order.add("Burger");
        order.add("Pizza");
        order.add("Sarma");
        order.add("Sushi");
        order.add("Kebab");
        order.add("Steak");
        order.add("Tacos");
        order.add("Wings");

        Thread w1 = new Thread(new Waiter("1", order));
        Thread w2 = new Thread(new Waiter("2", order));
        Thread w3 = new Thread(new Waiter("3", order));

        w1.start();
        w2.start();
        w3.start();

        try {
            w1.join();
            w2.join();
            w3.join();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("All orders have been served!");
        
    }

    public class Waiter implements Runnable{
        private List<String> order;
        private String name;

        public Waiter(String name, List<String> order){
            this.name = name;
            this.order = order;
        }

        @Override
        public void run() {

            while(true){
                
                
                synchronized(lock){
                    if(!order.isEmpty()){
                        String currentOrder = order.remove(0);
                        System.out.println("Waiter " + name + " is serving " + currentOrder);
                    } else{
                        break;
                    }


                    
                }
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

            }

            
        }


        
    }




    public static void main(String[] args) throws Exception {
        new RestaurantOrderSimulator();
    }
}

/*
Waiter 2 is serving: Burger  
Waiter 1 is serving: Pizza  
Waiter 3 is serving: Salad  
...
All orders have been served!

 */