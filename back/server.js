const app = require("./app");
const connectDB = require("./config/database");
const http = require("http");
const dotenv = require("dotenv");

//Setear el archivo de configuracion
dotenv.config({ path: "config/config.env" });

//Configuracion base de datos
connectDB();

//Inicializacion del servidor
const server = http.createServer(app);
const io = require("socket.io")(server);

//manejador de eventos de socket
io.on("connection", (socket) => {
  console.log("A user connected");
  socket.on("disconnect", () => {
    console.log("user disconnected");
  });

  //prueba test
  socket.on("test", (message) => {
    console.log(message);
  });
});

const PORT = process.env.PORT || 4000;
server.listen(PORT, () => {
  console.log(`Server started on port ${PORT}`);
});
