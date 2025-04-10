package vitals;

import java.util.ArrayList;
import java.util.List;

public abstract class VitalsChecker {
  static List<String> vitalsOk(float temperature, float pulseRate, float spo2) throws InterruptedException {
    List<String> healthIssues = new ArrayList<>(); 
    if (!isTemperatureOk(temperature)) {
      healthIssues.add("Temperature is critical!");
    }
    if (!isPulseRateOk(pulseRate)) {
      healthIssues.add("Pulse Rate is out of range!");
    }
    if (!isSpo2Ok(spo2)) {
      healthIssues.add("Oxygen Saturation out of range!");
    }
    return healthIssues;
  }

  private static boolean isTemperatureOk(float temperature) {
    return temperature >= 95 && temperature <= 102;
  }

  private static boolean isPulseRateOk(float pulseRate) {
    return pulseRate >= 60 && pulseRate <= 100;
  }

  private static boolean isSpo2Ok(float spo2) {
    return spo2 >= 90;
  }
}