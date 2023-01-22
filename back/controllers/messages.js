const Message = require("../models/message"); //importa tu esquema de Mongoose para mensajes
const io = require("socket.io")(server); //importa socket.io y asigna el servidor en el que se ejecutará

//Función para crear un nuevo mensaje
const createMessage = (messageData) => {
  const newMessage = new Message(messageData);
  return newMessage.save(); //guarda el nuevo mensaje en la base de datos y retorna una promesa
};

//Función para obtener los mensajes enviados entre dos usuarios
const getMessagesBetweenUsers = (senderUsername, receiverUsername) => {
  return Message.find({
    $or: [
      { $and: [{ sender: senderUsername }, { receiver: receiverUsername }] },
      { $and: [{ sender: receiverUsername }, { receiver: senderUsername }] },
    ],
  });
};

//Función para manejar los eventos de socket para nuevos mensajes
io.on("connection", (socket) => {
  socket.on("new message", (messageData) => {
    //guarda el mensaje en la base de datos
    createMessage(messageData)
      .then(() => {
        //emite el evento 'new message' a todos los sockets conectados
        io.emit("new message", messageData);
      })
      .catch((error) => {
        console.error(error);
      });
  });
});

module.exports = {
  createMessage,
  getMessagesBetweenUsers,
};
