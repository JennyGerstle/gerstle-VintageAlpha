package gerstle.vintage;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import com.google.gson.annotations.SerializedName;

public class AlphaVintageFeed implements Serializable
{
    @SerializedName("Monthly Time Series")
    Map<String, MonthlyTimeSeries> MonthlyTimeSeries;


    static class MonthlyTimeSeries
    {
        double open;
        double high;
        double low;
        double close;
        double volume;
    }
}
