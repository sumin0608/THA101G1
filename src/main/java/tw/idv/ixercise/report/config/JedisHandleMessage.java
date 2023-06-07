//package tw.idv.ixercise.report.config;
//
//import org.springframework.data.redis.core.RedisTemplate;
//
//public class JedisHandleMessage {
//
//	 private RedisTemplate redis;
//
//	
//
////	public static List<String> getHistoryMsg(String sender, String receiver) {
////		String key = new StringBuilder(sender).append(":").append(receiver).toString();
////		redis = null;
////		redis = pool.getResource();
////		List<String> historyData = jedis.lrange(key, 0, -1);
////		jedis.close();
////		return historyData;
////	}
////
////	public static void saveChatMessage(String sender, String receiver, String message) {
////		// 對雙方來說，都要各存著歷史聊天記錄
////		String senderKey = new StringBuilder(sender).append(":").append(receiver).toString();
////		String receiverKey = new StringBuilder(receiver).append(":").append(sender).toString();
////		Jedis jedis = pool.getResource();
////		jedis.rpush(senderKey, message);
////		jedis.rpush(receiverKey, message);
////
////		jedis.close();
//	}
//}
