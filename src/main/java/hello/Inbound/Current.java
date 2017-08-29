package hello.Inbound;

/**
 * Created by kmaayeh on 8/29/2017.
 */
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)

public class Current {

    private String temp_c;
    private String feelslike_c;

    public String getTemp_c() {
        return temp_c;
    }

    public void setTemp_c(String temp_c) {
        this.temp_c = temp_c;
    }

    public String getFeelslike_c() {
        return feelslike_c;
    }

    public void setFeelslike_c(String feelslike_c) {
        this.feelslike_c = feelslike_c;
    }

    @Override
    public String toString() {

        return " \"current\":{" +
                " \"temp_c\":" + temp_c + "," +
                "\"condition\":{}" +
                "\"feelslike_c\":" + feelslike_c;
    }
}
