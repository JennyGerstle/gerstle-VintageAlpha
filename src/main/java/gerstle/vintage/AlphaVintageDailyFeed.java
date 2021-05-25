package gerstle.vintage;

import com.google.gson.annotations.SerializedName;

import java.util.Map;

public class AlphaVintageDailyFeed
{
    @SerializedName("Time Series (Daily)")
    Map<String, AlphaVintageDailyFeed.DailyTimeSeries> DailyTimeSeries;

    static class DailyTimeSeries
    {
        @SerializedName("4. close")
        double close;
    }
}
