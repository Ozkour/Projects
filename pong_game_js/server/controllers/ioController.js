export default class IOController {

    constructor(io) {
        this.io = io;
        this.clients = [];
        this.other = 0;
      }


      registerSocket(socket) {
        console.log(`new connection with id ${socket.id}`);
        this.clients[this.clients.length] = socket;
        this.setupListeners(socket);
        socket.emit('register', this.clients.length);
      }

      setupListeners(socket) {
        socket.on( 'leave' , () => {
          socket.disconnect(true);
        });

        socket.on( 'disconnect' , () => this.leave(socket) );

        if (this.clients.length == 2){ //if there is exactly 2 players, we can start the game
          this.clients.forEach(socket => {
            socket.emit('ready');
          });
          this.clients[0].emit('start');
        }
        if(this.clients.length > 2){// if there is already 2 players, the 3rd is disconnected
          socket.emit('disconnected');
          socket.disconnect(true);
          this.clients.pop();
          console.log(`disconnection forced from ${socket.id}`);
        }

        socket.on('PressUp', (pos) => { //to synchronize the paddle
          this.other = (this.clients.indexOf(socket) + 1) %2;
          this.clients[this.other].emit('PressedUp', pos);
        }); 
        socket.on('PressDown', (pos) => { //to synchronize the paddle
          this.other = (this.clients.indexOf(socket) + 1) %2;
          this.clients[this.other].emit('PressedDown', pos);
        });
        socket.on('StopPress', (pos) => { //to synchronize the paddle
          this.other = (this.clients.indexOf(socket) + 1) %2;
          this.clients[this.other].emit('StopPressed', pos);
        });

        socket.on('throw', () => {//say to the other player you threw the ball
          this.other = (this.clients.indexOf(socket) + 1) %2;
          this.clients[this.other].emit('thrown');
        });
        
        //if you got the point you can start the ball
        socket.on('point', () => this.clients[this.clients.indexOf(socket)].emit('start'));
        
        socket.on('synchroBall',(ball) => { //synchro the ball of player 2 according to the one of player 1
          if(socket == this.clients[0]){
            this.clients[1].emit('ball', ball);
          }
        });
      }

      leave(socket){
        console.log(`disconnection from ${socket.id}`);
        this.clients.splice(this.clients.indexOf(socket.id),1);
      }
      
}