package tw.idv.ixercise.report.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import redis.clients.jedis.Jedis;


@Service
public class PodcastMessage {
	

	public static void saveChatMessage(Integer accountId, String podcast) {
		Jedis jedis = new Jedis();
	
			
			String receiverKey = new StringBuilder(accountId).append("_").toString();
			String  kepper=new StringBuilder("4").append("_").toString();
			jedis.rpush(receiverKey, podcast);
			jedis.rpush(kepper, podcast);
			System.out.println("有被保存");
			jedis.close();
	}
	
	
	public static  List<String> getHistorypodcast(Integer accountId) {
			Jedis jedis = new Jedis();
	
			String key = new StringBuilder(accountId).append("_").toString();
			System.out.println(key);
			
			jedis.close();
			return jedis.lrange(key, 0, -1);
			
			
	
	}
	
	
}
