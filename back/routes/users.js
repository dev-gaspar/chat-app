const express = require("express");
const router = express.Router();
const {
  getUsers,
  createUser,
  getUserByUsername,
  deleteUser,
} = require("../controllers/users");

//Ruta para crear un nuevo usuario
router.route("/users").get(getUsers);
router.route("/users").post(createUser);
router.route("/users/:id").get(getUserByUsername);
router.route("/users/:id").delete(deleteUser);

module.exports = router;
