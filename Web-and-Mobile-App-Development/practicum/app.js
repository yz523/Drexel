var express = require('express');
var app = express();
app.use(express.static("."));
app.listen(8080,function(){
    console.log('Server started at localhost:8080');
});

app.get('/', function(req, res){
    res.redirect('./index.html');
});

app.get('/part2', function(req, res){
    var msg = req.query.message;
    var c = req.query.count;
    var result = "";
    for (var i = 0; i < c; i++) {
        result += msg;
    }
    res.send(result);
});
