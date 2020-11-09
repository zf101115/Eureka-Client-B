package server.remote.handler;

import feign.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

@Component
@SuppressWarnings("unused")
public class GlobalFeignErrorHandler {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    public Exception decode(Response response) {

        switch (response.status()) {
            case 400:
                logger.error("xxxx");
            case 404: {
                logger.error("xxxx");
                return new ResponseStatusException(HttpStatus.valueOf(response.status()), "XXXX");
            }
            default:
                return new Exception(response.reason());
        }
    }
}
