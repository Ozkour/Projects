import Mobile from './Mobile.js';

const PADDLE_IMAGE_SRC = './images/paddle.png';
const SHIFT_X = 0;
const SHIFT_Y = 6;
const MoveState = { UP : 0, DOWN : 1, STATIC : 2};

export default class Paddle extends Mobile {

    /**  build a paddle
   *
   * @param  {number} x       the x coordinate
   * @param  {number} y       the y coordinate
   * @param  {Game} theGame   the Game this paddle belongs to
   */
  constructor(x, y, theGame) {
    super(x, y, PADDLE_IMAGE_SRC , SHIFT_X, SHIFT_Y);
    this.theGame = theGame;
    this.moving = MoveState.STATIC;
  }

  get up() {
    return (this.moving == MoveState.UP);
  }

  get down() {
    return (this.moving == MoveState.DOWN);
  }

  moveUp() {
    this.shiftY = -Math.abs(this.shiftY);
    this.moving = MoveState.UP;
  }

  moveDown(){
    this.shiftY = Math.abs(this.shiftY);
    this.moving = MoveState.DOWN;
  }

  stopMoving() {
    this.moving = MoveState.STATIC;
  }

  /**
   * when moving a paddle can only move inside the limit of its game's canvas
   */
  move(){
    if(this.up){
        this.y = Math.max(0, this.y + this.shiftY);
    }
    if(this.down){
        this.y =  Math.min(this.theGame.canvas.height - this.img.height, this.y + this.shiftY);
    }   
  }
}