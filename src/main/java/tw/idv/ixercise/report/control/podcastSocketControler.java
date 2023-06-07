package tw.idv.ixercise.report.control;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.google.gson.Gson;

import redis.clients.jedis.Jedis;
import tw.idv.ixercise.report.entity.Message;
import tw.idv.ixercise.report.entity.Podcast;

@ServerEndpoint("/checkbell/{accountId}")
@Controller
public class podcastSocketControler {


	
	   Gson gson=new Gson();
	   
	   
	   private static Map<Integer,Session> sessionsMap = new ConcurrentHashMap<>();
	   
	   @OnOpen
	   public void onOpen(@PathParam("accountId") Integer accountId, Session userSession) throws IOException {
		   sessionsMap.put(accountId, userSession);
		   System.out.println(accountId);
		   System.out.println("open方法被調用");
	   
	   	}
	   
	

	   @OnMessage(maxMessageSize = 10485760)
	   public void onMessage(Session userSession, String podcast) {
		   System.out.println("onmessage被調用");
		   Podcast mypodcast = gson.fromJson( podcast, Podcast.class);
		   Integer acountId = mypodcast.getAcountId();
		   System.out.println("onmessage被調用");
	   	
	   	if ("history".equals(mypodcast.getType())) {
	   		
	   		List<String> historyData = PodcastMessage.getHistorypodcast(acountId);
	   		
	   		String historyMsg = gson.toJson(historyData);
	   			if(historyData .size()==0) {
	   			 System.out.println("沒歷史訊息");
	   				Podcast noHistory = new Podcast("new", historyMsg);
	   				if (userSession != null && userSession.isOpen()) 
	   					userSession.getAsyncRemote().sendText(gson.toJson(noHistory));
	   				return;
	   			}
	   				
	   			Podcast hasHistory = new Podcast("history", acountId , historyMsg);
	   			System.out.println("有");
	   				if (userSession != null && userSession.isOpen()) {
	   					userSession.getAsyncRemote().sendText(gson.toJson(hasHistory));
	   					System.out.println("history = " + gson.toJson(hasHistory));
	   					return;
	   			
	   		
	   		}
	   	}
	   	
	   	if("podcast".equals(mypodcast.getType())) {
	   	Session receiverSession = sessionsMap.get(acountId);
	   	if (receiverSession != null && receiverSession.isOpen()) {
	   		receiverSession.getAsyncRemote().sendText(podcast);
	   		mypodcast.setType("history");
	   		PodcastMessage.saveChatMessage(acountId,  podcast);
	   	}else {
	   		mypodcast.setType("history");
	   		PodcastMessage.saveChatMessage(acountId,  podcast);
	   	}
	   		
	   	
	   }

	   	
	   	
	   }
	   	
	
}
