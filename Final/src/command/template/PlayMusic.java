package command.template;

public class PlayMusic extends ProcessingRequestTemplate{

    private Invoker invoker;
    @Override
    public void execute(Request request){
        String[] musicInfo = request.getCommand().split(",");
        Command playMusicCommand = new PlayMusicCommand(new Music(musicInfo[0], musicInfo[1]));
        invoker = new Invoker(playMusicCommand);
        invoker.execute();
    }
}
