package com.web.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webutils.annotations.HandlerScan;
import com.webutils.annotations.ModelScan;
import com.webutils.app.StompTunnelClient;
import com.webutils.app.WebAppClient;
import com.webutils.app.WebAppProperties;

@Service
@HandlerScan("com.web.handler")
@ModelScan("com.web.models")
public class AppClient extends WebAppClient {

	@Autowired
	public AppClient(WebAppProperties webAppProperties,
			StompTunnelClient stompTunnelClient) {
		super(webAppProperties, stompTunnelClient);
	}

}
