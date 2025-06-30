package runrun.demo;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class RedisTestRunner {

    private final RedisService redisService;


    public RedisTestRunner(RedisService redisService) {
        this.redisService = redisService;
    }

    @PostConstruct
    public void run() {

    }
}
