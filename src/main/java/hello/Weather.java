package hello;

/**
 * Created by kmaayeh on 8/29/2017.
 */
public class Weather {

    private final long id;
    private final String city;
    private final String temp;
    private final boolean correct;

    public Weather(long id, String city,String temp,boolean correct) {
        this.id = id;
        this.city = city;
        this.temp=temp;
        this.correct=correct;

    }

    public String getTemp() {
        return temp;
    }

    public long getId() {
        return id;
    }

    public String getCity() {
        return city;
    }
    public boolean isCorrect() {
        return correct;
    }

}
