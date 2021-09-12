//Get config values
var config = require("./config.js");
//Database stuff
var Data = require('./data.js').Data;
var data = new Data();

/**
 * All game calculations go here
 * @param {Object} keys Player 1 & 2 key press data
 * @param {Object} player1 Player 1 x,y coordinates
 * @param {Object} player2 Player 2 x,y coordinates
 * @param {Object} ball Ball coordinates
 * @param {String} player1User player 1 username
 * @param {String} player1User player 2 username
 */
exports.updateGame = function(keys, player1, player2, ball, player1User, player2User){
    //player 1

    if (keys.player1.left && player1.x > config.canvasPadding) {
        player1.x -= config.playerSpeed;
    }
    if (keys.player1.up && player1.y > config.canvasPadding){
        player1.y -= config.playerSpeed;
    }
    if (keys.player1.right && player1.x < config.canvasWidth - config.canvasPadding) {
        player1.x += config.playerSpeed;
    }
    if (keys.player1.down && player1.y < config.canvasHeight - config.canvasPadding) {
        player1.y += config.playerSpeed;
    }

    //player 2
    if (keys.player2.left && player2.x > config.canvasPadding) {
        player2.x -= config.playerSpeed;
    }
    if (keys.player2.up && player2.y > config.canvasPadding) {
        player2.y -= config.playerSpeed;
    }
    if (keys.player2.right && player2.x < config.canvasWidth - config.canvasPadding) {
        player2.x += config.playerSpeed;
    }
    if (keys.player2.down && player2.y < config.canvasHeight - config.canvasPadding) {
        player2.y += config.playerSpeed;
    }

    //ball

   if(player1.x < ball.x + config.ballSize && player1.x + config.playerSize > ball.x &&
      player1.y < ball.y + config.ballSize && player1.y + config.playerSize > ball.y &&
      player2.holdingBall == false)
   {
      player1.holdingBall = true;
   }

   if(player2.x < ball.x + config.ballSize && player2.x + config.playerSize > ball.x &&
      player2.y < ball.y + config.ballSize && player2.y + config.playerSize > ball.y &&
      player1.holdingBall == false)
   {
      player2.holdingBall = true;
   }

   if(player1.holdingBall)
   {
      ball.x = player1.x + 5;
      ball.y = player1.y - 5;
   }

   if(player2.holdingBall)
   {
      ball.x = player2.x + 5;
      ball.y = player2.y - 5;
   }

   // Kicking

   if(keys.player1.space && player1.holdingBall)
   {
      player1.holdingBall = false;

      ball.isMoving = true;
      ball.firstTick = true;
      ball.trajX = keys.player1.mouseX - ball.x;
      ball.trajY = keys.player1.mouseY - ball.y;
   }

   if(keys.player2.space && player2.holdingBall)
   {
      player2.holdingBall = false;

      ball.isMoving = true;
      ball.firstTick = true;
      ball.trajX = keys.player2.mouseX - ball.x;
      ball.trajY = keys.player2.mouseY - ball.y;

   }

   if(ball.isMoving)
   {
      if(ball.firstTick)
      {
         if(ball.x < config.ballBoundEast && ball.x > config.ballBoundWest && ball.y > config.ballBoundNorth && ball.y < config.ballBoundSouth)
         {
            ball.x += ball.trajX / 10;
            ball.y += ball.trajY / 10;
            ball.firstTick = false;
         }
         else {
            ball.firstTick = false;
            ball.isMoving = false;
         }
      }

      if(ball.x < config.ballBoundEast && ball.x > config.ballBoundWest && ball.y > config.ballBoundNorth && ball.y < config.ballBoundSouth)
      {
         ball.x += ball.trajX / 30;
         ball.y += ball.trajY / 30;
      }
      else
      {
         ball.isMoving = false;
      }
   }

   //Scoring
   if(ball.x > config.leftGoal.x && ball.x < config.leftGoalWidth &&
      ball.y > config.leftGoal.y && ball.y < config.leftGoal.y + config.leftGoalHeight)
   {
      player2.score += 1;
      ball.x = 400;
      ball.y = 300;
      player1.holdingBall = false;
      ball.isMoving = false
      data.addGoal(player2User); //Track player stats in database
   }
   if(ball.x > config.rightGoal.x && ball.x < config.rightGoal.x + config.rightGoalWidth &&
    ball.y > config.rightGoal.y && ball.y < config.rightGoal.y + config.rightGoalHeight)
   {
      player1.score += 1;
      ball.x = 400;
      ball.y = 300;
      player2.holdingBall = false;
      ball.isMoving = false
      data.addGoal(player1User); //Track player stats in database
   }
}
