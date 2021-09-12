var express = require('express');
var app = express();
app.use(express.static("."));

app.listen(8080,function(){
    console.log('Server started at localhost:8080');
});

app.get('/', function(req, res){
    res.redirect('./index.html');
});

var calc = require('./modules/computer.js');
var computer = new calc();

app.get('/part3', function(req, res){
    var result = computer.render();
    res.send(result);
});

app.get('/fac', function(req, res){
    var input = req.query.input;
    var result = computer.computeFactorial(input);
    res.send(result);
});

app.get('/sum', function(req, res){
    var input = req.query.input;
    var result = computer.computeSummation(input);
    res.send(result);
});

var w = require('./modules/weather.js');
var weather = new w();

app.get('/part4', function(req, res){
    var result = weather.Render();
    res.send(result);
});

app.get('/weather', function(req, res){
    var zip = req.query.zipcode;
    weather.getWeather(zip);
    weather.once('done', function(msg){
        res.send(msg);
    })
});