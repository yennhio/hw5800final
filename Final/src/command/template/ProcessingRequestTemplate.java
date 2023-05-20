package command.template;

import java.time.LocalDateTime;

public abstract class ProcessingRequestTemplate {



    public void process(Request request){
        if (validateInput(request)) {
            logRequest(request);
            notifyUser(request);
            execute(request);
        }
    }

    private boolean validateInput(Request request){
        if (request == null){
            System.out.println("It's not a valid request");
            return false;
        }
        else {
            System.out.println("It's a valid request");
            return true;
        }

    }

    private void logRequest(Request request) {
        System.out.println("The request \"" + request.getCommand() + "\" has been logged at " + LocalDateTime.now());
    }

    private void notifyUser(Request request) {
        System.out.println("The request has been notified to the user");
    }

    public abstract void execute(Request request);
}
