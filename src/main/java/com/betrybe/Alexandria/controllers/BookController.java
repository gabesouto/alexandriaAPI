package com.betrybe.Alexandria.controllers;

import com.betrybe.Alexandria.dtos.BookDTO;
import com.betrybe.Alexandria.dtos.BookDetailDTO;
import com.betrybe.Alexandria.dtos.ResponseDTO;
import com.betrybe.Alexandria.enums.ResponseMessage;
import com.betrybe.Alexandria.models.entities.Book;
import com.betrybe.Alexandria.models.entities.BookDetail;
import com.betrybe.Alexandria.services.BookService;
import java.util.List;
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
@RequestMapping(value = "/books")
public class BookController {

  private final BookService bookService;


  @Autowired
  public BookController(BookService bookService) {
    this.bookService = bookService;
  }

  @PostMapping()
  public ResponseEntity<ResponseDTO<Book>> createBook(
      @RequestBody BookDTO bookDTO) {
    Book newBookDetail = bookService.insertBook(bookDTO.toBook());
    ResponseDTO<Book> responseDTO = new ResponseDTO<>("Livro criado com sucesso!",
        newBookDetail);
    return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
  }

  @PutMapping("/{bookId}")
  public ResponseEntity<ResponseDTO<Book>> updateBook(@PathVariable() Long bookId,
      @RequestBody Book book) {
    Optional<Book> optionalBook = bookService.updateBook(bookId, book);

    if (optionalBook.isEmpty()) {
      ResponseDTO<Book> responseDTO = new ResponseDTO<>(
          ResponseMessage.NOT_FOUND.getMessage(), null);
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseDTO);
    }

    ResponseDTO<Book> responseDTO = new ResponseDTO<>(
        ResponseMessage.CREATED.getMessage(), optionalBook.get());
    return ResponseEntity.ok(responseDTO);

  }

  @DeleteMapping("/{bookId}")
  public ResponseEntity<ResponseDTO<Book>> deleteBook(@PathVariable Long bookId) {

    Optional<Book> optionalBook = bookService.removeBookById(bookId);

    if (optionalBook.isEmpty()) {
      ResponseDTO<Book> responseDTO = new ResponseDTO<>(
          ResponseMessage.NOT_FOUND.getMessage() + " " + bookId, null);
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseDTO);
    }

    ResponseDTO<Book> responseDTO = new ResponseDTO<>(ResponseMessage.REMOVED.getMessage(), null);
    return ResponseEntity.ok(responseDTO);
  }

  @GetMapping("/{bookId}")
  public ResponseEntity<ResponseDTO<Book>> getBookById(@PathVariable Long bookId) {
    Optional<Book> optionalBook = bookService.getBookById(bookId);

    if (optionalBook.isEmpty()) {
      ResponseDTO<Book> responseDTO = new ResponseDTO<>(
          ResponseMessage.NOT_FOUND.getMessage() + " " + bookId, null);
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseDTO);
    }

    ResponseDTO<Book> responseDTO = new ResponseDTO<>(ResponseMessage.SUCCESS.getMessage(),
        optionalBook.get());
    return ResponseEntity.ok(responseDTO);
  }

  @GetMapping
  public ResponseEntity<List<Book>> getAllBooks() {
    return ResponseEntity.ok(this.bookService.getAllBooks());
  }

  @PostMapping("/{bookId}/details")
  public ResponseEntity<ResponseDTO<BookDetail>> createBook(
      @RequestBody BookDetailDTO bookDetailDTO) {
    BookDetail newBookDetail = bookService.insertBookDetail(bookDetailDTO.toBookDetail());
    ResponseDTO<BookDetail> responseDTO = new ResponseDTO<>("Livro criado com sucesso!",
        newBookDetail);
    return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);

  }

  @PutMapping("/{bookId}/details/{id}")
  public ResponseEntity<ResponseDTO<BookDetail>> updateBook(@PathVariable() Long bookDetailId,
      @RequestBody BookDetail bookDetail) {
    Optional<BookDetail> optionalBookDetail = bookService.updateBookDetail(bookDetailId,
        bookDetail);

    if (optionalBookDetail.isEmpty()) {
      ResponseDTO<BookDetail> responseDTO = new ResponseDTO<>(
          ResponseMessage.NOT_FOUND.getMessage(), null);
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseDTO);
    }

    ResponseDTO<BookDetail> responseDTO = new ResponseDTO<>(
        ResponseMessage.CREATED.getMessage(), optionalBookDetail.get());
    return ResponseEntity.ok(responseDTO);

  }

  @DeleteMapping("/{bookId}/details/{id}")
  public ResponseEntity<ResponseDTO<BookDetail>> deleteBookDetail(@PathVariable Long bookDetailId) {

    Optional<BookDetail> optionalBookDetail = bookService.removeBookDetailById(bookDetailId);

    if (optionalBookDetail.isEmpty()) {
      ResponseDTO<BookDetail> responseDTO = new ResponseDTO<>(
          ResponseMessage.NOT_FOUND.getMessage() + " " + bookDetailId, null);
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseDTO);
    }

    ResponseDTO<BookDetail> responseDTO = new ResponseDTO<>(ResponseMessage.REMOVED.getMessage(),
        null);
    return ResponseEntity.ok(responseDTO);
  }

  @GetMapping("/{bookId}/details/{id}")
  public ResponseEntity<ResponseDTO<BookDetail>> getBookDetailById(
      @PathVariable Long bookDetailId) {
    Optional<BookDetail> optionalBookDetail = bookService.getBookDetailById(bookDetailId);

    if (optionalBookDetail.isEmpty()) {
      ResponseDTO<BookDetail> responseDTO = new ResponseDTO<>(
          ResponseMessage.NOT_FOUND.getMessage() + " " + bookDetailId, null);
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseDTO);
    }

    ResponseDTO<BookDetail> responseDTO = new ResponseDTO<>(ResponseMessage.SUCCESS.getMessage(),
        optionalBookDetail.get());
    return ResponseEntity.ok(responseDTO);
  }


}
