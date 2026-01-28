package LiterAlura.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record LibroApiResponse(

        @JsonProperty("results")
        List<LibroApiDTO> resultados
) {
}
