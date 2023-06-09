package tw.idv.ixercise.report.control;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import com.google.gson.Gson;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import tw.idv.ixercise.report.entity.Message;
import tw.idv.ixercise.report.service.WebSocketServer;

@ServerEndpoint("/FriendWS/{accountId}")
@Controller
public class webSocketController {
	
	
	Gson gson=new Gson();
	



    private static Map<Integer,Session> sessionsMap = new ConcurrentHashMap<>();


@OnOpen
public void onOpen(@PathParam("accountId") Integer accountId, Session userSession) throws IOException {
	sessionsMap.put(accountId, userSession);
	System.out.println("open方法被調用");
	
	
	}




@OnMessage
public void onMessage(Session userSession, String message) {
	Message chatMessage = gson.fromJson(message, Message.class);
	Integer sender = chatMessage.getSender();
	Integer receiver = chatMessage.getReceiver();
	Timestamp messageTime = chatMessage.getMessageTime();
	
	if ("history".equals(chatMessage.getType())) {
		List<String> historyData = JedisHandleMessage.getHistoryMsg(sender, receiver);
		String historyMsg = gson.toJson(historyData);
		
			if(historyData.size()==0) {
				Message noHistory = new Message("new", sender, receiver, historyMsg);
				if (userSession != null && userSession.isOpen()) 
   					userSession.getAsyncRemote().sendText(gson.toJson(noHistory));
				return;
			}else {
				
				Message cmHistory = new Message("history", sender, receiver, historyMsg);
				
				if (userSession != null && userSession.isOpen()) {
					userSession.getAsyncRemote().sendText(gson.toJson(cmHistory));
					System.out.println("歷史紀錄");
					return;
					}
			
		
		}
			
	}
	
	
 	if("chat".equals(chatMessage.getType())) {
		System.err.println("chat被執行");
	Session receiverSession = sessionsMap.get(receiver);
	
	if (receiverSession != null && receiverSession.isOpen()) {
		JedisHandleMessage.saveChatMessage(sender, receiver, message);
		receiverSession.getAsyncRemote().sendText(message);
//		userSession.getAsyncRemote().sendText(message);

	}
}
	if("leave".equals(chatMessage.getType())) {
	Session receiverSession = sessionsMap.get(receiver);
	if (receiverSession != null && receiverSession.isOpen()) {
		receiverSession.getAsyncRemote().sendText(message);
//		userSession.getAsyncRemote().sendText(message);

	}
}
	
	
}



}
