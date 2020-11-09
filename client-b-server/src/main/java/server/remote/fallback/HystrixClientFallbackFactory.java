package server.remote.fallback;

import cn.clienta.api.entity.UserDTO;
import feign.hystrix.FallbackFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import server.remote.ClientAFeignClient;

@Component
public class HystrixClientFallbackFactory implements FallbackFactory<ClientAFeignClient> {

    @Override
    public ClientAFeignClient create(Throwable throwable) {
        return () -> ResponseEntity.ok(new UserDTO());
    }

}
