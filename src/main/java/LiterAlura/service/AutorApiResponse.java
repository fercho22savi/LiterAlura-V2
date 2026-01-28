package LiterAlura.service;

import LiterAlura.dto.LibroApiDTO;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class AutorApiResponse {

    @JsonProperty("count")
    private Integer total;

    @JsonProperty("results")
    private List<LibroApiDTO> results;

    // Getters y Setters

}
