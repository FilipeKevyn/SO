public class Peterson {
    private static volatile boolean[] wantToEnter = new boolean[2];
    private static volatile int turn;

    public static void main(String[] args) {
        Thread process0 = new Thread(new CriticalRegionProcess(0));
        Thread process1 = new Thread(new CriticalRegionProcess(1));

        process0.start();
        process1.start();
    }

    static class CriticalRegionProcess implements Runnable {
        private int id;
        private int other;

        public CriticalRegionProcess(int id) {