package hello;

import hello.Inbound.GetWeather;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by kmaayeh on 8/29/2017.
 */
@RestController
public class WeatherController {
    private final AtomicLong counter = new AtomicLong();


    @RequestMapping(value = "/weather/{cityName}",method = RequestMethod.GET)
    @ResponseBody
    public Weather getWeather(@PathVariable("cityName") String name) {
        RestTemplate restTemplate = new RestTemplate();
        GetWeather getWeather = restTemplate.getForObject("http://api.apixu.com/v1/forecast.json?key=a885ea0a353f436dbdf180550172908&q=" + name, GetWeather.class);
        return new Weather(counter.incrementAndGet(), name, getWeather.getCurrent().getTemp_c());
        //return "your Variable is "+name;
    }
}
