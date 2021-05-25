package gerstle.vintage;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.Map;

public class AlphaVintageSearchFeed  implements Serializable
{
    static Map<String, AlphaVintageSearchFeed.bestMatches> bestMatches;

    static class bestMatches
    {
        String symbol;
    }
}
