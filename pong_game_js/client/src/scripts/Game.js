import Ball from './Ball.js';
import Paddle from './Paddle.js';
import { io } from "socket.io-client";

/**
 * a Game animates a ball bouncing in a canvas
 */
export default class Game {

  /**
   * build a Game
   *
   * @param  {Canvas} canvas the canvas of the game
   */
  constructor(canvas) {
    this.raf = null;
    this.canvas = canvas;
    this.ball = null;
    this.paddle = new Paddle(50, this.canvas.width/2 - 150, this);
    this.paddle2 = new Paddle(this.canvas.width-77, this.canvas.width/2 - 150, this);
    this.canStart = false;
  }

  /** start this game animation */
  start() {
    this.socket = io();
    this.serverListener();
  }
  /** stop this game animation */
  stop() {
    this.socket.emit('leave'); //send to the server the player left
    window.cancelAnimationFrame(this.raf);
  }

  /** animate the game : move and draw */
  animate() {
    this.moveAndDraw();
    this.raf = window.requestAnimationFrame(this.animate.bind(this));
  }
  /** move then draw the bouncing ball and the paddles */
  moveAndDraw(){
    const ctxt = this.canvas.getContext("2d");
    ctxt.clearRect(0, 0, this.canvas.width, this.canvas.height);
    if(this.ball != null){
      if(this.ball.shiftX != 0 || this.ball.shiftY != 0){// pour que les points ne soient pas donnés à l'infini
        this.ball.move();
      } 
    }
    if(this.ball != null){
      this.ball.draw(ctxt); 
    }
    this.paddle.move();
    this.paddle2.move();
    this.paddle.draw(ctxt);
    this.paddle2.draw(ctxt);
  }

  keyDownActionHandler(event){
    switch (event.key) {
        case "ArrowUp":
        case "Up":
            this.socket.emit('PressUp', this.paddle.y); //send message to the server to move the paddle of the other player
            this.paddle.moveUp();
            break;
        case "ArrowDown":
        case "Down":
            this.socket.emit('PressDown', this.paddle.y); //send message to the server to move the paddle of the other player
            this.paddle.moveDown();
            break;
        default: return;
    } 
    event.preventDefault();
  }

  keyUpActionHandler(event){
    switch (event.key) {
        case "ArrowUp":
        case "Up":
           this.socket.emit('StopPress', this.paddle.y);//send message to the server to move the paddle of the other player
           this.paddle.stopMoving();
        case "ArrowDown":
        case "Down":
            this.socket.emit('StopPress', this.paddle.y);//send message to the server to move the paddle of the other player
            this.paddle.stopMoving();
            break;
        default: return;
    }
 event.preventDefault();
}

  point(winner){//on donne 1 point au vainqueur
    let txt = document.getElementById("score").innerText;
    let rep;
    if(winner > 0){
      rep = parseInt(txt[0])+1 +" - "+ txt[txt.length-1];
      //le vainqueur peut relancer la balle
      this.socket.emit('point');
    }
    else{
      rep = txt[0] +" - "+ (parseInt(txt[txt.length-1])+1);
    }
    document.getElementById("score").innerText = rep;
  }

  serverListener(){
    this.socket.on('register', (nb) => { //to tell which player you are
      console.log("You are player "+ nb);
      document.getElementById('player').textContent = "Player "+ nb;
    });

    this.socket.on('disconnected', () => {// to tell you were disconnected
      console.log("you have been disconnected");
    });

    this.socket.on('ready', () => this.animate()); //if there is 2 players 

    this.socket.on('start', () => { // the player who can start can throw the ball
      this.canStart = true;
      this.waitClick();
    });

    this.socket.on('PressedUp', (pos) => { //move the other paddle
      this.paddle2.y = pos;
      this.paddle2.moveUp();
    });
    this.socket.on('PressedDown', (pos) => { //move the other paddle
      this.paddle2.y = pos;
      this.paddle2.moveDown();
    });
    this.socket.on('StopPressed', (pos) => { //move the other paddle
      this.paddle2.y = pos;
      this.paddle2.stopMoving();
    });

    this.socket.on('thrown', () => { //create the ball if the other throw it
      this.ball = new Ball((this.paddle2.x - 25), this.canvas.height/2, this);
      this.ball.shiftX = - this.ball.shiftX;
    });

    this.socket.on('ball', (ball) => { //to synchronize the ball
      console.log(ball);
      this.ball.x = this.canvas.width - ball.ballX;
      this.ball.y = ball.ballY;
      this.ball.shiftX = - ball.ballSX;
      this.ball.shiftY = ball.ballSY;
    });
  }


  waitClick(){ //wait the player to click on the canvas
    this.canvas.addEventListener('click',this.throwBall.bind(this));
  }

  throwBall(){ //if there is no ball and the player can throw it does
    if(this.ball == null && this.canStart){
      this.ball = new Ball(this.paddle.x + 25 + this.paddle.width, this.canvas.height/2, this);
      this.socket.emit('throw');
      this.canStart = false;
    }
  }
    
  
}

