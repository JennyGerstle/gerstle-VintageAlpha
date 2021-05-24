package gerstle.vintage;

import io.reactivex.rxjava3.core.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface AlphaVintageService
{
    @GET("query?function=TIME_SERIES_MONTHLY&symbol=IBM&apikey=4FLLHYV9D7QKWY96")
    Single<AlphaVintageFeed> getMonthly();
}
