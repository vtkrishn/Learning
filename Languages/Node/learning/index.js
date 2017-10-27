var express = require('express');
var app = express();

var things = require('./router.js');


//URL Building
//app.get('/:id', function(req, res){
//   res.send('The id you specified is ' + req.params.id);
//});

app.get('/things/:name/:id', function(req, res) {
   res.send('id: ' + req.params.id + ' and name: ' + req.params.name);
});

app.get('/things/:id([0-9]{5})', function(req, res){
   res.send('id: ' + req.params.id);
});

//Other routes here
//app.get('*', function(req, res){
//   res.send('Sorry, this is an invalid URL.');
//});

app.use('/middle', function(req, res, next){
   console.log("A request for things received at " + Date.now());
   next();
});

// Route handler that sends the response
app.get('/middle', function(req, res){
   res.send('middleware');
});

//for ROUTER usage
//both index.js and things.js should be in same directory
app.use('/things', things);

app.listen(3000);
