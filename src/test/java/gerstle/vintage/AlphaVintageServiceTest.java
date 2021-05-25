package gerstle.vintage;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class AlphaVintageServiceTest
{
    @FXML
    TextField stockName;
    @Test
    public void getDaily()
    {
        //given
        AlphaVintageServiceFactory factory = new AlphaVintageServiceFactory();
        AlphaVintageService service = factory.newInstance();

        //when
        AlphaVintageMonthlyFeed feed = service.getMonthly(stockName.getText(), "4FLLHYV9D7QKWY96").blockingGet();

        //then
        assertNotNull(feed);
        Assert.assertFalse(feed.monthlyTimeSeries.isEmpty());
        //Assert.assertTrue(feed.MonthlyTimeSeries.get() > -1);
        assertNotNull(feed.monthlyTimeSeries);
    }
}