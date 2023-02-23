package interceptor;

import java.util.ArrayList;
import java.util.List;

public class ConcreteInterceptor implements Interceptor {
    private List<Interceptor> interceptors = new ArrayList<>();

    @Override
    public void addInterceptor(Interceptor interceptor) {
        interceptors.add(interceptor);
    }

    public void play(String songTitle, String artistName) {
        System.out.println("Playing " + songTitle + " by " + artistName);
        // code to actually play the song goes here
    }

    public void pause() {
        System.out.println("Pausing the CD.");
        // code to pause the song goes here
    }

    public void stop() {
        System.out.println("Stopping the CD.");
        // code to stop the song goes here
    }
}
