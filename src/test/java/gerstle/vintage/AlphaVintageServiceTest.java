package gerstle.vintage;

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
    }
}