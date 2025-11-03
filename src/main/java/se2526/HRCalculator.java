package se2526;

public class HRCalculator {
    public static int calculateMaxHR(int age){
        if (age > 120 || age < 0) {
            throw new IllegalArgumentException("Age out of bounds");
        }

        return 220 - age;
    }
    public static String getWorkoutZone(int age, int bpm) {
        int maxHR = calculateMaxHR(age);
        double percent = (double) bpm / maxHR * 100;

        if (percent < 50) return "Below Zone";
        else if (percent < 60) return "Warm-up";
        else if (percent < 70) return "Fat Burn";
        else if (percent < 80) return "Cardio";
        else if (percent < 90) return "Anaerobic";
        else if (percent <= 100) return "Maximum Effort";
        else return "Overexertion";
    }

}

