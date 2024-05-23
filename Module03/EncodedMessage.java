package Module03;

public abstract class EncodedMessage implements Message {
    private String to;
    private String from;
    private String message;


    public EncodedMessage() {}

    public EncodedMessage(String to, String from, String message) {
        this.to = to;
        this.from = from;
        this.message = message;
    }


    public String getTo() {
        return to;
    }


    public void setTo(String to) {
        this.to = to;
    }


    public String getFrom() {
        return from;
    }


    public void setFrom(String from) {
        this.from = from;
    }


    public String getMessage() {
        return decode(message);
    }


    public void setMessage(String message) {
        this.message = encode(message);
    }

    protected String getRawMessage() {
        return message;
    }

    protected abstract String encode(String message);

    protected abstract String decode(String message);


}
