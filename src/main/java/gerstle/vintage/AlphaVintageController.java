package gerstle.vintage;

import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.util.ArrayList;


public class AlphaVintageController
{
    @FXML
    Label Label1;
    AlphaVintageService service;
    public AlphaVintageController(AlphaVintageService service)
    {
        this.service = service;
    }

    public void initialize()
    {
        Disposable disposable = service.getMonthly("IBM")
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.trampoline())
                .subscribe(this::onStockPriceAverage, this::onError);
    }
    private void onStockPriceAverage(AlphaVintageFeed feed)
    {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                onStockPriceAverageRunL(feed);
            }
        });
    }

    private void onStockPriceAverageRunL(AlphaVintageFeed feed)
    {
       Label1.setText(feed.monthly.get(0).volume + "");
    }
    public void onError(Throwable throwable)
    {
        // bad but better
        throwable.printStackTrace();
    }


}
