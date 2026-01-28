package LiterAlura.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http
                // Desactivar CSRF (para APIs)
                .csrf(csrf -> {
                    csrf.disable();
                })

                // Configurar permisos
                .authorizeHttpRequests(auth -> auth

                        // APIs públicas
                        .requestMatchers(
                                "https://gutendex.com/books/**",
                                "/api/autores-externos/**",
                                "/api/libros-externos/**"
                        ).permitAll()

                        // Lo demás requiere login
                        .anyRequest().authenticated()
                )

                // Login por formulario
                .formLogin(form -> {
                    form.permitAll();
                })

                // Logout libre
                .logout(logout -> {
                    logout.permitAll();
                });

        return http.build();
    }
}
