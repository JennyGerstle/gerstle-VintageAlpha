package gerstle.vintage;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class AlphaVintageServiceFactory
{
    public AlphaVintageService newInstance()
    {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://www.alphavantage.co/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .build();

        AlphaVintageService service = retrofit.create(AlphaVintageService.class);

        return service;

    }
}
