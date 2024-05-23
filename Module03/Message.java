package Module03;

public interface Message {

    static final String FORMAT_TYPE = "TXT";

    enum MessageType {
        SMS, EMAIL, MMS
    }

    static Message getInstance() {
        return new ReverseEncodedMessage();
    }

    String getTo();

    void setTo(String to);

    String getFrom();

    void setFrom(String from);

    String getMessage();

    void setMessage(String message);


}
