# SavePoint API

Uma API REST moderna para gerenciamento de catálogo de jogos com sistema de reviews e autenticação JWT.

## Sobre o Projeto

SavePoint é uma API desenvolvida em Spring Boot que permite:

- **Gerenciar catálogo de jogos** - CRUD completo para jogos
- **Sistema de reviews** - Usuários podem avaliar e comentar jogos
- **Autenticação JWT** - Sistema seguro de autenticação
- **Documentação interativa** - Interface Swagger/OpenAPI
- **Containerização** - Deploy com Docker e PostgreSQL

## Tecnologias Utilizadas

### Backend
- **Java 21** - Linguagem principal
- **Spring Boot 3.5.0** - Framework web
- **Spring Security** - Autenticação e autorização
- **Spring Data JPA** - Persistência de dados
- **JWT (java-jwt 4.4.0)** - Autenticação stateless

### Banco de Dados
- **PostgreSQL** - Banco de dados principal
- **Flyway** - Versionamento de banco de dados

### Documentação
- **SpringDoc OpenAPI** - Documentação automática da API
- **Swagger UI** - Interface interativa para testes

### Ferramentas
- **Docker** - Containerização
- **Lombok** - Redução de boilerplate
- **Maven** - Gerenciamento de dependências

## Estrutura do Projeto

```
savepoint/
├── src/
│   ├── main/
│   │   ├── java/com/SavePoint/
│   │   │   ├── config/          # Configurações (Security, JWT, etc.)
│   │   │   ├── controller/      # Controllers REST
│   │   │   ├── dto/             # Data Transfer Objects
│   │   │   ├── entity/          # Entidades JPA
│   │   │   ├── repository/      # Repositórios JPA
│   │   │   ├── service/         # Lógica de negócio
│   │   │   └── SavePointApplication.java
│   │   └── resources/
│   │       ├── db/migration/    # Scripts Flyway
│   │       └── application.yml  # Configurações da aplicação
├── docker-compose.yml
├── Dockerfile
├── pom.xml
└── README.md
```

## Pré-requisitos

- Java 21+
- Maven 3.8+
- Docker e Docker Compose
- PostgreSQL (se não usar Docker)

## Instalação com Docker

### 1. Clone o repositório
```bash
git clone https://github.com/seu-usuario/savepoint.git
cd savepoint
```

### 2. Execute com Docker Compose
```bash
docker-compose up -d
```

### 3. Acesse a aplicação
- **API:** http://localhost:8080
- **Swagger UI:** http://localhost:8080/swagger-ui.html

## Instalação Manual

### 1. Configure o banco PostgreSQL
```sql
CREATE DATABASE savepoint;
CREATE USER savepoint_user WITH PASSWORD 'sua_senha';
GRANT ALL PRIVILEGES ON DATABASE savepoint TO savepoint_user;
```

### 2. Configure as variáveis de ambiente
```bash
export DB_URL=jdbc:postgresql://localhost:5432/savepoint
export DB_USERNAME=savepoint_user
export DB_PASSWORD=sua_senha
export JWT_SECRET=seu_jwt_secret_aqui
```

### 3. Execute a aplicação
```bash
./mvnw clean install
./mvnw spring-boot:run
```

## Autenticação

A API utiliza JWT para autenticação. Para acessar endpoints protegidos:

### 1. Registre um usuário
```bash
POST /api/auth/register
{
  "username": "usuario",
  "email": "usuario@email.com",
  "password": "senha123"
}
```

### 2. Faça login
```bash
POST /api/auth/login
{
  "username": "usuario",
  "password": "senha123"
}
```

### 3. Use o token retornado
```bash
Authorization: Bearer {seu_jwt_token}
```

## Endpoints Principais

### Autenticação
- `POST /api/auth/register` - Registrar usuário
- `POST /api/auth/login` - Fazer login
- `POST /api/auth/refresh` - Renovar token

### Jogos
- `GET /api/games` - Listar jogos
- `GET /api/games/{id}` - Buscar jogo por ID
- `POST /api/games` - Criar jogo (autenticado)
- `PUT /api/games/{id}` - Atualizar jogo (autenticado)
- `DELETE /api/games/{id}` - Deletar jogo (autenticado)

### Reviews
- `GET /api/games/{gameId}/reviews` - Listar reviews de um jogo
- `POST /api/games/{gameId}/reviews` - Criar review (autenticado)
- `PUT /api/reviews/{id}` - Atualizar review (autenticado)
- `DELETE /api/reviews/{id}` - Deletar review (autenticado)

## Documentação da API

Acesse a documentação interativa em: http://localhost:8080/swagger-ui.html

##  Banco de Dados

O projeto utiliza **Flyway** para versionamento do banco de dados. As migrações estão em `src/main/resources/db/migration/`.

### Principais Tabelas
- `users` - Usuários do sistema
- `games` - Catálogo de jogos
- `reviews` - Reviews dos jogos
- `categories` - Categorias de jogos (se aplicável)

##  Configuração

### Variáveis de Ambiente
```yaml
# Banco de dados
DB_URL: jdbc:postgresql://localhost:5432/savepoint
DB_USERNAME: savepoint_user
DB_PASSWORD: sua_senha

# JWT
JWT_SECRET: seu_jwt_secret_muito_seguro_aqui
JWT_EXPIRATION: 86400000  # 24 horas em ms

# Aplicação
SERVER_PORT: 8080
SPRING_PROFILES_ACTIVE: dev
```

## 👨‍💻 Autor

**RyanGTorres** - [GitHub](https://github.com/RyanGTorres)

---

⭐ Se este projeto foi útil para você, considere dar uma estrela!

## 🔗 Links Úteis

- [Spring Boot Documentation](https://spring.io/projects/spring-boot)
- [JWT.io](https://jwt.io/)
- [PostgreSQL Documentation](https://www.postgresql.org/docs/)
- [Docker Documentation](https://docs.docker.com/)
- [Swagger Documentation](https://swagger.io/docs/)
