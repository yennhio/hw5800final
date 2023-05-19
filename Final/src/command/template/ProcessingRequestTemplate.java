package command.template;

public abstract class ProcessingRequestTemplate {
    Request request;



    public void process(){
        validateInput();
        logRequest();
        notifyUser();
        execute();
    }

    public void validateInput(){

    }

    public void logRequest() {

    }

    public void notifyUser() {

    }

    private void execute() {

    }
}
