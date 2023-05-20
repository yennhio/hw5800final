package command.template;

public class SendEmailCommand implements Command{
    private Email email;

    public SendEmailCommand(Email email){
        this.email = email;
    }

    @Override
    public void execute() {
        System.out.println("Sending an email to " + email.getRecipientEmail() + ", Content: " + email.getContent());

    }
}
