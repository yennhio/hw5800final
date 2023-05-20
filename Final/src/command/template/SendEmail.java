package command.template;

public class SendEmail extends ProcessingRequestTemplate{
    private Invoker invoker;

    @Override
    public void execute(Request request) {
        String[] emailInfo = request.getCommand().split(",");
        Command sendEmailCommand = new SendEmailCommand(new Email(emailInfo[0], emailInfo[1]));
        invoker = new Invoker(sendEmailCommand);
        invoker.execute();
    }
}
