📚 Literalura - Challenge Alura Latam + Oracle

Aplicación backend desarrollada en Java con Spring Boot que permite gestionar libros y autores consumiendo una API externa, almacenando datos en una base de datos y ofreciendo consultas avanzadas.

🚀 Descripción

Literalura es una API REST que permite:

Buscar libros desde una API externa (como Gutendex 📖)

Guardar libros en base de datos

Registrar autores

Consultar libros por idioma

Listar autores vivos en un determinado año

Gestionar información de forma estructurada (DTO, Service, Repository, etc.)

Este proyecto forma parte del desafío backend del programa:

👉 Alura Latam + Oracle Next Education (ONE)

🧱 Arquitectura del Proyecto

El proyecto sigue una arquitectura en capas basada en buenas prácticas:

src/main/java/LiterAlura
│
├── config        → Configuraciones (Beans, API clients)
├── controller    → Controladores REST
├── dto           → Objetos de transferencia de datos
├── model         → Entidades (Libro, Autor)
├── repository    → Interfaces JPA
├── service       → Lógica de negocio
├── viewmodel     → Modelos para presentación
└── LiterAluraApplication.java
🛠️ Tecnologías utilizadas

☕ Java 17+

🌱 Spring Boot

📦 Spring Data JPA

🐘 PostgreSQL / MySQL / H2

🔗 API externa (Gutendex)

🧪 Maven

🔄 Jackson (JSON parsing)

⚙️ Instalación y ejecución
1. Clonar el repositorio
git clone https://github.com/TU-USUARIO/LiterAlura.git
cd LiterAlura
2. Configurar base de datos

Editar el archivo:

src/main/resources/application.properties

Ejemplo:

spring.datasource.url=jdbc:postgresql://localhost:5432/literalura
spring.datasource.username=tu_usuario
spring.datasource.password=tu_password

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
3. Ejecutar la aplicación
./mvnw spring-boot:run

O desde tu IDE (IntelliJ / VS Code / Eclipse)

🔎 Funcionalidades principales

✔ Buscar libro por título
✔ Guardar libro en la base de datos
✔ Listar libros registrados
✔ Listar autores registrados
✔ Buscar autores vivos en determinado año
✔ Filtrar libros por idioma

📡 Endpoints (ejemplo)
Método	Endpoint	Descripción
GET	/libros	Listar libros
POST	/libros	Guardar libro
GET	/autores	Listar autores
GET	/autores/vivos	Filtrar autores vivos
GET	/libros/idioma	Filtrar por idioma
📊 Ejemplo de consumo API externa

La aplicación consume datos desde:

👉 https://gutendex.com/books/

Ejemplo:

GET https://gutendex.com/books/?search=harry+potter
🧠 Buenas prácticas implementadas

Separación por capas (Controller, Service, Repository)

Uso de DTOs

Manejo de APIs externas

Persistencia con JPA

Código limpio y modular

Principios básicos de arquitectura backend

📸 Estructura del proyecto

Tu estructura actual:

config

controller

dto

model

repository

service

viewmodel

✔ Muy bien organizada (nivel semi-senior 👀)

🧪 Posibles mejoras

🔐 Implementar autenticación con JWT

📄 Documentación con Swagger

🐳 Dockerización

📊 Paginación de resultados

🧾 Logs estructurados

🧪 Tests unitarios (JUnit)

👨‍💻 Autor

Fernando (Jefe Maestro)
📺 Creador de contenido & desarrollador backend

📜 Licencia

Este proyecto es de uso educativo como parte del programa:

Alura Latam + Oracle ONE

⭐ Apóyame

Si este proyecto te ayuda:

👉 Dale ⭐ en GitHub
👉 Compártelo
👉 Sígueme para más contenido de programación

🌎 Versión en Inglés (Short)
📚 Literalura - Alura Challenge

Backend API built with Spring Boot to manage books and authors using an external API.

Features:

Search books

Store data in DB

Filter by language

Authors by year

Tech Stack:
Java, Spring Boot, JPA, PostgreSQL
