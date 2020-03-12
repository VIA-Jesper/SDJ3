package exercise5_1__pubsub.models;

import java.util.Date;

public class Message {

    private String message;
    private Date createDate;
    private String sender;

    public Message(String message, Date createDate, String sender) {
        this.message = message;
        this.createDate = createDate;
        this.sender = sender;
    }

    public String getMessage() {
        return message;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public String getSender() {
        return sender;
    }

    @Override
    public String toString() {
        return "Message{" +
                "message='" + message + '\'' +
                ", createDate=" + createDate +
                ", sender='" + sender + '\'' +
                '}';
    }
}
