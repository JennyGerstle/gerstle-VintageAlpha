package gerstle.vintage;

import java.io.Serializable;
import java.util.Map;
import com.google.gson.annotations.SerializedName;

public class AlphaVintageWeeklyFeed
{
        @SerializedName("Weekly Time Series")
        Map<String, gerstle.vintage.AlphaVintageWeeklyFeed.WeeklyTimeSeries> weeklyTimeSeries;

        static class WeeklyTimeSeries
        {
            @SerializedName("4. close")
            double close;
        }
}
