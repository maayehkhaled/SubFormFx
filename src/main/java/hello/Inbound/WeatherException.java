package hello.Inbound;

/**
 * Created by kmaayeh on 8/30/2017.
 */
public class WeatherException extends Exception {
        private static final long serialVersionUID = 1L;
        private String errorMessage;

        public String getErrorMessage() {
            return errorMessage;
        }
        public WeatherException(String errorMessage) {
            super(errorMessage);
            this.errorMessage = errorMessage;
        }
        public WeatherException() {
            super();
        }
    }

