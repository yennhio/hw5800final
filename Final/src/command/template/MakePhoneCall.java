package command.template;

public class MakePhoneCall extends ProcessingRequestTemplate{

    private Invoker invoker;
    @Override
    public void execute(Request request) {
        Command makePhoneCallCommand = new MakePhoneCallCommand(request.getCommand());
        invoker = new Invoker(makePhoneCallCommand);
        invoker.execute();
    }

}
