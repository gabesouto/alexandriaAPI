package com.betrybe.Alexandria.dtos;

import com.betrybe.Alexandria.models.entities.Book;
import com.betrybe.Alexandria.models.entities.BookDetail;

public record BookDTO(Long id, String title, String genre) {
  
  public Book toBook() {
    return new Book(id, title, genre);
  }

}