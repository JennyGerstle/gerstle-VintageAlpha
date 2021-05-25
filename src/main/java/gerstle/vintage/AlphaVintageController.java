package gerstle.vintage;

import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.RadioButton;
import javafx.scene.input.MouseEvent;
import java.util.List;
import java.util.Map;


public class AlphaVintageController
{
    @FXML
    List<RadioButton> radioBTNS;
    @FXML
    LineChart chart;

    AlphaVintageService service;

    public AlphaVintageController(AlphaVintageService service)
    {
        this.service = service;
    }

    public void initialize()
    {
    }

    public void LoadGraph(MouseEvent mouseEvent)
    {
        if (radioBTNS.get(0).isSelected())
        {
            radioBTNS.get(1).setSelected(false);
            radioBTNS.get(2).setSelected(false);
            Disposable disposable = service.getDaily()
                    .subscribeOn(Schedulers.io())
                    .observeOn(Schedulers.trampoline())
                    .subscribe(this::onStockPriceAverageDaily, this::onError);
        }
        else if (radioBTNS.get(1).isSelected())
        {
            radioBTNS.get(0).setSelected(false);
            radioBTNS.get(2).setSelected(false);
            Disposable disposable = service.getWeekly()
                    .subscribeOn(Schedulers.io())
                    .observeOn(Schedulers.trampoline())
                    .subscribe(this::onStockPriceAverageWeekly, this::onError);
        }
        else
        {
            radioBTNS.get(1).setSelected(false);
            radioBTNS.get(0).setSelected(false);
            AlphaVintageMonthlyFeed MFeed = new AlphaVintageMonthlyFeed();
            Disposable disposable = service.getMonthly()
                    .subscribeOn(Schedulers.io())
                    .observeOn(Schedulers.trampoline())
                    .subscribe(this::onStockPriceAverageMonthly, this::onError);
        }
    }

    private void onStockPriceAverageDaily(AlphaVintageDailyFeed feed)
    {
        Platform.runLater(new Runnable()
        {
            @Override
            public void run()
            {
                onStockPriceAverageDailyRunL(feed);
            }
        });
    }

    private void onStockPriceAverageDailyRunL(AlphaVintageDailyFeed feed)
    {
        XYChart.Series series = new XYChart.Series();
        for (Map.Entry<String, AlphaVintageDailyFeed.DailyTimeSeries> entry : feed.DailyTimeSeries.entrySet()
             )
        {
            series.getData().add(new XYChart.Data<>(entry.getKey(), entry.getValue().close));
        }
        chart.setData(FXCollections.observableArrayList(series));
    }


    private void onStockPriceAverageWeekly(AlphaVintageWeeklyFeed feed)
    {
        Platform.runLater(new Runnable()
        {
            @Override
            public void run()
            {
                onStockPriceAverageWeeklyRunL(feed);
            }
        });
    }

    private void onStockPriceAverageWeeklyRunL(AlphaVintageWeeklyFeed feed)
    {
        XYChart.Series series = new XYChart.Series();
        for (Map.Entry<String, AlphaVintageWeeklyFeed.WeeklyTimeSeries> entry : feed.WeeklyTimeSeries.entrySet()
        )
        {
            series.getData().add(new XYChart.Data<>(entry.getKey(), entry.getValue().close));
        }
        chart.setData(FXCollections.observableArrayList(series));
    }


    private void onStockPriceAverageMonthly(AlphaVintageMonthlyFeed feed)
    {
        Platform.runLater(new Runnable()
        {
            @Override
            public void run()
            {
                onStockPriceAverageMonthlyRunL(feed);
            }
        });
    }

    private void onStockPriceAverageMonthlyRunL(AlphaVintageMonthlyFeed feed)
    {
        XYChart.Series series = new XYChart.Series();
        for (Map.Entry<String, AlphaVintageMonthlyFeed.MonthlyTimeSeries> entry : feed.MonthlyTimeSeries.entrySet()
        )
        {
            series.getData().add(new XYChart.Data<>(entry.getKey(), entry.getValue().close));
        }
        chart.setData(FXCollections.observableArrayList(series));
    }

    public void onError(Throwable throwable)
    {
        // bad but better
        throwable.printStackTrace();
    }


}
