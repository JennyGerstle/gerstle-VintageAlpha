package gerstle.vintage;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import com.google.gson.annotations.SerializedName;
import java.time.LocalDateTime;

public class AlphaVintageMonthlyFeed
{
    @SerializedName("Monthly Time Series")
    Map<String, MonthlyTimeSeries> monthlyTimeSeries;

    static class MonthlyTimeSeries
    {
        @SerializedName("4. close")
        double close;
    }
}
