'use strict';

var express = require('express');
var body = require('body-parser');
var request = require('request');

var app = express();

app.set('port', (process.env.PORT || 5000));

app.use(body.urlenconder({extended: false}));
app.use(body.json());


app.get('/', function(req,res){
    res.send("Hi I am chatbot");
});

app.get('/webhook/',function(req,res){
    if(req.query['hub.verify_token'] === "vtkrishn")
        res.send(req.query('hub.challenge'));
    res.send("Wrong Token");
});

app.listen(app.get('port'),function(){
   console.log("running : port");        
});