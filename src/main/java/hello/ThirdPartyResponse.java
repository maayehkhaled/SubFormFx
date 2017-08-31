package hello;

/**
 * Created by kmaayeh on 8/30/2017.
 */
public class ThirdPartyResponse {
    Response response= new Response();
    String version = "1.0";
    SessionAttributes sessionAttributes;

    public Response getResponse() {
        return response;
    }

    public void setResponse(Response response) {
        this.response = response;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public SessionAttributes getSessionAttributes() {
        return sessionAttributes;
    }

    public void setSessionAttributes(SessionAttributes sessionAttributes) {
        this.sessionAttributes = sessionAttributes;
    }
}

class Response {
    OutputSpeech outputSpeech= new OutputSpeech();
    Card card= new Card();
    String shouldEndSession = "true";

    public OutputSpeech getOutputSpeech() {
        return outputSpeech;
    }

    public void setOutputSpeech(OutputSpeech outputSpeech) {
        this.outputSpeech = outputSpeech;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public String getShouldEndSession() {
        return shouldEndSession;
    }

    public void setShouldEndSession(String shouldEndSession) {
        this.shouldEndSession = shouldEndSession;
    }
}

class SessionAttributes {

}

class OutputSpeech {
    String Type = "\"PlainText\"";
    String SSML;

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public String getSSML() {
        return SSML;
    }

    public void setSSML(String SSML) {
        this.SSML = SSML;
    }
}

class Card {
    String Content="";
    String title="";
    String Type="";

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }
}
