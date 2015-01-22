utils.define("sample.login").extend('utils.viewmodel').as(function(login,_instance_) {
	
	var server = utils.module('tunnel.server');
	
	login._instance_ = function(obj){
		this._login_ = obj.onLogin;
		this._def_ = obj.def || {};
		console.log("obj",obj);
	};
	//model Initializer
	_instance_._init_ = function(){
		//Set View
		this.view('sample.login.html');
		
		//Bind Model (2Way binding)
		this.model({
			username : "" || this._def_.username, 
			password : ""|| this._def_.password,
			company : "",
			status : ""
		});
		console.log("MODEL==",this.model());
		if(this._def_.auto){
			this.login_clicked();
		}
	};
		
	// DOM events
	_instance_.login_clicked = function(e){
		var self = this;
		server.post({
			api : "user/authByCompany",
			data : self.model()
		}).done(function(data,resp){
			console.log("RESPONSE FROM SERVER==",data,resp);
			//SET VALUE TO MODEL
			self.model().status = data.status;
			if(resp.success){
				if(self._login_) self._login_(self.model());
			}
		});
	};
});