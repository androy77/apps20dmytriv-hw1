package ua.edu.ucu.tempseries;


import java.util.InputMismatchException;

public class TemperatureSeriesAnalysis {

    private final double[] temperatures;


    public TemperatureSeriesAnalysis() {
        temperatures = new double[]{};
    }

    public TemperatureSeriesAnalysis(double[] temperatureSeries) {
        for (double temp : temperatureSeries) {
            if (temp < -273.0) {
                throw new InputMismatchException();
            }

        }
        temperatures = temperatureSeries;
    }

    public double average() {
        if (temperatures.length == 0) {
            throw new IllegalArgumentException("Empty array");
        }
        double tempsum = 0;

        for (double temp : temperatures) {
            tempsum += temp;
        }
        double average = tempsum / temperatures.length;
        return average;
    }

    public double deviation() {
        double mean = average();
        double standardDeviation = 0.0;
        for (double num : temperatures) {
            standardDeviation += Math.pow(num - mean, 2);
        }

        return Math.sqrt(standardDeviation / temperatures.length);
    }

    public double min() {
        if (temperatures.length == 0) {
            throw new IllegalArgumentException("Empty array");
        }
        double minValue = temperatures[0];
        for (int i = 1; i < temperatures.length; i++) {
            if (temperatures[i] < minValue) {
                minValue = temperatures[i];
            }
        }
        return minValue;
    }

    public double max() {
        if (temperatures.length == 0) {
            throw new IllegalArgumentException("Empty array");
        }
        double maxValue = temperatures[0];
        for (int i = 1; i < temperatures.length; i++) {
            if (temperatures[i] > maxValue) {
                maxValue = temperatures[i];
            }
        }
        return maxValue;
    }

    public double findTempClosestToZero() {
        if (temperatures.length == 0) {
            throw new IllegalArgumentException("Empty array");
        }
        double distance = Math.abs(temperatures[0]);
        int idx = 0;
        for (int c = 1; c < temperatures.length; c++) {
            double cdistance = Math.abs(temperatures[c]);
            if (cdistance < distance) {
                idx = c;
                distance = cdistance;
            }
        }
        return temperatures[idx];
    }

    public double findTempClosestToValue(double tempValue) {
        if (temperatures.length == 0) {
            throw new IllegalArgumentException("Empty array");
        }
        double distance = Math.abs(temperatures[0] - tempValue);
        int idx = 0;
        for (int c = 1; c < temperatures.length; c++) {
            double cdistance = Math.abs(temperatures[c] - tempValue);
            if (cdistance < distance) {
                idx = c;
                distance = cdistance;
            }
        }
        return temperatures[idx];
    }

    public double[] findTempsLessThen(double tempValue) {
        if (temperatures.length == 0) {
            throw new IllegalArgumentException("Empty array");
        }
        int len = 0;
        int i = 0;
        for (double temp : temperatures) {
            if (temp < tempValue) {
                len += 1;
            }
        }
        double[] tempsLessEntered = new double[len];

        for (double temp : temperatures) {
            if (temp < tempValue) {
                tempsLessEntered[i] = temp;
                i += 1;
            }
        }
        return tempsLessEntered;
    }

    public double[] findTempsGreaterThen(double tempValue) {
        if (temperatures.length == 0) {
            throw new IllegalArgumentException("Empty array");
        }
        int len = 0;
        int i = 0;
        for (double temp : temperatures) {
            if (temp > tempValue) {
                len += 1;
            }
        }
        double[] tempsGreaterEntered = new double[len];

        for (double temp : temperatures) {
            if (temp > tempValue) {
                tempsGreaterEntered[i] = temp;
                i += 1;
            }
        }
        return tempsGreaterEntered;
    }

    public TempSummaryStatistics summaryStatistics() throws IllegalArgumentException {
        return new TempSummaryStatistics(average(), deviation(), min(), max());
    }

    public int addTemps(double... temps) {
        return 0;
    }
}
