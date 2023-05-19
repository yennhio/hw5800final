package command.template;

public class MakePhoneCallCommand implements Command{

    String phoneNumber;
    public MakePhoneCallCommand(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }
    @Override
    public void execute() {

    }
}
