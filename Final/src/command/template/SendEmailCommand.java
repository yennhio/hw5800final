package command.template;

public class SendEmailCommand implements Command{
    private Email email;

    public SendEmailCommand(Email email){
        this.email = email;
    }

    @Override
    public void execute() {

    }
}
