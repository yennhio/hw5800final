package command.template;

public class SetReminder extends ProcessingRequestTemplate{
    private Invoker invoker;

    @Override
    public void execute(Request request){
        String[] reminderInfo = request.getCommand().split(",");
        Command setReminderCommand = new SetReminderCommand(new Reminder(reminderInfo[0], reminderInfo[1]));
        invoker = new Invoker(setReminderCommand);
        invoker.execute();

    }
}
