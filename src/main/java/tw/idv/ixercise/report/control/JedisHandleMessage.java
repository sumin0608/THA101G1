package tw.idv.ixercise.report.control;

import java.util.List;

import redis.clients.jedis.Jedis;

public class JedisHandleMessage {


		// 此範例key的設計為(發送者名稱:接收者名稱)，實際應採用(發送者會員編號:接收者會員編號)


		public static List<String> getHistoryMsg(Integer sender, Integer receiver) {
			Jedis jedis = new Jedis();
			List<String> historyData=null;
			if(sender==5) {
				String key = new StringBuilder(sender).append(":").append(receiver).toString();
				
				 historyData = jedis.lrange(key, 0, -1);
			}else {
				
				String key = new StringBuilder(receiver).append(":").append(sender).toString();
				
				 historyData = jedis.lrange(key, 0, -1);
			}
			jedis.close();
			return historyData;
		}

		public static void saveChatMessage(Integer sender,Integer receiver, String message) {
			Jedis jedis = new Jedis();
			System.out.println("jedis被創建");
			if(sender==5){
				
				String senderKey = new StringBuilder(sender).append(":").append(receiver).toString();
				jedis.rpush(senderKey, message);
				System.out.println("管理員被儲存");
		
				
			}else {
				String receiverKey = new StringBuilder(receiver).append(":").append(sender).toString();
				jedis.rpush(receiverKey, message);
				System.out.println("使用者被儲存");
			}
			

			jedis.close();
		}

	}


