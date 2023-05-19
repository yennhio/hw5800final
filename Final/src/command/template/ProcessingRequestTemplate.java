package command.template;

import java.time.LocalDateTime;

public abstract class ProcessingRequestTemplate {



    public void process(Request request){
        if (validateInput(request)) {
            logRequest(request);
            notifyUser(request);
            execute();
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
        System.out.println(LocalDateTime.now());
        System.out.println("The request has been logged");
        System.out.println("Content:" + request.getCommand());
    }

    private void notifyUser(Request request) {
        System.out.println("The request has been notified to the user");
    }

    public abstract void execute();
}
