package concurrency;

public class Main {
   
    public static void main(String[] args) {
         //run all of your threads from this main class.
        Reasoning reasoning = new Reasoning();
        reasoning.start();

        TeamTC1 teamTC1 = new TeamTC1();
        Thread teamV8 = new Thread(teamTC1);
        teamV8.setName("Team V8");
        teamV8.start();
    }
}