var EventEmitter = require('events').EventEmitter;
var utils = require('util');
var fs = require('fs');

function computer()
{
    EventEmitter.call(this);
}

computer.prototype.render= function(){
    var page = fs.readFileSync('./modules/computer.html');
    return (page);
}

computer.prototype.computeFactorial = function(n) {
    if(n<0){
        return("Please enter a non-negative integer");
    }
    else if(n==""){
        return("Please enter an integer");
    }
    else{
        var r = 1;
        for(var i=1;i<=n;i++){
            r=r*i;
        }
        return(r.toString());
    }
}

computer.prototype.computeSummation = function(n) {
    if(n<0){
        return("Please enter a non-negative integer");
    }
    else if(n==""){
        return("Please enter an integer");
    }
    else{
        var r = 0;
        for(var i=1;i<=n;i++){
            r=r+i;
        }
        return(r.toString());
    }
}

utils.inherits(computer, EventEmitter);
module.exports = computer;