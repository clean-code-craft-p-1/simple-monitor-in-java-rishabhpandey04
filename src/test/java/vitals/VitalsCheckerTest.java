package vitals;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;


public class VitalsCheckerTest {

  @Test
  public void testNotOkWhenAnyVitalIsOffRange() throws InterruptedException {
    assertFalse(VitalsMonitor.vitalsMonitor(99f, 102, 70));
    assertTrue(VitalsMonitor.vitalsMonitor(98.1f, 70, 98));
  }

  @Test
  public void testAllVitalsWithinRange() throws InterruptedException {
    // All vitals are within range
    assertTrue(VitalsMonitor.vitalsMonitor(98.6f, 75, 95));
  }

  @Test
  public void testTemperatureOutOfRange() throws InterruptedException {
    // Temperature too low
    assertFalse(VitalsMonitor.vitalsMonitor(94.9f, 75, 95));
    // Temperature too high
    assertFalse(VitalsMonitor.vitalsMonitor(102.1f, 75, 95));
  }

  @Test
  public void testPulseRateOutOfRange() throws InterruptedException {
    // Pulse rate too low
    assertFalse(VitalsMonitor.vitalsMonitor(98.6f, 59, 95));
    // Pulse rate too high
    assertFalse(VitalsMonitor.vitalsMonitor(98.6f, 101, 95));
  }

  @Test
  public void testSpo2OutOfRange() throws InterruptedException {
    // Oxygen saturation too low
    assertFalse(VitalsMonitor.vitalsMonitor(98.6f, 75, 89));
  }

}
