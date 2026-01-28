package LiterAlura.service;

import LiterAlura.dto.AutorApiDTO;
import LiterAlura.dto.LibroApiResponse;
import LiterAlura.dto.LibroApiDTO;
import LiterAlura.model.Autor;
import LiterAlura.model.Libro;
import LiterAlura.repository.AutorRepository;
import LiterAlura.repository.LibroRepository;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class LibroApiService {

    private final RestTemplate restTemplate;
    private final LibroRepository libroRepository;
    private final AutorRepository autorRepository;

    private static final String API_URL =
            "https://gutendex.com/books/";

    public LibroApiService(RestTemplate restTemplate,
                           LibroRepository libroRepository,
                           AutorRepository autorRepository) {

        this.restTemplate = restTemplate;
        this.libroRepository = libroRepository;
        this.autorRepository = autorRepository;
    }

    /* =============================
       LISTAR
       ============================= */

    public List<LibroApiDTO> listarLibros() {

        LibroApiResponse response =
                restTemplate.getForObject(API_URL, LibroApiResponse.class);

        return response != null ? response.resultados() : List.of();
    }

    /* =============================
       BUSCAR
       ============================= */

    public List<LibroApiDTO> buscarPorTitulo(String titulo) {

        String url = API_URL + "?search=" + titulo;

        LibroApiResponse response =
                restTemplate.getForObject(url, LibroApiResponse.class);

        return response != null ? response.resultados() : List.of();
    }

    /* =============================
       IMPORTAR Y GUARDAR
       ============================= */

    @Transactional
    public void importarYGardar(String titulo) {

        List<LibroApiDTO> libros = buscarPorTitulo(titulo);

        for (LibroApiDTO dto : libros) {

            /* =============================
               AUTOR
               ============================= */

            Autor autor = null;

            if (!dto.autores().isEmpty()) {

                AutorApiDTO autorApi = dto.autores().get(0);

                autor = autorRepository
                        .findByNombreIgnoreCase(autorApi.nombre())
                        .orElseGet(() -> {

                            Autor nuevo = new Autor(
                                    autorApi.nombre(),
                                    autorApi.nacimiento(),
                                    autorApi.muerte()
                            );

                            return autorRepository.save(nuevo);
                        });
            }

            if (autor == null) {
                autor = new Autor("Desconocido", null, null);
                autor = autorRepository.save(autor);
            }

            /* =============================
               EVITAR DUPLICADOS
               ============================= */

            if (libroRepository.existsByTitulo(dto.titulo())) {
                continue;
            }

            /* =============================
               LIBRO
               ============================= */

            String idioma = dto.idiomas().isEmpty()
                    ? "N/A"
                    : dto.idiomas().get(0);

            Libro libro = new Libro(
                    dto.titulo(),
                    idioma,
                    dto.descargas(),
                    autor
            );

            libroRepository.save(libro);
        }
    }

    /* =============================
       BUSCAR POR ID (API)
       ============================= */

    public LibroApiDTO buscarPorId(Long id) {

        String url = API_URL + id;

        return restTemplate.getForObject(url, LibroApiDTO.class);
    }
}
