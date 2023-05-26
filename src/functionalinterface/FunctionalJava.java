package functionalinterface;

public class FunctionalJava {

    public static void functionalJavaTest() {
        System.out.println("From primary()method: " + Thread.currentThread().getName());

        System.out.println("Implementing the runnable interface in Java");

        Runnable instance = getRunnable();

    }

    private static Runnable getRunnable() {
        return new Runnable() {
            @Override

            public void run() {

                System.out.println("From run()method: " + Thread.currentThread().getName());

            }
        };
    }
}


