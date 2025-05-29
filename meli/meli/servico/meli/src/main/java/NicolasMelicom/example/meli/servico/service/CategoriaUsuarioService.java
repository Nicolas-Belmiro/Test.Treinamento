package NicolasMelicom.example.meli.servico.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.util.Optional;

@Component
public class CategoriaUsuarioService {

    @Autowired
    private final CategoriaMemeRepository categoriaMemeRepository;

    public CategoriaMemeService(CategoriaMemeRepository categoriaMemeRepository) {
        this.categoriaMemeRepository = categoriaMemeRepository;
    }

    public Iterable<CategoriaMeme> buscarTodasAsCategorias() {
        return categoriaMemeRepository.findAll();
    }

    public CategoriaMeme criarCategoriaMeme(CategoriaMeme categoriaMeme) {
        return categoriaMemeRepository.save(categoriaMeme);
    }

    public CategoriaMeme buscarCategoriaMemePorId(Long id) {
        Optional<CategoriaMeme> categoria = categoriaMemeRepository.findById(id);
        if (categoria.isPresent()) {
            return categoria.get();
        } else {
            throw new RuntimeException("CategoriaMeme não encontrada!");
        }
    }
}