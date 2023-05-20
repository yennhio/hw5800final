package command.template;

public class Reminder {
    private String time;
    private String content;

    public Reminder(String time, String content){
        this.time = time;
        this.content = content;
    }

    public String getTime() {
        return time;
    }

    public String getContent() {
        return content;
    }
}
