package tw.idv.ixercise.report.config;

import javax.servlet.http.HttpSession;
import javax.websocket.HandshakeResponse;
import javax.websocket.server.HandshakeRequest;
import javax.websocket.server.ServerEndpointConfig;

import org.apache.tomcat.websocket.server.DefaultServerEndpointConfigurator;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

public class GetHttpSessionConfigurator extends  ServerEndpointConfig.Configurator {

	@Override
	public void modifyHandshake(ServerEndpointConfig sec, HandshakeRequest request, HandshakeResponse response) {
		
		super.modifyHandshake(sec, request, response);
	HttpSession httpsession=(HttpSession )request.getHttpSession();
	sec.getUserProperties().put(HttpSession.class.getName(), httpsession);
	}
	
	

}
