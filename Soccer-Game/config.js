var config = {};

config.canvasWidth = 800;
config.canvasHeight = 600;
config.canvasPadding = 20;

config.playerSize = 20;
config.playerSpeed = 5;
config.player1Start = {x: 300, y: 300};
config.player2Start = {x: 500, y: 300};

config.ballSize = 20;
config.ballReset = {x: 400, y: 300};

config.leftGoal = {x: 0, y: 200};
config.leftGoalWidth = 70;
config.leftGoalHeight = 200;

config.rightGoal = {x: 730, y: 200};
config.rightGoalWidth = 70;
config.rightGoalHeight = 200;

config.winningScore = 3;

config.ballBoundNorth = 25;
config.ballBoundEast = 775;
config.ballBoundSouth = 575;
config.ballBoundWest = 25;

module.exports = config;
