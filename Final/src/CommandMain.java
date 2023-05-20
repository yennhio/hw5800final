import command.template.*;
public class CommandMain {
    public static void main(String[] args) {
        Request phoneCallRequest = new Request("714-123-1234");
        ProcessingRequestTemplate makePhoneCall = new MakePhoneCall();
        makePhoneCall.process(phoneCallRequest);

        Request playMusicRequest = new Request("Remember,beatles");
        ProcessingRequestTemplate playMusic = new PlayMusic();
        playMusic.process(playMusicRequest);

        Request sendEmailRequest = new Request("Kevin,Hi how are you");
        ProcessingRequestTemplate sendEmail = new SendEmail();
        sendEmail.process(sendEmailRequest);

        Request setReminderRequest = new Request("11:12AM,Math Exam");
        ProcessingRequestTemplate setReminder = new SetReminder();
        setReminder.process(setReminderRequest);
    }
}