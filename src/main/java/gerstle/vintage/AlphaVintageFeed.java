package gerstle.vintage;

import java.util.List;
import java.util.Map;

public class AlphaVintageFeed
{
    Map<String, MonthlyTimeSeries.MonthlyDate> monthly;
    static class MonthlyTimeSeries
    {
        static class MonthlyDate
        {
            double open;
            double high;
            double low;
            double close;
            double volume;
        }
    }
}
