package com.web.handler;

import org.springframework.beans.factory.annotation.Autowired;

import com.web.app.MessageClient;
import com.web.models.ChatMessage;
import com.web.models.UserBean;
import com.webutils.AbstractHandler;
import com.webutils.annotations.ActionHandler;
import com.webutils.annotations.HandlerAction;

/**
 * THis is sampe test handler.
 *
 * @author <a mailto:lalit.tanwar07@gmail.com> Lalit Tanwar</a>
 * @version 1.0
 * @lastModified Aug 19, 2014
 */
@ActionHandler(name = "chat")
public class ChatHanlder extends AbstractHandler {
	
	@Autowired
	MessageClient messageClient;

	@HandlerAction(name = "send")
	public ChatMessage auth(ChatMessage model, UserBean user) {

		System.out.println(model.getText());
		MessageClient.send("messages", model);
		return model;
	}
}
