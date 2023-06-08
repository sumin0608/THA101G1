package tw.idv.ixercise.report.control;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import tw.idv.ixercise.report.entity.Message;

@RestController
public class messageController {

	@Autowired
	@Qualifier("redisTemplate")
	private RedisTemplate redistemplate;
	
	@PostMapping("/set")
	public void set(@RequestBody Message message) {
//		System.out.println(message.getMessage());
//		redistemplate.opsForValue().set("message", message);
		 redistemplate.opsForList().leftPush("messages", message);
		 System.out.println(message);
		 System.err.println( redistemplate);
//		 return 1;
//		System.out.println(message);
	}
	
	@GetMapping("/get/{key}")
	public List<Message> get(@PathVariable("key") String key) {
//		return (Message)redistemplate.opsForValue().get(key);
//		return redistemplate.opsForList().range(key, 0, -1);
		return null;
	}
}
