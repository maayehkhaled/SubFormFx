package hello;

import hello.Inbound.*;
import hello.Inbound.WeatherException;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.util.UriComponentsBuilder;


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
        if (StringUtils.isAllEmpty(getWeather.getCurrent().getTemp_c()) || StringUtils.isNumeric(name) || StringUtils.isBlank(name) || !StringUtils.isAlpha(name)) {
            throw new WeatherException("Invalid Country/city name requested");

        }
        if (StringUtils.isNumeric(weather.getCity()) || StringUtils.isAllEmpty(weather.getCity())) {
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

    @RequestMapping(value = "/weather")
    @ResponseBody
    public void getEmpty(String name) throws WeatherException {
        throw new WeatherException("This Service Does not Exist");

    }

    @RequestMapping(value = "/weather", method = RequestMethod.POST)
    public ResponseEntity<Weather> postWeather(@RequestBody String request) throws WeatherException {
        System.out.println(request);
        JSONObject jsonObject = new JSONObject(request);
        System.err.println("Starting the Post Request");
        System.out.println(jsonObject.getJSONObject("request").getJSONObject("intent").getJSONObject("slots").getJSONObject("cityName").getString("value"));

        String cityName=null;
        try {


           cityName = jsonObject.getJSONObject("request").getJSONObject("intent").getJSONObject("slots").getJSONObject("cityName").getString("value");
        }catch (JSONException ex){
            System.err.println(ex.getMessage());
        }
        System.err.println(cityName);
        RestTemplate restTemplate = new RestTemplate();
        GetWeather getWeather = restTemplate.getForObject("http://api.apixu.com/v1/forecast.json?key=a885ea0a353f436dbdf180550172908&q=" + cityName, GetWeather.class);
        Weather weather = new Weather();
        weather.setId(counter.incrementAndGet());
        weather.setCity(cityName);
        weather.setCorrect(true);
        weather.setTemp(getWeather.getCurrent().getTemp_c());
        if (StringUtils.isAllEmpty(getWeather.getCurrent().getTemp_c()) || StringUtils.isNumeric(cityName) || StringUtils.isBlank(cityName) || !StringUtils.isAlpha(cityName)) {
            throw new WeatherException("Invalid Country/city name requested");

        }
        if (StringUtils.isNumeric(weather.getCity()) || StringUtils.isAllEmpty(weather.getCity())) {
            throw new WeatherException("Invalid Country/city name requested");
        }
        return new ResponseEntity<Weather>(weather, HttpStatus.OK);

    }
}