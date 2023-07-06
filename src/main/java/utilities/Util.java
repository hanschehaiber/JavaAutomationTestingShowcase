package utilities;

public class Util {
    /**
     * This is for debugging purposes only. Hard waits should almost never be present in a test.
     * @param milliSeconds
     */
    public static void sleep(long milliSeconds) {
        try {
            Thread.sleep(milliSeconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
