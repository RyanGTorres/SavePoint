# SavePoint API

API para o gerenciamento de catálogo de jogos.

## Tecnologias Utilizadas

- Java 21
- Spring Boot 3.5.0
- Spring Data JPA
- Spring Security
- Spring Web
- JWT (JSON Web Tokens)
- PostgreSQL
- Flyway (Migrações de Banco de Dados)
- Lombok
- Maven
- Docker

## Configuração do Ambiente

### Pré-requisitos

Certifique-se de ter as seguintes ferramentas instaladas:

- Java Development Kit (JDK) 21 ou superior
- Maven 3.x
- Docker e Docker Compose

### Banco de Dados

O projeto utiliza PostgreSQL como banco de dados. Um arquivo `docker-compose.yml` é fornecido para facilitar a configuração de uma instância de banco de dados PostgreSQL.

1. Navegue até a raiz do projeto no seu terminal.
2. Inicie o container do PostgreSQL usando Docker Compose:
   ```bash
   docker-compose up -d
   ```
   Isso iniciará um container PostgreSQL na porta `5434`.

### Executando a Aplicação

1. **Configuração do Banco de Dados:** Certifique-se de que o container do PostgreSQL esteja em execução (conforme as instruções acima).

2. **Compilar e Executar:** Navegue até a raiz do projeto e execute o seguinte comando Maven:
   ```bash
   ./mvnw spring-boot:run
   ```
   A aplicação será iniciada na porta `8080` (por padrão).

## Endpoints da API

Os endpoints da API podem ser explorados através da interface Swagger UI, que estará disponível em:

`http://localhost:8080/swagger-ui.html`

*(Este endereço pode variar dependendo da configuração da sua aplicação)* 