package LiterAlura.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record AutorApiDTO(

        @JsonProperty("name")
        String nombre,

        @JsonProperty("birth_year")
        Integer fechaNacimiento,

        @JsonProperty("death_year")
        Integer fechaMuerte

) {

    // Devuelve año de nacimiento
    public Integer nacimiento() {
        return fechaNacimiento;
    }

    // Devuelve año de muerte
    public Integer muerte() {
        return fechaMuerte;
    }
}
