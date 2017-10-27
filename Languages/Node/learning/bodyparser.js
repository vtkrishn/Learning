var express = require('express');
var app = express();
var bodyParser = require('body-parser');

//To parse URL encoded data
app.use(bodyParser.urlencoded({ extended: false }))

//To parse json data
app.use(bodyParser.json());

app.use('/static', express.static('public'));

app.listen(3000);
