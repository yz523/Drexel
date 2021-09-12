var EventEmitter = require('events').EventEmitter;
var utils = require('util');
var fs = require('fs');
var http = require('http');
var request = require('request');
function weather()
{
    EventEmitter.call(this);
}

weather.prototype.Render= function(){
    var page = fs.readFileSync('./modules/weather.html');
    return(page);
}


weather.prototype.getWeather = function(zipcode) {
    var key = fs.readFileSync('./modules/key.txt');
    var URL = "https://api.openweathermap.org/data/2.5/forecast?zip="+zipcode+"&appid="+key;
    var self = this;
    request(URL, function(error, response, body) {
        var json = JSON.parse(body);
        var table = "<table class='table'><thead><tr><th scope='col'>#</th><th scope='col'>Date and Time</th><th scope='col'>Weather description</th><th scope='col'>Temp (deg. F)</th></tr></thead><tbody>";
        if(json.list != undefined) {
            for (var i = 0; i < json.list.length; i++) {
                table = table + "<tr><th scope='row'>" + (i + 1) + "</th><td>" + json.list[i].dt_txt + "</td><td>" + json.list[i].weather[0].description + "</td><td>" + json.list[i].main.temp + "</td></tr>";
            }
            table = table + "</tbody></table>";
            self.emit('done', table);
        }
        else{
            self.emit('done', "Invalid API key or Zip code.");
        }
    });
}

utils.inherits(weather, EventEmitter);
module.exports = weather;