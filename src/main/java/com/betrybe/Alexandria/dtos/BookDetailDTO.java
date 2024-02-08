package com.betrybe.Alexandria.dtos;

import com.betrybe.Alexandria.models.entities.Book;
import com.betrybe.Alexandria.models.entities.BookDetail;
import com.fasterxml.jackson.annotation.JsonProperty;

public record BookDetailDTO(
    Long id,
    String summary,
    String year,
    @JsonProperty("page_count")
    Integer pageCount,
    String isbn,
    Book book

) {

  public BookDetail toBookDetail() {
    return new BookDetail(id, summary, pageCount, year, isbn, book);
  }
}
