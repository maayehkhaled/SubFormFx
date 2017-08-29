package hello.Inbound;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by kmaayeh on 8/29/2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class GetWeather {

    private Current current;

    public Current getCurrent() {
        return current;
    }

    public void setCurrent(Current current) {
        this.current = current;
    }

    @Override
    public String toString() {
        return " \"location\":{}" +
                "   \"current\":{" + current + "}" +
                "   \"forecast\":{}";

    }
}
