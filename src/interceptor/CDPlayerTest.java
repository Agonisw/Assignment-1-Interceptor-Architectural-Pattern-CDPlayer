package interceptor;

import org.junit.Test;
import static org.junit.Assert.*;

public class CDPlayerTest {
    @Test
    public void testPause() {
        CDPlayer cdPlayer = new CDPlayer();
        cdPlayer.addInterceptor(new ConcreteInterceptor());

        cdPlayer.play();
        cdPlayer.pause();
        assertFalse("CD is not paused", cdPlayer.isPlaying);
    }

    @Test
    public void testStop() {
        CDPlayer cdPlayer = new CDPlayer();
        cdPlayer.addInterceptor(new ConcreteInterceptor());

        cdPlayer.play();
        cdPlayer.stop();
        assertFalse("CD is not stopped", cdPlayer.isPlaying);
    }

    @Test
    public void testPlay() {
        CDPlayer cdPlayer = new CDPlayer();
        PlaySongInterceptor interceptor = new PlaySongInterceptor();
        ContextObject context = new ContextObject();
        interceptor.play("Wake Me Up", "Avicii", context);
        cdPlayer.addInterceptor(interceptor);
        cdPlayer.play();

        assertTrue(cdPlayer.isPlaying());
        assertEquals("Wake Me Up", context.getSongTitle());
        assertEquals("Avicii", context.getArtistName());
    }
}
