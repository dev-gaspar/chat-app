const express = require("express");
const app = express();
const errorMiddleware = require("./middleware/errors");
app.use(express.json());

//importar rutas
const users = require("./routes/users");
//(ruta del navegador)
app.use("/api", users);

//MiddleWares para manejar errores
app.use(errorMiddleware);

module.exports = app;
