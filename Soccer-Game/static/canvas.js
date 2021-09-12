//Get canvas
var canvas = $('#canvas')[0];
//Set canvas width and height
canvas.width = 800;
canvas.height = 600;
//Get context
var context = canvas.getContext('2d');
//Get canvas mouse position
var mouseX = 0;
var mouseY = 0;
$('canvas').mousemove(function(e){
  var rect = canvas.getBoundingClientRect();
  mouseX = e.pageX - rect.left;
  mouseY = e.pageY - rect.top;
});

/**
 * Draws the game using HTML canvas
 * @param {Socket} socket Used to listen to the socket for movement state
 */
drawGame = function (socket){

  //Listen to server for update to game
  socket.on('state', function(game) {
    
    if (Object.keys(game.players).length >= 2 && $("#msg-div").html() == "Waiting for other players..."){
      $("#msg-div").html("");
    }

    //Clear canvas
    context.clearRect(0, 0, 800, 600);
    
    //Keep track of which player to draw
    var drawPlayer1 = true;
    //keep track of scores
    var player1Score = 0;
    var player2Score = 0;
    //Draw every player
    for (var key in game.players) {
      var playerImg = new Image();
      if (drawPlayer1){
        playerImg.src = "./static/images/Player1.svg";
        player1Score = game.players[key].score;
      } else {
        playerImg.src = "./static/images/Player2.svg";
        player2Score = game.players[key].score;
      }
      if (key == $('#username').val()){
        context.setTransform(0.1, 0, 0, 0.1, game.players[key].x, game.players[key].y );  // set scale and origin
        context.rotate(Math.atan2(mouseY - game.players[key].y, mouseX - game.players[key].x)); // set angle
        context.drawImage(playerImg, -205, -205); // draw image
        context.setTransform(1, 0, 0, 1, 0, 0); // restore default not needed if you use setTransform for other rendering operations
      } else {
        context.drawImage(playerImg, game.players[key].x, game.players[key].y, 30, 40);
      }
      drawPlayer1 = !drawPlayer1;
    }
    
    //Draw ball
    var ballImg = new Image();
    ballImg.src = "./static/images/Soccerball.svg";
    context.drawImage(ballImg, game.ball.x, game.ball.y, 20, 20);
    
    //Draw score numbers
    context.fillStyle = 'red';
    context.font = "50px Arial";
    context.fillText(player1Score.toString(),350,50);
    context.fillText(player2Score.toString(),430,50);
  });
}
