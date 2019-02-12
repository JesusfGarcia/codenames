'use strict';

const room = require('../models/Roms');

exports.loginRoom = (name) =>
    new Promise((resolve,reject)=>{
        room.find({name})

        .then(rooms =>{
            if(rooms.length ==0){
                reject({status:404, message:'No se ha encontrado la sala'});
            }else{
                    return rooms[0];
            }
        })
        
    })