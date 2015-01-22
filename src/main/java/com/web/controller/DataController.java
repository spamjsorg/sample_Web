package com.web.controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.web.app.AppClient;
import com.web.models.AuthResponse;
import com.web.models.UserBean;
import com.webutils.HandlerResponse;
import com.webutils.WebAppContext;
import com.webutils.WebSockRequest;

@Controller
public class DataController {

	@Autowired
	public AppClient appClient;

	@RequestMapping(value = "/json/auth", method = RequestMethod.GET)
	@ResponseBody
	public AuthResponse home(ModelAndView modelAndView,
			HttpServletRequest request, @RequestParam String username,
			@RequestParam String password) throws IOException {
		AuthResponse hm = new AuthResponse();
		UserBean user = (UserBean) WebAppContext.getUser();
		user.setUserName(username);
		user.setPassword(password);
		user.auth(username, password);
		if (user.isValid()) {
			hm.setSessionID(user.getSessionID());
			hm.setSuccess(true);
		}
		return hm;
	}

	@RequestMapping(value = "/data/{handlerName}/{actionName}", method = RequestMethod.POST)
	@ResponseBody
	public HandlerResponse data(String data,
			@PathVariable("handlerName") String handlerName,
			@PathVariable("actionName") String actionName, HttpServletRequest req)
			throws IOException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException {
		//WebAppContext.setRequestContext(message);
		return appClient.invokeHanldler(handlerName, actionName, data);
	}
}
