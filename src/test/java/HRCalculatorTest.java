import org.junit.jupiter.api.Test;
import se2526.HRCalculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class HRCalculatorTest {
    @Test
    public void testValidMaxHR() {
        var result = HRCalculator.calculateMaxHR(25);
        assertEquals(195, result);
    }
    @Test
    public void testInvalidMinHR_ageTooHigh() {
        assertThrows(IllegalArgumentException.class, () -> HRCalculator.calculateMaxHR(500));
    }

    @Test
    public void testInvalidMinHR_ageTooLow() {
        assertThrows(IllegalArgumentException.class, () -> HRCalculator.calculateMaxHR(-1));
    }

    @Test
    public void testWorkoutZones() {
        assertEquals("Below Zone", HRCalculator.getWorkoutZone(30, 90));   // ~45%
        assertEquals("Warm-up", HRCalculator.getWorkoutZone(30, 105));     // ~52%
        assertEquals("Fat Burn", HRCalculator.getWorkoutZone(30, 120));    // ~60%
        assertEquals("Cardio", HRCalculator.getWorkoutZone(30, 140));      // ~70%
        assertEquals("Anaerobic", HRCalculator.getWorkoutZone(30, 160));   // ~80%
        assertEquals("Maximum Effort", HRCalculator.getWorkoutZone(30, 180)); // ~90%
    }

}