'use strict';

var express = require('express');
var bodyParser = require('body-parser');
var request = require('request');

var app = express();
var token = "13";
app.set('port', (process.env.PORT || 5000));

app.use(bodyParser.urlencoded({extended: false}));
app.use(bodyParser.json());


app.get('/', function(req,res){
    res.send("Hi I am a chatbot");
});

app.get('/webhook/',function(req,res){
    if(req.query['hub.verify_token'] === "vtkrishn")
        res.send(req.query['hub.challenge']);
    res.send("wrong token");
});

app.get('/webhook/',function(req,res){
	var messagin_events = req.body.entry[0].messaging_events;
	for(var i=0;i<messagin_events.length;i++){
		var event = messagin_events[i];
		var sender = event.sender.id;
		if(event.message && event.message.text){
			var text = event.message.text;
			sendText(sender, "Text echos: " + text.substring(0,100));
		}
	}
	res.sendStatus(200);
});

function sendText(sender, text){
	var messageData = {text:text};
	request({
		url : "https://graph.facebook.com/v2.6/me/messages",
		qs : {access_token: token},
		method : "POST",
		json : {
			recipient: {id : sender},
			message : messageData
		}
	}, function(error,response,body){
		if(error){
			console.log("sendng error");
		}
		else if(response.body.error){
			console.log("response body error");
		}
	});
}

app.listen(app.get('port'),function(){
   console.log("running : port");        
});