package NicolasMelicom.example.meli.servico.controller;


import NicolasMelicom.example.meli.servico.service.CategoriaUsuarioService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/category")
public class CategoriaUsuarioController {

    private static final Logger logger = LoggerFactory.getLogger(CategoriaUsuarioController.class);
    private final CategoriaUsuarioService categoriaMemeService;

    @Autowired
    private CategoriaMemeClient categoriaMemeClient;

    public CategoriaMemeController(CategoriaMemeService categoriaMemeService) {
        this.categoriaMemeService = categoriaMemeService;
    }

    @GetMapping("/users")
    public Iterable<Usuario> buscarTodosUsuarios() {
        logger.info("Buscando todos usuários");
        Iterable<Usuario> usuarios = categoriaMemeClient.buscarTodos();
        int numeroUsuarios = 0;
        for (Usuario usuario : usuarios) {
            numeroUsuarios++;
        }
        logger.info("buscarTodosUsuarios() retornou {} usuários", numeroUsuarios);
        return usuarios;
    }

    @PostMapping
    public CategoriaMeme criarCategoriaMeme(@RequestBody CategoriaMeme categoriaMeme) {
        logger.info("Criando categoria: {}", categoriaMeme);
        Long usuarioId = categoriaMeme.getUsuarioId();
        Usuario usuario = categoriaMemeClient.buscarPorId(usuarioId);
        if (usuario == null) {
            logger.info("criarCategoriaMeme() falhou: usuário com ID {} não encontrado", usuarioId);
            return null;
        }
        categoriaMeme.setUsuarioId(usuario.getId());
        CategoriaMeme criarCategoria = categoriaMemeService.criarCategoriaMeme(categoriaMeme);
        if (criarCategoria == null) {
            logger.info("criarCategoriaMeme() falhou: não pode criar categoriaMeme={}", categoriaMeme);
        } else {
            logger.info("criarCategoriaMeme() sucesso: categoriaMeme={} criado com ID {}", criarCategoria, criarCategoria.getId());
        }
        return criarCategoria;
    }

    @GetMapping
    public Iterable<CategoriaMeme> buscarTodasAsCategorias() {
        logger.info("Buscando todas categorias de memes");
        Iterable<CategoriaMeme> categorias = categoriaMemeService.buscarTodasAsCategorias();
        int numeroCategorias = 0;
        for (CategoriaMeme categoria : categorias) {
            numeroCategorias++;
        }
        logger.info("encontrarTodasCategorias() retornado {} categorias", numeroCategorias);
        return categorias;
    }

    @GetMapping("/{id}")
    public CategoriaMeme buscarCategoriaMemePorId(@PathVariable Long id) {
        logger.info("Buscando categoria com id={}", id);
        CategoriaMeme categoria = categoriaMemeService.buscarCategoriaMemePorId(id);
        if (categoria == null) {
            logger.info("buscarCategoriaMemePorId() falhou: categoria com ID {} não encontrada", id);
        } else {
            logger.info("buscarCategoriaMemePorId() sucesso: categoria={} encontrada", categoria);
        }
        return categoria;
    }
}