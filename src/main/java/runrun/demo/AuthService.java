package runrun.demo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.UUID;

@Service
public class AuthService {

    private final StringRedisTemplate redisTemplate;
    private final ObjectMapper objectMapper;

    public AuthService(StringRedisTemplate redisTemplate, ObjectMapper objectMapper) {
        this.redisTemplate = redisTemplate;
        this.objectMapper = objectMapper;
    }

    public String login(User user) {
        String token = UUID.randomUUID().toString();
        try {
            String json = objectMapper.writeValueAsString(user);
            redisTemplate.opsForValue().set(token, json, Duration.ofMinutes(30));
            return token;
        } catch (JsonProcessingException e) {
            throw new RuntimeException("login 오류",e);
        }
    }

    public User getUserByToken(String token) {
        String json = redisTemplate.opsForValue().get(token);
        try {
            if (json == null) {
                return null;
            }
            return objectMapper.readValue(json, User.class);

        } catch (JsonProcessingException e) {
                throw new RuntimeException("파싱오류",e);
            }
        }

    public void logout(String token) {
        redisTemplate.delete(token);
    }

}
