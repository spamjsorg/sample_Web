package com.web.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;

import com.web.app.AppClient;
import com.web.app.MessageClient;
import com.web.models.Greeting;
import com.web.models.AuthResponse;
import com.webutils.AbstractResponse;
import com.webutils.WebAppContext;
import com.webutils.WebSockRequest;

@Controller
@MessageMapping("/action")
public class SockController {

	@Autowired
	public AppClient rxController;

	@MessageMapping("/hello")
	@SendTo("/event/greetings")
	public Greeting greeting(AuthResponse message) throws Exception {
		// Thread.sleep(3000); // simulated delay
		return new Greeting("Hello, " + "!");
	}

	@MessageMapping("/wsr/{handlerName}/{actionName}")
	public AbstractResponse wrappedRequest(WebSockRequest webSockRequest,
			@DestinationVariable("handlerName") String handlerName,
			@DestinationVariable("actionName") String actionName, Message<Object> message)
			throws Exception {
		Principal principal = message.getHeaders().get(SimpMessageHeaderAccessor.USER_HEADER, Principal.class);
	    String authedSender = principal.getName();
		WebAppContext.setRequestContext(webSockRequest);
		return rxController.invokeHanldler(handlerName, actionName, webSockRequest.getData());
	}

}
