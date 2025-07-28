public class PerformanceTester {
    public void performTask() {
        try {
            Thread.sleep(500);  // Simulate task
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}