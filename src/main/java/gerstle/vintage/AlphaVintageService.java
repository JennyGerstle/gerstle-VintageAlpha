package gerstle.vintage;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface AlphaVintageService
{
    @GET("query?function=TIME_SERIES_MONTHLY&symbol=IBM&apikey=4FLLHYV9D7QKWY96")
    Single<AlphaVintageMonthlyFeed> getMonthly();

    @GET("query?function=TIME_SERIES_WEEKLY&symbol=IBM&apikey=4FLLHYV9D7QKWY96")
    Single<AlphaVintageWeeklyFeed> getWeekly();

    @GET("query?function=TIME_SERIES_DAILY&symbol=IBM&apikey=4FLLHYV9D7QKWY96")
    Single<AlphaVintageDailyFeed> getDaily();
}
