package com.betrybe.Alexandria.dtos;

import com.betrybe.Alexandria.models.entities.Publisher;

public record PublisherDTO(Long id, String name, String address) {

  public Publisher toPublisher() {
    return new Publisher(id, name, address, null);
  }
}
