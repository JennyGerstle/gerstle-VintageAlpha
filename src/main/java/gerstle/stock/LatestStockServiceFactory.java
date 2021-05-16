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
    public LatestStockService newInstance() throws IOException, InterruptedException
    {
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(new Interceptor()
                                  {
                                      @Override
                                      public Response intercept(Interceptor.Chain chain) throws IOException
                                      {
                                          Request original = chain.request();

                                          Request request = original.newBuilder()
                                                  .header("x-rapidapi-key", "3d3bec4cf6msh5e70c5761ec73d4p1df9e5jsne9a9941276b6")
                                                  .header("x-rapidapi-host", "latest-stock-price.p.rapidapi.com")
                                                  .method(original.method(), original.body())
                                                  .build();

                                          return chain.proceed(request);
                                      }
                                  }    );

                OkHttpClient client = httpClient.build();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://rapidapi.com/suneetk92/api/latest-stock-price/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .build();

        LatestStockService service = retrofit.create(LatestStockService.class);

        return service;

    }
}
