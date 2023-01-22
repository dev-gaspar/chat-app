const ErrorHandler = require("./errorHandler");

module.exports = (err, req, res, next) => {
  err.statusCode = err.statusCode || 500;
  err.message = err.message || "Internal Server Error";

  res.status(err.statusCode).json({
    success: false,
    message: err.stack,
  });

  //Error de clave duplicada en mongoose
  if (err.code === 1100) {
    const message = `Clave duplicada ${Object.keys(err.keyValue)}`;
    error = new ErrorHandler(message, 400);
  }
};
