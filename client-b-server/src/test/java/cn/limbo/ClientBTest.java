package cn.limbo;

import cn.clienta.api.entity.UserDTO;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import server.ClientB;
import server.remote.ClientAFeignClient;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ClientB.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@AutoConfigureJsonTesters
@Slf4j
@AutoConfigureStubRunner(ids = {"org.example:client-a-server:1.0:stubs"}, stubsMode = StubRunnerProperties.StubsMode.CLASSPATH)
public class ClientBTest {

    @Autowired
    private ClientAFeignClient feignClient;

    @Test
    public void testGetUser() {
        ResponseEntity<UserDTO> dtoResponseEntity = feignClient.getUser();
        log.info("Entity={}", dtoResponseEntity);
    }
}
