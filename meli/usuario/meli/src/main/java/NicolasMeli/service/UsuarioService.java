package NicolasMeli.service;


import NicolasMeli.entity.Usuario;
import NicolasMeli.repository.UsuarioRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;


@Component
public class UsuarioService {

    private final UsuarioRepository userRepo;

    public UsuarioService(UsuarioRepository userRepo) {
        this.userRepo = userRepo;
    }

    public Iterable<Usuario> findThemAll() {
        return userRepo.findAll();
    }

    public Usuario createUsers(Usuario users) {
        return userRepo.save(users);
    }

    public Usuario findById(Long id) {
        Optional<Usuario> usersOptional = userRepo.findById(id);
        if (usersOptional.isPresent()) {
            return usersOptional.get();
        } else {
            throw new RuntimeException(" ** User not found! ** ");
        }
    }
}