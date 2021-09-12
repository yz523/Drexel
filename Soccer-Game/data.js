'use strict'

var mysql = require('mysql');
var EventEmitter = require('events').EventEmitter;

//Setup database connection
var con = mysql.createConnection({
    host: 'den1.mysql3.gear.host',
    user: 'playerstats',
    password: 'Ve7ZV8!H~lb8',
    database: 'playerstats',
    multipleStatements: true
});

con.connect(function(err) {
    if (err) throw err;
    console.log("Connected!");
});

class Data extends EventEmitter{

    constructor(){
        super();
    }

    /**
     * Get player from players table
     */
    getPlayer(username){
        var self = this;
        con.query('SELECT * FROM players WHERE id="'+username+'"',
            function(err,rows,fields) {
                if (err){
                    console.log('Error during query processing');
                    console.log(err);
                } else {
                    self.emit('playerData', rows);
                }
            }
        );
    }

    /**
     * Creates new player
     */
    createPlayer(username){
        var self = this;
        con.query('INSERT INTO players (id, win, lose, goal) VALUES ("'+username+'", 0, 0, 0); SELECT * FROM players WHERE id="'+username+'"',
            function(err,rows,fields) {
                if (err){
                    console.log('Error during query processing');
                    console.log(err);
                } else {
                    self.emit('newPlayer', rows);
                }
            }
        );
    }

    /**
     * Add win
     */
    addWin(username){
        con.query('UPDATE players SET win = win + 1 WHERE id = "'+username+'";',
            function(err,rows,fields) {
                if (err){
                    console.log('Error during query processing');
                    console.log(err);
                }
            }
        );
    }

    /**
     * Add goal
     */
    addGoal(username){
        con.query('UPDATE players SET goal = goal + 1 WHERE id = "'+username+'";',
            function(err,rows,fields) {
                if (err){
                    console.log('Error during query processing');
                    console.log(err);
                }
            }
        );
    }
}
module.exports.Data = Data;