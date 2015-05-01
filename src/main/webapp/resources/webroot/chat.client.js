utils.define("chat.client").extend("spamjs.module").as(function(client,_client_) {
	
	utils.require(':jqgeeks/jquery-ui',":jqgeeks/bootstrap");
	
	var stomp = utils.module('tunnel.stomp');
	
	
	_client_._init_ = function(){
		
		
	};
	
	/**
	 * _ready_ method is triggered when module is loaded and
	 * doc is ready to handler DOM operations
	 */
	client._ready_ = function(){
		client.instance().init();
	};
});