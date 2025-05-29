package NicolasMelicom.example.meli.servico.CategoriaUsuario;


import NicolasMelicom.example.meli.servico.entity.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Configuration
@EnableFeignClients
@EnableDiscoveryClient
@Lazy
public class CategoriaUsuario {

    @Autowired
    private CategoriaUsuario categoriaUsuario;

    @FeignClient(name = "user")
    interface ICategoriaMemeClient {
        @RequestMapping(path = "/users", method = RequestMethod.GET)
        @ResponseBody Iterable<Usuario> buscarTodos();

        @RequestMapping(path = "/users/{id}", method = RequestMethod.GET)
        @ResponseBody
        Usuario buscarPorId(@PathVariable("id") Long id);
    }

    public Iterable<Usuario> buscarTodos() {
        return categoriaUsuario.buscarTodos();
    }

    public Usuario buscarPorId(Long id) {
        return categoriaUsuario.buscarPorId(id);
    }
}
