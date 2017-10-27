var express = require('express');
var app = express();

//to get the router from the  browser
app.get('/hello', function(req, res){
   res.send("Hello world!");
});

//use 
//curl -X POST "http://localhost:3000/hello"
app.post('/hello', function(req, res){
   res.send("You just called the post method at '/hello'!\n");
});


//for any remaining router
app.all('/test', function(req, res){
   res.send("HTTP method doesn't have any effect on this route!");
});

app.listen(3000);	
