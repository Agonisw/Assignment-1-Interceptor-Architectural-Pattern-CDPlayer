package interceptor;

import java.util.ArrayList;
import java.util.List;

public class Dispatcher {
    private List<Interceptor> interceptors;

    public Dispatcher() {
        interceptors = new ArrayList<>();
    }

    public void addInterceptor(Interceptor interceptor) {
        interceptors.add(interceptor);
    }

    public void dispatch(ContextObject context, String method, Object object) {
        for (Interceptor interceptor : interceptors) {
            if (interceptor instanceof ConcreteInterceptor) {
                ConcreteInterceptor concreteInterceptor = (ConcreteInterceptor) interceptor;
                switch (method) {
                    case "play":
                        concreteInterceptor.play(context.getSongTitle(), context.getArtistName());
                        break;
                    case "pause":
                        concreteInterceptor.pause();
                        break;
                    case "stop":
                        concreteInterceptor.stop();
                        break;
                    default:
                        System.out.println("Unsupported method: " + method);
                        break;
                }
            } else {
                interceptor.addInterceptor((Interceptor) object);
            }
        }
    }
}
