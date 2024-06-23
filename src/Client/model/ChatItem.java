package Client.model;

public class ChatItem {

    String time;
    String owner;
    String content;

    public ChatItem(String time, String owner, String content) {
        this.time = time;
        this.owner = owner;
        this.content = content;
    }

    @Override
    public String toString() {
        return "[" + time + "] " + owner + ": " + content;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
