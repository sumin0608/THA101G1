package tw.idv.ixercise.report.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;



@Component
public class Redisexample {


	
	 private RedisTemplate<String, String> redisTemplate;

	    @Autowired
	    public void MyRedisComponent(RedisTemplate<String, String> redisTemplate) {
	        this.redisTemplate = redisTemplate;
	    }

	    // 使用 RedisTemplate 進行 Redis 操作的方法
	    public void setKey(String key, String value) {
	        redisTemplate.opsForValue().set(key, value);
	    }

	    public String getValue(String key) {
	        return redisTemplate.opsForValue().get(key);
	    }
	}

