package com.web.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webutils.AbstractWebAppClient;
import com.webutils.annotations.AppProperties;
import com.webutils.annotations.HandlerScan;
import com.webutils.annotations.ModelScan;

@Service
@HandlerScan("com.web.handler")
@ModelScan("com.web.models")
@AppProperties("application.properties")
public class AppClient extends AbstractWebAppClient {

	public AppClient() {
		super();
	}

	@Autowired
	private MessageClient messageClient;

}
