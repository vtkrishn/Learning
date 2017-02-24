 var http = require("http");
// http.createServer(function(request,response){
// response.writeHead(200,{'Content-Type' : 'text/plain'});
// response.end("Hello World");
// }).listen(8081);

// console.log("Server running at 8081");

//Blocking
 var fs = require("fs");
// var data = fs.readFileSync("style.css");
// console.log(data.toString());


//Non Blocking
// console.log("Non Blocking");
// fs.readFile('style.css',function(err,data){
// 	if(err) return console.error("sssssssss"+err);
// 		console.log(data.toString());
// });

//events
// Import events module
 var events = require('events');


// // Create an eventEmitter object
// var eventEmitter = new events.EventEmitter();

// // Create an event handler as follows
// var connectHandler = function connected() {
//    console.log('connection succesful.');
  
//    // Fire the data_received event 
//    eventEmitter.emit('data');
// }

// // Bind the connection event with the handler
// eventEmitter.on('connection', connectHandler);
 
// // Bind the data_received event with the anonymous function
// eventEmitter.on('data', function(){
//    console.log('data received succesfully.');
// });

// // Fire the connection event 
// eventEmitter.emit('connection');

// console.log("Program Ended.");

//Buffer
// var buf = new Buffer(256);
// // len = buf.write("Simple and Easy");
// // console.log("write ::"+ len);

// for(var i=0;i<256;i++){
// 	buf[i] = i;
// }

// console.log(buf.toString('ascii',0,10));

var url = require('url');
// http.createServer(function(request,response){

// var path = url.parse(request.url).pathname;
// console.log("Request for " +path+ " received");

// fs.readFile(path.substr(1),function(err,data){
// 	if(err){
// 		console.log(err);
// 		response.writeHead(404, {'Content-Type' : 'text/html'});
// 	}

// 	response.writeHead(200, {'Content-Type' : 'text/html'});

// 	response.write(data.toString());

// 	response.end();
// });

// }).listen(8081);

// console.log("Server running at http://127.0.0.1:8081");

var express  = require("express");
var app = express();

 var mongo = require("mongojs");
  var db = mongo('test',['user']);

//to server static files
app.use(express.static('public'));

var userList;
db.user.find({ _id : mongo.ObjectId("57f49f12453f3169b47816b3")},function(err,docs) 
   {
 	userList = docs;
   });

app.get('/',function(req,res){
	res.send(userList);
});

app.get('/index.html',function(req,res){
	var path = url.parse(req.url).pathname;
	res.send(path);
});


var server = app.listen(8081,function(){
	var host = server.address().address;
	var port = server.address().port;

	console.log("Server running at http://127.0.0.1:8081");
});

 
