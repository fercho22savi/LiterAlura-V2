package LiterAlura.controller;

import LiterAlura.dto.LibroApiDTO;
import LiterAlura.service.LibroApiService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/libros-externos")
public class LibroApiController {

    private final LibroApiService service;

    public LibroApiController(LibroApiService service) {
        this.service = service;
    }

    /* =============================
       LISTAR DESDE API
       ============================= */
    @GetMapping
    public List<LibroApiDTO> listar() {
        return service.listarLibros();
    }

    /* =============================
       BUSCAR POR TITULO
       ============================= */
    @GetMapping("/buscar")
    public List<LibroApiDTO> buscar(@RequestParam String q) {
        return service.buscarPorTitulo(q);
    }

    /* =============================
       IMPORTAR Y GUARDAR EN BD
       ============================= */
    @PostMapping("/importar")
    public String importar(@RequestParam String titulo) {

        service.importarYGardar(titulo);

        return "Libros importados correctamente";
    }

    /* =============================
       BUSCAR POR ID (API)
       ============================= */
    @GetMapping("/{id}")
    public LibroApiDTO buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }
}
