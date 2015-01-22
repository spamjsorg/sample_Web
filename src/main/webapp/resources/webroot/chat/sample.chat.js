utils.define("sample.chat").extend('utils.viewmodel').as(function(chat,_instance_) {
	
	var stomp = utils.module('tunnel.stomp');
	var server = utils.module('tunnel.server');
	//model Initializer
	_instance_._init_ = function(){
		
		//Set View
		this.view('sample.chat.html');
		
		//Bind Model (2Way binding)
		this.model({
			message : { text : "" }, 
			msgs : []
		});
		console.log("MODEL==",this.model());
	};
	
	// DOM events
	_instance_.send_clicked = function(e){
		var self = this;
		server.post({
			api : "chat/send",
			data : self.model().message
		}).done(function(data,resp){
			self.model().message.text = "";
			self.model().msgs.push(data);
		});
//		stomp.on('onchatmessage',function(cm){
//			console.log('cm',cm);
//		});
	};
	
	chat._ready_ = function(){
		stomp.connect();
	};
});