package gerstle.vintage;

import java.util.List;

public class AlphaVintageFeed
{
    List<MonthlyTimeSeries> monthly;
    static class MonthlyTimeSeries
    {
        double open;
        double high;
        double low;
        double close;
        double volume;

    }
}
