# AlexandriaAPI - API de Gerenciamento de Livros

AlexandriaAPI é uma API baseada em Java Spring Boot projetada para gerenciar livros, editoras e autores. Ela fornece endpoints para realizar operações como adicionar, editar, remover e atualizar livros, editoras e autores.

## Funcionalidades

- Adicionar, editar, remover e atualizar livros
- Adicionar, editar, remover e atualizar editoras
- Adicionar, editar, remover e atualizar autores

## Tecnologias Utilizadas

- Java 17
- Spring Boot
- Spring Data JPA
- MySql

## Diagrama de Relacionamentos do Banco de Dados

 ![](https://github.com/gabesouto/AlexandriaAPI/blob/master/public/91dba0df-5cbd-4b91-89cd-222ba1f213f3-Banco%20de%20dados%20Alexandria.webp)

## Funcionalidades

A API disponibiliza os seguintes endpoints:
<details>
  <summary>/books</summary>
  <br/>

- `GET /books`: Recupera todos os livros
- `GET /books/{id}`: Recupera um livro específico pelo ID
- `GET /books/{bookId}/details/{detailId}`: Recupera os detalhes de um livro
- `POST /books`: Adiciona um novo livro
- `POST /books/{bookId}/details`: Adiciona detalhes a um livro
- `PUT /books/{id}`: Atualiza um livro existente
- `PUT /books/{bookId}/details/{detailId}`: Atualiza os detalhes de um livro
- `PUT /books/{bookId}/publisher/{publisherId}`: Vincula uma editora a um livro pelo ID do livro e ID da editora
- `PUT /books/{bookId}/author/{authorId}`: Vincula um autor a um livro pelo ID do livro e ID do autor
- `DELETE /books/{id}`: Exclui um livro pelo ID
- `DELETE /books/{bookId}/details/{detailId}`: Exclui um detalhe de um livro
- `DELETE /books/{bookId}/publisher`: Remove a editora vinculada a um livro pelo ID do livro
- `DELETE /books/{bookId}/author/{authorId}`: Remove um autor vinculado a um livro pelo ID do livro e ID do autor
 </details>

 <details>
   <summary>/publishers</summary>
   <br/>

- `GET /publishers`: Recupera todas as editoras
- `GET /publishers/{id}`: Recupera uma editora específica pelo ID
- `POST /publishers`: Adiciona uma nova editora
- `PUT /publishers/{id}`: Atualiza uma editora existente
- `DELETE /publishers/{id}`: Exclui uma editora pelo ID
  </details>

<details>
  <summary>/authors</summary>
  <br/>

- `GET /authors`: Recupera todos os autores
- `GET /authors/{id}`: Recupera um autor específico pelo ID
- `POST /authors`: Adiciona um novo autor
- `PUT /authors/{id}`: Atualiza um autor existente
- `DELETE /authors/{id}`: Exclui um autor pelo ID
  </details>

## Como Rodar a Aplicação
#### ⚠️ Certifique-se de ter o Maven e o Java 17 instalados

### Clone o repositório
```sh
  git clone https://github.com/gabesouto/AlexandriaAPI.git
```
### Acesse a pasta do projeto
```sh
cd alexandriaAPI
```
### Instale as dependências 
```sh
mvn install
```
### Rode o projeto
```sh
 mvn spring-boot:run

A aplicação estará disponível em: http://localhost:8080
```
