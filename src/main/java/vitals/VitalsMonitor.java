package vitals;

import java.util.List;

public class VitalsMonitor {

    public static boolean vitalsMonitor(float temperature, int pulseRate, int spo2) throws InterruptedException {
        List<String> issues = VitalsChecker.vitalsOk(temperature, pulseRate, spo2);
        if (issues.isEmpty()) {
            System.out.println("All vitals are within range.");
            return true;
        } else {
            for (String issue : issues) {
                displayCriticalMessage(issue);
            }
            return false;
        }
    }

    private static void displayCriticalMessage(String message) throws InterruptedException {
        System.out.println(message);
        for (int i = 0; i < 6; i++) {
            System.out.print("\r* ");
            Thread.sleep(1000);
            System.out.print("\r *");
            Thread.sleep(1000);
        }
    }

}
