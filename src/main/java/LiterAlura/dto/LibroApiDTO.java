package LiterAlura.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public record LibroApiDTO(

        @JsonProperty("title")
        String titulo,

        @JsonProperty("authors")
        List<AutorApiDTO> autores,

        @JsonProperty("languages")
        List<String> idiomas,

        @JsonProperty("download_count")
        Integer descargas
) {
}
