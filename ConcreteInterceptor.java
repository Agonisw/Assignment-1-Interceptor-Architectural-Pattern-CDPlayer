package interceptor;

public class ConcreteInterceptor implements Interceptor {
    public void execute(ContextObject context) {
        System.out.println("ConcreteInterceptor executing...");

        // Set the output data to a hardcoded value for testing purposes
        context.setOutputData("output data");
    }
}
