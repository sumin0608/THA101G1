package tw.idv.ixercise.report.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

@Configuration
public class WebSocketConfig {
	
	@Bean
	public ServerEndpointExporter serverwndpointexporter() {
		return new ServerEndpointExporter();
	}

}
