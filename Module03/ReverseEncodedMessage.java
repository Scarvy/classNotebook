package Module03;

public class ReverseEncodedMessage extends EncodedMessage implements Comparable<Message> {

    @Override
    protected String encode(String message) {
        message = new StringBuilder(message).reverse().toString();
        return message;
    }

    @Override
    protected String decode(String message) {
        return message = new StringBuilder(message).reverse().toString();
    }

    public String getReversed() {
        return getRawMessage();
    }

    public static void main(String[] args) {
        Message msg = new ReverseEncodedMessage();
        msg.setTo("Alice");
        msg.setFrom("Bob");
        msg.setMessage("Hello, Alice!");
        System.out.println(((ReverseEncodedMessage) msg).getReversed());

        System.out.println(msg.getMessage());
    }

    @Override
    public int compareTo(Message o) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'compareTo'");
    }
}
