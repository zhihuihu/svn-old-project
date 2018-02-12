package com.hxkj.websocket.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig extends AbstractWebSocketMessageBrokerConfigurer {

	@Override    
    public void registerStompEndpoints(StompEndpointRegistry registry) {        
        registry.addEndpoint("/socket").withSockJS()
        .setInterceptors( new ChatHandlerShareInterceptor())
        .setStreamBytesLimit(512 * 1024)
        .setHttpMessageCacheSize(1000)
        .setDisconnectDelay(30 * 1000);;       
    }    
	
    @Override    
    public void configureMessageBroker(MessageBrokerRegistry registry) {  
        registry.enableSimpleBroker("/topic","/user");  
        registry.setApplicationDestinationPrefixes("/app"); 
        //registry.setPathMatcher(new AntPathMatcher("."));
    }

}
