//Dependencies
var express = require('express');
var http = require('http');
var path = require('path');
var socketIO = require('socket.io');
var gameLogic = require('./game-logic.js');
var bodyParser = require('body-parser');
var Data = require('./data.js').Data;
var config = require('./config.js');

//Initial setup
var data = new Data();
var app = express();
var server = http.Server(app);
var io = socketIO(server);
app.use(bodyParser.json());
app.use(bodyParser.urlencoded({extended: true}));
app.set('port', 8080);
app.use('/static', express.static(__dirname + '/static'));
app.use(express.json()); // to support JSON-encoded bodies

//Send index.html when navigating to the website.
//i.e you don't have to type "/index.html" in the url
app.get('/', function(request, response) {
  response.sendFile(path.join(__dirname, 'static/index.html'));
});

// Starts the server.
server.listen(8080, function() {
  console.log('Starting server on port 8080');
});

//Keep track of all players logged in
var players = []
//Initialize a dictionary to keep track of all games
var games = {};
//Keep track of time interval
var interval;

io.on('connection', function(socket) {

  var room = "FILLER_ROOM_NAME";
  var username = "FILLER_USERNAME";
  var gameOver = false;

  /**
   * Create a new room with a ball and no players
   */
  socket.on('new room', function(roomName) {
    room = roomName
    //If the room does not exist, create it
    if(!games[room]){
      games[room] = {
        ball:{
          x: config.ballReset.x,
          y: config.ballReset.y,
          isMoving: false,
          firstTick: false,
          trajX: 0,
          trajY: 0
        },
        players:{

        },
        playerKey: function(n) {
          return this.players[Object.keys(this.players)[n]]
        }
      }
    }
  });

  /**
   * Logged in player joins the game
   */
  socket.on('join room', function(data) {

    username = data.username;
    room = data.room;
    //Join room
    socket.join(room);

    gameOver = false;

    //Add the player 2 to the room
    if (games[room].playerKey(0)) {
      games[room].players[username] = {
        x: config.player2Start.x,
        y: config.player2Start.y,
        holdingBall: false,
        score: 0,
        movement: {
          up: false,
          down: false,
          left: false,
          right: false
        }
      };
    } else { //Player 1
      games[room].players[username] = {
        x: config.player1Start.x,
        y: config.player1Start.y,
        holdingBall: false,
        score: 0,
        movement: {
          up: false,
          down: false,
          left: false,
          right: false
        }
      };
    }

    //Emit the state of the game in 60fps
    interval = setInterval(function() {
      io.to(room).emit('state', games[room]);
    }, 1000 / 60);
  });

  //Handle game logic when client sends 'movement' request
  socket.on('movement', function(data) {

    //Store key press data
    if (games[room] && games[room].players[username]){
      games[room].players[username].movement = data.player;
    } else {
      return;
    }
    var game = games[room] || {};
    var data = new Data();
    //If a second player exists, update game
    if (game.playerKey(1)){

      //Check win condition
      if (username != "FILLER_USERNAME" && game.players[username].score >= config.winningScore) {
        io.to(room).emit('win', username);
        if (!gameOver) data.addWin(username);
        gameOver = true;
        return;
      }
      else if (game.playerKey(0).score  >= config.winningScore){
        io.to(room).emit('win', Object.keys(games[room].players)[0]);
        gameOver = true;
        return;
      }
      else if(game.playerKey(1).score  >= config.winningScore){
        io.to(room).emit('win', Object.keys(games[room].players)[1]);
        gameOver = true;
        return;
      }

      //Update Game
      gameLogic.updateGame(
        {
          player1: game.playerKey(0).movement, //Player 1 key press
          player2: game.playerKey(1).movement //Player 2 key press
        },
        game.playerKey(0), //Player 1 coordinates
        game.playerKey(1), //player 2 coordinates
        game.ball, //Ball coordinates
        Object.keys(game.players)[0], //Player 1 username
        Object.keys(game.players)[1] //Player 2 username
      );
    }
  });

  //Leave room
  socket.on('leave', function(){
    socket.leave(room);
    //sclearInterval(interval);
    console.log("Deleting "+username);
    if (username != "FILLER_USERNAME"){
      delete games[room].players[username];
      console.log(games[room].players);
    }
  });

});

/**
 * Log in.
 */
app.get('/login', function(request, response){
  data.once('playerData', function(msg){
    response.send(msg);
    //Add player to players object
    if (msg.length > 0){
      players.push(request.query.username);
    }
  });
  data.getPlayer(request.query.username);
});

/**
 * Create account.
 */
app.post('/create', function(request, response){
  //Get player to see if username already exists
  data.once('playerData', function(msg){
    //Player exists
    if (msg.length > 0){
      response.send({err:"Username already exists"});
    }
    //Player does not exist
    else{
      data.once('newPlayer', function(msg){
        response.send(msg);
      });
      data.createPlayer(request.body.username);
      //Add player to players object
      players.push(request.body.username);
    }
  });
  data.getPlayer(request.body.username);
});

/**
 * Get a list of rooms
 */
app.get('/rooms', function(request, response){
  let rooms = []
  for (var key in games){
    rooms.push({
      room: key,
      players: Object.keys(games[key].players).length
    })
  }
  response.send({rooms: rooms})
});
