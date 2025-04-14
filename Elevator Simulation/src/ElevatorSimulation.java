/*
 🧪 Objective:
Simulate an elevator being used by multiple people (threads).
Each person (thread) calls the elevator, waits for it, and enters one at a time.
The elevator has a maximum capacity of 1 person at a time.

📝 Instructions:
Create a class called ElevatorSimulation.

Inside the class:

Define a shared method enterElevator(String personName) which:

Prints: "Person X is entering the elevator..."

Sleeps for 300 ms (to simulate elevator ride)

Prints: "Person X has exited the elevator."

Use synchronized(lock) to allow only one thread inside the elevator at a time.

In the constructor:

Create and start 4 threads representing people: "Alice", "Bob", "Charlie", "Diana"

Each person calls enterElevator(...) once

Use join() on all threads

After all threads are done, print: "All passengers have exited the elevator."
 */

public class ElevatorSimulation {
    private Object lock = new Object();

    public ElevatorSimulation(){
        Thread person1 = new Thread(new Person("Alice"));
        Thread person2 = new Thread(new Person("Bob"));
        Thread person3 = new Thread(new Person("Charlie"));
        Thread person4 = new Thread(new Person("Diana"));

        person1.start();
        person2.start();
        person3.start();
        person4.start();

        try {
            person1.join();
            person2.join();
            person3.join();
            person4.join();
        } catch (InterruptedException e) {
           
            e.printStackTrace();
        }

        System.out.println("All passengers have exited the elevator.");
    }

    public void enterElevator(String personName){
        //Prints: "Person X is entering the elevator..."
        //Sleeps for 300 ms (to simulate elevator ride)
        //Prints: "Person X has exited the elevator."
        //Use synchronized(lock)

        synchronized(lock){
            System.out.println("Person " + personName + " is entering the elevator...");

            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            System.out.println("Person " + personName + " has exited the elevator.");
        }
    }


    class Person implements Runnable{
        private String name;

        public Person(String name){
            this.name = name;
        }

        @Override
        public void run() {
            enterElevator(name);
        }
    }


    public static void main(String[] args) throws Exception {
        new ElevatorSimulation();
    }
}




/*
Alice is entering the elevator...
Alice has exited the elevator.
Bob is entering the elevator...
Bob has exited the elevator.
Charlie is entering the elevator...
Charlie has exited the elevator.
Diana is entering the elevator...
Diana has exited the elevator.
All passengers have exited the elevator.


💡 Key Concepts Reinforced:
Shared resource (elevator)

synchronized block with lock

Thread creation and management

Simulating delay with Thread.sleep
 */