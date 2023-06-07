package tw.idv.ixercise.report.service;

import javax.websocket.server.ServerEndpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.google.gson.Gson;

import tw.idv.ixercise.report.config.GetHttpSessionConfigurator;
import tw.idv.ixercise.report.config.MessageUtil;
import tw.idv.ixercise.report.entity.Comment;
import tw.idv.ixercise.report.entity.Message;

import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.http.HttpSession;
import javax.websocket.CloseReason;
import javax.websocket.EndpointConfig;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;




@ServerEndpoint(value="/chattogether" ,configurator =GetHttpSessionConfigurator.class )
@Component
public class WebSocketServer {
	

	
	
	private Session session;
	private HttpSession httpsession;
	
	private static Map<Integer,WebSocketServer> onlineUsers = new ConcurrentHashMap<>();
	
//用暱稱登入	
//	@OnOpen
//	public void onOpen(Session session,@PathParam("username") String userName) throws IOException {
//		System.out.println("onOpen被啟動 "+userName+"你好" );
//		this.session=session;
//		
//	}
	

	@OnOpen
	public void onOpen(Session session,EndpointConfig config) throws IOException {
		System.out.println("onOpen被啟動 你好" );
//		this.session=session;
//		HttpSession httpsession=(HttpSession )config.getUserProperties().get(HttpSession.class.getName());
//		this. httpsession=httpsession;
		
// 從session對象獲取用戶名		String username=(String)HttpSession.getAttribute("user");
		
//	將當前對象封裝在容器裡	onlineusers.put(username, this);
		
		
		
//		String message = MessageUtil.getMessage(true,null,getmemberId());
//		broadcastAll(message);
		
	}
	
	private void broadcastAll( String message) {
		try {
			Set<Integer> memberIds=onlineUsers.keySet();
			for(Integer memberId: memberIds) {
				WebSocketServer Server = onlineUsers.get( memberId);
				Server.session.getBasicRemote().sendText(message);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
	private Set<Integer> getmemberId(){
		return  onlineUsers.keySet();
	}

	@OnMessage
	public void onMessage(Session userSession,String userName ) {
		System.out.println("onMessage被啟動 " );
//		System.out.println(Message);
//		sys
		}
		
		
	

/*歷史聊天紀錄
	Session receiverSession = sessionsMap.get(receiver);
	if (receiverSession != null && receiverSession.isOpen()) {
		receiverSession.getAsyncRemote().sendText(message);
		userSession.getAsyncRemote().sendText(message);
	}
		JedisHandleMessage.saveChatMessage(sender, receiver, message);
	System.out.println("Message received: " + message);
}

	*/
	
	@OnError
	public void onError(Session userSession, Throwable e) {
		System.out.println("Error: " + e.toString());
	}

	@OnClose
	public void onClose(Session userSession, CloseReason reason) {
		System.out.println("onClose被啟動 " );
	}

	
	
}
