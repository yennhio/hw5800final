package command.template;

public class PlayMusicCommand implements Command{
    private Music music;

    public PlayMusicCommand(Music music){
        this.music = music;
    }

    @Override
    public void execute() {
        System.out.println("Playing the music " + music.getName() + " by " + music.getSinger());
    }
}
