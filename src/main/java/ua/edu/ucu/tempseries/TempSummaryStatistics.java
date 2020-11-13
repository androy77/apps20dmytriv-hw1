package ua.edu.ucu.tempseries;

public class TempSummaryStatistics {

    private final double averageTemp;
    private final double minimalTemp;
    private final double maximalTemp;
    private final double deviationTemp;

    public TempSummaryStatistics(double averageTemp, double minimalTemp, double maximalTemp, double deviationTemp) {
        this.averageTemp = averageTemp;
        this.deviationTemp = deviationTemp;
        this.maximalTemp = maximalTemp;
        this.minimalTemp = minimalTemp;
    }
    public double getAvgTemp() { return averageTemp; }

    public double getDevTemp() { return deviationTemp; }

    public double getMaxTemp() { return maximalTemp; }

    public double getMinTemp() { return minimalTemp; }
}
