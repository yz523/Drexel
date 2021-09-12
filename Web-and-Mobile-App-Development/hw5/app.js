var express = require('express');
var app = express();
app.use(express.static("."));

app.listen(8080,function(){
    console.log('Server started at localhost:8080');
});

app.get('/', function(req, res){
    res.redirect('./index.html');
});

var u = require('./modules/hw5.js');
var university = new u();

app.get('/render', function(req, res){
    var result = university.Render();
    res.send(result);
});

app.get('/getTable', function(req, res){
    var sel = req.query.sel;
    university.getTable(sel);
    university.once('done', function(msg){
        res.send(msg);
    })
});

app.get('/getTable2', function(req, res) {
    var sel1 = req.query.sel1;
    var sel2 = req.query.sel2;
    university.getTable2(sel1, sel2);
    university.once('done', function (msg) {
        res.send(msg);
    })
});