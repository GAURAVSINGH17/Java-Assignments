// Simulates a loading spinner/progress using a separate thread
public class Loader implements Runnable {
    private final int durationMillis; // total duration

    public Loader(int durationMillis) {
        this.durationMillis = durationMillis;
    }

    @Override
    public void run() {
        try {
            int steps = 5;
            int stepDelay = durationMillis / steps;
            for (int i = 0; i < steps; i++) {
                System.out.print("Loading");
                for (int j = 0; j <= i; j++) System.out.print(".");
                System.out.println();
                Thread.sleep(stepDelay);
            }
        } catch (InterruptedException e) {
            // if interrupted, just exit the loader thread gracefully
            Thread.currentThread().interrupt();
        }
    }
}
