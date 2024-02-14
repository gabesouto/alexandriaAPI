package com.betrybe.Alexandria.dtos;

import com.betrybe.Alexandria.models.entities.Author;
import com.betrybe.Alexandria.models.entities.Book;
import com.betrybe.Alexandria.models.entities.BookDetail;
import com.betrybe.Alexandria.models.entities.Publisher;
import java.util.List;

public record BookDTO(
    Long id,
    String title,
    String genre,
    Publisher publisher,
    BookDetail bookDetail,
    List<Author> authorList) {

  public Book toBook() {
    return new Book(id, title, genre, null, null, null);
  }

}
