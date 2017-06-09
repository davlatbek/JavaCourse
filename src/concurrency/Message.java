package concurrency;

/**
 * Created by davlet on 6/9/17.
 */
public class Message {
    public String Message;

    public Message(String message){
        this.Message = message;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }
}
