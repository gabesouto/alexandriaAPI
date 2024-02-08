package com.betrybe.Alexandria.controllers;

import com.betrybe.Alexandria.dtos.AuthorDTO;
import com.betrybe.Alexandria.dtos.ResponseDTO;
import com.betrybe.Alexandria.enums.ResponseMessage;
import com.betrybe.Alexandria.models.entities.Author;
import com.betrybe.Alexandria.services.AuthorService;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/authors")
public class AuthorController {

  private final AuthorService authorService;

  @Autowired
  public AuthorController(AuthorService authorService) {
    this.authorService = authorService;
  }

  @PostMapping()
  public ResponseEntity<ResponseDTO<Author>> createAuthor(@RequestBody AuthorDTO authorDTO) {
    Author newAuthor = authorService.insertAuthor(authorDTO.toAuthor());
    ResponseDTO<Author> responseDTO = new ResponseDTO<>(ResponseMessage.CREATED.getMessage(),
        newAuthor);
    return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
  }

  @PutMapping("/{authorId}")
  public ResponseEntity<ResponseDTO<Author>> updateAuthor(@PathVariable() Long authorId,
      @RequestBody Author author) {
    Optional<Author> optionalAuthor = authorService.updateAuthor(authorId, author);

    if (optionalAuthor.isEmpty()) {
      ResponseDTO<Author> responseDTO = new ResponseDTO<>(
          ResponseMessage.NOT_FOUND.getMessage(), null);
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseDTO);
    }

    ResponseDTO<Author> responseDTO = new ResponseDTO<>(
        ResponseMessage.UPDATED.getMessage(), optionalAuthor.get());
    return ResponseEntity.ok(responseDTO);

  }

  @DeleteMapping("/{authorId}")
  public ResponseEntity<ResponseDTO<Author>> deleteAuthor(@PathVariable Long authorId) {

    Optional<Author> optionalAuthor = authorService.removeAuthorById(authorId);

    if (optionalAuthor.isEmpty()) {
      ResponseDTO<Author> responseDTO = new ResponseDTO<>(
          ResponseMessage.NOT_FOUND.getMessage() + " " + authorId, null);
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseDTO);
    }

    ResponseDTO<Author> responseDTO = new ResponseDTO<>(ResponseMessage.REMOVED.getMessage(), null);
    return ResponseEntity.ok(responseDTO);
  }

  @GetMapping("/{authorId}")
  public ResponseEntity<ResponseDTO<Author>> getAuthorById(@PathVariable Long authorId) {
    Optional<Author> optionalAuthor = authorService.getAuthorById(authorId);

    if (optionalAuthor.isEmpty()) {
      ResponseDTO<Author> responseDTO = new ResponseDTO<>(
          ResponseMessage.NOT_FOUND.getMessage() + " " + authorId, null);
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseDTO);
    }

    ResponseDTO<Author> responseDTO = new ResponseDTO<>(ResponseMessage.SUCCESS.getMessage(),
        optionalAuthor.get());
    return ResponseEntity.ok(responseDTO);
  }
}
