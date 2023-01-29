import Mobile from './Mobile.js';


// default values for a Ball : image and shifts
const BALL_IMAGE_SRC = './images/balle24.png';
const SHIFT_X = 8;
const SHIFT_Y = 0;


/**
 * a Ball is a mobile with a ball as image and that bounces in a Game (inside the game's canvas)
 */
export default class Ball extends Mobile {

  /**  build a ball
   *
   * @param  {number} x       the x coordinate
   * @param  {number} y       the y coordinate
   * @param  {Game} theGame   the Game this ball belongs to
   */
  constructor(x, y, theGame) {
    super(x, y, BALL_IMAGE_SRC , SHIFT_X, SHIFT_Y);
    this.theGame = theGame;
  }


  /**
   * when moving a ball bounces inside the limit of its game's canvas
   */
  move() {
    if (this.y <= 0 || (this.y+this.height >= this.theGame.canvas.height)) {
      this.shiftY = - this.shiftY;    // rebond en haut ou en bas
    }
    else if (this.x <= 0 || this.x + this.width >= this.theGame.canvas.width ) {
      this.shiftX = - this.shiftX;    // rebond en gauche ou à droite
      this.stopMoving(this.x);
      this.theGame.ball = null; //set the ball to null
    }
    else if (this.collisionWith(this.theGame.paddle)){
      let theY = Math.floor((this.y-this.theGame.paddle.y+this.width)/10-5);
      this.shiftX = Math.max(2,7 - Math.abs(theY));
      this.shiftY = theY;
      if(this.theGame.player == 1){ //synchro the ball when there is a collision
        this.theGame.socket.emit('synchroBall', {ballX : this.x, ballY : this.y, ballSX : this.shiftX, ballSY : this.shiftY});
      }
    }
    else if (this.collisionWith(this.theGame.paddle2)){
      let theY = Math.floor((this.y-this.theGame.paddle2.y+this.width)/10-5);
      this.shiftX = - Math.max(2,7 - Math.abs(theY));//car decalage de 7
      this.shiftY = theY;
      if(this.theGame.player == 1){ //synchro the ball when there is a collision
        this.theGame.socket.emit('synchroBall', {ballX : this.x, ballY : this.y, ballSX : this.shiftX, ballSY : this.shiftY});
      }
    }
    else if (this.x == this.theGame.canvas.width/2){ //synchro the ball when is reach the center of the canvas
      this.theGame.socket.emit('synchroBall', {ballX : this.x, ballY : this.y, ballSX : this.shiftX, ballSY : this.shiftY});
    }
    super.move();
  }

  /**
   * Checks if there is a collision between the ball and a paddle
   * @param paddle the paddle
   * @return true or false if there is a collision or not
   */
  collisionWith(paddle){

    let p1 = [Math.max(this.x, paddle.x), Math.max(this.y, paddle.y)];
    let p2 = [Math.min(this.x + this.width, paddle.x + paddle.width), Math.min(this.y + this.height, paddle.y + paddle.height)];
    if(p1[0] < p2[0] && p1[1] < p2[1]) {
      return true;
    }
    return false;
  }

  /**
   * Stop the ball and give a point to the winner
   * @param winner the position of the ball to give the point to the winner
   */
  stopMoving(winner){
    super.stopMoving();
    this.theGame.point(winner);
  }

}
