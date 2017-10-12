'use strict';

const express = require('express');
const body = require('body-parser');
const request = require('request');

const app = express();

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

app.listen(app.get('port'),functioon(){
   console.log("running : port");        
});