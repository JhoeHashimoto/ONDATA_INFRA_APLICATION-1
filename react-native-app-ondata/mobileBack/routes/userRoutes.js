const express = require('express');
const router = express.Router();
const userController = require('../controllers/userController'); 

// Rota para cadastro de usuário
router.post('/register', userController.registerUser);

// Rota para login de usuário
router.post('/login', userController.loginUser);

// Rota para redefinição de senha
router.post('/reset-password', userController.resetPassword);

module.exports = router;
