package server.controller;

import cn.clienta.api.entity.UserDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import server.remote.ClientAFeignClient;


@RestController
@RequestMapping("/testRemoteCall")
public class OrderController {

    private final ClientAFeignClient clientAFeignClient;

    public OrderController(ClientAFeignClient clientAFeignClient) {
        this.clientAFeignClient = clientAFeignClient;
    }

    @PostMapping("/printUser")
    public ResponseEntity<UserDTO> printUser() {
        return clientAFeignClient.getUser();
    }

}
