package NicolasMeli.controller;


import NicolasMeli.entity.Usuario;
import NicolasMeli.service.UsuarioService;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.slf4j.Logger;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UsuarioController {

    private static final Logger logger = LoggerFactory.getLogger(UsuarioController.class);
    private final UsuarioService userService;

    public UsuarioController(UsuarioService userService) {
        this.userService = userService;
    }

    @PostMapping
    public Usuario createUsuario(@RequestBody Usuario users) {
        logger.info("Criando usuario: {}", users);
        Usuario createdUser = userService.createUsers(users);
        logger.info("Usuario criado: {}", createdUser);
        return createdUser;
    }

    @GetMapping
    public Iterable<Usuario> findThemAll() {
        logger.info("Encontre todos os usuários");
        Iterable<Usuario> users = userService.findThemAll();
        logger.info("Encontrados {} usuários", users.spliterator().getExactSizeIfKnown());
        return users;
    }

    @GetMapping("/{id}")
    public Usuario findById(@PathVariable Long id) {
        logger.info("Encontrar usuário com id: {} ", id);
        Usuario users = userService.findById(id);
        logger.info("Usuário encontrado: {}", users);
        return users;
    }

}