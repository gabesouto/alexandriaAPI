package com.betrybe.Alexandria.dtos;

import com.betrybe.Alexandria.models.entities.Author;

public record AuthorDTO(Long id, String name, String nationality) {

  public Author toAuthor() {
    return new Author(id, name, nationality);
  }
}
