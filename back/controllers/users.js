const User = require("../models/user"); //importa tu esquema de Mongoose para usuarios
const catchAsyncErrors = require("../middleware/catchAsyncErrors");
const ErrorHandler = require("../middleware/errorHandler");

//funcion para obtener todos los usuarios
exports.getUsers = catchAsyncErrors(async (req, res, next) => {
  const users = await User.find(); //busca todos los usuarios en la base de datos y retorna una promesa

  if (!users) {
    return next(new ErrorHandler("No hay usuarios", 404));
  }

  res.status(200).json({
    success: true,
    users,
  });
});

//Función para crear un nuevo usuario
exports.createUser = catchAsyncErrors(async (req, res, next) => {
  const user = await User.create(req.body);

  if (!user) {
    return next(new ErrorHandler("Error al crear usuario", 400));
  }

  res.status(201).json({
    success: true,
    user,
  });
});

//Función para obtener un usuario por su nombre de usuario
exports.getUserByUsername = catchAsyncErrors(async (req, res, next) => {
  const user = await User.findById(req.params.id); //busca el usuario en la base de datos y retorna una promesa

  if (!user) {
    return next(new ErrorHandler("Este usuario no existe", 404));
  }

  res.status(200).json({
    success: true,
    user,
  });
});

//Función para eliminar un usuario
exports.deleteUser = catchAsyncErrors(async (req, res, next) => {
  const user = await User.findByIdAndDelete(req.params.id); //busca el usuario en la base de datos y retorna una promesa

  if (!user) {
    return next(new ErrorHandler("Error al eliminar usuario", 404));
  }

  res.status(200).json({
    success: true,
    user,
  });
});
