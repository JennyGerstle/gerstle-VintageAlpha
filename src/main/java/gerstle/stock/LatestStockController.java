package gerstle.stock;

import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class LatestStockController
{
    LatestStockService service;
    public LatestStockController(LatestStockService service)
    {
        this.service = service;
    }

    public void initialize()
    {
        String stock = "ADANIGREEN";
        Disposable disposable = service.getPrice()
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.trampoline())
                .subscribe(this::onStockPriceAverage, this::onError);
    }

    private void onStockPriceAverage(LatestStockFeed Feed)
    {
        System.out.println(service);
    }
    public void onError(Throwable throwable)
    {
        // bad but better
        throwable.printStackTrace();
    }


}
