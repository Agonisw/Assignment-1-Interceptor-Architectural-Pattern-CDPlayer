package interceptor;

public class PlaySongInterceptor implements Interceptor {
    @Override
    public void addInterceptor(Interceptor interceptor) {
        // No need to add additional interceptors to this interceptor
    }

    public void play(String songTitle, String artistName, ContextObject context) {
        System.out.println("Intercepting play request for song: " + songTitle + " by " + artistName);
        context.setSongTitle(songTitle);
        context.setArtistName(artistName);
    }
}
