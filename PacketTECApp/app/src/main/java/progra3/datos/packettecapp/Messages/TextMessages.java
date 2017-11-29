package progra3.datos.packettecapp.Messages;

/**
 * Created by deiber on 11/28/17.
 */

public class TextMessages {
    private String id;
    private String message;
    private int MessageType;
    private String TimeMessage;

    public TextMessages() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getMessageType() {
        return MessageType;
    }

    public void setMessageType(int messageType) {
        MessageType = messageType;
    }

    public String getTimeMessage() {
        return TimeMessage;
    }

    public void setTimeMessage(String timeMessage) {
        TimeMessage = timeMessage;
    }
}
