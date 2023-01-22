const mongoose = require("mongoose");
const User = require("../models/user"); //importa tu esquema de Mongoose para usuarios

//Función para crear un nuevo usuario
const createUser = (userData) => {
  const newUser = new User(userData);
  return newUser.save(); //guarda el nuevo usuario en la base de datos y retorna una promesa
};

//Función para obtener un usuario por su nombre de usuario
const getUserByUsername = (username) => {
  return User.findOne({ username }); //busca el usuario en la base de datos y retorna una promesa
};

//Función para eliminar un usuario
const deleteUser = (username) => {
  return User.findOneAndDelete({ username }); //elimina el usuario de la base de datos y retorna una promesa
};

module.exports = {
  createUser,
  getUserByUsername,
  deleteUser,
};
