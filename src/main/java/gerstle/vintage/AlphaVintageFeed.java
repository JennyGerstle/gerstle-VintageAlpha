package gerstle.vintage;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import com.google.gson.annotations.SerializedName;
import java.time.LocalDateTime;

public class AlphaVintageFeed implements Serializable
{
    @SerializedName("Monthly Time Series")
    Map<String, MonthlyTimeSeries> MonthlyTimeSeries;

    static class MonthlyTimeSeries
    {
        @SerializedName("1. open")
        double open;
        @SerializedName("2. high")
        double high;
        @SerializedName("3. low")
        double low;
        @SerializedName("4. close")
        double close;
        @SerializedName("5. volume")
        double volume;
    }
}
