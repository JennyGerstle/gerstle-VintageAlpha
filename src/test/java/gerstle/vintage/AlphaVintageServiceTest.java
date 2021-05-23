package gerstle.vintage;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class AlphaVintageServiceTest
{
    @Test
    public void getDaily()
    {
        //given
        AlphaVintageServiceFactory factory = new AlphaVintageServiceFactory();
        AlphaVintageService service = factory.newInstance();

        //when
        AlphaVintageFeed feed = service.getMonthly("IBM").blockingGet();

        //then
        assertNotNull(feed);
        Assert.assertFalse(feed.MonthlyTimeSeries.isEmpty());
        Assert.assertTrue(feed.MonthlyTimeSeries.get(0).volume > -1);
        assertNotNull(feed.MonthlyTimeSeries);
    }
}