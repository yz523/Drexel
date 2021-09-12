//Keep track of logged in user
var username;
//Define socket.io object
var socket = io();
//keep track of interval
var interval;
//Set up player object. This will not necessarily be just movement data
var player = {
  up: false,
  down: false,
  left: false,
  right: false,
  space : false,
  mouseX: 0,
  mouseY: 0
}

var myCanvas = document.getElementById('canvas');

//Listen to key down
document.addEventListener('keydown', function(event) {
  switch (event.keyCode) {
    case 65: // A
      player.left = true;
      break;
    case 87: // W
      player.up = true;
      break;
    case 68: // D
      player.right = true;
      break;
    case 83: // S
      player.down = true;
      break;
    case 32: // Space
      player.space = true;
      break;
  }
});

//Listen to key up
document.addEventListener('keyup', function(event) {
  switch (event.keyCode) {
    case 65: // A
      player.left = false;
      break;
    case 87: // W
      player.up = false;
      break;
    case 68: // D
      player.right = false;
      break;
    case 83: // S
      player.down = false;
      break;
    case 32: // Space
      player.space = false;
      break;
  }
});

var canvas = document.getElementById('canvas');
var context = canvas.getContext('2d');

canvas.addEventListener("mousemove", function (evt) {
    var mousePos = getMousePos(canvas, evt);
    player.mouseX = mousePos.x;
    player.mouseY = mousePos.y;
}, false);

//Get Mouse Position
function getMousePos(canvas, evt) {
    var rect = canvas.getBoundingClientRect();
    return {
        x: evt.clientX - rect.left,
        y: evt.clientY - rect.top
    };
}


//Emit player objects
interval = setInterval(function() {
  socket.emit('movement', {player: player, username: username});
}, 1000 / 60);

//HTML canvas stuff in separate file: canvas.js
drawGame(socket);

/**
 * Creates room
 */
function createRoom(){
  //Get room
  var room = $('#room').val();
  //Create room
  socket.emit('new room', room);
}

/**
 * Joins room
 */
function joinRoom(){
  //Get room
  var room = $('#room-list').val();
  //Set message to indicate that the game will not start until all players join
  $("#msg-div").html("Waiting for other players...");
  //This will call the "join room" event on the back end
  socket.emit('join room', {username: username, room: room});
}

/**
 * Leave game
 */
function leave(){
  //Leave room
  socket.emit('leave');
  //Clear canvas
  var canvas = $('#canvas')[0];
  var context = canvas.getContext('2d');
  context.clearRect(0, 0, 800, 600);
  //Refresh stats
  login();
  //Show the correct pages on screen
  hideCanvas(); 
  hideLeaveButton(); 
  showServerPage();
}

/**
 * Fires when a player has won
 */
socket.on('win', function(user){
  if ($("#msg-div").html() != "Player "+user+" Has Won!"){
    $("#msg-div").html("Player "+user+" Has Won!");
  }
});

/**
 * If the user navigates away, leave the game
 */
window.onbeforeunload = function(){
  leave();
};
