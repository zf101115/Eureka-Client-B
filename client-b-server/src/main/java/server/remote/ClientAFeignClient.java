package server.remote;

import cn.clienta.api.entity.UserDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import server.remote.fallback.HystrixClientFallbackFactory;

@FeignClient(value = "Client-A", fallbackFactory = HystrixClientFallbackFactory.class)
public interface ClientAFeignClient {

    @PostMapping("/user/getUser")
    ResponseEntity<UserDTO> getUser();

}
