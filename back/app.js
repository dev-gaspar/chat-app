const express = require("express");
const app = express();

//MiddleWares para manejar errores
const errorMiddleware = require("./middleware/errors");
app.use(errorMiddleware);

module.exports = app;
