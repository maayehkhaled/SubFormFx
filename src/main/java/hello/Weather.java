package hello;

/**
 * Created by kmaayeh on 8/29/2017.
 */
public class Weather {



    private long id;
    private String cityName;
    private String temp;
    private boolean correct;

    public void setId(long id) {
        this.id = id;
    }

    public void setCity(String city) {
        this.cityName = city;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    public void setCorrect(boolean correct) {
        this.correct = correct;
    }

    public Weather() {

    }


    public String getTemp() {
        return temp;
    }

    public long getId() {
        return id;
    }

    public String getCity() {
        return cityName;
    }

    public boolean isCorrect() {
        return correct;
    }

}
