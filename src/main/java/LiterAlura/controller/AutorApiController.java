package LiterAlura.controller;

import LiterAlura.dto.AutorApiDTO;
import LiterAlura.model.Autor;
import LiterAlura.service.AutorApiService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("/libros/autores")
@SessionAttributes("resultados")
public class AutorApiController {

    private final AutorApiService autorApiService;

    public AutorApiController(AutorApiService autorApiService) {
        this.autorApiService = autorApiService;
    }

    /* ===============================
       🔍 BUSCAR AUTOR EN API
    ================================ */
    @Transactional
    @GetMapping("/buscar")
    public String buscarAutor(
            @RequestParam("q") String query,
            Model model
    ) {
        List<AutorApiDTO> resultados = autorApiService.buscarAutores(query);

        model.addAttribute("resultados", resultados);
        model.addAttribute("autor", new Autor());
        model.addAttribute("accion", "Registrar");

        return "autor-form";
    }

    /* ===============================
       📌 SELECCIONAR AUTOR DE API
    ================================ */
    @GetMapping("/seleccionar/{index}")
    public String seleccionarAutor(
            @PathVariable int index,
            @ModelAttribute("resultados") List<Autor> resultados,
            Model model
    ) {
        Autor autorSeleccionado = resultados.get(index);

        model.addAttribute("autor", autorSeleccionado);
        model.addAttribute("accion", "Registrar");

        return "autor-form";
    }
}
