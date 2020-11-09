package server.remote.intercepetors;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.stereotype.Component;

@Component
public class ClientAInterceptor implements RequestInterceptor {
    @Override
    public void apply(RequestTemplate input) {
        input.header("name", "value");
        //....
    }
}
