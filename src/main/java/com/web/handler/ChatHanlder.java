package com.web.handler;

import com.web.models.ChatMessage;
import com.web.models.UserBean;
import com.webutils.abstracts.AbstractHandler;
import com.webutils.annotations.ActionHandler;
import com.webutils.annotations.HandlerAction;
import com.webutils.app.StompTunnelClient;

/**
 * THis is sampe test handler.
 *
 * @author <a mailto:lalit.tanwar07@gmail.com> Lalit Tanwar</a>
 * @version 1.0
 * @lastModified Aug 19, 2014
 */
@ActionHandler(name = "chat")
public class ChatHanlder extends AbstractHandler {
	
	@HandlerAction(name = "send")
	public ChatMessage auth(ChatMessage model, UserBean user) {

		System.out.println(model.getText());
		StompTunnelClient.send(model);
		return model;
	}
}
