package interceptor;

public class CDPlayer {
    public boolean isPlaying;
    private ConcreteInterceptor concreteInterceptor;

    public CDPlayer() {
        this.isPlaying = false;
        this.concreteInterceptor = new ConcreteInterceptor();
    }

    public void play() {
        if (this.isPlaying) {
            System.out.println("CD is already playing.");
            return;
        }

        ContextObject context = new ContextObject();
        context.setSongTitle("Wake Me Up");
        context.setArtistName("Avicii");

        this.concreteInterceptor.play(context.getSongTitle(), context.getArtistName());
        this.isPlaying = true;
        System.out.println("CD is now playing.");
    }

    public void pause() {
        if (!this.isPlaying) {
            System.out.println("CD is not playing.");
            return;
        }

        ContextObject context = new ContextObject();
        this.concreteInterceptor.pause();
        this.isPlaying = false;
        System.out.println("CD is now paused.");
    }

    public void stop() {
        if (!this.isPlaying) {
            System.out.println("CD is not playing.");
            return;
        }

        ContextObject context = new ContextObject();
        this.concreteInterceptor.stop();
        this.isPlaying = false;
        System.out.println("CD is now stopped.");
    }

    public void addInterceptor(Interceptor interceptor) {
        this.concreteInterceptor.addInterceptor(interceptor);
    }

    public boolean isPlaying() {
        return this.isPlaying;
    }

    public static void main(String[] args) {
        CDPlayer cdPlayer = new CDPlayer();
        cdPlayer.addInterceptor(new PlaySongInterceptor());
        cdPlayer.play();
        cdPlayer.pause();
        cdPlayer.play();
        cdPlayer.stop();
    }
}
