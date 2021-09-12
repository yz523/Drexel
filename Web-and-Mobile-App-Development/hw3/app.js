var express = require('express');
var app = express();
app.use(express.static("."));
app.listen(8080,function(){
    console.log('Server started at localhost:8080');
});

app.get('/', function(req, res){
    res.redirect('./yz523_HW3.html');
});

app.get('/fac', function(req, res){
    var input = req.query.input;
    if(input<0){
        res.send("Please enter a non-negative integer");
    }
    else if(input==""){
        res.send("Please enter an integer");
    }
    else{
        var r = 1;
        for(var i=1;i<=input;i++){
            r=r*i;
        }
        res.send(r.toString());
    }
});

app.get('/sum', function(req, res){
    var input = req.query.input;
    if(input<0){
        res.send("Please enter a non-negative integer");
    }
    else if(input==""){
        res.send("Please enter an integer");
    }
    else{
        var r = 0;
        for(var i=1;i<=input;i++){
            r=r+i;
        }
        res.send(r.toString());
    }
});
