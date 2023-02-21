package interceptor;

public class CDPlayer {
    private boolean isPlaying = false;

    public void play() {
        System.out.println("Playing CD...");
        isPlaying = true;
    }

    public void stop() {
        System.out.println("Stopping CD...");
        isPlaying = false;
    }

    public boolean isPlaying() {
        return isPlaying;
    }

    public static void main(String[] args) {
        CDPlayer cdPlayer = new CDPlayer();
        cdPlayer.play();
        cdPlayer.stop();
    }
}
