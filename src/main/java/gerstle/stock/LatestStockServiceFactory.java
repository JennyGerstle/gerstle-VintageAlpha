package gerstle.stock;

import com.google.gson.GsonBuilder;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class LatestStockServiceFactory
{
    public LatestStockService newInstance()
    {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://latest-stock-price.p.rapidapi.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .build();

        LatestStockService service = retrofit.create(LatestStockService.class);

        return service;

    }
}
