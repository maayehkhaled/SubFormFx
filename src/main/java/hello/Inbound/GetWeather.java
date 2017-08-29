package hello.Inbound;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by kmaayeh on 8/29/2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class GetWeather {

    private Current current;

    private String error;

    public void setError(String error) {
        this.error = error;
    }
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

    public String getError(){

        return "{\"error\":{\"code\":1006,\"message\":\""+error+"\"}}";
    }
}
