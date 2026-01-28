package LiterAlura.service;

import LiterAlura.dto.AutorApiDTO;
import LiterAlura.dto.LibroApiDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service

public class AutorApiService {

    private final RestTemplate restTemplate;

    // API de Gutenberg
    private static final String API_URL =
            "https://gutendex.com/books/";

    public AutorApiService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    /* =============================
       BUSCAR AUTORES POR NOMBRE
       ============================= */
    public List<AutorApiDTO> buscarAutores(String nombre) {

        String url = API_URL + "?search=" + nombre;

        AutorApiResponse response =
                restTemplate.getForObject(url, AutorApiResponse.class);

        List<AutorApiDTO> autores = new ArrayList<>();

        if (response == null || response.getResults() == null) {
            return autores;
        }

        // Extraer autores desde libros
        for (LibroApiDTO libro : response.getResults()) {

            if (libro.autores() != null) {
                autores.addAll(libro.autores());
            }
        }

        return autores;
    }
}
