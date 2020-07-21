package concurrency;

class Reasoning extends Thread {
    //set up this class so it can become a valid thread. 
    void distinguish() {
        //print to the console the difference between a thread and a process
        //print out you think will happen if you invoke the run() method of a thread as opposed to the start() method of a thread.

        System.out.println("Threads have shared memory and run in a shared memory space, whereas processes run in separate memory spaces.");
        System.out.println("If you call run(), the code inside the body of the run method will be executed on the current thread. If you call start(), a new thread will be created and the run method will be executed in the new thread.");
    }

    @Override
    public void run() {
        this.distinguish();
    }
}

