package util;

public class Loader implements Runnable {
    @Override
    public void run() {
        try {
            System.out.print("Loading");
            for (int i = 0; i < 3; i++) {
                Thread.sleep(500);
                System.out.print(".");
            }
            System.out.println();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
