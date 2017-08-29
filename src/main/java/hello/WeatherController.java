package hello;

import hello.Inbound.*;
import hello.Inbound.WeatherException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.apache.commons.lang3.StringUtils;


import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by kmaayeh on 8/29/2017.
 */
@RestController
public class WeatherController {
    private final AtomicLong counter = new AtomicLong();


    @RequestMapping(value = "/weather/{cityName}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<Weather> getWeather(@PathVariable("cityName") String name) throws WeatherException {

        RestTemplate restTemplate = new RestTemplate();
        GetWeather getWeather = restTemplate.getForObject("http://api.apixu.com/v1/forecast.json?key=a885ea0a353f436dbdf180550172908&q=" + name, GetWeather.class);
        Weather weather = new Weather();
        weather.setId(counter.incrementAndGet());
        weather.setCity(name);
        weather.setCorrect(true);
        weather.setTemp(getWeather.getCurrent().getTemp_c());
        System.err.println(weather.getCity());
        CharSequence nameseq=name;
        if(StringUtils.isAllEmpty(getWeather.getCurrent().getTemp_c())||StringUtils.isNumeric(nameseq)||StringUtils.isBlank(nameseq) || !StringUtils.isAlpha(nameseq)){
            throw new WeatherException("Invalid Country/city name requested");

        }
        if (StringUtils.isNumeric(weather.getCity())||StringUtils.isAllEmpty(weather.getCity())) { 
            throw new WeatherException("Invalid Country/city name requested");
        }
        return new ResponseEntity<Weather>(weather, HttpStatus.OK);
    }

    @ExceptionHandler(WeatherException.class)
    public ResponseEntity<ErrorResponse> exceptionHandler(Exception ex) {
        ErrorResponse error = new ErrorResponse();
        error.setErrorCode(HttpStatus.PRECONDITION_FAILED.value());
        error.setMessage(ex.getMessage());
        return new ResponseEntity<>(error, HttpStatus.OK);
    }


}
