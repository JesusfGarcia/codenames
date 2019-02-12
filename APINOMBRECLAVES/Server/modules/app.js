'use strict';
const express = require('express');
const app = express();
const bodyParser = require('body-parser');
const logger = require('morgan');
const router = express.Router();
const port = process.env.PORT || 8080;
//sockets
var http = require('http');
var server = http.Server(app);
var io = require('socket.io')(server)
var socket = io.listen(server,{log: false});
    socket.on('event',(variable)=>{
        console.log('si se pudo UwU')
    });
    socket.on('event',(palabra)=>{
        console.log(palabra);
    })
io.sockets.on('connection',(socket)=>{
    console.log('El cliente con IP'+ socket.handshake.address + 'se ha conectado');
    socket.on('disconnect',()=>{
        console.log('user has left');
    });
    socket.on('event',(uwu)=>{
        console.log('El cliente con IP'+ socket.handshake.address + 'se ha conectado a la habitacion' );
       // socket.join('/room');

    });
  

})





    

//ejemplo de algo que quiero probar OwO
var salita = io.of('/salita');
    salita.on('connection', function(socket){
       socket.broadcast.emit('usuario_nuevo',{data:""})
       console.log("alguien se conecto a salita");
    });
//para pruebas 
//app.use(express.static('Client'))

app.use(bodyParser.json());
app.use(logger('dev'));
require('./routes')(router);
app.use('/api/v1', router);
server.listen(port);

console.log(`App Runs on ${port}`);