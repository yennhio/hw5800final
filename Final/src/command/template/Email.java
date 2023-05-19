package command.template;

public class Email {
    private String recipientEmail;
    private String content;

    public Email(String recipientEmail, String content){
        this.recipientEmail = recipientEmail;
        this.content = content;
    }
}
