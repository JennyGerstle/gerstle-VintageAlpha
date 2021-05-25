package gerstle.vintage;

import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;

import java.util.ArrayList;
import java.util.Date;


public class AlphaVintageController
{
    @FXML
    Label Label1;
    @FXML
    Label labelTimePeriod;
    @FXML
    LineChart chart;

    AlphaVintageService service;
    AlphaVintageFeed feed;

    public AlphaVintageController(AlphaVintageService service)
    {
        this.service = service;
    }

    public void initialize()
    {
        Disposable disposable = service.getMonthly()
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.trampoline())
                .subscribe(this::onStockPriceAverageRunL, this::onError);
    }

    private void onStockPriceAverage(AlphaVintageFeed feed)
    {
        Platform.runLater(new Runnable()
        {
            @Override
            public void run()
            {
                onStockPriceAverageRunL(feed);
            }
        });
    }

    private void onStockPriceAverageRunL(AlphaVintageFeed feed)
    {

        String[] sKeys =setSKey(feed);
        ObservableList<XYChart.Series> graph = setGraph(feed, sKeys);
        chart.setData(graph);
        //Label1.setText("" + feed.MonthlyTimeSeries.get(sKeys[0]).close);
    }

    public void onError(Throwable throwable)
    {
        // bad but better
        throwable.printStackTrace();
    }
    public String[] setSKey(AlphaVintageFeed feed)
    {
        String[] sKeys = feed.MonthlyTimeSeries.keySet().toArray(new String[0]);
        chart.getData().add(setGraph(feed, sKeys));
        return sKeys;
    }
    public ObservableList<XYChart.Series> setGraph(AlphaVintageFeed feed, String[] sKeys)
    {
        //Integer.parseInt(labelTimePeriod.getText());
        int timeGiven = 3;
        XYChart.Series series = new XYChart.Series();
        for (int points = 0; points < timeGiven; ++points)
        {
            int iX;
            double dY;
            iX = points;
            dY = feed.MonthlyTimeSeries.get(sKeys[points]).close;
            series.getData().add(new XYChart.Data(iX, dY));
        }
        ObservableList<XYChart.Series> seriesOL = series.getData();
        return seriesOL;
    }

}
