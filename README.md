# Loja Virtual - Projeto

Este é um projeto de loja virtual desenvolvido com uma API no backend utilizando Spring Boot, Spring Data JPA, Spring Security e validações, juntamente com migração de banco de dados usando Flyway. O frontend é construído com Next.js.

## Requisitos

Certifique-se de ter as seguintes tecnologias instaladas em seu ambiente de desenvolvimento:

- JDK (Java Development Kit) 17 ou superior
- Node.js e npm (Node Package Manager)
- MySQL (ou outro banco de dados de sua preferência)
- Git

## Configuração do Banco de Dados

Este projeto utiliza o PostgreSQL como banco de dados. Certifique-se de criar um banco de dados vazio com o nome `loja_virtual` (ou outro nome de sua preferência). As configurações de conexão com o banco de dados podem ser encontradas no arquivo `application.properties` no módulo Spring Boot.

## Instalação e Execução

### Backend (Spring Boot)

1. Clone este repositório: `git clone https://github.com/juliocesarcoutinho/e-commerce.git`
2. Navegue até o diretório do backend: `cd back-end`
3. Execute o projeto Spring Boot: `./mvnw spring-boot:run`

### Frontend (Next.js)

1. Navegue até o diretório do frontend: `cd front-end`
2. Instale as dependências: `npm install`
3. Execute o servidor de desenvolvimento: `npm run dev`

## Uso

- Acesse o frontend em [http://localhost:3000](http://localhost:3000) para interagir com a loja virtual.

## Documentação da API

- A documentação da API pode ser encontrada em [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html) após a execução do backend.

## Contribuição

Contribuições são bem-vindas! Sinta-se à vontade para abrir um problema ou enviar um pull request.

## Licença

Este projeto está licenciado sob a [MIT License](LICENSE).
